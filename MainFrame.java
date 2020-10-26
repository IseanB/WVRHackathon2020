import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainFrame extends JFrame implements ActionListener{
	
	static JButton button2020;
	static JButton button2019;
	static JButton button2018;
	static JLabel appName;
	
	
	MainFrame(){
			
			
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
			
			JLabel WVRlabel = new JLabel();
			WVRlabel.setIcon(WVRicon);
			WVRlabel.setBounds(500, 0, 200, 300);
			WVRlabel.setText("FRC Scouting App");
			
			
			this.add(WVRlabel);
			this.add(button2018);
			this.add(button2019);
			this.add(button2020);
			
			
			this.setTitle("WVR Scouting App: Main Frame"); // Titles the Window
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the X is clicked, the window closes
			this.setResizable(false); // Keeps a consistent window size.
			this.setSize(1200,600);  // In pixels, the size of the widow. (width x height)
			Color customColor = new Color(93, 188, 210); //Creates a background color
			this.getContentPane().setBackground(customColor);
			this.setLayout(null);
			this.setVisible(true); // Makes the frame visible
			
		} 



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button2020) {
			this.dispose();
			IndexFrame2020 indexframe2020 = new IndexFrame2020();
		} else if (e.getSource()==button2019) {
			this.dispose();
			IndexFrame2019 indexframe2019 = new IndexFrame2019();
		} else if (e.getSource()==button2018) {
			this.dispose();
			IndexFrame2018 indexframe2018 = new IndexFrame2018();
		}
	}
	
}
 
