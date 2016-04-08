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
		updateTabs();
		frame.addBtnRefreshActionListener(new BtnRefreshAction());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * Gets the latest data from the database.
	 */
	protected void updateTabs() {
		// TAB #1: get current temperature for both sensors
		Sensor sensor1 = SensorDAO.getCurrentTemperature(1);
		Sensor sensor2 = SensorDAO.getCurrentTemperature(2);

		// TAB #2: get past temp data for sensor #1
		DefaultTableModel model1 = buildTableModel(SensorDAO.getPastTemperature(1));

		// TAB #2: get past temp data for sensor #2
		DefaultTableModel model2 = buildTableModel(SensorDAO.getPastTemperature(2));			

		// Pass data to UI
		frame.setCurrentTemp(sensor1.getTimestamp().toString(), Float.toString(sensor1.getTempdata()), sensor2.getTimestamp().toString(), Float.toString(sensor2.getTempdata()));
		frame.setPastTemp(model1, model2);
	}
	
	/**
	 * Builds the DefaultTableModel given an ArrayList<Sensor>
	 * @param sensors
	 * @return
	 */
	private DefaultTableModel buildTableModel(ArrayList<Sensor> sensors) {
		// Create model instance with non-editable cells
		DefaultTableModel model = new DefaultTableModel() {
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		// Fill in table content
		String[] colNames = new String[] {"Timestamp", "Temperature"};
		model.setColumnIdentifiers(colNames);
		for (Sensor s : sensors) {
			Object[] row = new Object[] {s.getTimestamp(), s.getTempdata()};
			model.addRow(row);
		}

		return model;
	}

	class BtnRefreshAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			
			updateTabs();
		}
	}
}
