package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NoticeDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public ArrayList<NoticeVo> setNoticeP(String storeNo) {
		
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		
		try {
		
			
		conn = Main.db.dbConn;
		stmt = DBDAO.setStmt(conn);	
		
		String findA ="SELECT ROWNUM, X.* FROM (SELECT * FROM NOTICE "
				+ "WHERE STORENO = '"+storeNo+"' ORDER BY NOTICETIME) X";
		
		
		rs = DBDAO.setRsAll(stmt,findA);
		while(rs.next()) {
			String rowNum = rs.getString("ROWNUM");
			String contents = rs.getString("CONTENTS");
			
			
			NoticeVo data = new NoticeVo(rowNum, contents);
			list.add(data);
		}
		
		rs.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public int insertNotice(String contents, String storeNo){
		
		
		
		try {
		
		conn = Main.db.dbConn;
		stmt = DBDAO.setStmt(conn);	
		
		String insert ="INSERT INTO NOTICE VALUES(to_char(systimestamp,'YYYY-MM-DD hh24:mi:ss')"
				+ ",'"+contents+"',+'"+storeNo+"')";
		
		boolean b = stmt.execute(insert);
		if(!b) {
			return 1;
		}else {
			System.out.println("why?");
			return 0;
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
}
