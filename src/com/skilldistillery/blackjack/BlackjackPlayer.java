package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.gameabstractions.*;


public class BlackjackPlayer extends Guest implements Playable {
	
	protected Hand hand;

	{
		hand = new BlackjackHand();
	}

	public BlackjackPlayer() {
		
	}
	
	public BlackjackPlayer(String username) {
		
		super(username);
	}
	
	public void cardsGameDisplay() {
		((BlackjackHand)hand).displayCards( getUsername(), false);
	}
	
	@Override
	public void takeCard(Card card) {
		
		hand.addCard(card);
	}
	
	@Override
	public int getHandValue() {
		
		return hand.getHandValue();	
	}
	
	@Override
	public void displayCards() {
		System.out.println("\n"+ getUsername() +": " + getHandValue());
		hand.displayCards();
	}
	@Override
	public String getTitle() {
		
		return getUsername();
	}
	
}
