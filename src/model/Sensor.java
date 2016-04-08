package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Sensor {
	private Timestamp timestamp;
	private float tempdata;
	
	public Sensor(Timestamp ts, float td) {
		timestamp = ts;
		tempdata = td;
	}
	
	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the tempdata
	 */
	public float getTempdata() {
		return tempdata;
	}
	/**
	 * @param tempdata the tempdata to set
	 */
	public void setTempdata(float tempdata) {
		this.tempdata = tempdata;
	}
	
	
}
