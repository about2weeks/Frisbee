import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIMG {

	public static Connection dbConn;
	public static Statement dbST;
	public static ResultSet dbRS;
	
	
	public static void main(String[] args) {
		
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
				
				File file = new File("/Users/kai/Documents/Project/Frisbee/img/empIcon/beaverIcon.png"); 
				FileInputStream fis = new FileInputStream(file);
				
				String sql = "UPDATE EMP SET PIC = ? WHRER EMPNO = 'AAA-12345'";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setBinaryStream(1,  fis, (int)file.length());
				ps.executeUpdate();
				
				ps.close();
				conn.close();
				fis.close();
				
				
			}catch(ClassNotFoundException cnfe) {
				System.out.println("DB driver loading fail : "+cnfe.toString());
			}catch(SQLException sqle) {
				System.out.println("DB connecting fail : "+sqle.toString());
			}catch(Exception e) {
				System.out.println("unknown error");
				e.printStackTrace();
			}

	}

}
