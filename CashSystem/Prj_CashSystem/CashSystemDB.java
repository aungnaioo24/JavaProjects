import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class CashSystemDB extends database{
	
	public ResultSet getItem(int code){
		
		ResultSet reset=null;
		PreparedStatement pstm;
		
		try {
			pstm = conn.prepareStatement("SELECT * FROM items WHERE item_code=?");
			pstm.setInt(1, code);
			reset = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reset;
	}
	
	public int addItem(ArrayList<Item> items){
		int result = 0;
		Item item;
		PreparedStatement pstm;
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		
		try {
			pstm = conn.prepareStatement("INSERT INTO items_sold (items_name, items_code, items_prize, items_qty, items_discount, items_date) VALUES (?, ?, ?, ?, ?, ?)");
			for(int i=0; i<items.size(); i++){
				item = items.get(i);
				pstm.setString(1, item.getName());
				pstm.setInt(2, item.getCode());
				pstm.setInt(3, item.getPrize());
				pstm.setInt(4, item.getQty());
				pstm.setInt(5, item.getDiscount());
				pstm.setString(6, currentTime);
				
				result = pstm.executeUpdate();
				if(result != 1){
					return result;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn();
		}
		
		for(int i=0; i<items.size(); i++){
			items.remove(i);
		}
	
		return result;
	}
	
}
