Rahul Khanna
rk2658

How to run and compile the code:
javac edu/columbia/cs/cs1007/hw4/problem1/*.java
java edu/columbia/cs/cs1007/hw4/problem1/Tester

Tester:
Just a tester class showing that EncryptingWrtier.java and DecryptingReader.java work.

EncryptingWriter:
A decorator for an underlying writer class. Its job is to take in a character array and encrypt the array by taking each character in the array and moving its placement three to the right in the alphabet.

DecryptingReader:
A decorator for an underlying reader class. Its job is to take in a character array and decrypt the array by taking each character in the array and moving its placement three to the left in the alphabet.

Summery:
The user enters whatever text he/she wants without spaces and only using letters. The program than shows the user his text, then shows the user his encrypted text and re-shows the user his encrypted text. Finally the program shows the user his text again by decrypting the encryption. It doesn't keep case, because that was not required in the assignment and thus would just add more lines to the code.