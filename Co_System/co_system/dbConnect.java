import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JTable;

public class dbConnect {
	
	Connection conn = null;
	private static final String URL = "jdbc:mysql://localhost:3306/co_system";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	public dbConnect() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch(SQLException sqe){
			sqe.printStackTrace();
		}
		
	}
	
	public ResultSet getAllPosition(){
		
		Statement stm;
		ResultSet reset = null;
		
		try{
			stm = conn.createStatement();
			reset = stm.executeQuery("SELECT * FROM position");
			
			System.out.println(""+reset.getInt(1));
			
		}catch(SQLException sqe){
			sqe.printStackTrace();
		}
		
		return reset;
	}
	
	public void conClose(){
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
