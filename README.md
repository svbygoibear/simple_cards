#simple_cards
##Synopsis
###Functionality
Simple cards is a library initially as an exercise to determine the winner of a poker game determine from a hand of cards, and can perform the following:
<br>
[x] Compare any amount of player's hand to determine a winner of a game of poker
<br>
[] Read from a text file
<br>
[] Determine the winner from another card game
<br>
[] Output how many times player 1 wins

###How to solve the problem
I first started off by out lining the 4 main areas of functionality in my mind, which is:
 - The rules of poker and different hand types. *DONE*
 - How to calculate a score/winner based on the rules. *DONE*
 - Reading in a file.
 - Doing a count to determine how many hands player 1 wins.
 
For this, I did not complete reading the text file, creating player objects and determining how many times player 1 wins, but rather focused on the functionality which could be used to determine the winner.
With this in mind, I created objects to define in words what a card looks like and what it's value translates to - then using hands of cards and players I created case classes that aid in determining the outcome of a hand and then comparing player's hands.

##Code Example
###Assignment
In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

- High Card: Highest value card.
- One Pair: Two cards of the same value.
- Two Pairs: Two different pairs.
- Three of a Kind: Three cards of the same value.
- Straight: All cards are consecutive values.
- Flush: All cards of the same suit.
- Full House: Three of a kind and a pair.
- Four of a Kind: Four cards of the same value.
- Straight Flush: All cards are consecutive values of same suit.
- Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

The cards are valued in the order:
```
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
```
If two players have the same ranked hands then the rank made up of the highest value wins; for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, both players have a pair of queens, then highest cards in each hand are compared; if the highest cards tie then the next highest cards are compared, and so on.

###Example Results
The following results would yield from the example values:
<br>
 Hand   | Player 1                                                 | Player 2                                                   | Winner 
--------|----------------------------------------------------------|------------------------------------------------------------|--------
  1     |   5H 5C 6S 7S KD: Pair of Fives                          |   2C 3S 8S 8D TD: Pair of Eights                           | Player 2
  2     |   5D 8C 9S JS AC: Highest card Ace                       |   2C 5C 7D 8S QH: Highest card Queen                       | Player 1
  3     |   2D 9C AS AH AC: Three Aces                             |   3D 6D 7D TD QD: Flush with Diamonds                      | Player 2
  4     |   4D 6S 9H QH QC: Pair of Queens --  Highest card Nine   |   3D 6D 7H QD QS: Pair of Queens --  Highest card Seven    | Player 1
  5     |   2H 2D 4C 4D 4S: Full House --  With Three Fours        |   3C 3D 3S 9S 9D: Full House --  with Three Threes         | Player 1


###Assumptions
The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. Each card is specified as the number (T for ten, J for Jack, Q for Queen) and then the suite - so TS is the 10 of Spades.
You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.

###Code Snippet
First off, make sure that there is a hand for each player as well as a list of all the players:
```javascript
  val hand1 =  IndexedSeq[EuroCard](EuroCard(5, Hearts), EuroCard(5, Clubs), EuroCard(6, Spades), EuroCard(7, Spades), EuroCard(13, Diamonds))
  val hand2 = IndexedSeq[EuroCard](EuroCard(2, Clubs), EuroCard(2, Spades), EuroCard(8, Spades), EuroCard(8, Diamonds), EuroCard(10, Diamonds))

  val person1 = PokerHand(hand1)
  val person2 = PokerHand(hand2)

  val people = PokerHands(Seq[Player](Player("Player 1", person1), Player("Player 2", person2)))
```

Then to determine the winner from a list of players with their hands, just call the following:
```javascript
  val winner = PokerInterpreter.getWinner(people)
```


##Contributors
Feel free to pop me a message or flag an issue if you come across it - I'll see what I can do about it.

##License

Copyright © `2016` `Simone van Buuren`

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the “Software”), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.