## Micro Bellagio Casino

This is the forth weekend project for Skill Distillery.  We learned about Regular Expressions, Maps, Collection iteration, Enums, the JVM, and command line arguments among so many other things.  This Skill Distillery experience has been going by like lightning.  I've learned so much and we're just getting started.

________________________________________________________________________________
### Overview

This app is the entryway into Micro Bellagio where they always treat you well but you only really play one game.  
Luckily - that game is Blackjack!
________________________________________________________________________________
### Class Structure

The com.skilldistillery.casino package contains the main() - which is located inside of CasinoApp.java
It also contains a class that handles all console input - as well as a Table.java class which has unrealized potential. 

A package called com.skilldistillery.cards contains all things related to playing cards! Rank and Suit enums - Card and Deck Classes.

The next package, com.skilldistillery.gameabstractions contains the abstraction of each game - A Dealer, a Hand.  I included a Playable interface for any class that might want its instanciations to be able to play a game.  There is also a Game abstract class for other games to inherit from.

Finially, the package com.skilldistillery.blackjack contains the actual, concrete, Blackjack specific classes.  These classes all inherit from something else. A BlackjackPlayer extends Guest and implements Playable. A BlackjackDealer extends Dealer and implements Playable.

________________________________________________________________________________
### How to use

The app can be run through com.skilldistillery.casino.CasinoApp, which contains the main.  After running that file, prompts will carry you through.
________________________________________________________________________________
### Technologies

Abstraction, Scanner, Enums.
More OOP than I used in any prior project.
________________________________________________________________________________
### What I learned
The superclass's private fields rule is more obnoxious than I had thought.  This project involved planning!  I learned that I need to read directions more thoroughly.  I started coding blackjack features that I ultimately didn't need to. 
