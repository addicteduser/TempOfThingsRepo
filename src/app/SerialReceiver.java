package app;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialReceiver implements SerialPortEventListener {
	private SerialPort serialPort = null;
	CommPortIdentifier portId = null;
	private static final String PORT_NAME = "COM4";

	private BufferedReader input;
	private static final int TIME_OUT = 2000;
	private static final int BAUD_RATE = 9600;

	private static boolean isPortReady = false;

	public SerialReceiver() {
		initialize();
	}

	public void initialize() {	
		try {
			portId = CommPortIdentifier.getPortIdentifier(PORT_NAME);
			isPortReady = true;
		} catch (NoSuchPortException e1) {
			//e1.printStackTrace();
			System.err.println("Could not find COM port: '"+PORT_NAME+"'");
			isPortReady = false;
		}
	}

	public void openPort() {
		if (isPortReady) {
			try {
				// open serial port, and use class name for the appName.
				serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

				// set port parameters
				serialPort.setSerialPortParams(BAUD_RATE,
						SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);

				// open the streams
				input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

				// add event listeners
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
			} catch (Exception e) {
				System.err.println("[openPort] "+e.toString());
			}
		}
	}

	/**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine=null;
				if (input.ready()) {
					inputLine = input.readLine();
					System.out.println("Message: "+inputLine);
				}

			} catch (Exception e) {
				System.err.println("[event ]"+e.toString());
			}
		}
	}

	public boolean IsPortReady() {
		return isPortReady;
	}

	public static void main(String[] args) throws Exception {
		SerialReceiver main = new SerialReceiver();
		if (main.IsPortReady())
			main.openPort();

		Thread t=new Thread() {
			public void run() {
				//the following line will keep this app alive for 1000 seconds,
				//waiting for events to occur and responding to them (printing incoming messages to console).
				try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
			}
		};
		t.start();
		System.out.println("Started");
	}
}
