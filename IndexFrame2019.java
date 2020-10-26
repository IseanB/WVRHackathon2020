import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;


public class IndexFrame2019 extends JFrame implements ActionListener{
	
	static JButton backButton;

	
	IndexFrame2019() {
		backButton = new JButton();
		backButton.setBounds(20, 20, 100, 25);
		backButton.setText("Back");
		backButton.addActionListener(this);
		
		this.setTitle("WVR Scouting App: Index Frame 2019"); // Titles the Window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the X is clicked, the window closes
		this.setResizable(false); // Keeps a consistent window size.
		this.setSize(1200,600);  // In pixels, the size of the widow. (width x height)
		this.setVisible(true); // Makes the frame visible
		Color customColor = new Color(255, 255, 255); //Creates a background color
		this.getContentPane().setBackground(customColor);
		this.setLayout(null);
		this.add(backButton);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==backButton) {
			this.dispose();
			MainFrame mainframe = new MainFrame();
		
		}
	}
}
 