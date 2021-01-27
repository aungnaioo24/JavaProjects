import java.sql.*;

public class database {
	
	Connection conn = null;
	private static final String URL = "jdbc:mysql://localhost:3306/cash_system";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	public database(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch(SQLException sqe){
			sqe.printStackTrace();
		}
		
	}
	
	public void closeConn(){
		
		try {
			conn.close();
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		}
		
	}
	
}
