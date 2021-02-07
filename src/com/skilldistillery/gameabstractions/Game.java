package com.skilldistillery.gameabstractions;

import java.util.List;

import com.skilldistillery.cards.Deck;

public abstract class Game {
	
	public Dealer dealer;
	
	public List<Playable> players;

	public Game(Dealer dealer, List<Playable> players) {
		
		this.dealer = dealer;
		this.players = players;
	}
	
	public abstract void play();	
}
