package simple_cards.core.framework

/**
  * Created by Simone on 10/25/2016.
  * github: https://github.com/svbygoibear
  */

// Trait is used as the suit can then be defined off of the extended list of suits - this keeps things easy to
// modify but also type-safe
sealed trait EuroCardSuit
object Clubs extends EuroCardSuit
object Diamonds extends EuroCardSuit
object Hearts extends EuroCardSuit
object Spades extends EuroCardSuit

// Used compare on value to determine which values are higher than others
sealed class Value(val naturalNumber: Int) extends Ordered[Value]{
  def compare(that: Value) = naturalNumber.compare(that.naturalNumber)
}

// Card case class which can be built from it's value and the representing suit
// This is a case class as it allows pattern matching and do not need the new keyword for new instances
case class EuroCard(value: Int, suit: EuroCardSuit)

//Shows which value is higher than others
object One extends Value(1)
object Two extends Value(2)
object Three extends Value(3)
object Four extends Value(4)
object Five extends Value(5)
object Six extends Value(6)
object Seven extends Value(7)
object Eight extends Value(8)
object Nine extends Value(9)
object Ten extends Value(10)
object Jack extends Value(11)
object Queen extends Value(12)
object King extends Value(13)
object Ace extends Value(14)

// Creates the sequence when it comes to assigning values to cards
object Value{
  val cardValuesInOrder = Seq(One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace)
}

