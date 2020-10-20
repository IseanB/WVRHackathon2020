# WVRHackathon2020
///
Definitions:
    Frame: a window with a certain buttons and features.
    
    
Frames To-Do:                                                               Who Will Do It:             Must Have / Important Info:
    Main                                                                    Harris                      Button: Year# / Include Title and Team#
    Index                                                                   Harris                      Buttons: (One for Each Dashes), Input: Team# / Given: Year#
    - Visual Data                                                           Satvik, Isean               Button: Back / Given: Team#
    - OPR                                                                   Eric                        Button: Back / Given: Team#
    - Robot description and Avg points                                      Carl                        Button: Back / Given: Team#
    - Notes                                                                 Chandrack                   Button: Back / Given: Team#
    Back Button                                                             Chandrack                   N/A / Must be in the same spot when the frames are combined.


Basic Code:

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame(); // Creates a Window
		frame.setTitle("WVR Scouting App"); // Titles the Window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the X is clicked, the window closes
		frame.setResizable(false); // Keeps a consistent window size.
		frame.setSize(1200,600);  // In pixels, the size of the widow. (width x height)
		frame.setVisible(true); // Makes the frame visible
	}
}
