package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParolaDAO {
	
	
	
	public boolean checkDizionario(String parola){
		String jdbcURL= "jdbc:mysql://localhost/dizionario?user=root";
		try {
			Connection c = DriverManager.getConnection(jdbcURL);
			PreparedStatement st = c.prepareStatement("SELECT nome FROM parola WHERE nome = ?");
			st.setString(1, parola);
			st.executeQuery();
			ResultSet result = st.getResultSet();
			if(result == null){
				c.close();
				return false;
			}
			else if(result.next()){
				if(result.getString("nome").compareTo(parola) == 0){
					result.close();
					c.close();
					return true;
				}
				else{
					result.close();
					c.close();
					return false;
				}
			}
			else {
				result.close();
				c.close();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
