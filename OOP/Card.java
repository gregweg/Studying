package OOP;

//	Design the data structures for a generic deck of cards. 
//	Explain how you would subclass it to implement particular card games.

public class Card {
	public enum Suit {
		CLUBS (1), SPADES(2), HEARTS(3), DIAMONDS(4);
		int value;
		private Suit(int v) { value = v; }
	};
	
	private int card;
	private Suit suit;
	
	public Card(int r, Suit s) {
		card = r;
		suit = s;
	}
	
	public int value() { return card; }
	public Suit suit() { return suit; }
}
