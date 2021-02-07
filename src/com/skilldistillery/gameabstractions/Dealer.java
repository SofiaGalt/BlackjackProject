package com.skilldistillery.gameabstractions;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public abstract class Dealer {
	
	protected Deck gameDeck;
	protected String name;
	protected Hand hand;
	
	public Dealer() { 
		name = "Kylo Ren"; 
		gameDeck = new Deck();
	}

	public Dealer(Deck gameDeck) {
	
		this.gameDeck = gameDeck;
		name = "Kylo Ren";
	}
	
	public Dealer(Deck gameDeck, String name) {
		
		this.gameDeck = gameDeck;
		this.name = name;
	}

	public Card dealCard() {
		Card toReturn = gameDeck.dealCard();
		
		if(toReturn == null) {
			System.out.println("Dealer " + name + ": I apologize, we're out of cards.");
		}
		
		return toReturn;
	}
	
	public void shuffle() {
		gameDeck.shuffle();
	}
}
