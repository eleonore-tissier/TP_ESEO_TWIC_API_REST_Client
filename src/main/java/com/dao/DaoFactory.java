package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoFactory {
	private static Logger logger = Logger.getLogger(DaoFactory.class.getName());
	
	private String url;
	private String username;
	private String password;
	
	public DaoFactory() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.log(Level.WARNING, e.getMessage());
		}
		this.url = "jdbc:mysql://localhost:3306/ville_france";
		this.username = "root";
		this.password = "network";
	}
	
	public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
	}
}
