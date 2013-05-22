//*************
//Test.java
//The Test method for Poker
//Rahul Khanna
//*************

public class Test { //allows a user to play the game
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Video Poker. You have 10 Java Dollars.");
		System.out.println("The rules are simple, each time you play you use one Java Dollar.");
		System.out.println("The winning hands are as follows: Royal Flush, Straight Flush,\nFour of a Kind, Full House, Flush, Straight, Three of A kind,\nTwo Pair or a Pair of Jacks or Better.");
		System.out.println();
		System.out.println("The payouts for each hand are:\nRoyal Flush: 250\nStraight Flush: 50\nFour of a Kind: 24\nFull House: 6\nFlush: 5\nStraight: 4\nThree of a Kind: 3\nTwoPair: 2\nPair of Jacks or Better: 1.");
		System.out.println();
		Game g= new Game();
		g.play();
		g.netProfit();
	}

}
