package br.com.deitel.cap.twenty;

class Card {
	public static enum Face {
		Ace, Deuce, Three, Four, Five, Six, Seve, Eight, Nine, Ten, Jack, Queen, King
	};

	public static enum Suit {
		Clubs, Diamonds, Hearts, Spades
	};
	
	private final Face face;
	private final Suit suit;
	
	public Card(Face cardFace, Suit cardSuit)  {
		face = cardFace;
		suit = cardSuit;
	}
	
	public Face getFace() {
		return face;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return String.format("%s of %s", face, suit);
	}
}
