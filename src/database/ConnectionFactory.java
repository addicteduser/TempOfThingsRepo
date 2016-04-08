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
			Class.forName(DbConfig.getDbdriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(DbConfig.getDbconnect(), DbConfig.getDbuser(), DbConfig.getDbpass());
		} catch (SQLException e) {
			e.printStackTrace();
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