import simple_cards.core.framework._

val hand1 =  IndexedSeq[EuroCard](EuroCard(8, Clubs), EuroCard(10, Spades), EuroCard(13, Clubs), EuroCard(9, Hearts), EuroCard(4, Spades))
val hand2 = IndexedSeq[EuroCard](EuroCard(7, Diamonds), EuroCard(2, Spades), EuroCard(5, Diamonds), EuroCard(3, Spades), EuroCard(14, Clubs))

val person1 = PokerHand(hand1)
val person2 = PokerHand(hand2)

person1.isOnePair