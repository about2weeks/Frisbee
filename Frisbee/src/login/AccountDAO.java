package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.crypto.Data;

public class AccountDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs1;
	private ResultSet rs2;
	
	public ArrayList<AccountVo> setAccount(String empno) {
		
		ArrayList<AccountVo> list = new ArrayList<AccountVo>();
		
		try {
		
			
		conn = Main.db.dbConn;
		stmt = DBDAO.setStmt(conn);	
		
		String findEmp ="SELECT * FROM EMP WHERE EMPNO = '"+empno+"'";
		String findST = "SELECT NAME FROM STORE WHERE STORENO = (SELECT STORENO FROM EMP WHERE EMPNO ='"+empno+"')";

		String storeNo = "";
		String storeName = "";
		String name = "";
		String rank = "";
		//imageIcon
		
		rs1 = DBDAO.setRsAll(stmt,findEmp);
		while(rs1.next()) {
			storeNo = rs1.getString("STORENO");
			name = rs1.getString("EMPNAME");
			rank = rs1.getNString("EMPRANK");
		}
		rs2 = DBDAO.setRsAll(stmt,findST);
		rs2.next();
		storeName = rs2.getString("NAME");
		
		AccountVo data = new AccountVo(empno, storeNo, storeName, name, rank);
		
		list.add(data);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	 
	
	public ArrayList<AccountVo> setProfile(String empno) {
		
		ArrayList<AccountVo> list = new ArrayList<AccountVo>();
		
		try {
			
			
			conn = Main.db.dbConn;
			stmt = DBDAO.setStmt(conn);		
			
			String findPf ="SELECT * FROM EMP WHERE EMPNO = '"+empno+"'";
		
	
			rs1 = DBDAO.setRsAll(stmt, findPf);
			rs1.next();
			String name = rs1.getString("EMPNAME");
			String rank = rs1.getString("EMPRANK");
			String phone = rs1.getString("PHONE");
			String email = rs1.getNString("EMAIL");
			String sal = rs1.getString("SALDATE");
			String start = rs1.getString("STARTDATE");
			String end = rs1.getNString("ENDDATE");
			
			String findS = "SELECT NVL(SUPER, '-') FROM EMP WHERE EMPNO = '"+empno+"'";

			rs1 = DBDAO.setRsAll(stmt, findS);
			rs1.next();
			String superC = rs1.getString(1);
			String superN;
			if(superC.equals("-")) {
				superN = "-";
			}else {
			String findSu ="SELECT NVL(EMPNAME,'-') FROM EMP WHERE EMPNO = '"+superC+"'";
			rs1.close();
			rs2 = DBDAO.setRsAll(stmt, findSu);
			rs2.next();
			superN = rs2.getString("EMPNAME");
			}
			AccountVo data = new AccountVo(name, rank, 
					phone, email, superC, sal, 
					start, end, superN);
			
			list.add(data);

			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return list;
	}
	
	public ArrayList<AccountVo> setWorker(String storeNo){
		
		
		ArrayList<AccountVo> list = new ArrayList<AccountVo>();
		
		try {
			
			
			conn = Main.db.dbConn;
			stmt = DBDAO.setStmt(conn);		
			
			String findEmp ="SELECT ROWNUM, EMP.* FROM EMP WHERE STORENO  = '"+storeNo+"'";

			rs1 = DBDAO.setRsAll(stmt, findEmp);
			while(rs1.next()) {
				String rowNum = rs1.getNString("ROWNUM");
				String empNo = rs1.getString("EMPNO");
				String empName = rs1.getString("EMPNAME");
				String rank = rs1.getNString("EMPRANK");
				String StartDate =  rs1.getString("STARTDATE");
				String phone = rs1.getString("PHONE");
				
				
				AccountVo data = new AccountVo(empNo, empName,rank,StartDate,phone,rowNum);
				list.add(data);
			}
			
			
			
			rs1.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		
		return list;
	}
	
}
