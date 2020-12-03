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
			String name = "";
			String rank = "";
			String phone = "";
			String email = "";
			String sal = "";
			String start = "";
			String end = "";
			if(rs1.next()) {
			name = rs1.getString("EMPNAME");
			rank = rs1.getString("EMPRANK");
			phone = rs1.getString("PHONE");
			email = rs1.getNString("EMAIL");
			sal = rs1.getString("SALDATE");
			start = rs1.getString("STARTDATE");
			end = rs1.getNString("ENDDATE");
			}
			
			String findS = "SELECT NVL(SUPER, '-') FROM EMP WHERE EMPNO = '"+empno+"'";

			rs1 = DBDAO.setRsAll(stmt, findS);
			String superC = "";
			String superN = "";
			if(rs1.next()) {
			superC = rs1.getString(1);
			}
			if(superC.equals("-")) {
				superN = "-";
			}else {
			String findSu ="SELECT EMPNAME FROM EMP WHERE EMPNO = '"+superC+"'";
			rs1.close();
			rs2 = DBDAO.setRsAll(stmt, findSu);
			if(rs2.next()) {
				superN = rs2.getString("EMPNAME");
			}
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
	
	public int insertAccount(String name, String superC, String rank, String empno, String start, String phone, String email, String storeNo) {
		
		try {
			conn = Main.db.dbConn;
			stmt = DBDAO.setStmt(conn);	
			
			String findEMP = "SELECT * FROM EMP";
			if(empno!=null) {
				findEMP += " WHERE EMPNO = '"+empno.toUpperCase()+"'";
			}
			//직원 코드가 존재하는지 찾기 
			
			String end = start.replace("2020", "2023");
			int salD = Integer.parseInt(start.substring(5,7))+1 > 12 ? 1 : Integer.parseInt(start.substring(5,7))+1;
			String sal = "2020-"+String.valueOf(salD)+"-15";
			
			String insertEMP = "INSERT INTO EMP (EMPNO, STORENO, EMPNAME, EMPRANK, PHONE, EMAIL, "
					+ "SUPER, STARTDATE, ENDDATE, SALDATE)" + 
					"VALUES ('"+empno+"', '"+storeNo+"', '"+name+"', '"+rank+"', '"+phone+"', '"+email+"', '"
					+ superC+"', TO_DATE('"+start+"','YYYY-MM-DD'), TO_DATE('"+end+"','YYYY-MM-DD'), "
							+ "TO_DATE('"+sal+"','YYYY-MM-DD'))";
			
			rs1 = DBDAO.setRsAll(stmt, findEMP);
			rs1.last();
			if(rs1.getRow()!=0) {
				System.out.println("exist?");
				return 0;
			}else {
				boolean b = stmt.execute(insertEMP);
				if(!b) {
					return 1;
				}else {
					System.out.println("why?");
					return 0;
				}
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
}
