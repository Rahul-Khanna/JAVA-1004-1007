//*************
//Hand.java
//The Hand class for poker, the point of this class is to find what hand the user has
//Rahul Khanna
//*************

import java.util.ArrayList;
import java.util.Collections;

public class Hand // creating my instance variables, there are a lot of them since we have to check for many different hands
{
	private int suitCard1;
	private int valueCard1;
	private int suitCard2;
	private int valueCard2;
	private int suitCard3;
	private int valueCard3;
	private int suitCard4;
	private int valueCard4;
	private int suitCard5;
	private int valueCard5;
	boolean sameSuit;
	private ArrayList<Integer>sortedHand= new ArrayList<Integer>();
	private boolean royalFlush;
	private boolean straightFlush;
	private boolean fourOfAKind;
	private boolean fullHouse;
	private boolean flush;
	private boolean straight;
	private boolean threeOfAKind;
	private boolean twoPairs;
	private boolean onePair;
	private boolean jackOrHigher;
	
	public Hand() //creates the object Hand, and sets the booleans to false.
	{	
		royalFlush=false;
		straightFlush=false;
		fourOfAKind= false;
		fullHouse=false;
		flush=false;
		straight=false;
		threeOfAKind=false;
		twoPairs=false;
		onePair=false;
		sameSuit=false;
		jackOrHigher=false;
	}
	
	public void getHandInfo(ArrayList<Card> hand) //gets the suit and value of each card in the user's hand
	{
		Card card1= hand.get(0);
		Card card2= hand.get(1);
		Card card3= hand.get(2);
		Card card4= hand.get(3);
		Card card5= hand.get(4);
		suitCard1= card1.getSuit();
		valueCard1= card1.getValue();
		suitCard2= card2.getSuit();
		valueCard2= card2.getValue();
		suitCard3= card3.getSuit();
		valueCard3= card3.getValue();
		suitCard4= card4.getSuit();
		valueCard4= card4.getValue();
		suitCard5= card5.getSuit();
		valueCard5= card5.getValue();
	}

	
	public void sortCards() //sorts the card from lowest value to highest value
	{
		sortedHand.add(valueCard1);
		sortedHand.add(valueCard2);
		sortedHand.add(valueCard3);
		sortedHand.add(valueCard4);
		sortedHand.add(valueCard5);
		Collections.sort(sortedHand);
	}
	
	public void checkSuit() // since a few hands need the suit to be the same, I created a method to do this
	{	
		if(suitCard1== suitCard2 && suitCard1== suitCard3 && suitCard1== suitCard4 && suitCard1== suitCard5)
			sameSuit=true;
	}
			
	
	public boolean royalFlush() //checks for a Royal Flush
	{
		if(sameSuit && ((valueCard1 +valueCard2+ valueCard3+ valueCard4+ valueCard5)== 50))
			royalFlush=true;
		
		return royalFlush;
	}
	
	public boolean straightFlush() //checks for a Straight Flush
	{
		if(sameSuit && !royalFlush)
		{
			int difference1= (sortedHand.get(1)- sortedHand.get(0));
			int difference2= (sortedHand.get(2)- sortedHand.get(1));
			int difference3= (sortedHand.get(3)- sortedHand.get(2));
			int difference4= (sortedHand.get(4)- sortedHand.get(3));
			
			if(difference1==1 && difference2==1 && difference3==1 && difference4==1)
				straightFlush=true;
			
			//The case below is if the Ace is the lowest valued card
			if(sortedHand.get(0)==0 && sortedHand.get(1)==1 && sortedHand.get(2)==2 && sortedHand.get(3)==3 && sortedHand.get(4)==12)
				straightFlush=true;
		}
		
		return straightFlush;	
	}
	
	public boolean fourOfAKind() //checks for Four of a Kind
	{
		if(!royalFlush && !straightFlush)
		{
			if(sortedHand.get(0)==sortedHand.get(1) && sortedHand.get(0)==sortedHand.get(2) && sortedHand.get(0)==sortedHand.get(3))
				fourOfAKind=true;
			
			if(sortedHand.get(1)==sortedHand.get(2) && sortedHand.get(1)==sortedHand.get(3) && sortedHand.get(1)==sortedHand.get(4))
				fourOfAKind=true;
		}
		
		return fourOfAKind;
	}

	public boolean fullHouse()  //checks for a Full House
	{
		if(!royalFlush && !straightFlush && !fourOfAKind)
		{
			if(sortedHand.get(0)==sortedHand.get(1) && sortedHand.get(0)==sortedHand.get(2) && sortedHand.get(3)==sortedHand.get(4))
				fullHouse=true;
			
			if(sortedHand.get(0)==sortedHand.get(1) && sortedHand.get(2)==sortedHand.get(3) && sortedHand.get(2)==sortedHand.get(4))
				fullHouse=true;
		}
		
		return fullHouse;
	}

