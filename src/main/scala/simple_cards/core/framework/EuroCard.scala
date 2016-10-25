package simple_cards.core.framework

/**
  * Created by Simone on 10/25/2016.
  * github: https://github.com/svbygoibear
  */

sealed trait EuroCardSuit
object Clubs extends EuroCardSuit
object Diamonds extends EuroCardSuit
object Hearts extends EuroCardSuit
object Spades extends EuroCardSuit

//Used compare on value to determine which values are higher than others
sealed class CardValue(val naturalNumber: Int) extends Ordered[CardValue]{
  def compare(that: CardValue) = naturalNumber.compare(that.naturalNumber)
}

//Card case class which can be built from it's value and the representing suit
case class Card(numericValue: Int, suit: EuroCardSuit)

//Shows which value is higher than others
object One extends CardValue(1)
object Two extends CardValue(2)
object Three extends CardValue(3)
object Four extends CardValue(4)
object Five extends CardValue(5)
object Six extends CardValue(6)
object Seven extends CardValue(7)
object Eight extends CardValue(8)
object Nine extends CardValue(9)
object Ten extends CardValue(10)
object Jack extends CardValue(11)
object Queen extends CardValue(12)
object King extends CardValue(13)
object Ace extends CardValue(14)

object CardValue{
  val allSorted = Seq(One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace)
}

