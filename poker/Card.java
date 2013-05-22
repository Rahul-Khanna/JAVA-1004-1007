//******************
// Card.java
// Card class for Poker
// Rahul Khanna
//******************

public class Card { //creating my instance variables

	private int suit;
	private int value;
	private final static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	private final static String[] values = {"Two", "Three","Four","Five","Six","Seven","Eight", "Nine", "Ten","Jack", "Queen","King", "Ace"};
	
	public Card(int s, int v) //creating the object called Card (creating a card)
	{
			suit =s;
			value = v;
	}
	
	public String toString() // creating the toSting method for the Card class. It will be used to tell the user what card he/she has.
	{
		String cardInfo = values[value] + " of " + suits[suit];
		return cardInfo;
	}
	
	public int getSuit() // this method allows other classes to know what suit the card is
	{
		return suit;
	}
	
	public int getValue() // this method allows other classes to know what value a card has
	{
		return value;
	}
}

