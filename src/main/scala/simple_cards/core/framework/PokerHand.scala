package simple_cards.core.framework

import scala.Some
import scalaz._
import Scalaz._

/**
  * Created by Simone on 10/25/2016.
  * github: https://github.com/svbygoibear
  */

// Poker hands checks for the rules to each hand
class PokerHand(cards: IndexedSeq[EuroCard]) { // Using IndexedSeq as this will access any sequence O(1)
  type Hand = IndexedSeq[EuroCard]

  val royalFlushValues = IndexedSeq(Ten, Jack, Queen, King, Ace)  // Setting up royal flush hand
  def isRoyal : Option[Hand] = royalFlushValues.forall(value => cards.exists(_.value == value)) match { // Checks if value is a royal value
      case true => cards.some
      case false => None
    }

  // Checks if the cards are a flush: All cards of the same suit.
  def isFlush: Option[Hand] = cards.groupBy(_.suit).size == 1 match { // Checking that when cards are grouped by suit, their suit should be the same, thus the size should be 1
    case true => cards.some
    case false => None
  }

  val possibleStraightValues = Value.cardValuesInOrder.sliding(5).toSet // Slides to 5 consecutive values from the card value sequence, this is used to check if a hand is straight

  // Checks if it is Straight: All cards are consecutive values.
  def isStraight: Option[Hand] = possibleStraightValues.contains(cards.map(_.value).sorted) match { // Check if the values are straight/incrementing
    case true => cards.some
    case false => None
  }

  // Checks for RoyalFlush: Ten, Jack, Queen, King, Ace, in same suit.
  def isRoyalFlush: Option[Hand] = isRoyal.zip(isFlush).headOption.map(_._1)

  // Checks for StraightFlush: All cards are consecutive values of same suit.
  def isStraighFlush: Option[Hand] = isStraight.zip(isFlush).headOption.map(_._1)

  // Checks if is Four of a Kind: Four cards of the same value.
  def isFourOfAKind: Option[Hand] = cards.groupBy(_.value).find(_._2.size == 4).map(_._2)

  // Checks if it is Three of a Kind: Three cards of the same value.
  def isThreeOfAKind: Option[Hand] = cards.groupBy(_.value).find(_._2.size == 3).map(_._2)

  // Checks if it is Two Pairs: Two different pairs.
  def isTwoPairs: Option[Hand] = {
    val pairs = cards.groupBy(_.value).filter(_._2.size == 2)
    pairs.size == 2 match {
      case true => pairs.values.flatten.toIndexedSeq.some
      case false => None
    }
  }

  // Checks if it is One Pair: Two cards of the same value.
  def isOnePair: Option[Hand] = cards.groupBy(_.value).find(_._2.size == 2).map(_._2)

  // Checks if it is a Full House: Three of a kind and a pair.
  def isFullHouse: Option[Hand] = isThreeOfAKind.zip(isOnePair).headOption.map(_._1)
}
