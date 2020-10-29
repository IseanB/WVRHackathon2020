import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class IndexFrame2020 extends MainFrame implements ActionListener{
	

	String teamNumberRawData;

	String teamNumberRobotType;
	static JButton backButton;
	static JButton rawDataButton;
	static JButton Pointranking;
	static JButton rawDataAllButton;
	static JButton notesButton;
	static JTextField rawDatatextfield;
	static JButton visualButton;
	private JFrame frame;
	private int teamnum;

	
	IndexFrame2020(JFrame frame1, int teamnum1) {
		
		frame = frame1;
		teamnum = teamnum1;
		//back
		frame.dispose();
		
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
		rawDataAllButton.setText("Robot Analytics");
		rawDataAllButton.addActionListener(this);
		
		//raw data text field
		rawDatatextfield = new JTextField();
		rawDatatextfield.setBounds(650, 200, 200, 50);



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
		
		rawDatatextfield.setText("Enter Team#");
		
		visualButton = new JButton();
		visualButton.setBounds(650, 500, 200, 50);
		visualButton.setText("Visuals");
		visualButton.addActionListener(this);

		//adding
		frame.add(visualButton);
		
		/**
		this.setTitle("WVR Scouting App: Index Frame 2020"); // Titles the Window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the X is clicked, the window closes
		this.setResizable(false); // Keeps a consistent window size.
		this.setSize(1200,600);  // In pixels, the size of the widow. (width x height)
		this.setVisible(true); // Makes the frame visible
		Color customColor = new Color(93, 188, 210); //Creates a background color
		this.getContentPane().setBackground(customColor);
		this.setLayout(null);
		*/
		frame.add(backButton);
		
		frame.add(rawDataButton);
		frame.add(rawDataAllButton);
		frame.add(rawDatatextfield);

		frame.add(Pointranking);
		
		frame.add(notesButton);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==backButton) {
			frame.remove(backButton);
			frame.remove(rawDataButton);
			frame.remove(rawDataAllButton);
			frame.remove(rawDatatextfield);
			frame.remove(Pointranking);
			frame.remove(notesButton);
			new MainFrame();
		} 
		else if(e.getSource()==visualButton) {
			frame.remove(backButton);
			frame.remove(rawDataButton);
			frame.remove(rawDataAllButton);
			frame.remove(rawDatatextfield);
			frame.remove(Pointranking);
			frame.remove(notesButton);
			frame.remove(visualButton);
			try {
				new VisualFrame(frame, Integer.parseInt(rawDatatextfield.getText()));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
}
