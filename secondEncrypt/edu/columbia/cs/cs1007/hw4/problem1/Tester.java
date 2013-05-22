package edu.columbia.cs.cs1007.hw4.problem1;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The tester class for EncryptingWriter and DecryptingReader
 * @author R_K
 *
 */

public class Tester {

	/**
	 * @param args Command line arguments
	 * @throws IOException Exception for any Input or Output problems
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner input= new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		PrintWriter writer= new PrintWriter(System.out);
		
		System.out.println("Type in what you want to enrcypt without spaces. (If you type lowercase letters the case will not remain).\nONLY TYPE IN LETTERS.");
		String text= input.next();
		char[] cbuf= text.toCharArray();
		CharArrayReader reader= new CharArrayReader(cbuf, 0, cbuf.length);
		DecryptingReader decrypt= new DecryptingReader(reader);
		EnrcryptingWriter encrypt= new EnrcryptingWriter(writer);
		
		out.println("Here is your text: ");
		out.println(cbuf);
		out.println("Here is your text coded: ");
		encrypt.write(cbuf, 0, cbuf.length); //encrypts cbuf
		out.println(cbuf);
		out.println("Here is your text coded again : ");
		out.println(cbuf);
		out.println("Here is your text decoded: ");
		decrypt.read(cbuf, 0, cbuf.length); //decrypts cbuf
		decrypt.close();
		out.println(cbuf);
		out.close();
		
		
		
	}
}
