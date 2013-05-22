package edu.columbia.cs.cs1007.hw4.problem1;
import java.io.IOException;
import java.io.Reader;
/**
 * A class that acts a decoration to another Reader class. Its job is to decrypt a character array.
 * @author R_K
 *
 */

public class DecryptingReader extends Reader {

	/**
	 * The underlying Reader object.
	 */
	private Reader in= null;
	
	/**
	 * The number of characters read.
	 */
	int read;
	
	/**
	 * The decryption key
	 */
	private final static int DECRYPT = 3;
	
	/**
	 * A character array of the alphabet
	 */
	private final static char[] UPPERCASEALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
		'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
		'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	private final static char[] LOWERCASEALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
		'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
		'u', 'v', 'w', 'x', 'y', 'z'};
	
	/**
	 * Constructs a DecryptingReader object which can decrypt a character array.
	 * @param in The underlying Reader object
	 */
	public DecryptingReader(Reader in)
	{
		this.in =in;
	}
	
	/**
	 * The inherited close method
	 */
	public void close() throws IOException {

	}

	/**
	 * The overridden read method, which decrypts a character array.
	 * @param arg0 The character array to be decrypted 
	 * @param arg1 The starting index in the array that the decryption starts
	 * @param arg2 The number of elements to decrypt
	 */
	public int read(char[] arg0, int arg1, int arg2) throws IOException {

		in.read(arg0,arg1,arg2);
		int length= arg1+arg2;

		for(int i=arg1; i<length; i++) { // goes through every character in arg0
			char c = arg0[i];
			boolean found = false;
			int indexOfLetter = 0;
			int newIndexOfLetter=0;
			
			while (indexOfLetter < 26 && !found)	//  finds the position of the character in the alphabet
			{
				if (c == UPPERCASEALPHABET[indexOfLetter]||c == LOWERCASEALPHABET[indexOfLetter] )
					found = true;

				else
					indexOfLetter++;
			}
			
			
			if (indexOfLetter >2) // decrypts the character
				newIndexOfLetter = indexOfLetter - DECRYPT;
			else
				newIndexOfLetter =  UPPERCASEALPHABET.length+indexOfLetter-DECRYPT;

			char newC = UPPERCASEALPHABET[newIndexOfLetter];

			arg0[i]=newC;			
		}
		return read;
	}
}
