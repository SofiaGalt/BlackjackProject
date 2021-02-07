package com.skilldistillery.blackjack;

import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.gameabstractions.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
	}
	
	public void displayCards(String title , boolean withFaceDownCard) {
		
		if(withFaceDownCard) {
			System.out.println("\n"+ title +": > " + getVisibleHandValue());
		}
		else {
			System.out.println("\n"+ title +": " + getHandValue());
		}
		
		int i;
		for(i = 1 ; i < cardsOfHand.size(); i++) {
			System.out.println("\t"+ i + ". "+ cardsOfHand.get(i));
		}
		
		if(withFaceDownCard) {
			System.out.println("\t" + i + ". (facedown card)");
		}
		else {
			System.out.println("\t"+ i + ". "+ cardsOfHand.get(0));
		}
	}

	@Override
	public int getHandValue() {
		
		int totalValue = 0;
		
		for(Card c : cardsOfHand) {
			totalValue += c.getValue();
		}
		
		return totalValue;
	}
	
	private int getVisibleHandValue() {
		
		int totalValue = 0;
		
		for(int i = 1 ; i < cardsOfHand.size(); i++) {
			totalValue += cardsOfHand.get(i).getValue();
		}
		
		return totalValue;
	}

	@Override
	public void displayCards() {
		
		for(int i = 0 ; i < cardsOfHand.size(); i++) {
			System.out.println("\t"+ (i+1) + ". "+ cardsOfHand.get(i));
		}
	}
	

}
