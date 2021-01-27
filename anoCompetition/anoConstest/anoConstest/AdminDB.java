package anoConstest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminDB extends DB_Config{

	public ResultSet loadColumn() {
		
		Statement stm;
		ResultSet result = null;
		
		try {
			
			stm = conn.createStatement();
			result = stm.executeQuery("SELECT title FROM questions");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConn();
		}
		
		
		return result;
	}
	
	public ResultSet loadTeams() {
		
		Statement stm;
		ResultSet result = null;
		
		try {
			stm = conn.createStatement();
			result = stm.executeQuery("SELECT id, name FROM teams");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConn();
		}
		
		return result;
	}
	
	public ResultSet loadResults(int team_id) {
		
		PreparedStatement pstm;
		ResultSet result = null;
		
		try {
			pstm = conn.prepareStatement("SELECT questions.title, answers.status FROM questions LEFT JOIN answers ON questions.id = answers.question_id WHERE answers.team_id=?");
			pstm.setInt(1, team_id);
			result = pstm.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConn();
		}
		
		return result;
	}
	
}
