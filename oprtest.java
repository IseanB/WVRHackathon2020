import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class oprtest{
    public static void main(String []args){
        int r1 = 37; // manually counted lol
        //33, 94, 240, 247, 548, 573, 835, 1481, 2591, 3096, 3414, 3538, 4130, 4758, 4768, 4840, 4854, 5090, 5197, 5214, 5498, 5531, 5532, 5577, 5695, 5756, 6013, 6120, 6742, 7145, 7191, 7232, 7692, 7716, 7856, 8179, 8280,     
        double scores[][] = new double[r1][r1];
        double avgScores[] = new double[r1];
        int avgerageScores[] = new int[r1];
        int matchPlayed[] = new int[r1];
        ArrayList<Integer> teams = new ArrayList<Integer>(Arrays.asList(
            37, 94, 240, 247, 548, 573, 835, 1481, 2591, 3096, 3414, 3538, 4130, 4758, 4768, 4840, 4854, 5090, 5197, 5214, 5498, 5531, 5532, 5577, 5695, 5756, 6013, 6120, 6742, 7145, 7191, 7232, 7692, 7716, 7856, 8179, 8280
        ));
        System.out.println(teams.size());
        

        for(int i = 0; i < 76; i++){    //76 games
            int matchNumber = 0; //replace 0 with match number from spreadsheet
            int j = 0;           
            while(matchNumber == i){
                matchNumber = 0; //replace 0 with match number from spreadsheet
                int index = teams.indexOf(j); //replace j with team number from spreadsheet
                scores[index][index]++;
                matchPlayed[index]++;
                j++;
            }
        }

        int totalScores = 0;
        for(int i = 0; i < r1; i++){
            avgerageScores[i] = totalScores/matchPlayed[i]; //REPLACE totalScores with total scores of the team from carl's detailframe thingy
        }

        for(int i = 0; i < r1; i++){
            for(int j = 0; j < r1; j++){
                avgScores[i] += scores[i][j] * avgerageScores[i];
            }
        }

        /*int r1 = 2;
        double[][] scores = {
            {2, 5},
            {1, 3}
        };
        
        double[] avgs = {16, 9};*/

        double inverse[][] = invert(scores);

        System.out.println("The inverse is: ");
        for (int i = 0; i < 2; ++i){
            for (int j = 0; j < 2; ++j)
            {
                System.out.print(inverse[i][j]+"  ");
            }
            System.out.println();
        }

        double[][] product = multiplyMatrices(inverse, avgScores, r1);
        
        System.out.println("The product is: ");
        for (int i = 0; i < 2; ++i){
            for (int j = 0; j < 1; ++j)
            {
                System.out.print(product[i][j]+"  ");
            }
            System.out.println();
        }
        
    }


    public static double[][] invert(double a[][]) {
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