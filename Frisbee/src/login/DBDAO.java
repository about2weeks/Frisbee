package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDAO {
	public Connection dbConn;
	public static Statement dbST;
	public static ResultSet dbRS;
	
	public Connection getConnection() {
		
		Connection dbConn = null;	
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String user = "frisbee";
			String pw = "frisbee1234";
			String url = "jdbc:oracle:thin:@localhost:1521/XE";
			
			
			Class.forName(driver);
			System.out.println("driver loading success");
			dbConn = DriverManager.getConnection(url, user,pw);
			System.out.println("connection success");
			
		}catch(ClassNotFoundException cnfe) {
			System.out.println("DB driver loading fail : "+cnfe.toString());
		}catch(SQLException sqle) {
			System.out.println("DB connecting fail : "+sqle.toString());
		}catch(Exception e) {
			System.out.println("unknown error");
			e.printStackTrace();
		}
		return dbConn;
	}
	
	public static Statement setStmt(Connection conn) {
		
		Statement dbST = null;
		
		try {
		dbST = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dbST;
	}
	
	public static ResultSet setRsAll(Statement st,String query) {
		
		ResultSet dbRS = null;
		
		try {
			dbRS = st.executeQuery(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dbRS;
	}
	
	
}
