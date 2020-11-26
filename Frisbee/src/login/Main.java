
package login;

public class Main {

	static DBDAO db = new DBDAO();
	
	
	public static void main(String[] args) {
		db.dbConn = db.getConnection();
		LoginFrame lg = new LoginFrame();
		lg.setFrame();
		
	}

}
