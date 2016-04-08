package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Sensor;
import model.SensorDAO;
import view.FrameUI;

public class Controller {
	private static FrameUI frame = new FrameUI();
	
	public Controller() {
		// Build database + content
		frame.addBtnRefreshActionListener(new BtnRefreshAction());
		frame.setVisible(true);
	}
	
	class BtnRefreshAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int tabNumber = frame.getTabNumber();
			
			switch(tabNumber) {
			case 0: // get current temperature for both sensors
				Sensor sensor1 = SensorDAO.getCurrentTemperature(1);
				Sensor sensor2 = SensorDAO.getCurrentTemperature(2);
				frame.setCurrentTemp(sensor1.getTimestamp().toString(), Float.toString(sensor1.getTempdata()), sensor2.getTimestamp().toString(), Float.toString(sensor2.getTempdata()));
				break;
			case 1: // get last 10 temperature data for sensor 1
				break;
			case 2:  // get last 10 temperature data for sensor 1
				break;
			}
		}

	}
}
