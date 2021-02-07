package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  private List<Card> deck;
  
  public Deck() {
	  
	  // right now the default deck is instantiated as blackjack deck.
	  initializeBlackjackDeck();
  }
  
  private void initializeBlackjackDeck() {
	  deck = new ArrayList<>();
	  for(Suit suit : Suit.values()) {
		  for(Rank rank : Rank.values()) {
			  deck.add(new Card(suit, rank));
		  }
	  }
	  shuffle();
  }
  
  public Card dealCard() {
	  return deck.remove( deck.size() -1);
  }
  
  public int deckSize() {
	  return deck.size();
  }
  
  public void shuffle() {
	  Collections.shuffle(deck);
  }
  
}
