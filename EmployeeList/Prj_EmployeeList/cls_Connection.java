import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cls_Connection {

	Connection conn = null;
	private static final String URL = "jdbc:mysql://localhost:3306/employeelist";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	public cls_Connection() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch(SQLException sqe){
			sqe.printStackTrace();
		}
		
	}
	
	public int addEmployee(String namep, String em_idp, String phnop, String postp, int salp){
		
		String name, em_id, phno, post;
		int sal;
		int result = 0;
		
		name = namep;
		em_id = em_idp;
		phno = phnop;
		post = postp;
		sal = salp;
		
		try {
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO emlist (name, em_id, phone, post, salary) VALUES (?, ?, ?, ?, ?)");
			
			pstm.setString(1, name);
			pstm.setString(2, em_id);
			pstm.setString(3, phno);
			pstm.setString(4, post);
			pstm.setInt(5, sal);
			
			result = pstm.executeUpdate();
		} catch (SQLException sqe) {
			sqe.printStackTrace();
			closeConn();
		}
		
		return result;
		
	}
	
	public List<cls_Employees> getAllEmployee(){
		
		List<cls_Employees> results = null;
		Statement stm;
		ResultSet reset = null;
		
		try{
			stm = conn.createStatement();
			reset = stm.executeQuery("SELECT * FROM emlist");
			results = new ArrayList<cls_Employees>();
			
			while(reset.next()){
				results.add(new cls_Employees(reset.getInt("id"), reset.getString("name"), reset.getString("em_id"), reset.getString("phone"),
						reset.getString("post"), reset.getInt("salary")));
			}
		}catch(SQLException sqe){
			sqe.printStackTrace();
			closeConn();
		}finally{
			try {
				reset.close();
			} catch (SQLException e) {
				e.printStackTrace();
				closeConn();
			}
		}
		
		return results;
		
	}
	
	public List<cls_Employees> getSearchEmployee(String name){
		
		List<cls_Employees> results = null;
		PreparedStatement pstm;
		ResultSet reset = null;
		
		try{
			pstm = conn.prepareStatement("SELECT * FROM emlist WHERE name = ?");
			pstm.setString(1, name);
			reset = pstm.executeQuery();
			results = new ArrayList<cls_Employees>();
			
			while(reset.next()){
				results.add(new cls_Employees(reset.getInt("id"), reset.getString("name"), reset.getString("em_id"), reset.getString("phone"),
						reset.getString("post"), reset.getInt("salary")));
			}
		}catch(SQLException sqe){
			sqe.printStackTrace();
			closeConn();
		}finally{
			try {
				reset.close();
			} catch (SQLException e) {
				e.printStackTrace();
				closeConn();
			}
		}
		
		return results;
		
	}
	
	public int deleteEmployee(int id){
		
		int result = 0;
		PreparedStatement pstm;
		
		try{
			pstm = conn.prepareStatement("DELETE FROM emlist WHERE id = ?");
			pstm.setInt(1, id);
			result = pstm.executeUpdate();
		}catch(SQLException sqe){
			sqe.printStackTrace();
			closeConn();
		}
		
		return result;
		
	}
	
	public int editEmployee(int id, String name, String em_id, String phone, String post, int salary){
		
		int result = 0;
		PreparedStatement pstm;
		
		try{
			pstm = conn.prepareStatement("UPDATE emlist SET name=?, em_id=?, phone=?, post=?, salary=? WHERE id=?");
			pstm.setString(1, name);
			pstm.setString(2, em_id);
			pstm.setString(3, phone);
			pstm.setString(4, post);
			pstm.setInt(5, salary);
			pstm.setInt(6, id);
			result = pstm.executeUpdate();
		}catch(SQLException sqe){
			sqe.printStackTrace();
			closeConn();
		}
		
		return result;
		
	}
	
	public void closeConn(){
		
		try {
			conn.close();
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		}
		
	}
	
}
