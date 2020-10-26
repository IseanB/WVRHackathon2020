import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class IndexFrame2020 extends JFrame implements ActionListener{
	

	String teamNumberRawData;

	String teamNumberRobotType;
	static JButton backButton;
	static JButton rawDataButton;
	static JButton robotTypeButton;
	static JButton Pointranking;
	static JButton rawDataAllButton;
	static JButton notesButton;
	static JTextField robotTypetextfield;
	static JTextField rawDatatextfield;
	

	
	IndexFrame2020() {
		
		//back
		backButton = new JButton();
		backButton.setBounds(20, 20, 100, 25);
		backButton.setText("Back");
		backButton.addActionListener(this);
		
		//raw data
		rawDataButton = new JButton();
		rawDataButton.setBounds(900, 200, 100, 50);
		rawDataButton.setText("Specific Team");
		rawDataButton.addActionListener(this);
		
		//all raw data
		rawDataAllButton = new JButton();
		rawDataAllButton.setBounds(1050, 200, 100, 50);
		rawDataAllButton.setText("All Data");
		rawDataAllButton.addActionListener(this);
		
		//raw data text field
		rawDatatextfield = new JTextField();
		rawDatatextfield.setBounds(650, 200, 200, 50);

		
		//line 2: robot Type button
		robotTypeButton = new JButton();
		robotTypeButton.setBounds(900, 275, 200, 50);
		robotTypeButton.setText("Robot Type");
		robotTypeButton.addActionListener(this);

		//robot Type text field
		robotTypetextfield = new JTextField();
		robotTypetextfield.setBounds(650, 275, 200, 50);
		
		//line 3: point ranking
		Pointranking = new JButton();
		Pointranking.setBounds(650, 350, 200, 50);
		Pointranking.setText("Point Ranking");
		Pointranking.addActionListener(this);
		
		//notes button
		notesButton = new JButton();
		notesButton.setBounds(650, 425, 200, 50);
		notesButton.setText("Notes");
		notesButton.addActionListener(this);
		
		
		
		
		
		this.setTitle("WVR Scouting App: Index Frame 2020"); // Titles the Window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the X is clicked, the window closes
		this.setResizable(false); // Keeps a consistent window size.
		this.setSize(1200,600);  // In pixels, the size of the widow. (width x height)
		this.setVisible(true); // Makes the frame visible
		Color customColor = new Color(93, 188, 210); //Creates a background color
		this.getContentPane().setBackground(customColor);
		this.setLayout(null);

		this.add(backButton);
		
		this.add(rawDataButton);
		this.add(rawDataAllButton);
		this.add(rawDatatextfield);
		
		this.add(robotTypeButton);
		this.add(robotTypetextfield);
		
		
		this.add(Pointranking);
		
		this.add(notesButton);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==backButton) {
			this.dispose();
			MainFrame mainframe = new MainFrame();
		} 
		if (e.getSource()==rawDataButton) {
			teamNumberRawData = rawDatatextfield.getText();
			System.out.println(rawDatatextfield.getText());
			rawDatatextfield.setText(" ");
			
		}
		
		if (e.getSource()==robotTypeButton) {
			teamNumberRobotType = robotTypetextfield.getText();
			System.out.println(robotTypetextfield.getText());
			robotTypetextfield.setText(" ");
		}
	}
}
