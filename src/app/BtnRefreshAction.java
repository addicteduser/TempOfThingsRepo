package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Sensor;
import model.SensorDAO;

public class BtnRefreshAction implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Sensor sensor = SensorDAO.getCurrentTemperature(1);
		System.out.println(sensor.getTimestamp()+" // "+sensor.getTempdata());
	}

}
