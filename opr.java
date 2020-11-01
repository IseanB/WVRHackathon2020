package test1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class opr extends JFrame { //implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton backb;
	
	public opr(JFrame a, int teamnum) throws IOException{
		int teams = 38; 	//sometimes known as r1
		String finale = "finalmaster.xlsx";
		OPCPackage finalefs = null;
		try {
			finalefs = OPCPackage.open(new File(finale));
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    XSSFWorkbook finalewb = new XSSFWorkbook(finale);
	    XSSFSheet finalesheet = finalewb.getSheetAt(0);
	    XSSFRow finalerow; 
	    XSSFCell finalecell; 

	    int finalerows;  // No of rows
	    finalerows = finalesheet.getPhysicalNumberOfRows();
	    int finalecols = 0;
	    int finaletmp = 0;
	    
	    for(int i = 0; i < 10 || i < finalerows; i++) {
	        finalerow = finalesheet.getRow(i);
	        if(finalerow != null) {
	            finaletmp = finalesheet.getRow(i).getPhysicalNumberOfCells();
	            if(finaletmp > finalecols) finalecols = finaletmp;
	        }
	    }	
	    
	    ArrayList<Integer> teamsList = new ArrayList<Integer>(Arrays.asList(
	            33, 94, 240, 247, 548, 573, 835, 1481, 2591, 3096, 3414, 3538, 4130, 4758, 4768, 4840, 4854, 5090, 5197, 5214, 5498, 5531, 5532, 5577, 5695, 5756, 6013, 6120, 6742, 7145, 7191, 7232, 7692, 7716, 7856, 7865, 8179, 8280
	        ));
	    
	    // Everything above is setup variables and sheets etc
	    // Everything below is matrix setups
	    
	    double scores[][] = new double[teams][teams]; // main matrix
	    double avgScores[] = new double[teams]; 	  // total score in all matches a team played in
        

        for(int i = 0; i < 76; i++){    //76 games/matches played
        	ArrayList<Integer> tmparr = new ArrayList<Integer>();
        	for(int j = 0; j < 3; j++) {
                int index = teamsList.indexOf((int) finalesheet.getRow(i).getCell(j).getNumericCellValue()); //replace j with team number from spreadsheet IMPORTANT IMPORTANT IMPORTANT IMPORTANT
                tmparr.add(index);
            }
        	for(int ab = 0; ab < tmparr.size(); ab++) {
        		for(int bc = 0; bc < tmparr.size(); bc++) {
        			scores[tmparr.get(ab)][tmparr.get(bc)]++;
        		}
        		avgScores[tmparr.get(ab)] += finalesheet.getRow(i).getCell(6).getNumericCellValue();
        	}
        	
        	ArrayList<Integer> tmparr1 = new ArrayList<Integer>();
        	
        	for(int six = 3; six < 6; six++) {
        		int index = teamsList.indexOf((int) finalesheet.getRow(i).getCell(six).getNumericCellValue()); //replace j with team number from spreadsheet IMPORTANT IMPORTANT IMPORTANT IMPORTANT
                tmparr1.add(index);
        	}
        	
        	for(int ab = 0; ab < tmparr1.size(); ab++) {
        		for(int bc = 0; bc < tmparr1.size(); bc++) {
        			scores[tmparr1.get(ab)][tmparr1.get(bc)]++;
        		}
        		avgScores[tmparr1.get(ab)] += finalesheet.getRow(i).getCell(7).getNumericCellValue();
        	}
        	
        }

        
        double inverse[][] = invert(scores);
        
        double[][] product = multiplyMatrices(inverse, avgScores, teams);
        for (int i = 0; i < teams; ++i){
            for (int ii = 0; ii < 1; ++ii)
            {	
            	product[i][ii] = Math.floor(product[i][ii] * 10000) / 10000.0;
                System.out.print(teamsList.get(i) + ": ");
            	System.out.print(product[i][ii]+"  ");
            }
            System.out.println();
        }
        
	}	        
	
	//------------------------------------------------------------------------------------------------------
	
	public static double[][] invert(double a[][]){
		int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i){
            b[i][i] = 1;
        }
 
        // Transform the matrix into an upper triangle
        gaussian(a, index);
 
        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i){
            for (int j=i+1; j<n; ++j){
                for (int k=0; k<n; ++k){
                    b[index[j]][k] -= a[index[j]][i]*b[index[i]][k];
                }
            }
        }
        // Perform backward substitutions
        for (int i=0; i<n; ++i){
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j){
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k){
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }
 
    // Method to carry out the partial-pivoting Gaussian
    // elimination.  Here index[] stores pivoting order.
 
    public static void gaussian(double a[][], int index[]){
        int n = index.length;
        double c[] = new double[n];
 
        // Initialize the index
        for (int i=0; i<n; ++i){ 
            index[i] = i;
        }
 
        // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i){
            double c1 = 0;
            for (int j=0; j<n; ++j){
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
 
        // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j){
            double pi1 = 0;
            for (int i=j; i<n; ++i){
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1){
                    pi1 = pi0;
                    k = i;
                }
            }
 
            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i){
                double pj = a[index[i]][j]/a[index[j]][j];
 
                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;
 
                // Modify other elements accordingly
                for (int l=j+1; l<n; ++l){
                    a[index[i]][l] -= pj*a[index[j]][l];
                }
            }
        }
	}
    
    public static double[][] multiplyMatrices(double[][] firstMatrix, double[] secondMatrix, int r1) {
        double[][] product = new double[r1][1];
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < r1; j++){
                product[i][0] += firstMatrix[i][j] * secondMatrix[j];
            }
        }

        return product;
    }
}
