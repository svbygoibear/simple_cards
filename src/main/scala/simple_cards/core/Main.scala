package simple_cards.core

import simple_cards.core.framework._
import simple_cards.core.models.Player

import scalaz._
import Scalaz._

/**
  * Created by Simone on 10/25/2016.
  * github: https://github.com/svbygoibear
  */

object Main extends App {
  val hand1 =  IndexedSeq[EuroCard](EuroCard(5, Hearts), EuroCard(5, Clubs), EuroCard(6, Spades), EuroCard(7, Spades), EuroCard(13, Diamonds))
  val hand2 = IndexedSeq[EuroCard](EuroCard(5, Hearts), EuroCard(5, Clubs), EuroCard(8, Spades), EuroCard(2, Spades), EuroCard(8, Diamonds))

  val person1 = PokerHand(hand1)
  val person2 = PokerHand(hand2)

  val people = PokerHands(Seq[Player](Player("Player 1", person1), Player("Player 2", person2)))

  //val winner = PokerInterpreter.getWinner(people)

  println(people.isRoyalFlushPresent)
  println(s"${person2.isOnePair}")
}
