package com.skilldistillery.blackjack;

import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.casino.UI;
import com.skilldistillery.gameabstractions.Dealer;
import com.skilldistillery.gameabstractions.Game;
import com.skilldistillery.gameabstractions.Playable;
import com.skilldistillery.gameabstractions.Playable;

public class BlackjackGame extends Game {
	
	BlackjackDealer gameDealer;

	private BlackjackGame(Dealer dealer, List<Playable> players) {
		super(dealer, players);
		gameDealer = (BlackjackDealer) dealer;
	}

	public static Game initializeBlackjackGame(Dealer dealer, List<Playable> players) {

		if (!(dealer instanceof BlackjackDealer))
			return null;

		for (Playable player : players) {
			if (!(player instanceof BlackjackPlayer))
				return null;
		}

		return new BlackjackGame(dealer, players);
	}

	@Override
	public void play() {
		System.out.println("*******Blackjack!!!");
		BlackjackDealer gameDealer = (BlackjackDealer) dealer;

		// first - the dealer and each player get one face up card.
		Card dealtCard;

		dealtCard = gameDealer.dealCard();
		players.get(0).takeCard(dealtCard);
		dealtCard = gameDealer.dealCard();
		players.get(0).takeCard(dealtCard);

		dealtCard = gameDealer.dealCard();
		gameDealer.takeCard(dealtCard);
		dealtCard = gameDealer.dealCard();
		gameDealer.takeCard(dealtCard);

		viewTable();
		
		// The players are iterated backwards because 
		// 	players are removed from the game's List<Player>
		// 		if they either reach 21 or bust.
		for(int i = players.size() -1 ; i >= 0 ; i--) {
			
			// if players drew a blackjack
			if(players.get(i).getHandValue() == 21 ) { 
				if(gameDealer.getHandValue() != 21) {
					Blackjack(players.get(i));
					return; // return because right now there will only be one player.
				}
				System.out.println("\n" + players.get(i) + " and the dealer both drew *** blackjack *** !  It's a tie");
				System.out.println("\nThanks for playing!\n");
				return; // return because right now there will only be one player.
			}
			// if players bust
			if(players.get(i).getHandValue() > 21 ) {
				if(gameDealer.getHandValue() > 21) {
					System.out.println("\n" + players.get(i) + " and the dealer both bust.  It's a tie");
					return; // return because right now there will only be one player.
				}
				System.out.println("\n" + players.get(i) + " busts!  Dealer wins.");
				System.out.println("\nThanks for playing!\n");
				return; // return because right now there will only be one player.
			}
			
			playerTurn(players.get(i));
		}
		
		// if all of the players busted.
		if(players.size() == 0) {
			System.out.println("________________________\n");
			System.out.println("Dealer wins.");
			System.out.println("________________________\n");
			UI.pressAnyKeyToContinue();
			System.out.println("Thanks for playing!");
			
			return;
		}
		
		// dealer has to hit for hand < 17
		System.out.println("Dealer's turn - their cards total " + gameDealer.getHandValue());
		
		if(gameDealer.getHandValue() < 17 ) {
			hit_returnCanHitAgain(gameDealer);
		}
		else {
			System.out.println("\tDealer will stand.");
		}
		
		if(gameDealer.getHandValue() > 21) {
			playerWins(players.get(0));
			return;
		}
		
		// right now, there is only one player - player 0.
		if(players.get(0).getHandValue() > gameDealer.getHandValue()) {
			playerWins(players.get(0));
			return;
		}
		if(players.get(0).getHandValue() == gameDealer.getHandValue()) {
			System.out.println("\n********************************************************************");
			System.out.println("\n" + players.get(0).getTitle() + " ties with dealer!\n");
			System.out.println("********************************************************************\n");
			UI.pressAnyKeyToContinue();
			System.out.println("Thanks for playing!");
		}
		else {
			System.out.println("________________________\n");
			System.out.println("Dealer wins.");
			System.out.println("________________________\n");
			UI.pressAnyKeyToContinue();
			System.out.println("Thanks for playing!");
		}
		
	}

	private void viewTable() {

		gameDealer.displayCards();
		players.get(0).displayCards();
	}

	private void playerTurn(Playable p) {

		boolean keepRunning = true;

		while (keepRunning) {
			playerOptionsMenu(p);
			keepRunning = executePlayerOption(UI.userInputPrompt(), p);
		}
	}

	private void playerOptionsMenu(Playable p) {
		System.out.println(
				"_________________________________________________\n\n" +p.getTitle()+",\nYour hand's total is " + p.getHandValue()
						+ ".  What would you like to do? \n" + "_________________________________________________\n\n"
						+ "1 : Hit\n" + "2 : Stand\n" + "_________________________________________________\n");
	}

	private boolean executePlayerOption(String userInput, Playable p) {

		switch (userInput) {

		case "1":
			return hit_returnCanHitAgain(p);
		case "2":
			stand(p);
			return false;
		default:
			System.out.println("\nThat is not a recognized option.\n");
			UI.pressAnyKeyToContinue();
			return true;
		}
	}
	
	/*
	 * @return boolean true if the player's hand is under 21.
	 * 					false if the player hit 21 or busted.
	 * 					
	 */
	private boolean hit_returnCanHitAgain(Playable p) {
		
		System.out.println("\n* * * * * *  Hit!  * * * * * *\n");
		
		Card newCard = dealer.dealCard();
		p.takeCard(newCard);
		
		if(p.getHandValue() < 21) {
			System.out.println("New Card: " + newCard);
			UI.pressAnyKeyToContinue();
			return true;
		}
		if(p.getHandValue() > 21) {
			//bust!
			System.out.println("\n\t. . . and BUST!\n");
			System.out.println(newCard + 
					" was drawn. New hand value: " + p.getHandValue() );
			if(!(p instanceof Dealer)) System.out.println("You're out!");
			players.remove(p);
			UI.pressAnyKeyToContinue();
			return false;
		}
		// 21!
		System.out.println("\n\t  *   *   *   *   *   *   *   *  ");
		System.out.println("\n\t*   *   *   *  21!  *   *   *   *");
		System.out.println("\n\t  *   *   *   *   *   *   *   * ");
		System.out.println("You drew " + newCard + " which brings your hand's value to " + p.getHandValue() + "!");
		
		UI.pressAnyKeyToContinue();
		return false;
	}

	private void stand(Playable p) {
		System.out.println("\n" + p.getTitle() + " is standing.\n");
		UI.pressAnyKeyToContinue();
	}
	
	private void Blackjack(Playable p) {
		System.out.println("\n\t* * * * * * * * * * * * * * * *\n");
		System.out.println("\n\t* * * * *  Blackjack! * * * * *\n");
		System.out.println("\n\t* * * * * * * * * * * * * * * *\n");
		System.out.println(p.getTitle()+ " wins!");
		UI.pressAnyKeyToContinue();
	}
	
	private void playerWins(Playable p) {
		System.out.println("\n********************************************************************");
		System.out.println("\n" + p.getTitle() + " wins!  Congratulations!\n");
		System.out.println("********************************************************************\n");
		UI.pressAnyKeyToContinue();
		System.out.println("Thanks for playing!");
	}
}
