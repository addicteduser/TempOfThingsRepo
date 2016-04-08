package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

public class FrameUI extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JButton btnRefresh;
	private JPanel pnlTab1;
	private JPanel pnlTab2;
	private JPanel pnlTab3;
	private JPanel pnlCurr1;
	private JPanel pnlCurr2;
	private JLabel lblCurr1;
	private JLabel lblTemp1;
	private JLabel lblTimestamp1;
	private JLabel lblAsOf1;
	private JLabel lblCurr2;
	private JLabel lblTemp2;
	private JLabel lblAsOf2;
	private JLabel lblTimestamp2;
	private JTable tblSensor1;
	private JTable tblSensor2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameUI frame = new FrameUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameUI() {
		initGUI();
	}
	
	private void initGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		pnlTab1 = new JPanel();
		tabbedPane.addTab("Current", null, pnlTab1, null);
		pnlTab1.setLayout(new BoxLayout(pnlTab1, BoxLayout.X_AXIS));
		
		pnlCurr1 = new JPanel();
		pnlCurr1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTab1.add(pnlCurr1);
		pnlCurr1.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblCurr1 = new JLabel("Sensor #1");
		lblCurr1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCurr1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurr1.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCurr1.add(lblCurr1);
		
		lblTemp1 = new JLabel("<temp>");
		lblTemp1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTemp1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTemp1.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCurr1.add(lblTemp1);
		
		lblAsOf1 = new JLabel("as of");
		lblAsOf1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAsOf1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsOf1.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlCurr1.add(lblAsOf1);
		
		lblTimestamp1 = new JLabel("<timestamp>");
		lblTimestamp1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTimestamp1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimestamp1.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlCurr1.add(lblTimestamp1);
		
		pnlCurr2 = new JPanel();
		pnlCurr2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTab1.add(pnlCurr2);
		pnlCurr2.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblCurr2 = new JLabel("Sensor #2");
		lblCurr2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurr2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurr2.setAlignmentX(0.5f);
		pnlCurr2.add(lblCurr2);
		
		lblTemp2 = new JLabel("<temp>");
		lblTemp2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemp2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTemp2.setAlignmentX(0.5f);
		pnlCurr2.add(lblTemp2);
		
		lblAsOf2 = new JLabel("as of");
		lblAsOf2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsOf2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAsOf2.setAlignmentX(0.5f);
		pnlCurr2.add(lblAsOf2);
		
		lblTimestamp2 = new JLabel("<timestamp>");
		lblTimestamp2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimestamp2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimestamp2.setAlignmentX(0.5f);
		pnlCurr2.add(lblTimestamp2);
		
		pnlTab2 = new JPanel();
		pnlTab2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("Sensor #1", null, pnlTab2, null);
		pnlTab2.setLayout(new BorderLayout(0, 0));
		
		tblSensor1 = new JTable();
		tblSensor1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Timestamp", "Temperature"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblSensor1.getColumnModel().getColumn(0).setResizable(false);
		tblSensor1.getColumnModel().getColumn(1).setResizable(false);
		tblSensor1.setRowSelectionAllowed(false);
		JScrollPane scrollPane1 = new JScrollPane(tblSensor1);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlTab2.add(scrollPane1, BorderLayout.CENTER);
		
		pnlTab3 = new JPanel();
		pnlTab3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("Sensor #2", null, pnlTab3, null);
		pnlTab3.setLayout(new BorderLayout(0, 0));
		
		tblSensor2 = new JTable();
		tblSensor2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Timestamp", "Temperature"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblSensor2.getColumnModel().getColumn(0).setResizable(false);
		tblSensor2.getColumnModel().getColumn(1).setResizable(false);
		tblSensor2.setRowSelectionAllowed(false);
		JScrollPane scrollPane2 = new JScrollPane(tblSensor2);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlTab3.add(scrollPane2);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnRefresh, BorderLayout.SOUTH);
	}
	
	public void addBtnRefreshActionListener(ActionListener l) {
		btnRefresh.addActionListener(l);
	}
	
	public int getTabNumber() {
		return tabbedPane.getSelectedIndex();
	}
	
	public void setCurrentTemp(String ts1, String td1, String ts2, String td2) {
		lblTimestamp1.setText(ts1);
		lblTemp1.setText(td1);
		lblTimestamp2.setText(ts2);
		lblTemp2.setText(td2);
	}
	
	public void setPastTemp(DefaultTableModel model1, DefaultTableModel model2) {
		tblSensor1.setModel(model1);
		tblSensor2.setModel(model2);
	}
}
