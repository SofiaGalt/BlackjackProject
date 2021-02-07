package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.gameabstractions.Dealer;
import com.skilldistillery.gameabstractions.Playable;

public class BlackjackDealer extends Dealer implements Playable {

	{
		this.hand = new BlackjackHand();
	}

	public BlackjackDealer() {}

	public BlackjackDealer(Deck gameDeck) {

		super(gameDeck);
	}

	public BlackjackDealer(Deck gameDeck, String name) {

		super(gameDeck, name);
	}

	public void hitOrStay() {

	}

	public void takeCard(Card card) {
		hand.addCard(card);
	};
	
	public int getHandValue() {
		return hand.getHandValue();
	}

	@Override
	public void displayCards() {
		System.out.println("\nDealer: " + getHandValue());
		hand.displayCards();
	}

	@Override
	public String getTitle() {
		return name;
	}

}
