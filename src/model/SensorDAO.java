package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import database.ConnectionFactory;
import database.DbUtil;

public class SensorDAO {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static String query = "";
	private static ResultSet rs = null;
	
	public static Sensor getCurrentTemperature(int sensor) {
		Sensor temp = null;
		String tablename = "";
		
		if (sensor == 1)
			tablename = "sensor1";
		else
			tablename = "sensor2";
		
		query = "SELECT * FROM "+tablename+" ORDER BY timestamp DESC LIMIT 1";
		
		conn = ConnectionFactory.getConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			Timestamp timestamp = rs.getTimestamp("timestamp");
			float tempdata = rs.getFloat("temperature");
			temp = new Sensor(timestamp, tempdata);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DbUtil.close(rs);
			DbUtil.close(stmt);
			DbUtil.close(conn);
		}		
		
		return temp;
	}
}
