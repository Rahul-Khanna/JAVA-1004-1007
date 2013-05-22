//***********
//Game.java
//The Game class for Poker
//Rahul Khanna
//************

import java.util.ArrayList;
import java.util.Scanner;

public class Game { //creating my instance variables

	private Player user;
	private Deck deck;
	private Hand hand;
	private Scanner in= new Scanner(System.in);
	private int javaDollar;
	private boolean playAgain;
	
	public Game() //creating the object Game( creating the game)
	{
		user= new Player();
		deck= new Deck();
		hand= new Hand();
		javaDollar=10;
		playAgain=true;
	}
	
	public void play() //this method is to play Poker
	{
		while(playAgain) // allows the user to play again
		{
			javaDollar--;
			boolean replace= false; // allows the method to skip presenting the users cards again if the user didn't want to replace
			
			for(int i=1; i<6; i++) //creates a hand
			{
				Card card = deck.draw();
				user.addCard(card);
			}
			System.out.println("Your cards are\n"); //these two lines display the hand
			System.out.println(user.toString());
		
			
			System.out.println("Would you like to replace your cards? Enter yes or no.");
			
			if(in.next().equals("yes")) // if the user wants to replace his cards, he/she follows the instructions below.
			{
				ArrayList<Integer> locations = new ArrayList<Integer>(); //this ArrayList is used below
				
				System.out.println("Enter a five digit number that has a zero in the location of the card you want to get rid off\nand a one in the location of the card you want to keep.\nFor example if you want to keep cards 1,3,5, you would input 10101");
				String number= in.next();
				
				while(number.length()!=5) // makes sure the user input is of length 5
				{
					System.out.println("You didn't enter a fiver digit number. Please try again.\nRemember a zero in the same position of the cards you want to replace \nand a one in the same position of the cards you want to keep.");
					number=in.next();
				}
				
				for(int i=0; i<5; i++) // fills the location ArrayList with the user's input
				{
					locations.add(i,Integer.parseInt(number.substring(i, (i+1))));
				}
				
				for(int i=0; i<5; i++) // replaces the card if the value in the location ArrayList at that position is 0
				{
					if(locations.get(i)==0)
						user.replaceCard(i, deck.draw());
				}
				
				replace=true;
			}
		
			if(replace) //shows the user his new cards
			{
				System.out.println("Your cards are now:\n");
				System.out.println(user.toString());
			}
			hand.getHandInfo(user.retrunHand()); // these three steps and all the if statements below check to see what hand the user got
			hand.sortCards();
			hand.checkSuit();
		
			if(hand.royalFlush())
			{
				System.out.println("YOU HAVE A ROYAL FLUSH");
				javaDollar+=250;
			}
		
			if(hand.straightFlush())
			{
				System.out.println("YOU HAVE A STRAIGHT FLUSH");
				javaDollar+=50;
			}
		
			if(hand.fourOfAKind())
			{
				System.out.println("YOU HAVE A FOUR OF A KIND");
				javaDollar+=25;
			}
		
			if(hand.fullHouse())
			{
				System.out.println("You have a FULL HOUSE");
				javaDollar+=6;
			}
		
			if(hand.flush())
			{
				System.out.println("You have a FlUSH");
				javaDollar+=5;
			}
		
			if(hand.straight())
			{
				System.out.println("You have a STRAIGHT");
				javaDollar+=4;
			}
		
			if(hand.threeOfAKind())
			{
				System.out.println("You have a Three Of A Kind");
				javaDollar+=3;
			}
		
			if(hand.twoPairs())
			{
				System.out.println("You have Two Pairs");
				javaDollar+=2;
			}
		
			if(hand.jackOrHigher())
			{
				System.out.println("You have a pair of Jacks or higher");
				javaDollar+=1;
			}
		
			hand.theRest(); // checks to see if the user got a hand not in the payout scheme
			
			if(javaDollar!=0) // if the user still has javaDollars, allows him to play again
			{
				System.out.println("You have: " + javaDollar + " Java Dollar(s).\nWould you like to play again? Enter yes or no.");
			
				if(in.next().equals("yes")) // resets the deck, the hand and all the checks
				{
					deck.resetDeck(deck);
					user.resetHand();
					hand.resetBooleans();
				}
				else
					playAgain=false;
				
			}
			else // if the user has no money left, doesn't allow him to play again
			{
				System.out.println("YOU ARE BANKRUPT. YOU SHOULDN'T GAMBLE.");
				playAgain=false;
			}
		}	
	}
	public void netProfit() // this method is used at the end of the game to tell the user how he did
	{
		int netProfit= javaDollar-10;
		if(netProfit>0)
			System.out.println("Great Job! You made " + netProfit + " Java Dollar(s).");
		if(netProfit==0)
			System.out.println("Not too shabby, you broke even.");
		if(netProfit<0 && netProfit!=-10)
			System.out.println("At least you knew when to quit. You only lost " + Math.abs(netProfit) + " Java Dollar(s).");
		if(netProfit==-10)
			System.out.println("Don't play poker, gambling isn't for you.");
	}
}
