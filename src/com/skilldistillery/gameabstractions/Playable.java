package com.skilldistillery.gameabstractions;

import com.skilldistillery.cards.Card;

public interface Playable {
	
	public abstract void takeCard(Card card);
	
	public abstract int getHandValue();
	
	public abstract void displayCards();
	
	public abstract String getTitle();
}