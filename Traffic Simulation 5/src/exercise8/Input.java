package exercise8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 

public class Input extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextField simText = null;
	JTextField genRateText = null;
	JTextField redCarText = null;
	JTextField blueCarText = null;
	JTextField yellowCarText = null;
	JTextField purpleCarText = null;
	Config config = new Config();
	
	public Input(String title) {
		super(title);
	}
	
	public static void main(String[] args) {
		Input frame = new Input("Swing Example");
		frame.setSize(350, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.placeComponents(panel);
		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JLabel simLabel = new JLabel("Simulator Time:");
		simLabel.setBounds(10, 20, 140, 25);
		panel.add(simLabel);
		
		simText = new JTextField("0");
		simText.setBounds(160, 20, 165, 25);
		panel.add(simText);
		
		JLabel genRateLabel = new JLabel("Car Generation Rate (%):");
		genRateLabel.setBounds(10, 50, 140, 25);
		panel.add(genRateLabel);
		
		genRateText = new JTextField("0");
		genRateText.setBounds(160, 50, 165, 25);
		panel.add(genRateText);
		
		JLabel redCarLabel = new JLabel("Red Cars (%):");
		redCarLabel.setBounds(10, 80, 140, 25);
		panel.add(redCarLabel);
		
		redCarText = new JTextField("0");
		redCarText.setBounds(160, 80, 165, 25);
		panel.add(redCarText);
		
		JLabel blueCarLabel = new JLabel("Blue Cars (%):");
		blueCarLabel.setBounds(10, 110, 140, 25);
		panel.add(blueCarLabel);
		
		blueCarText = new JTextField("0");
		blueCarText.setBounds(160, 110, 165, 25);
		panel.add(blueCarText);
		
		JLabel yellowCarLabel = new JLabel("Yellow Cars (%):");
		yellowCarLabel.setBounds(10, 140, 140, 25);
		panel.add(yellowCarLabel);
		
		yellowCarText = new JTextField("0");
		yellowCarText.setBounds(160, 140, 165, 25);
		panel.add(yellowCarText);
		
		JLabel purpleCarLabel = new JLabel("Purple Cars (%):");
		purpleCarLabel.setBounds(10, 170, 140, 25);
		panel.add(purpleCarLabel);
		
		purpleCarText = new JTextField("0");
		purpleCarText.setBounds(160, 170, 165, 25);
		panel.add(purpleCarText);
		
		JButton startButton = new JButton("Start");
		startButton.setBounds(10, 200, 80, 25);
		panel.add(startButton);
		startButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String simTime = simText.getText();
		String carRate = genRateText.getText();
		String redCar = redCarText.getText();
		String blueCar = blueCarText.getText();
		String yellowCar = yellowCarText.getText();
		String purpleCar = purpleCarText.getText();
		
		config.write(simTime, carRate, redCar, blueCar, yellowCar, purpleCar);
	}
	
}