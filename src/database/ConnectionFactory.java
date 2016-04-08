package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();

	//private constructor
	private ConnectionFactory() {
		/* Fetches the values from the DbConectionFactory.ini file.
		 * If DbConectionFactory.ini does not exist, create the file in the /resources/ folder with the following:
		 * 		URL = jdbc:mysql://localhost:3306/gateway_server
		 * 		USER = <your db username>
		 * 		PASSWORD = <your db password>
		 * 		DRIVER_CLASS = com.mysql.jdbc.Driver
		 */
		DbConfig.initialize();
		try {
			Class.forName(DbConfig.getDriverClass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DbConfig.getUrl(), DbConfig.getUser(), DbConfig.getPassword());

		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}

}