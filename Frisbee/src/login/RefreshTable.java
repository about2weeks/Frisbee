package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class RefreshTable {

	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	DefaultTableModel newModel;
	
	
	public DefaultTableModel refreshAccount(DefaultTableModel model, Vector data) {
		
		try {
		conn = Main.db.dbConn;
		stmt = DBDAO.setStmt(conn);	
		
		
		
		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return newModel;
		
	}
	
	
	
	
}
