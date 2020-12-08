package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StockDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public ArrayList<StockVo> setStock(String storeNo) {
		
		ArrayList<StockVo> list = new ArrayList<StockVo>();
		
		try {
		
			
		conn = Main.db.dbConn;
		stmt = Main.db.setStmt(conn);	
		
		String findStock ="SELECT NAME, STOCKS FROM STOCK WHERE STORENO = '"+storeNo+ "' AND STOCKS <= 3";
		
		
		rs = Main.db.setRsAll(stmt, findStock);
		while(rs.next()) {
			String name = rs.getString("NAME");
			String stock = rs.getString("STOCKS");
			
			StockVo data = new StockVo(name, stock);
			list.add(data);
		}
		
		rs.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<StockVo> setAllStock(String storeNo) {
		
		ArrayList<StockVo> list = new ArrayList<StockVo>();
		
		try {
		
			
		conn = Main.db.dbConn;
		stmt = Main.db.setStmt(conn);	
		
		String findStock ="SELECT NAME, STOCKS FROM STOCK WHERE STORENO = '"+storeNo+ "'";
		
		
		rs = Main.db.setRsAll(stmt, findStock);
		while(rs.next()) {
			String name = rs.getString("NAME");
			String stock = rs.getString("STOCKS");
			
			StockVo data = new StockVo(name, stock);
			list.add(data);
		}
		
		rs.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public ArrayList<StockVo> setStockProfile(String storeNo, String goodName) {
		
		ArrayList<StockVo> list = new ArrayList<StockVo>();
		
		try {
		
			
		conn = Main.db.dbConn;
		stmt = Main.db.setStmt(conn);	
		
		String findStock ="SELECT * FROM STOCK WHERE NAME = '"+goodName+ "' AND STORENO = '"+storeNo+ "'";
		
		
		rs = Main.db.setRsAll(stmt, findStock);
		while(rs.next()) {
			String goodNo = rs.getString("GOODNO");
			String stocks = rs.getString("STOCKS");
			int unitPrice = rs.getInt("UNITPRICE");
			String loc = rs.getNString("LOC");
			
			
			StockVo data = new StockVo(goodNo, goodName, stocks, unitPrice, loc) ;
			list.add(data);
		}
		
		rs.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
