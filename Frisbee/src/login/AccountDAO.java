package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs1;
	private ResultSet rs2;
	
	public ArrayList<AccountVo> setAccount(String empno) {
		
		ArrayList<AccountVo> list = new ArrayList<AccountVo>();
		
		try {
		
			
		conn = DBDAO.getConnection();
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
		
		String findEmp ="SELECT * FROM EMP WHERE EMPNO = '"+empno+"'";
		String findST = "SELECT NAME FROM STORE WHERE STORENO = (SELECT STORENO FROM EMP WHERE EMPNO ='"+empno+"')";

		String storeNo = "";
		String storeName = "";
		String name = "";
		String rank = "";
		//imageIcon
		
		rs1 = stmt.executeQuery(findEmp);
		while(rs1.next()) {
			storeNo = rs1.getString("STORENO");
			name = rs1.getString("EMPNAME");
			rank = rs1.getNString("EMPRANK");
		}
		rs2 = stmt.executeQuery(findST);
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
			
			
			conn = DBDAO.getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
			
			String findPf ="SELECT * FROM EMP WHERE EMPNO = '"+empno+"'";
		
	
			rs1 = stmt.executeQuery(findPf);
			rs1.next();
			String name = rs1.getString("EMPNAME");
			String rank = rs1.getString("EMPRANK");
			String phone = rs1.getString("PHONE");
			String email = rs1.getNString("EMAIL");
			String superC = rs1.getString("SUPER");
			String sal = rs1.getString("SALDATE");
			String start = rs1.getString("STARTDATE");
			String end = rs1.getNString("ENDDATE");
			
			String findSu ="SELECT EMPNAME FROM EMP WHERE EMPNO = '"+superC+"'";
			rs2 = stmt.executeQuery(findSu);
			rs2.next();
			String superN = rs2.getString("EMPNAME");
			AccountVo data = new AccountVo(name, rank, 
					phone, email, superC, sal, 
					start, end, superN);
			
			list.add(data);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return list;
	}
	
}
