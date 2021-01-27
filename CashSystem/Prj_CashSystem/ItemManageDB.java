import java.sql.*;
import java.util.*;


public class ItemManageDB extends database{

	public int addItem(String name, String dateTime, int code, int qty, int prize, int discount){
		
		int rid = 0;
		
		try {
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO items (item_name, item_code, item_prize, item_qty, item_discount, item_date) VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstm.setString(1, name);
			pstm.setInt(2, code);
			pstm.setInt(3, prize);
			pstm.setInt(4, qty);
			pstm.setInt(5, discount);
			pstm.setString(6, dateTime);
			
			pstm.executeUpdate();
			
			ResultSet reset = pstm.getGeneratedKeys();
			if(reset.next()){
				rid = reset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn();
		}
		
		return rid;
	}
	
	public List<Item> getAllItems(){
		
		List<Item> itemsResult = null;
		Statement stm;
		ResultSet reset = null;
		
		try{
			stm = conn.createStatement();
			reset = stm.executeQuery("SELECT * FROM items");
			itemsResult = new ArrayList<Item>();
			
			while(reset.next()){
				itemsResult.add(new Item(reset.getInt("item_id"), reset.getString("item_name"), reset.getInt("item_code"), reset.getInt("item_qty")
						, reset.getInt("item_prize"), reset.getInt("item_discount"), reset.getString("item_date")));
			}
			
		}catch(SQLException sqe){
			sqe.printStackTrace();
			closeConn();
		}finally{
			try{
				reset.close();
			}catch(SQLException sqe){
				sqe.printStackTrace();
				closeConn();
			}
		}
		
		return itemsResult;
		
	}
	
	public int updateItem(int id, String name, String date, int code, int qty, int prize, int discount){
		
		int result = 0;
		PreparedStatement pstm;
		System.out.println(date);
		
		try {
			pstm = conn.prepareStatement("UPDATE items SET item_name=?, item_code=?, item_qty=?, item_prize=?, item_discount=?, item_date=? WHERE item_id=?");
			pstm.setString(1, name);
			pstm.setInt(2, code);
			pstm.setInt(3, qty);
			pstm.setInt(4, prize);
			pstm.setInt(5, discount);
			pstm.setString(6, date);
			pstm.setInt(7, id);
			
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn();
		}
		
		return result;
	}
	
	public int deleteItem(int id){
		
		int result = 0;
		PreparedStatement pstm;
		
		try{
			pstm = conn.prepareStatement("DELETE FROM items WHERE item_id=?");
			pstm.setInt(1, id);
			
			result = pstm.executeUpdate();
		}catch(SQLException sqe){
			sqe.printStackTrace();
			closeConn();
		}
		
		return result;
	}
	
}
