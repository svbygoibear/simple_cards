package simple_cards.core.framework

import simple_cards.core.models.Player

/**
  * Created by Simone on 10/25/2016.
  * github: https://github.com/svbygoibear
  */

object PokerInterpreter {
  // ToDo: This singleton can be improved with the use of an implicit players

  // This is used to determine the winner from a collection of players with a hand of 5 cards
  def getWinner(players: PokerHands): Player = {
    resolveRoyalFlush(players) match {
      case Some(player) => player // Only one royal flush was found, that player wins
      case None => null
    }
  }

  // Resolves the result from a royal flush
  def resolveRoyalFlush(players: PokerHands): Option[Player] = {
    players.isRoyalFlushPresent match {
      case Some(ps) => if(ps.size > 1) None else ps.headOption
      case None => None
    }
  }
}
