package test1;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ranking implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton backb;
	private JLabel title;
    private JFrame frame;
	private JLabel ranking;
	private JLabel blank;
	
	public Ranking(JFrame a) throws IOException{
		JFrame frame = a;
		title = new JLabel();
		ranking = new JLabel();
		blank = new JLabel();
		
		Color customColor = new Color(0,162,232); //Creates a background color
        frame.setTitle("WVR Scouting App: Robot Analytics"); // Titles the Window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the X is clicked, the window closes
	  	frame.setResizable(false); // Keeps a consistent window size.
	  	frame.setSize(1500,800);  // In pixels, the size of the widow. (width x height)
	  	frame.getContentPane().setBackground(customColor);
        
	  	backb = new JButton();
	    backb.setBounds(20, 20, 100, 25);
	    backb.setText("Back");
	    backb.addActionListener(this);
		frame.add(backb);
		title.setFont(new java.awt.Font("TimesRoman", Font.ITALIC, 25));
		title.setText("ROBOT ANALYSIS");
		title.setForeground(Color.WHITE);
		title.setBounds(500, -200, 852, 461);
		frame.add(title);
		
		ranking.setFont(new java.awt.Font("TimesRoman",Font.PLAIN, 12));
		ranking.setForeground(Color.WHITE);
		ranking.setBounds(500, 100, 852, 800);
		
		blank.setFont(new java.awt.Font("TimesRoman",Font.PLAIN, 12));
		blank.setForeground(Color.WHITE);
		blank.setBounds(500, 50, 852, 461);
		
		
		String master = "oprmaster.xlsx";
		OPCPackage masterfs = null;
		try {
			masterfs = OPCPackage.open(new File(master));
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}
		
		XSSFWorkbook masterwb = new XSSFWorkbook(master);
	    XSSFSheet mastersheet = masterwb.getSheetAt(0);
	    XSSFRow masterrow; 
	    XSSFCell mastrcell; 

	    int masterrows;  // No of rows
	    masterrows = mastersheet.getPhysicalNumberOfRows();
	    int mastercols = 0;
	    int mastertmp = 0;
	    
	    for(int i = 0; i < 10 || i < masterrows; i++) {
	        masterrow = mastersheet.getRow(i);
	        if(masterrow != null) {
	            mastertmp = mastersheet.getRow(i).getPhysicalNumberOfCells();
	            if(mastertmp > mastercols) mastercols = mastertmp;
	        }
	    }	
	    
	    /*ArrayList<Integer> teamsList = new ArrayList<Integer>();
	    for(int i = 1; i <= 38; i++) {
	    	teamsList.add((int) mastersheet.getRow(i).getCell(0).getNumericCellValue());
	    	//System.out.println(teamsList.get(i-1));
	    }
	    
	    ArrayList<Double> avgScore = new ArrayList<Double>();
	    for(int i = 1; i <= 38; i++) {
	    	avgScore.add(mastersheet.getRow(i).getCell(3).getNumericCellValue());
	    }
	    
	    ArrayList sorted = (ArrayList) avgScore.clone();
	    Collections.sort(sorted, Collections.reverseOrder());*/
	    
	    String output = "<html>";
	    for(int i = 0; i < 38; i++) {
	    	output += (int) mastersheet.getRow(i+1).getCell(0).getNumericCellValue() + ": " + Math.floor(mastersheet.getRow(i+1).getCell(3).getNumericCellValue() * 10000) / 10000.0 + "<br>";
	    }
	    output += "</html>";
	    
	    ranking.setText(output);
	    frame.add(ranking);
	    blank.setText("");
	    frame.add(blank);
	    
	    frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==backb) {
			frame.remove(backb);
		    frame.remove(title);
            //new IndexFrame(frame);
		}
	}
}
