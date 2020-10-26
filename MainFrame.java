import java.io.IOException;


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JButton button2020;
	public static JButton button2019;
	public static JButton button2018;
	public static JLabel WVRlabel;
	private static JLabel appName;
	private JFrame frame;
	private int teamnum;
	
	public MainFrame() {
		frame = new JFrame();
		teamnum = 33;
		button2020 = new JButton();
		button2020.setBounds(700, 400, 200, 100);
		button2020.setText("2020");
		button2020.addActionListener(this);
		button2020.setFocusable(false);
		
		button2019 = new JButton();
		button2019.setBounds(500, 400, 200, 100);
		button2019.setText("2019");
		button2019.addActionListener(this);
		
		button2019.setFocusable(false);
		
		button2018 = new JButton();
		button2018.setBounds(300, 400, 200, 100);
		button2018.setText("2018");
		button2018.addActionListener(this);
		button2018.setFocusable(false);
		
		
		ImageIcon WVRicon = new ImageIcon("WVR.png");
		
		WVRlabel = new JLabel();
		WVRlabel.setIcon(WVRicon);
		WVRlabel.setBounds(500, 0, 200, 300);
		WVRlabel.setText("FRC Scouting App");
		
		
		frame.add(WVRlabel);
		frame.add(button2018);
		frame.add(button2019);
		frame.add(button2020);
		
		
		frame.setTitle("WVR Scouting App: Main Frame"); // Titles the Window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the X is clicked, the window closes
		frame.setResizable(false); // Keeps a consistent window size.
		frame.setSize(1200,600);  // In pixels, the size of the widow. (width x height)
		Color customColor = new Color(93, 188, 210); //Creates a background color
		frame.getContentPane().setBackground(customColor);
		frame.setLayout(null);
		frame.setVisible(true); // Makes the frame visible
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==button2020) {
			frame.remove(WVRlabel);
			frame.remove(button2018);
			frame.remove(button2019);
			frame.remove(button2020);
			new IndexFrame2020(frame, teamnum);
		}
	}
}

