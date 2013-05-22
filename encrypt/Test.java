//******************
// Test.java
// Test class for Encrypt program
// Rahul Khanna
//******************

import java.io.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method 
		try 		//processing the information from the user
		{
			File inFile= new File(args[2]);
			File outFile = new File(args[3]);
			String code= args[1];
			String realCode=code.toUpperCase().substring(2);
			
			Crypt c= new Crypt();
			
			c.createNewAlphabet(realCode);
			
			if(args[0].equals("-e")) // if the user wants to encrypt the file, it calls the encryption method
			{
				c.encrypt(inFile, outFile);
				System.out.println("Your file has been encrypted.");
			}
			
			if(args[0].equals("-d")) // if the user wants to decrypt the file, it calls the encryption method
			{
				c.decrypt(inFile, outFile);
				System.out.println("Your file has been decrypted.");
			}
			
		}
		
		catch(IOException e)  // tells the user that files inputed are not valid
		{
			System.out.println("Please try again with correct input and output file names");
		}
		
		catch(ArrayIndexOutOfBoundsException e) //tell the user that he hasn't given enough information
		{
			System.out.println("You must enter the information like this: <-d or -e> <-k and keyword> <Input File> <Output File>");
		}
	}

}
