package edu.columbia.cs.cs1007.hw4.problem1;
import java.io.IOException;
import java.io.Writer;
/**
 * A class that acts a decoration to another Writer class. Its job is to encrypt a character array.
 * @author R_K
 *
 */
public class EnrcryptingWriter extends Writer {

	/**
	 * The underlying Writer object.
	 */
	private Writer out = null;
	/**
	 * The encryption key.
	 */
	private final static int CRYPT = 3;
	/**
	 * A character array with the letters of the alphabet in upper case.
	 */
	private final static char[] UPPERCASEALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	/**
	 * A character array with the letters of the alphabet in lower case.
	 */
	private final static char[] LOWERCASEALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
		'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
		'u', 'v', 'w', 'x', 'y', 'z'};

	/**
	 * Constructs a EncryptingWriter object which can encrypt a character array.
	 * @param out The underlying Writer object
	 */
	public EnrcryptingWriter(Writer out) {
		this.out = out;
	}
	/**
	 * The inherited close method from Writer.
	 */
	public void close() throws IOException {

	}

	/**
	 * The inherited flush method from Writer
	 */
	public void flush() throws IOException {

	}
	/**
	 * The overridden write method.
	 * @param arg0 The character array is to be encrypted.
	 * @param off The location in the array that the encryption starts at.
	 * @param len The number of elements to encrypt.
	 */
	public void write(char[] arg0, int off, int len) throws IOException {

		int i = off;
		int length= off+len;
		char[] buffer1=arg0;
		while (i < length) { // goes through each character in the array 
			char c = buffer1[i];
			boolean found = false;
			int indexOfLetter = 0;
			int newIndexOfLetter;

			while (indexOfLetter < 26 && !found)	//  finds the position of the character in the alphabet
			{
				if (c == UPPERCASEALPHABET[indexOfLetter]|| c == LOWERCASEALPHABET[indexOfLetter])
					found = true;

				else
					indexOfLetter++;
			}
												
			
			if (indexOfLetter < 23) //changes the index of the the character so that it is encrypted.
				newIndexOfLetter = indexOfLetter + CRYPT;
			else
				newIndexOfLetter = indexOfLetter - UPPERCASEALPHABET.length + CRYPT;

			
			char newC = UPPERCASEALPHABET[newIndexOfLetter];


			buffer1[i]=newC;
			i++;
		}
		
		out.write(buffer1, off, len);

	}

}
