package simple_cards.core.framework

import simple_cards.core.models.Player

/**
  * Created by Simone on 10/25/2016.
  * github: https://github.com/svbygoibear
  */

object PokerInterpreter {
  // ToDo: This singleton can be improved with the use of an implicit players

  // This is used to determine the winner from a collection of players with a hand of 5 cards
  def getWinner(players: PokerHands): Player = resolveRoyalFlush(players) match {
    case Some(player) => player // Only one royal flush was found, that player wins
    case None => resolveStraightFlush(players) match {
      case Some(player) => player // Only one straight flush was found, that player wins
      case None => resolveFourOfAKind(players) match {
        case Some(player) => player // There was only one player with the highest value of four of a kind
        case None => resolveFullHouse(players) match {
          case Some(player) => player // Only one player can have a full house
          case None => resolveFlush(players) match {
            case Some(player) => player // Resolve the single player with the highest flush hand
            case None => resolveStraight(players) match {
              case Some(player) => player // Resolves the single highest straight hand player
              case None => resolveThreeOfAKind(players) match {
                case Some(player) => player // Resolves the single highest three of a kind hand player
                case None => resolveTwoPairs(players) match {
                  case Some(player) => player // Resolves the best player out of two matching pairs
                  case None => resolveOnePair(players) match {
                    case Some(players) => players // Resolves the best hand out of a single pair
                    case None =>
                      val highestHand = players.getHighestHandsGrouped
                      if(highestHand == 1) highestHand.map(_._2).head.head else null // gets the hand with the highest card value, otherwise null
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  // Resolves the result from a royal flush
  def resolveRoyalFlush(players: PokerHands): Option[Player] = {
    players.isRoyalFlushPresent match {
      case Some(ps) => if(ps.size > 1) None else ps.headOption
      case None => None
    }
  }

  // Resolves the result from a straight flush
  def resolveStraightFlush(players: PokerHands): Option[Player] = {
    players.isStraightFlushPresent match {
      case Some(ps) => if(ps.size == 1) ps.headOption else None
      case None => None
    }
  }

  // Resolves the result of four of a kind, returning the highest ranked player of four of a kind, if there is only one
  def resolveFourOfAKind(players: PokerHands): Option[Player] = {
    players.isFourOfAKindPresent match {
      case Some(ps) =>
        val h = ps.sortBy(player => player.hand.getHighCard).reverse.groupBy(play => play.hand.getHighCard).filter(_._2.size == 1)
        h.size == 1 match {
          case true => h.head._2.headOption
          case false => None
        }
      case None => None
    }
  }

  // Resolves if there is only one full house
  def resolveFullHouse(players: PokerHands): Option[Player] = {
    players.isFullHousePresent match {
      case Some(ps) => if(ps.size == 1) ps.headOption else None
      case None => None
    }
  }

  // Resolves flush, determined by only one of the highest flush ranking
  def resolveFlush(players: PokerHands): Option[Player] = {
    players.isFlushPresent match {
      case Some(ps) =>
        val h = players.getHighestHandsGrouped
        h.size == 1 match {
          case true => h.head._2.headOption
          case false => None
        }
      case None => None
    }
  }

  // Resolve straight hand, determined by the highest straight hand ranking
  def resolveStraight(players: PokerHands): Option[Player] = {
    players.isStraightPresent match {
      case Some(ps) =>
        val h = players.getHighestHandsGrouped
        h.size == 1 match {
          case true => h.head._2.headOption
          case false => None
        }
      case None => None
    }
  }

  // Resolve three of a kind hand, determined by the highest hand ranking
  def resolveThreeOfAKind(players: PokerHands): Option[Player] = {
    players.isThreeOfAKindPresent match {
      case Some(ps) =>
        val h = players.getHighestHandsGrouped
        h.size == 1 match {
          case true => h.head._2.headOption
          case false => None
        }
      case None => None
    }
  }

  // ToDo: check both pairs
  // Resolve two pairs hand, determined by the highest hand ranking
  def resolveTwoPairs(players: PokerHands): Option[Player] = {
    players.isTwoPairsPresent match {
      case Some(ps) =>
        val h = players.getHighestHandsGrouped
        h.size == 1 match {
          case true => h.head._2.headOption
          case false => None
        }
      case None => None
    }
  }

  // Resolve one pair hand, determined by the highest hand ranking
  def resolveOnePair(players: PokerHands): Option[Player] = {
    players.isOnePairPresent match {
      case Some(ps) =>
        val h = players.getHighestHandsGrouped
        h.size == 1 match {
          case true => h.head._2.headOption
          case false => None
        }
      case None => None
    }
  }
}
