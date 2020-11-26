package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rsId;
	
	public String login(String id, String pwd){
		
		try {
			
			conn = Main.db.dbConn;
			stmt = DBDAO.setStmt(conn);
			
			String findId = "SELECT * FROM LOGIN WHERE ID = '"+id.toUpperCase()+"'";
			
			rsId = DBDAO.setRsAll(stmt, findId);
			rsId.last();
			
			if(rsId.getRow()==0) {
				return "wrong";
			}else {
				rsId.previous();
				String empno = "";
				String getPw = "";
				while(rsId.next()) {
					empno = rsId.getString("EMPNO");
					getPw = rsId.getString("PSWD");
				}
				rsId.close();
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
