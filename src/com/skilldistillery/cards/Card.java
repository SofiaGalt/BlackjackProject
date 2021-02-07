package com.skilldistillery.cards;

public class Card {
	
	final Suit suit;
	final Rank rank;
	
	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public int hashCode() {
		
		return (rank.ordinal() * 17) * (suit.ordinal() * 19);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return hashCode() == other.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rank.toString().toLowerCase() + " of " + suit);
		return builder.toString();
	}
	
	public int getValue() {
		return rank.getValue();
	}

}
