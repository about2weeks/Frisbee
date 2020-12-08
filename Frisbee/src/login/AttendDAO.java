package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AttendDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public ArrayList<AttendVo> setAttendP(String empNo) {
		
		ArrayList<AttendVo> list = new ArrayList<AttendVo>();
		
		try {
		
			
		conn = Main.db.dbConn;
		stmt = DBDAO.setStmt(conn);	
		
		String findA ="SELECT ROWNUM, X.* FROM (SELECT * FROM ATTEND WHERE EMPNO = '"
		+empNo+ "' ORDER BY ATTENDTIME) X";
		
		
		rs = DBDAO.setRsAll(stmt,findA);
		while(rs.next()) {
			String rowNum = rs.getString("ROWNUM");
			String AttendTime = rs.getString("ATTENDTIME");
			String StartTime = rs.getString("STARTTIME");
			String EndTime =  rs.getString("ENDTIME");
			String WholeTime = rs.getString("WHOLETIME");
			
			
			AttendVo data = new AttendVo(AttendTime, StartTime, EndTime, WholeTime,rowNum);
			list.add(data);
		}
		
		rs.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<AttendVo> setAttendA(String storeNo) {
		
		ArrayList<AttendVo> list = new ArrayList<AttendVo>();
		
		try {
		
			
		conn = Main.db.dbConn;
		stmt = DBDAO.setStmt(conn);		
		
		String find ="SELECT ROW_NUMBER() OVER(ORDER BY ATTENDTIME) ROW_NUM , X.* FROM (SELECT ATTENDTIME, EMPNAME,"
				+ "STARTTIME, ENDTIME, WHOLETIME FROM ATTEND a, EMP e WHERE a.EMPNO = e.EMPNO  AND a.STORENO  = '"
				+ storeNo+"') X";
		
		
		rs = DBDAO.setRsAll(stmt, find);
		System.out.println(rs.getRow());
		while(rs.next()) {
			
			String empName = rs.getString("EMPNAME");
			String AttendTime = rs.getString("ATTENDTIME");
			String StartTime = rs.getString("STARTTIME");
			String EndTime =  rs.getString("ENDTIME");
			String WholeTime = rs.getString("WHOLETIME");
			String rowNum = rs.getString("ROWNUM");
			
			AttendVo data = new AttendVo(empName, AttendTime, StartTime, EndTime, WholeTime,rowNum);
			list.add(data);
		}
		
		rs.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int insertAttend(String empno, String storeNo, String date, String start, String end, String whole) {
		try {
			conn = Main.db.dbConn;
			stmt = DBDAO.setStmt(conn);	
			
			String insert = "INSERT INTO ATTEND (ATTENDTIME, EMPNO, STARTTIME, ENDTIME, WHOLETIME, STORENO) "
					+ "VALUES(TO_DATE('"+date+"','YYYY-MM-DD'),'"+empno+"', "
					+ "TO_DATE('"+date+" "+start+"','YYYY-MM-DD HH24:MI'),"
					+ "TO_DATE('"+date+" "+end+"','YYYY-MM-DD HH24:MI'),"+whole+",'"+storeNo+"')";
			
			
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
