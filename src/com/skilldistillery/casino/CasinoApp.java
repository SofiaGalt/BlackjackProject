package com.skilldistillery.casino;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.BlackjackDealer;
import com.skilldistillery.blackjack.BlackjackGame;
import com.skilldistillery.blackjack.BlackjackPlayer;
import com.skilldistillery.gameabstractions.Game;
import com.skilldistillery.gameabstractions.Playable;

public class CasinoApp {
	
	Table userTable;

	public static void main(String[] args) {
		
		CasinoApp bellagio = new CasinoApp();
		
		bellagio.startTheFun();
		
	}
	
	private void startTheFun() {
		
		welcome();
		
		boolean keepRunning = true;

		while (keepRunning) {
			showMenu();
			keepRunning = executeMenuOption( UI.userInputPrompt() );
		}
	}
	
	private void welcome() {
		System.out.println("**************************************************************************\n");
		System.out.println("***********************  Welcome to the Bellagio!  ***********************\n");
		System.out.println("**************************************************************************\n");
		
		UI.pressAnyKeyToContinue();
	}
	
	
	private void showMenu() {
		System.out.println("_________________________________________________\n\n"
				+ "  What would you like to do? \n"
				+ "_________________________________________________\n\n" 
				+ "1 : Join a Blackjack table\n" 
				+ "2 : Leave.\n"
				+ "_________________________________________________\n");
	}
	
	/*
	 * @return boolean - returns false if the the String "9" is passed as a
	 * parameter. otherwise returns true. (executeMenuOption returns a boolean
	 * because it was designed to be used in tandem with the keepRunning boolean in
	 * run().)
	 */
	private boolean executeMenuOption(String choice) {

		switch (choice) {

		case "1":
			startBlackjackGame();
			return true;
		case "2":
			terminatingProgramMessage();
			return false;
		default:
			System.out.println("\nThat is not a recognized option.\n");
			UI.pressAnyKeyToContinue();
			return true;
		}
	}

	private void terminatingProgramMessage() {
		System.out.println("\n******************************************************************************\n");
		  System.out.println("***  Thank you for your visit!  We look forward to seeing you again soon!  ***\n");
		  System.out.println("******************************************************************************\n\n\n");
		
	}
	
	private void startBlackjackGame() {
		
		List<Playable> players = new ArrayList<>();
		players.add(signInPlayer());
		Game current = BlackjackGame.initializeBlackjackGame(new BlackjackDealer(), players);
		
		current.play();
	}
	
	private List<Playable> getTablePlayers(int maxPlayersPerTable){
		//right now - the casino only accepts one player per table.
		
		String playersForTable = "1"; // Later this can be prompt for
		
		int intPlayersForTable = Integer.parseInt(playersForTable);
		
		if(intPlayersForTable > maxPlayersPerTable) {
			System.out.println("We apologize - we can only accomodate for " + maxPlayersPerTable + " players at this table.");
			intPlayersForTable = maxPlayersPerTable;
		}
		
		List<Playable> players = new ArrayList<>();
		for( int i = 0 ; i < intPlayersForTable ; i++) {
			players.add(signInPlayer());
		}
		
		return players;
	}
	
	private Playable signInPlayer() {
		System.out.println("I need to sign you in. What is your name?");
		String username = UI.userInputPromptWithMessage("");
		
		Playable toReturn = new BlackjackPlayer(username);
		System.out.println(toReturn.getTitle() + ", you have been successfully registered.  Enjoy!\n");
		UI.pressAnyKeyToContinue();
		
		return toReturn;
	}
}
