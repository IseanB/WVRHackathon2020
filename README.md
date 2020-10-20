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

	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JLabel;

	public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame = new JFrame();
		frame.setTitle("WVR Scouting App: Visual Data"); // Titles the Window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the X is clicked, the window closes
		frame.setResizable(false); // Keeps a consistent window size.
		frame.setSize(1200,600);  // In pixels, the size of the widow. (width x height)
		frame.setVisible(true); // Makes the frame visible
		
		Boolean a = true;
		while(a) {
			...
			frame.setVisible(true);
			a = false;
		}
		
	}

}





Important info:

	- When you're creating your Java Project and you are on the step of creating 
	  a Class, select the "public static void(String[] args)" option.
	  
	- Don't add your code into the main method. Put it into the while loop.(P.S. if your adding buttons don't forget to do frame.add(JLabelName); )
	  
	- If your working on the "Index" frame, call a method once the user has inputed 
	  a team number and clicked the button. Provide the team number in the method call.
