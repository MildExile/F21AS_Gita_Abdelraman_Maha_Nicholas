package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SimulationGUI implements Observer {

	private CheckInModelForPassengerQueue cimfpq;

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private List list;
	private List list_1;
	private List list_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationGUI window = new SimulationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public SimulationGUI(CheckInModelForPassengerQueue cimfpq) {
		initialize();
		this.cimfpq = cimfpq;
		cimfpq.getPsl().registerObserver(this);

		for (int i = 0; i < cimfpq.getCids().size(); i++) {
			cimfpq.getCids().get(i).registerObserver(this);
			System.out.println(cimfpq.getCids().get(i).getName());
		}
		//cimfpq.getCids().get(0).registerObserver(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1800, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBounds(12, 12, 800, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		list = new List();
		list.setBounds(22, 43, 746, 127);
		panel.add(list);

		list_1 = new List();
		list_1.setBounds(22, 208, 746, 127);
		panel.add(list_1);

		list_2 = new List();
		list_2.setBounds(22, 363, 746, 127);
		panel.add(list_2);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBounds(12, 524, 800, 500);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(51, 12, 248, 203);
		panel_1.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(475, 12, 248, 203);
		panel_1.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(475, 269, 248, 203);
		panel_1.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(51, 269, 248, 203);
		panel_1.add(textField_7);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setBounds(938, 12, 800, 500);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		textField = new JTextField();
		textField.setBounds(69, 28, 248, 203);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(493, 28, 248, 203);
		panel_2.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(69, 285, 248, 203);
		panel_2.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(493, 285, 248, 203);
		panel_2.add(textField_3);

		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_3.setBounds(938, 524, 800, 500);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(106, 77, 117, 25);
		panel_3.add(btnNewButton);

		button = new JButton("New button");
		button.setBounds(106, 294, 117, 25);
		panel_3.add(button);

		button_1 = new JButton("New button");
		button_1.setBounds(542, 77, 117, 25);
		panel_3.add(button_1);

		button_2 = new JButton("New button");
		button_2.setBounds(542, 294, 117, 25);
		panel_3.add(button_2);

		frame.setVisible(true);
	}

	public synchronized void update() {
		updateQueuePanel();
		updateCheckInDeskPanel();
		//updateFlightPanel();

	}

	public void updateQueuePanel() {
		String report = cimfpq.getPsl().GenerateQueueDetails();
		list.add(report);

	}

	public  void updateCheckInDeskPanel() {
		//String report = cimfpq.getCids().get(0).DisplayPassengerDeskInfo();
		//textField.setText(report);
		for (int i = 0; i < cimfpq.getCids().size(); i++) {
			System.out.println(cimfpq.getCids().size());
			String report = cimfpq.getCids().get(i).DisplayPassengerDeskInfo();
			switch (i) {
				case 0 : textField.setText(report);
				case 1 : textField_1.setText(report);
			}

		}
	}

	public void updateFlightPanel() {

	}
}

