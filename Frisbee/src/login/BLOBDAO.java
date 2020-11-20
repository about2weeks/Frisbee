package login;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import oracle.sql.BLOB;

public class BLOBDAO {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	Image img = null;
	OutputStream os = null;
	BLOB blob = null;
	
	int chunkSize = 0;
	
	public ImageIcon PrintIcon(String empno) {
		
		String getIcon = "SELECT PIC FROM EMP WHERE EMPNO = '"+empno+"'";
		
		try {
		conn = DBDAO.getConnection();
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(getIcon);
		
		byte[] image = null;
		while(rs.next()) {
			image = rs.getBytes("PIC");
		}
		
		Image img = Toolkit.getDefaultToolkit().createImage(image);
		ImageIcon icon = new ImageIcon(img);
		
		return icon;
		
		
		/*ByteArrayInputStream inputStream = new ByteArrayInputStream(byteBuffer);
		BufferedImage bimg = ImageIO.read(inputStream);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		
		img = (Image)(bimg);
		ImageIcon imgResult = t.getImage(img);
		
		return imgResult; 
		*/
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	public void PrintGood(String goodname) {
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
