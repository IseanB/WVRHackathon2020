import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class IndexFrame extends JFrame implements ActionListener{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String teamNumberRawData;

	String teamNumberRobotType;
	static JButton backButton;
	static JButton robotTypeButton;
	static JButton Pointranking;
	static JButton notesButton;
	static JButton visualButton;
	static JTextField rawDatatextfield;
	static JLabel rawDataLabel;
	static JLabel visualLabel;
	static JLabel robotTypeLabel;
	static JLabel pointRankingLabel;
	static JLabel notesLabel;
	public JFrame IndexFrames;
	
	public IndexFrame(JFrame frame) {
		IndexFrames = frame;
		//back
		backButton = new JButton();
		backButton.setBounds(20, 20, 100, 25);
		backButton.setText("Back");
		backButton.addActionListener(this);
		backButton.setFocusable(false);

		//raw data label
		rawDataLabel = new JLabel();
		rawDataLabel.setBounds(200, 200-75, 400, 50);
		rawDataLabel.setText("Input Team#:");
		rawDataLabel.setFocusable(false);
		rawDataLabel.setHorizontalAlignment(JLabel.CENTER);
		rawDataLabel.setFont(new Font("MV Boli", Font.PLAIN,20));
		rawDataLabel.setForeground(new Color(0xFFFFFF));
		
		//raw data text field
		rawDatatextfield = new JTextField();
		rawDatatextfield.setBounds(650, 200-75, 200, 50);
		
		
		
		
		//line 2: robot Type button
		robotTypeButton = new JButton();
		robotTypeButton.setBounds(650, 275-75, 200, 50);
		robotTypeButton.setText("Robot Analyzer ");
		robotTypeButton.addActionListener(this);
		robotTypeButton.setFocusable(false);
		
		//robot Type text field
		//robotTypetextfield = new JTextField();
		//robotTypetextfield.setBounds(650, 275, 200, 50);
		//robotTypetextfield.setFocusable(false);
		
		
		//robot type label
		robotTypeLabel = new JLabel();
		robotTypeLabel.setBounds(200, 275-75, 400, 50);
		robotTypeLabel.setText("Analysis of a Robot: ");
		robotTypeLabel.setFocusable(false);
		robotTypeLabel.setHorizontalAlignment(JLabel.CENTER);
		robotTypeLabel.setFont(new Font("MV Boli", Font.PLAIN,20));
		robotTypeLabel.setForeground(new Color(0xFFFFFF));
		
		//line 3: point ranking
		Pointranking = new JButton();
		Pointranking.setBounds(650, 350-75, 200, 50);
		Pointranking.setText("Point Ranking");
		Pointranking.addActionListener(this);
		Pointranking.setFocusable(false);
		
		//
		pointRankingLabel = new JLabel();
		pointRankingLabel.setBounds(200, 350-75, 400, 50);
		pointRankingLabel.setText("Find out the Rankings: ");
		pointRankingLabel.setFocusable(false);
		pointRankingLabel.setHorizontalAlignment(JLabel.CENTER);
		pointRankingLabel.setFont(new Font("MV Boli", Font.PLAIN,20));
		pointRankingLabel.setForeground(new Color(0xFFFFFF));
		
		//notes button
		notesButton = new JButton();
		notesButton.setBounds(650, 425, 200, 50);
		notesButton.setText("Notes");
		notesButton.addActionListener(this);
		notesButton.setFocusable(false);
		
		//notes Label
		notesLabel = new JLabel();
		notesLabel.setBounds(200, 425, 400, 50);
		notesLabel.setText("Notes on Robots: ");
		notesLabel.setFocusable(false);
		notesLabel.setHorizontalAlignment(JLabel.CENTER);
		notesLabel.setFont(new Font("MV Boli", Font.PLAIN,20));
		notesLabel.setForeground(new Color(0xFFFFFF));
		
		visualButton = new JButton();
		visualButton.setBounds(650, 425-75, 200, 50);
		visualButton.setText("Visual Data");
		visualButton.addActionListener(this);
		visualButton.setFocusable(false);
		
		//notes Label
		visualLabel = new JLabel();
		visualLabel.setBounds(200, 425-75, 400, 50);
		visualLabel.setText("Visual Data for Team: ");
		visualLabel.setFocusable(false);
		visualLabel.setHorizontalAlignment(JLabel.CENTER);
		visualLabel.setFont(new Font("MV Boli", Font.PLAIN,20));
		visualLabel.setForeground(new Color(0xFFFFFF));
		 
		
		IndexFrames.add(backButton);
		IndexFrames.add(visualLabel);
		IndexFrames.add(visualButton);
		IndexFrames.add(rawDatatextfield);
		
		IndexFrames.add(robotTypeButton);
		//IndexFrames.add(robotTypetextfield);
		
		
		IndexFrames.add(Pointranking);
		
		IndexFrames.add(notesButton);
		
		IndexFrames.add(rawDataLabel);
		
		IndexFrames.add(notesLabel);
		IndexFrames.add(pointRankingLabel);
		IndexFrames.add(rawDataLabel);
		IndexFrames.add(robotTypeLabel);
		
		
		IndexFrames.setTitle("WVR Scouting App: Index Frame 2020"); // Titles the Window
		//IndexFrames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the X is clicked, the window closes
		IndexFrames.setResizable(false); // Keeps a consistent window size.
		//IndexFrames.setSize(1200,600);  // In pixels, the size of the widow. (width x height)
		//IndexFrames.setVisible(true); // Makes the frame visible
		//Color customColor = new Color(93, 188, 210); //Creates a background color
		//IndexFrames.getContentPane().setBackground(customColor);
		IndexFrames.setLayout(null);
		IndexFrames.setVisible(false); // Makes the frame visible
		IndexFrames.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource()==backButton) {
			//please copy and paste this chunk outside the if statements in the final verision for more efficieny
			backButton.setVisible(false);
			rawDataLabel.setVisible(false);
			rawDatatextfield.setVisible(false);
			robotTypeLabel.setVisible(false);
			robotTypeButton.setVisible(false);
			visualLabel.setVisible(false);
			visualButton.setVisible(false);
			Pointranking.setVisible(false);
			notesButton.setVisible(false);
			notesLabel.setVisible(false);
			pointRankingLabel.setVisible(false);
			rawDataLabel.setVisible(false);
			

			
		} else if (e.getSource()==robotTypeButton) {
			backButton.setVisible(false);
			rawDataLabel.setVisible(false);
			rawDatatextfield.setVisible(false);
			robotTypeLabel.setVisible(false);
			robotTypeButton.setVisible(false);
			visualLabel.setVisible(false);
			visualButton.setVisible(false);
			Pointranking.setVisible(false);
			notesButton.setVisible(false);
			notesLabel.setVisible(false);
			pointRankingLabel.setVisible(false);
			rawDataLabel.setVisible(false);
			
			try {
				new DetailFrame(IndexFrames, Integer.parseInt(rawDatatextfield.getText()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		} else if (e.getSource()==notesButton) {
			
		} else if (e.getSource()==Pointranking) {
			
		} else if(e.getSource()==visualButton) {
			backButton.setVisible(false);
			rawDataLabel.setVisible(false);
			rawDatatextfield.setVisible(false);
			robotTypeLabel.setVisible(false);
			robotTypeButton.setVisible(false);
			visualLabel.setVisible(false);
			visualButton.setVisible(false);
			Pointranking.setVisible(false);
			notesButton.setVisible(false);
			notesLabel.setVisible(false);
			pointRankingLabel.setVisible(false);
			rawDataLabel.setVisible(false);
			try {
				new VisualFrame(IndexFrames,Integer.parseInt(rawDatatextfield.getText()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}