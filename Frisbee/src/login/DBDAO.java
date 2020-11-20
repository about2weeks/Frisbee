package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDAO {
	public static Connection dbConn;
	public static Statement dbST;
	public static ResultSet dbRS;
	
	public static Connection getConnection() {
		
		Connection conn = null;	
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String user = "frisbee";
			String pw = "frisbee1234";
			String url = "jdbc:oracle:thin:@localhost:1521/XE";
			
			
			Class.forName(driver);
			System.out.println("driver loading success");
			conn = DriverManager.getConnection(url, user,pw);
			System.out.println("connection success");
			
		}catch(ClassNotFoundException cnfe) {
			System.out.println("DB driver loading fail : "+cnfe.toString());
		}catch(SQLException sqle) {
			System.out.println("DB connecting fail : "+sqle.toString());
		}catch(Exception e) {
			System.out.println("unknown error");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Statement setStmt(Connection conn) {
		
		Statement st = null;
		
		try {
		st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public static ResultSet setRsAll(Statement st,String query) {
		
		ResultSet rs = null;
		
		try {
			rs = st.executeQuery(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
}
