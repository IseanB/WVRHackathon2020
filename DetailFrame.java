
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


public class DetailFrame extends MainFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JButton backb;
    private JLabel title;
    private JFrame frame1;
    private int teamnum;
    
    public DetailFrame(JFrame a, int b) throws IOException{
      super(a, b);
      frame.remove(button2020);
	  frame.remove(WVRScouting);
	  frame.remove(WVRlabel);
      
      frame1 = a; // Creates get global frame variable, and sets it to a local variable
	  teamnum = b;
      ArrayList<Integer> rowToGet = new ArrayList<Integer>(); // Stores the rows where the team's info is.
      int totalpoints = 0; // Counts how many points overall gained
      String defense = "No"; // Shows what type of defense
      String target = "No"; // Shows what type of target
	  int numgames = 0; // Counts number of games played by the team number
	  boolean isMultiDef = false; // Shows that the robot can change defense style
      boolean isMultiTar = false; // Shows that the robot faced different defenses
	  title= new JLabel();

	  Color customColor = new Color(108, 211, 235); //Creates a background color
      frame1.setTitle("WVR Scouting App: Robot Analytics"); // Titles the Window
	  frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the X is clicked, the window closes
	  frame1.setResizable(false); // Keeps a consistent window size.
	  frame1.setSize(1200,600);  // In pixels, the size of the widow. (width x height)
	  frame1.getContentPane().setBackground(customColor);
	  
	  backb = new JButton();
	  backb.setBounds(20, 20, 100, 25);
      backb.setText("Back");
      backb.addActionListener(this);
	  frame1.add(backb);
	  title.setFont(new java.awt.Font("TimesRoman", Font.ITALIC, 25));
	  title.setText("ROBOT ANALYSIS");
	  title.setForeground(Color.WHITE);
	  title.setBounds(500, -200, 852, 461);
	  frame1.add(title);
	
		
	
          String file = "3538_2020misou.xlsx";
          OPCPackage fs = null;
          try {
            fs = OPCPackage.open(new File(file));
          } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;

        int rows; // No of rows
        rows = sheet.getPhysicalNumberOfRows();

        int cols = 0; // No of columns
        int tmp = 0;

        // This trick ensures that we get the data properly even if it doesn't start from first few rows
        for(int i = 0; i < 10 || i < rows; i++) {
            row = sheet.getRow(i);
            if(row != null) {
                tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                if(tmp > cols) cols = tmp;
            }
        }
        for(int r = 0; r < rows; r++) {
            row = sheet.getRow(r);
            if(row != null) {
                for(int c = 0; c < cols; c++) {
                    cell = row.getCell((short)c);
                    if(cell != null) {
                      if(CellType.NUMERIC == cell.getCellType()) {
                        if(c == 1 && cell.getNumericCellValue() == teamnum) {
                          numgames++;
                          rowToGet.add(r);	
                        }
                      }
                    }
                }
            }
        }



        /**
         * 
         */
        for(int r = 0; r < rowToGet.size()-1; r++) {
            row = sheet.getRow(rowToGet.get(r));
            if(row != null) {
                for(int c = 0; c < cols; c++) {
                    cell = row.getCell((short)c);
                    if(cell != null) {
                      if(CellType.NUMERIC == cell.getCellType()) {
                        if(c==3) {
                          totalpoints += (cell.getNumericCellValue()*2);//Scored in the Low Set of Goals and Auto giving 2 points
                        }
                        else if(c >= 4 && c <= 8) {
                          totalpoints += (cell.getNumericCellValue()*4); //Scored in the High Set of Goals and Auto giving 4 points
                        }
                        else if(c==11) {
                          totalpoints += (cell.getNumericCellValue());//Scored in the Low Set of Goals and Telop giving 1 point
                                          }
                        else if(c>=12 && c<=16) {
                          totalpoints += (cell.getNumericCellValue()*2);//Scored in the High Set of Goals and Telop giving 2 point
                        }
                        else if(c == 17 && cell.getNumericCellValue()!=0) {
                                                  totalpoints += 10; //Scored Spinning the wheel 10 points
                        }
                        else if(c == 18 && cell.getNumericCellValue()!=0) {
                                                  totalpoints += 20;//Scored Turning the wheel to a certain color 20 points
                        }
                      }
                      else if(CellType.STRING == cell.getCellType()) {
                                      if(c == 19) {
                                          if(!"None".equals(cell.getStringCellValue())){
                                                defense = cell.getStringCellValue();
                                                  if(!defense.equals(defense)){
                                                      isMultiDef = true;
                                                  }
                                              }
                        }
                                      else if (c == 20) {
                        if(!"None".equals(cell.getStringCellValue())){
                                                target = cell.getStringCellValue();
                                                  if(!target.equals(target)){
                                                      isMultiTar = true;
                                                  }

                                              }
                                        }
                                  }
                    }
                }
            }
          }
       double averagepoints= (totalpoints/(double)numgames);
       int roundedavgpoints= (int)Math.round(averagepoints);
       if (isMultiDef==true){
                  System.out.println("This robot can play both Heavy and Light defense");
                  }
       else {
                  System.out.println("This robot can play "+defense+" defense");
              }
       if (isMultiTar==true){
                  System.out.println("This robot has played against both Heavy and Light defense");
                  }
       else {
                  System.out.println("This robot has played against "+target+" defense");
                  }
      System.out.println("This robot has an individual rounded average score of about " + roundedavgpoints + " points");
      frame1.setVisible(true); // Makes the frame visible with all of it's stuff
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==backb) {
            frame.remove(backb);
		    frame.remove(title);
            new IndexFrame(frame);
		} 
	
	}

  }