	public boolean flush() //checks for a Flush
	{
		if(!royalFlush && !straightFlush && !fullHouse)
		{
			if(sameSuit)
				flush=true;
		}
		
		return flush;
	}
	
	public boolean straight() //checks for a Straight
	{
		if(!royalFlush && !straightFlush && !fullHouse && !flush)
		{
			int difference1= (sortedHand.get(1)- sortedHand.get(0));
			int difference2= (sortedHand.get(2)- sortedHand.get(1));
			int difference3= (sortedHand.get(3)- sortedHand.get(2));
			int difference4= (sortedHand.get(4)- sortedHand.get(3));
			
			if(difference1==1 && difference2==1 && difference3==1 && difference4==1)
				straight=true;
		
			if(sortedHand.get(0)==0 && sortedHand.get(1)==1 && sortedHand.get(2)==2 && sortedHand.get(3)==3 && sortedHand.get(4)==12)
				straight=true;
		}
		
		return straight;
	}

	public boolean threeOfAKind() //checks for Three of a Kind
	{
		if(!royalFlush && !straightFlush && !fullHouse && !flush && !straight)
		{
			if(sortedHand.get(0)==sortedHand.get(1) && sortedHand.get(0)==sortedHand.get(2))
				threeOfAKind=true;
		
			if(sortedHand.get(1)==sortedHand.get(2) && sortedHand.get(1)==sortedHand.get(3))
				threeOfAKind=true;
		
			if(sortedHand.get(2)==sortedHand.get(3) && sortedHand.get(2)==sortedHand.get(4))
				threeOfAKind=true;
		}
		
		return threeOfAKind;
	}
	
	public boolean twoPairs() //checks for Two Pairs
	{
		if(!royalFlush && !straightFlush && !fullHouse && !flush && !straight && !threeOfAKind)
		{
			if(sortedHand.get(0)==sortedHand.get(1) && sortedHand.get(2)==sortedHand.get(3))
				twoPairs=true;
		
			if(sortedHand.get(1)==sortedHand.get(2) && sortedHand.get(3)==sortedHand.get(4))
				twoPairs=true;	
			
			if(sortedHand.get(0)==sortedHand.get(1) && sortedHand.get(3)==sortedHand.get(4))
				twoPairs=true;
		}
		
		return twoPairs;	
	}
	
	public boolean jackOrHigher() // checks for a pair of jacks or higher
	{
		if(!royalFlush && !straightFlush && !fullHouse && !flush && !straight && !threeOfAKind && !twoPairs)
		{
			if(sortedHand.get(0)>8 && (sortedHand.get(0)==sortedHand.get(1)))
				jackOrHigher=true;
			
			if(sortedHand.get(1)>8 && (sortedHand.get(1)==sortedHand.get(2)))
				jackOrHigher=true;
			
			if(sortedHand.get(2)>8 && (sortedHand.get(2)==sortedHand.get(3)))
				jackOrHigher=true;
			
			if(sortedHand.get(3)>8 && (sortedHand.get(3)==sortedHand.get(4)))
				jackOrHigher=true;
		}
		
		return jackOrHigher;
	}
	
	
	public void onePair() //checks for a pair of tens or lower
	{
		if(!royalFlush && !straightFlush && !fullHouse && !flush && !straight && !threeOfAKind && !twoPairs && !jackOrHigher)
		{
			if(sortedHand.get(0)==sortedHand.get(1))
				onePair=true;
		
			if(sortedHand.get(1)==sortedHand.get(2))
				onePair=true;

			if(sortedHand.get(2)==sortedHand.get(3))
				onePair=true;
		
			if(sortedHand.get(3)==sortedHand.get(4))
				onePair=true;
		}
		
		if(onePair)
			System.out.println("You have a pair");
	}
	
	public void noPair() //Just says that the user has nothing
	{
		if(!royalFlush && !straightFlush && !fullHouse && !flush && !straight && !threeOfAKind && !twoPairs && !jackOrHigher && !onePair)
		{
			System.out.println("You got nothing");
		}	
	}
	
	
	public void theRest() // just calls on the methods onePair and noPair
	{
		onePair();
		noPair();
	}
		
	
	public void resetBooleans() // resets all the checks, so that each new hand can be evaluated
	{
		royalFlush=false;
		straightFlush=false;
		fourOfAKind= false;
		fullHouse=false;
		flush=false;
		straight=false;
		threeOfAKind=false;
		twoPairs=false;
		onePair=false;
		sameSuit=false;
		jackOrHigher=false;
		ArrayList<Integer>sortedHand1= new ArrayList<Integer>();
		sortedHand=sortedHand1;
	}
}
