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
		
			
		conn = DBDAO.getConnection();
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
		
		String findStock ="SELECT NAME, STOCKS FROM STOCK WHERE STORENO = '"+storeNo+ "' AND STOCKS <= 3";
		
		
		rs = stmt.executeQuery(findStock);
		while(rs.next()) {
			String name = rs.getString("NAME");
			String stock = rs.getString("STOCKS");
			
			StockVo data = new StockVo(name, stock);
			list.add(data);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
