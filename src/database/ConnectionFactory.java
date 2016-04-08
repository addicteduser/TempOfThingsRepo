package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();

	/**
	 * Private constructor
	 */
	private ConnectionFactory() {
		DbConfig.initialize();
		try {
			Class.forName(DbConfig.getDbdriverclass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(DbConfig.getDburl(), DbConfig.getDbuser(), DbConfig.getDbpass());
		} catch (SQLException e) {
			System.err.println("Unable to Connect to Database.");
		}
		
		return connection;
	}

	/**
	 * @return the Connection instance
	 */
	public static Connection getConnection() {
		return instance.createConnection();
	}
	
}