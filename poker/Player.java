//************
//Player.java
//The Player class for Poker
//Rahul Khanna
//************

import java.util.ArrayList;

public class Player { //creating my instance variables
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player() //creating the object Player( creating a player)
	{
	}
	
	public void addCard(Card newCard) //this method adds a card to the hand of the player
	{
		hand.add(newCard);
		
	}
	
	public ArrayList<Card> retrunHand() //this method  returns the hand of the player
	{
		return hand;
	}
	
	public void replaceCard(int cardLocation, Card replacementCard) //this method allows the player to replace his cards
	{
		hand.set(cardLocation, replacementCard);
	}
	
	public String toString() // the toString method for the Player. It just displays the hand of the player to the player.
	{
		String info= "";
		int i= 1;
	
		for(Card c : hand)
			{
					info += "CardNumber " + i + " is " + c.toString() + "\n";
					i++;
			}
		
		return info;
	}

	public void resetHand() // resets the hand of the player
	{
		ArrayList<Card> newHand = new ArrayList<Card>();
		hand=newHand;
	}
}
