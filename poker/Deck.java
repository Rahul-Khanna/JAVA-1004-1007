//**************
//Deck.java
//The Deck class for Poker
//Rahul Khanna
//****************
import java.util.ArrayList;

public class Deck { //creating my instance variables
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<Card> newDeck = new ArrayList<Card>();
	
	public Deck() // creating the object called deck (creating a deck of cards)
	{
		for(int i=0; i<4; i++)
		{
			for(int j = 0; j<13; j++)
			{
				Card newCard= new Card(i,j);
				deck.add(newCard);
			}
		}
		shuffle();
	}
	
	public void shuffle() //this method will rearrange the arraylist of cards(deck), it shuffles the cards
	{
		int n=52;
		
		for(int i=0; i<52; i++)
		{
			int randomNumber= (int) (Math.random() *n);
			Card randomCard = deck.get(randomNumber);
			newDeck.add(randomCard);
			deck.remove(randomCard);
			n--;
		}
		deck=newDeck;
		ArrayList<Card> newDeck1 = new ArrayList<Card>(); //to make sure that newDeck is blank each time
		newDeck=newDeck1;
		
	}
	
	public Card draw() // this method allows the user to draw a card from the top of the deck
	{
		Card c= deck.get(0);
		deck.remove(0);
		return c;
	}
	
	public void resetDeck(Deck d) // resets the deck to 52 shuffled cards 
	{
		Deck resetDeck= new Deck();
		d=resetDeck;
	}
	
}
