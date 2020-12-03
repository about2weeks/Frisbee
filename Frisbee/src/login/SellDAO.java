package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class SellDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public ArrayList<SellVo> setSellP(String storeNo, String month) {
		
		ArrayList<SellVo> list = new ArrayList<SellVo>();
		
		try {
		
			
		conn = Main.db.dbConn;
		stmt = DBDAO.setStmt(conn);	
		
		String sellT ="SELECT * FROM SELL WHERE TO_CHAR(SELLTIME, 'YYYY-MM')"
				+ " = '"+month+"' AND STORENO = '"+storeNo+"'";
		
		rs = DBDAO.setRsAll(stmt,sellT);
		while(rs.next()) {
			String goodsNo = rs.getString("GOODSNO");
			String sellTime = rs.getString("sellTime");
			String goodsName = rs.getString("GOODSNAME");
			int qtty = rs.getInt("QTTY");
			long unitPrice = rs.getLong("UNITPRICE");
			
			
			SellVo data = new SellVo(storeNo, goodsNo, sellTime, goodsName, qtty, unitPrice);
			list.add(data);
		}
		
		rs.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Vector<String> countMonth(String storeNo) {
		
		Vector<String> list = new Vector<String>();
		
		try {
			
			conn = Main.db.dbConn;
			stmt = DBDAO.setStmt(conn);	
			
			String findM ="SELECT DISTINCT TO_CHAR(SELLTIME, 'YYYY-MM')AS MONTH FROM SELL ORDER BY MONTH";
			
			
			rs = DBDAO.setRsAll(stmt,findM);
			while(rs.next()) {
				String month = rs.getString(1);
				list.add(month);
			}
			
			rs.close();
			
			;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return  list;
	}
	
	
}
