package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rsId;
	private ResultSet rsSt;
	
	public String login(String id, String pwd){
		
		try {
			
			conn = DBDAO.getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			String findId = "SELECT * FROM LOGIN WHERE ID = '"+id+"'";
			
			rsId = stmt.executeQuery(findId);
			rsId.last();
			
			if(rsId.getRow()==0) {
				return "wrong";
			}else {
				rsId.previous();
				String empno = "";
				String getPw = "";
				String storeNo = "";
				while(rsId.next()) {
					empno = rsId.getString("EMPNO");
					getPw = rsId.getString("PSWD");
				}
				if(pwd.equals(getPw)) {
					return empno;
				}else {
					return "wrong";
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
