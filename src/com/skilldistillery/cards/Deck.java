package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class Deck {
  List<Card> deck = new ArrayList<>();
  
  public Deck() {
	  for(Suit suit : Suit.values()) {
		  
		  for(Rank rank : Rank.values()) {
			  deck.add(new Card(suit, rank));
		  }
	  }
  }
  
  public Card dealCard() {
	  return deck.remove( (int)( Math.random() * deck.size()));
  }
  
  public int checkDeckSize() {
	  return deck.size();
  }
}
