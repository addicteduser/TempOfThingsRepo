package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SensorDAO {
	private static Connection conn = null;
	private static PreparedStatement sql = null;
	
	public static float getCurrentTemperature(int sensor) {
		float temp = 0;
		
		return temp;
	}
}
