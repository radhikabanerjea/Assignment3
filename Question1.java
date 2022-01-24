/*Radhika Banerjea 
 * October 29, 2021
 * This is a program that does the following based on what the user inputs.
 * a. Enter names and marks
Ask the user to enter names and marks. Every time after the person has entered the mark,the
name and the mark is written to a file called, “marks.txt”. You’ll keep asking for names and marks and writing
them to the file until “xx” is entered as a name. Then close the file.
b. Read names and marks
Read from the file “marks.txt” the names and marks and print them to the console. Read a name,
then a mark and then continue until you read in the number of names you wrote in Part A. You’ll
need a loop that counts up to the number of records you wrote. As each name and mark are read in,
print them in the console.
c. Read to an array names and marks
Read from the file “marks.txt” the names and marks and store them in an array. Instead of reading
into variables and printing them after each line is read, create an ARRAY for ‘name’ and an ARRAY
for ‘mark. Read all the data from the file into the arrays and then print the data in the console from
the arrays after all the data has been read.
d. Exit the program.
 */

//imports important packages
import java.util.*;
import java.io.*;
import exceptionbasics.EmptyStringException;

public class Question1 {

	public static void main(String[] args) throws IOException{
		

		try {
			//scanner variable for the console, making a new file, variable that holds what the user inputs.
			Scanner input = new Scanner (System.in);
			File handle = new File("marks.txt");
			String item = "";
			
			while(!item.equals("d")) {
				//asks user for menu item.
				System.out.println("Type the letter of the option that you would like. " + "\n");menu();
				item = input.nextLine();
				
				switch (item) {
					
					case "a":
						//getting the print writer variable. and a variable that will be used to hold what the user inputs for the names and grades
						PrintWriter output = new PrintWriter(handle);
						String line = "";
						//if line isn't xx then the loop keeps going. 
						while(!(line.equals("xx")))	{
							//takes the names and grades of the students
							System.out.println("Tell me the name of the student and their mark.");
							line = input.nextLine();
							
							if (line.equals("")) {
								//throws exception if it is empty string
								System.out.println("hello im here");
								throw new EmptyStringException();
							}
							
							//prints what they entered onto the file 
							if (!(line.equals("xx"))){
								output.println(line);
								
							}						
							
						}						
						output.close();

					break;	
					
					case "b":
						Scanner inputFile = new Scanner(handle);
						while(inputFile.hasNextLine()){  //the method hasNextLine checks whether there is a next line in the file
							System.out.println(inputFile.nextLine());  
				        } 		
						inputFile.close();
					break;	
		
					case "c":
						inputFile = new Scanner(handle);
						//variable that counts how many lines are in the file. And there is a loop that figures this out.
						int numlines = 0;
						while(inputFile.hasNextLine()){  //the method hasNextLine checks whether there is a next line in the file
							inputFile.nextLine();
							numlines++;
						} 
						//array from the marks and the names
						String [] names = new String[numlines];
						String [] marks = new String[numlines];
						inputFile.close();

						
						inputFile = new Scanner(handle);
						//loops how many times there is lines.
						for (int i = 0;i<numlines;i++) {
							//if there is a line that comes next, then the values in the lines of code are split where there is a split
							//then the first value is assigned to the names array and the second value is assigned to the marks arary
							if (inputFile.hasNextLine()) {
								String[]tokens = (inputFile.nextLine()).split(" ");
									names [i] = tokens[0];
									marks [i] = tokens [1];
									//prints out the names and marks.
									System.out.println(names[i] + " " + marks[i]);
							}
						}
						inputFile.close();
					break;
					
					case "d":
						//exists the program
						System.out.println("goodbye");
						break;	

				 	
				 	default:
				 		//checks for non menu item inputed.
				 		System.out.println("Please enter a valid option from the menu. Try again.");
				 		break;

				}	
			}
			//catches exceptions for an empty string, or file errors, or general error.
			} catch (EmptyStringException e)  { 
				System.out.println("Your input must contain something. Try again."); 
			} catch (IOException e){
				System.out.println("Error with the file.");
			} catch (Exception e) {
				System.out.println("Error");
			}
			
			
		

	}
	//this method prints out the menu options.
		public static void menu() {
			System.out.println("a. Enter names and marks\r\n"
					+ "b. Read names and marks\r\n"
					+ "c. Read to an array names and marks\r\n"
					+ "d. Exit the program");
		}
		

}
