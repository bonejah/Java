package br.com.deitel.cap.seven;

public class Card {
	private String face;
	private String suit;
	
	public Card(String cardFace, String cardSuite) {
		face = cardFace;
		suit = cardSuite;
	}
	
	@Override
	public String toString() {
		return face + " of " + suit;
	}
}

