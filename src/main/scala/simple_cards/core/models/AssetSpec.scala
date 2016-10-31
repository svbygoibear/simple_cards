package simple_cards.core.models

import simple_cards.core.framework.{EuroCard, PokerHand}

/**
  * Created by Simone on 10/25/2016.
  * github: https://github.com/svbygoibear
  */

// Player class can later be expanded to include the winning combination
case class Player(playerName: String, hand: PokerHand)
