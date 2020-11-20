package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rsE;
	private ResultSet rsEI;
	private ResultSet rsI;
	
	public int findID(String empno, String id, String pwd){
		
		try {
			
			conn = DBDAO.getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			String findEMP = "SELECT * FROM EMP";
			if(empno!=null) {
				findEMP += " WHERE EMPNO = '"+empno.toUpperCase()+"'";
			}
			System.out.println("SQL :" +findEMP);
			//직원 코드가 존재하는지 찾기 
			
			
			String findEMPID = "SELECT * FROM LOGIN";
			if(empno!=null) {
				findEMPID += " WHERE EMPNO = '"+empno.toUpperCase()+"'";
			}
			System.out.println("SQL :" +findEMPID);
			//직원 코드가 회원가입이 되어있는지 찾기  
			
			String findID = "SELECT * FROM LOGIN";
			if(empno!=null) {
				findID += " WHERE ID = '"+id.toUpperCase()+"'";
			}
			System.out.println("SQL :" +findID);
			//아이디가 이미 존재하는지 찾기 
			
			
			rsE = stmt.executeQuery(findEMP);
			rsE.last();
			
			if(rsE.getRow()==0) {
				return 1; //회원가입 해야한다 
			}
			else {
			 rsEI = stmt.executeQuery(findEMPID);
			 rsEI.last();
			 int EIrow = rsEI.getRow();
			 
			 rsI = stmt.executeQuery(findID);
			 rsI.last();
			 int Irow = rsI.getRow();
				if(EIrow!=0) {
					return 2; //이미 회원가입 되어있음 
				}else if(EIrow==0&&Irow!=0) {
					return 3; //아이디가 이미 있
				}else {
					
					String insert = "INSERT INTO LOGIN VALUES ('"+empno
							+"','"+id+"','"+pwd+"')";
					boolean b = stmt.execute(insert);
					if(b) {
						return 4;
					}else {
						return 5;
					}
					
				}
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
