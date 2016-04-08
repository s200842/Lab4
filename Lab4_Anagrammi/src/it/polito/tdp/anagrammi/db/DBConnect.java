package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root";
	
	public Connection getConnection(){
		Connection c;
		try {
			c = DriverManager.getConnection(jdbcURL);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
