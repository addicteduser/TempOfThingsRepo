package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

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
			String[] colNames = new String[] {"Timestamp", "Temperature"};
			
			// TAB #1: get current temperature for both sensors
			Sensor sensor1 = SensorDAO.getCurrentTemperature(1);
			Sensor sensor2 = SensorDAO.getCurrentTemperature(2);

			// TAB #2: get past temp data for sensor #1
			ArrayList<Sensor> sensors1 = SensorDAO.getPastTemperature(1);
			DefaultTableModel model1 = new DefaultTableModel();
			model1.setColumnIdentifiers(colNames);
			for (Sensor s : sensors1) {
				Object[] row = new Object[] {s.getTimestamp(), s.getTempdata()};
				model1.addRow(row);
			}
			
			// TAB #2: get past temp data for sensor #2
			ArrayList<Sensor> sensors2 = SensorDAO.getPastTemperature(2);
			DefaultTableModel model2 = new DefaultTableModel();			
			model2.setColumnIdentifiers(colNames);			
			for (Sensor s : sensors2) {
				Object[] row = new Object[] {s.getTimestamp(), s.getTempdata()};
				model2.addRow(row);
			}
			
			// Pass data to UI
			frame.setCurrentTemp(sensor1.getTimestamp().toString(), Float.toString(sensor1.getTempdata()), sensor2.getTimestamp().toString(), Float.toString(sensor2.getTempdata()));
			frame.setPastTemp(model1, model2);
		}

	}
}
