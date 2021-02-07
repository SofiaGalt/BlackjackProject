package com.skilldistillery.casino;

import java.util.List;
import com.skilldistillery.gameabstractions.*;

import com.skilldistillery.gameabstractions.Game;

public class Table {
	
	private Game liveGame;
	
	private List<Playable> playersAtTable;

	public Table(Game game, List<Playable> playersAtTable) {
		
		liveGame = game;
		this.playersAtTable = playersAtTable;
	}
	
	
	
}
