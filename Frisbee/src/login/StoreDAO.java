package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StoreDAO {
	
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public ArrayList<StoreVo> getStore(String goodName) {
		
		ArrayList<StoreVo> list = new ArrayList<StoreVo>();
		
		try {
		
			
		conn = Main.db.dbConn;
		stmt = Main.db.setStmt(conn);	
		
		String findStock ="SELECT LOC, NAME FROM STORE WHERE STORENO ="
				+ " (SELECT STORENO FROM STOCK WHERE NAME = '"+goodName+"' AND STOCKS > 3)";
		
		
		rs = Main.db.setRsAll(stmt, findStock);
		while(rs.next()) {
			String loc = rs.getString("LOC");
			String name = rs.getString("NAME");
			
			StoreVo data = new StoreVo(name, loc);
			
			list.add(data);
		}
		
		rs.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String getAddress(String storeNo) {
		
		String loc = "";
		
		try {
		
			
		conn = Main.db.dbConn;
		stmt = Main.db.setStmt(conn);	
		
		String find ="SELECT LOC FROM STORE WHERE STORENO = '"+storeNo+"'";
		
		
		rs = Main.db.setRsAll(stmt, find);
		while(rs.next()) {
			loc = rs.getString("LOC");
		}
		
		rs.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return loc;
	}
	
}
