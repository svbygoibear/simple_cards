package simple_cards.core.framework

import simple_cards.core.models.Player

import scalaz._
import Scalaz._

/**
  * Created by Simone on 10/25/2016.
  * github: https://github.com/svbygoibear
  */

case class PokerHands(players: Seq[Player]) {
  type TypeHands = Seq[Player] //this is used as a cleaner type reference throughout this case class

  // ToDo: Change to a map where custom comparison methods can be passed for this (all present methods)
  // The present methods return back all the hand that have a certain hand type present
  // To determine the highest value from more of a kind, high card from poker hand can be used
  def isRoyalFlushPresent: Option[TypeHands] = players.filter(player => player.hand.isRoyalFlush.isDefined) match {
    case Nil => None
    case h => h.some
  }

  def isStraightFlushPresent: Option[TypeHands] = players.filter(player => player.hand.isStraightFlush.isDefined) match {
    case Nil => None
    case h => h.some
  }

  def isFourOfAKindPresent: Option[TypeHands] = players.filter(player => player.hand.isFourOfAKind.isDefined) match {
    case Nil => None
    case h => h.some
  }

  def isFullHousePresent: Option[TypeHands] = players.filter(player => player.hand.isFullHouse.isDefined) match {
    case Nil => None
    case h => h.some
  }

  def isFlushPresent: Option[TypeHands] = players.filter(player => player.hand.isFlush.isDefined) match {
    case Nil => None
    case h => h.some
  }

  def isStraightPresent: Option[TypeHands] = players.filter(player => player.hand.isStraight.isDefined) match {
    case Nil => None
    case h => h.some
  }

  def isThreeOfAKindPresent: Option[TypeHands] = players.filter(player => player.hand.isThreeOfAKind.isDefined) match {
    case Nil => None
    case h => h.some
  }

  def isTwoPairsPresent: Option[TypeHands] = players.filter(player => player.hand.isTwoPairs.isDefined) match {
    case Nil => None
    case h => h.some
  }

  def isOnePairPresent: Option[TypeHands] = players.filter(player => player.hand.isOnePair.isDefined) match {
    case Nil => None
    case h => h.some
  }
}
