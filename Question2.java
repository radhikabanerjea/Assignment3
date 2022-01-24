/*Radhika Banerjea
 * October 28, 2021
 *This program does the following based on the user's input
a. Enter names and marks
Ask the user to enter names and marks, but instead of using a space between names and their
corresponding mark, we’ll build a string with a semicolon ‘;’ as the delimiter to separate the tokens.
So Joe Smith with a mark of 92 will look like “Joe;92 ” when it’s written to the file.

b. Read names and marks
Read from the file “marks.txt” the names and marks and print them to the console. 
c. Calculate Average
This option will calculate the average mark of all the students who were read in. 
d. Exit the program.
 * 
 */

//importing necessary packages
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import exceptionbasics.EmptyStringException;

public class Question2 {

	public static void main(String[] args) {
		

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
							//gets the user input
							System.out.println("Tell me the name of the student and their mark.");
							line = input.nextLine();
							
							//throws exception if the input is empty
							if (line.equals("")) {
								//throws exception if it is empty string
								System.out.println("hello im here");
								throw new EmptyStringException();
							}
							//replaces the space with a semicolon when printing it onto the file.
							if (!(line.equals("xx"))){
								output.println(line.replace(" ", ";"));
								
							}						
							
						}						
						//closing the scanner
						output.close();

					break;	
					
					case "b":
						//defining a variable for reading the file.
						Scanner inputFile = new Scanner(handle);
						//printing out what was on the file but replacing the semicolon with a space.
						while(inputFile.hasNextLine()){  //the method hasNextLine checks whether there is a next line in the file
							System.out.println((inputFile.nextLine()).replace(";", " "));  
				        } 		
						//closing the scanner variable.
						inputFile.close();
					break;	
		
					case "c":	
						inputFile = new Scanner(handle);
						//variables that keep track of how many lines there are (so that the average can be calculated), and are used to store the average
						int numlines = 0;
						double average = 0;
						while(inputFile.hasNextLine()){  //the method hasNextLine checks whether there is a next line in the file
							inputFile.nextLine();
							numlines++;
						} 
						inputFile.close();
						
						
						inputFile = new Scanner(handle);
						//splits whats on the file where there is a ;. Then it makes the value a double adds them tofether and calculates the average.
						for (int i = 0;i<numlines;i++) {
							if (inputFile.hasNextLine()) {
								String[]tokens = inputFile.nextLine().split(";");
								average = (Double.parseDouble(tokens[1]))+ average;	
							}
						}
						System.out.println("The average of all the grades is: "+average/numlines);
						inputFile.close();
					break;
					
					case "d":
						System.out.println("goodbye");
						break;	

				 	
				 	default:
				 		//checks for non menu item inputed.
				 		System.out.println("Please enter a valid option from the menu. Try again.");
				 		break;

				}	
			}

			//catching empty strings, file errors, and general errors.
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
				+ "c. Calculate Average\r\n"
				+ "d. Exit the program");
	}
}


