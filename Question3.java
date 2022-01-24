/*Radhika Banerjea
 * October 29, 2021
 * Read the first 15 records of BlueJays.csv is read into a 2D array in which each row is a record, and each column is a
different field. You just need to parse out the first 18 tokens when the delimiter is a ‘,’ using “.split()”.
After they are read in, print out the contents on your screen HORIZONTALLY using ‘\t’ between the values so
they are spaced out.
The  program looks through the arrays and print out the player with the highest Batting Avg., Walks
and Stolen Basis.
The code reports how many players have played more than 20 games.
 * 
 */
//importing necessary packages
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) throws FileNotFoundException {
		//file variable and 2d array to store the information and scanner variable to read the file
		File handle = new File ("BlueJays.csv");
		String [][] values = new String [16][18];
		Scanner inputFile = new Scanner(handle);
			
		//loop that goes through all the columns and rows of the file and splits up all the values with a comma inbetween them
		//Then it saves all the values to a 2D array
		//Then the 2D array is printed out in a chart format.
		for (int i = 0;i<16;i++) {
			String [] tokens = (inputFile.nextLine().split(","));
			
			for (int j = 0;j<18;j++) {
				values[i][j] = tokens[j];
				System.out.print(values[i][j]+ '\t');
			}
			System.out.println();
			
		}
		//closing scanner.
		inputFile.close();
			
		System.out.println();
		
		//printing out all the values for the highest batting avg, number of walks, and stolen basis
		//Each printing caslls the method highest to figure out which line contains the respective question's highest value
		System.out.println(values[highest(values,14)][0] + " has the highest Batting avg. at: " + values[highest(values,14)][14]);
		System.out.println(values[highest(values,10)][0] + " has the highest number of Walks at: " + values[highest(values,10)][10]);
		System.out.println(values[highest(values,12)][0] + " has the most amount of Stolen Basis at: " + values[highest(values,12)][12]);
		
		//cycles through all the game scores and figures how many of them are above 20. Then it prints out that number
		int num = 0;
		double current = 0;
		for (int i = 1; i<16; i++) {
			current= Double.parseDouble(values[i][2]);
			 if (current>20) {
				 num++;
			}
		}
		System.out.println(num + " players have played more than 20 games.");
		
		
	}

	//method that takes a 2D array and a value for the column number as parameter
	//cycles through the column asked for and finds the highest value.
	//The method returns the row number of the array that the highest number can be found on.
	public static int highest(String values[][],int column) {
		int highestnum = 0;
		double numstore = 0;
		double current ;
		for (int i = 1; i<16; i++) {
			 current= Double.parseDouble(values[i][column]);
			if (current>numstore) {
				highestnum = i;
				numstore = current;
			}
		}
		
		return highestnum;
	}
	
}
