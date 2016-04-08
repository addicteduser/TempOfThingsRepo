package app;

import database.DbConfig;
import view.FrameUI;

public class Driver { 
	public static void main(String[] args) {
		FrameUI frame = new FrameUI();
				
		// Build database + content
		frame.addBtnRefreshActionListener(new BtnRefreshAction());
		frame.setVisible(true);
	}
}
