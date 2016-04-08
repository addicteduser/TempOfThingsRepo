package database;

import java.io.File;
import java.util.Scanner;

public class DbConfig {
	private static String url;
	private static String user;
	private static String password;
	private static String driverClass;

	/**
	 * Fetches the values from the DbConectionFactory.ini file.
	 * If DbConectionFactory.ini does not exist, create the file in the /resources/ folder with the following:
	 * 		URL = jdbc:mysql://localhost:3306/gateway_server
	 * 		USER = <your db username>
	 * 		PASSWORD = <your db password>
	 * 		DRIVER_CLASS = com.mysql.jdbc.Driver
	 */
	public static void initialize(){
		try {
			File f = new File(".\\resources\\DbConnectionFactory.ini");
			Scanner s = new Scanner(f);

			while (s.hasNextLine()){
				String currentLine = s.nextLine().trim();
				String[] pair = currentLine.split("=");
				String var = pair[0].trim().toUpperCase();
				String value = pair[1].trim();
				switch(var){
				case "URL": 
					url = value;
					break;
				case "USER":
					user = value;
					break;
				case "PASSWORD":
					password = value;
					break;
				case "DRIVER_CLASS":
					driverClass = value;
					break;
				default: 
					System.err.println("Unknown variable [" + var + "] being assigned with " + value);
					break;
				}
			}

			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @return the url
	 */
	public static String getUrl() {
		return url;
	}

	/**
	 * @return the user
	 */
	public static String getUser() {
		return user;
	}

	/**
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}

	/**
	 * @return the driver_class
	 */
	public static String getDriverClass() {
		return driverClass;
	}

}
