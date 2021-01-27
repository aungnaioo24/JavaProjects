import java.sql.*;

public class Cls_Database {
	
	Connection conn;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	
	public Cls_Database(Connection conn, String URL, String USERNAME, String PASSWORD){
		this.conn = conn;
		this.URL = URL;
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
	}
	
	public void cls_Connection() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch(SQLException sqe){
			sqe.printStackTrace();
		}
		
	}
	
}
