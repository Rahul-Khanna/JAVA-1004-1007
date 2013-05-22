//******************
// Crypt.java
// Test class for Encrypt/Decrypt program
// Rahul Khanna
//******************

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Crypt { // creating my IVs
	
	private final static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private String backwardAlphabet= "ZYXWVUTSRQPONMLKJIHGFEDCBA";
	private ArrayList<Character> newAlphabet= new ArrayList<Character>();
	
	public Crypt()
	{
		
	}
	
	
	public void createNewAlphabet(String code) // this method creates the encryption code (new alphabet)
	{
		String realCode= code;
	
		for(int i=0; i< (realCode.length()-1); i++) // first adds the user inputed code to the new alphabet
		{
			char letter= realCode.charAt(i);
			if(!newAlphabet.contains(letter))
				newAlphabet.add(letter);
		}
	
		for(int i=0; i< 26; i++) // adds the rest of the letters to the new alphabet
		{
			char letter= backwardAlphabet.charAt(i);
			if(!newAlphabet.contains(letter))
				newAlphabet.add(letter);
		}
	}
	
	public void encrypt(File in,File out) throws FileNotFoundException // this method encrypts the message
	{
		File inFile=in;
		PrintWriter output= new PrintWriter(out);
		Scanner input= new Scanner(inFile);
		String originalWord;
		String modifiedWord;
		
		while(input.hasNext()) // makes sure there is something to encrypt
		{
			originalWord=input.nextLine();
			char letter;
			modifiedWord="";
			int indexOfLetter=0;
			boolean found =false;
			
			for (int i=0; i< (originalWord.length()); i++ ) // breaks up the message into single characters
			{
				letter = originalWord.toUpperCase().charAt(i);
				
				indexOfLetter=0;
				found =false;
				
				while(indexOfLetter<26 && !found) // checks to see if the character is a letter, if so finds the position of that character in the original alphabet
				{
					if(letter==alphabet[indexOfLetter])
						found=true;
				
						else
							indexOfLetter++;
				}
				
				if(found) // if the character is a letter, switches it with the corresponding letter in the new alphabet
					letter= newAlphabet.get(indexOfLetter);
				
				modifiedWord= modifiedWord + letter; // puts back together the line
			}
			output.println(modifiedWord);
		}
		output.close();
		
	}
	
	public void decrypt(File in,File out) throws FileNotFoundException // this method decrypts the message
	{
		File inFile=in;
		PrintWriter output= new PrintWriter(out);
		Scanner input= new Scanner(inFile);
		String originalWord;
		String modifiedWord;
		
		while(input.hasNext()) // makes sure there is something to decrypt
		{
			originalWord=input.nextLine();
			char letter;
			modifiedWord="";
			int indexOfLetter= 0;
			boolean found= false;
			
			for (int i=0; i< (originalWord.length()); i++ ) // breaks up the message into single characters
			{
				letter = originalWord.toUpperCase().charAt(i);
				
				indexOfLetter=0;
				found =false;
				
				while(indexOfLetter<26 && !found) // checks to see if the character is a letter, if so finds the position of that character in the new alphabet
				{
					if(letter==newAlphabet.get(indexOfLetter))
						found=true;
				
						else
							indexOfLetter++;
				}
				
				if(found) // if the character is a letter, switches it with the corresponding letter in the original alphabet
					letter= alphabet[indexOfLetter];
				
				modifiedWord= modifiedWord + letter; // puts back together the line
			}
			output.println(modifiedWord);
		}
		output.close();
		
	}
	
	
}
