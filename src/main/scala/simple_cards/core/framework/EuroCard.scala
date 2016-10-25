package simple_cards.core.framework

/**
  * Created by Simone on 10/25/2016.
  * github: https://github.com/svbygoibear
  */

// Trait is used as the suit can then be defined off of the extended list of suits - this keeps things easy to
// modify but also type-safe
sealed trait EuroSuit
object Clubs extends EuroSuit
object Diamonds extends EuroSuit
object Hearts extends EuroSuit
object Spades extends EuroSuit

// Used compare on value to determine which values are higher than others
// This is used so that we can still compare the numeric values of objects, but they are still objects
sealed class CardValue(val naturalNumber: Int) extends Ordered[CardValue]{
  def compare(that: CardValue) = naturalNumber.compare(that.naturalNumber)
}

// Card case class which can be built from it's value and the representing suit
// This is a case class as it allows pattern matching and do not need the new keyword for new instances
case class EuroCard(cardValue: Int, suit: EuroSuit)

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
// Creates the sequence when it comes to assigning values to cards
object CardValue{ val allSortedCards = Seq(One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace) }

