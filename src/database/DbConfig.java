package database;

import java.io.File;
import java.io.IOException;

import org.ini4j.Ini;
import org.ini4j.Profile.Section;

public class DbConfig {
	private static String dbhost;
	private static String dbuser;
	private static String dbpass; 
	private static String dbname; 
	private static String dburl;
	private static String dbdriver;
	private static String dbport;
	private static String dbconnect;
	
	/**
	 * Fetches the values from the config.ini file.
	 */
	public static void initialize() {
		// Set filepath of .INI file
		File f = new File(".\\resources\\config.ini");
		try {
			Ini ini = new Ini(f);
			
			// Set the section you want to access data from
			Section section = ini.get("DATABASE");
			
			// Get data
			dbhost = section.get("dbhost");
			dbuser = section.get("dbuser");
			dbpass = section.get("dbpass");
			dbname = section.get("dbname");
			dburl = section.get("dburl");
			dbdriver = section.get("dbdriver");
			dbport = section.get("dbport");
			
			// jdbc:mysql://<dbhost>:<dbport>/<dbname>
			dbconnect = dburl+"//"+dbhost+":"+dbport+"/"+dbname;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the dbhost
	 */
	public static String getDbhost() {
		return dbhost;
	}

	/**
	 * @return the dbuser
	 */
	public static String getDbuser() {
		return dbuser;
	}

	/**
	 * @return the dbpass
	 */
	public static String getDbpass() {
		return dbpass;
	}

	/**
	 * @return the dbname
	 */
	public static String getDbname() {
		return dbname;
	}

	/**
	 * @return the dburl
	 */
	public static String getDburl() {
		return dburl;
	}

	/**
	 * @return the dbdriver
	 */
	public static String getDbdriver() {
		return dbdriver;
	}
	
	/**
	 * @return the dbdriverclass
	 */
	public static String getDbconnect() {
		return dbconnect;
	}
}
