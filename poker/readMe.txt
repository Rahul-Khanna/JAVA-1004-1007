Card:
This class was very simple, the point of it was to make an object called Card, defined by its suit and 
value number.The most important part of this class are the methods, which allow other classes to access 
the value and suit of the card.

Deck:
This class is also simple. I made the deck of cards in this class, by creating an ArrayList of Cards, and
filled it with all 52 cards. I knew that there was a method "Collection.shuffle" but I wanted to make my
own shuffle method, so I looked up the best shuffling algorithms. I followed the Fisher-Yates/Knuth 
original shuffle, which is basically, create a new array, pick a random number, k from 0 to (n-1) where n
is the length of the originally array, and let the first element of the new array be the kth element of 
the original array. You keep doing this until the new array is filled, which is now shuffled array. The 
draw method just gets the first Card from the deck and removes it from the deck and returns the Card. I 
needed the resetDeck method so that each time the user wanted to play again, a new shuffle deck would be
created.

Player:
This class was responsible of adding cards to the hand, replacing cards in the hand, displaying the hand
to the player and then reseting the hand after every game. 

Hand:
This class's job was to check the value of the hand. The card would get an ArrayList of 5 Cards, break
that ArrayList down to five individual cards, and then store the suit and value of each Card. It would 
then sort the cards from lowest to highest value, and check to see if all the cards were of the same
suit. The sorting of the cards, allowed the check to be simple, since unless all the cards were equal, 
the first card's value couldn't equal the fifth card's value. This made the number of possibilities much,
much smaller. This class also included a method that would reset all the booleans for the checks, so that
each check would be reset for each round of play.

Game:
This class just brought the four previous classes together. This class included two methods, the play 
method, which allowed the user to play poker, and the netProfit method which would let the user know how
he/she did at the end of the game. The workings of the play method are described in the comments. 
Replacing multiple cards at once was tricky, since the amount of cards the user wanted to replace and 
the position of these cards were variable, but I wanted to make it as realistic as possible, so while
the method I did it in might be a bit odd, I feel it is better then replacing cards, card by card. I kind
of thought like a computer with the replacing card part of the game, as for each card I wanted to know if
the user wanted or didn't want to replace the card, so I used ones and zeros to do this. I added the 
whole wager aspect to the game, since I wanted this to be realistic, and in real poker there is a 
concept of money. Each time the user played he used one of his ten java dollars, which is what is part of
the original assignment in the book. 

Test:
This class simply tells the user how much money he has to start with it, the winning hands and the payout
scheme. It then runs the game and finally tells the user how he/she did.

