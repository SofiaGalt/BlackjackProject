package com.skilldistillery.gameabstractions;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {

	public List<Card> cardsOfHand;
	
	public Hand() {
		cardsOfHand = new ArrayList<>();
	}
	
	public abstract int getHandValue(); 
	
	public abstract void displayCards();
	
	public void addCard(Card newCard) {
		cardsOfHand.add(newCard);
	}
	
	public List<Card> clearHand(Card newCard) {
		List<Card> toReturn = cardsOfHand;
		cardsOfHand = new ArrayList<>();
		return toReturn;
	}
}
