package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Deck;

public class Blackjack{
	
	Scanner sc = new Scanner(System.in);
	BlackjackHand dealer;
	BlackjackHand user;
	boolean gameStart;
	Deck deck; 
	
	Blackjack(){
		
		gameStart = true;
		dealer = new BlackjackHand();
		user = new BlackjackHand();

	}
	
	private int deckSize() {
		System.out.println("How many deck of cards would you like to add?? 1 to 10 is available!");
		int choice = sc.nextInt();
		boolean accept = true;
		while(accept) {
			try {
				if(choice >= 1 && choice <= 10) {
					System.out.println("It is added!");
				}
				accept = false;
			} catch (IllegalArgumentException e) {
				System.err.println("Invalid Number");
			}
		}
		return choice;
	}

	public static void main(String[] args) {
		Blackjack app = new Blackjack();
		app.launch();
	}

	private void launch() {
		// TODO Auto-generated method stub
		deck = new Deck(deckSize());
		deck.shuffle();
		
		while(gameStart) {
			//boolean userHitting = true;
			dealerHand();
			playerPlay();
			dealerPlay();
			showTheWinner();
			reGame();
		}
	}
	
	public void dealerHand() {
		user.addCard(deck.dealCard());
		user.addCard(deck.dealCard());
		
		System.out.println(user.toString());
		
		dealer.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		
		System.out.println(dealer.showOnehand());
	}

	
	public void playerPlay() {

		System.out.println("1. hit \n 2. Stand \n");
		//int choice = sc.nextInt();
		boolean decision = true;
		while(decision) {
			int choice = sc.nextInt();
			try {
				switch(choice) {
					case 1:
						user.addCard(deck.dealCard());
						System.out.println("The User card " + user.toString());
						if(user.isBlackjack() || user.isBust()) {
							decision = false;
						}
						break;
					case 2:
						System.out.println("Stop adding a card");
						decision = false;
						break;
					default:
						throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				System.err.println("Enter between 1 and 2");
			}
		}
	}
	
	public void dealerPlay() {
		if(dealer.getHandValue() >= 17) {
			System.out.println("No more hit");
		}
		while(dealer.getHandValue() < 17) {
			dealer.addCard(deck.dealCard());
			//System.out.println();
		}
	}
	
	public void showTheWinner() {
		//boolean userWin = false;
		//boolean dealerWin = false;
		if(user.isBlackjack()) {
			//userWin = user.isBlackjack();
			System.out.println("you got 21. win!!");
		}
			else if(user.getHandValue() > dealer.getHandValue() && user.getHandValue() < 21 && !user.isBlackjack()) {
				System.out.println("The User card " + user.toString() + " is higher than the dealer card " + dealer.toString());
				System.out.println("User WIN!!");
		}
			else if(dealer.getHandValue() > user.getHandValue() && dealer.getHandValue() <= 21) {
				System.out.println("The Dealer card " + dealer.toString() + " is higher than the user card " +  user.toString());
				System.out.println("Dealer WIN!!");
		}
			else if(user.isBust()) {
				System.out.println("You cannot win since you over 21..");
				System.out.println("The User card " + user.toString());
			}
			else if(dealer.isBust() && !user.isBust()){
				System.out.println("Dealer is Bust.. you just won!!");
				System.out.println("The dealer card is busted with " + dealer.toString());
			}
		
			else if(dealer.isBlackjack()) {
				System.out.println("GAME OVER. DEALER GOT BLACKJACK");
			}
			else if(dealer.getHandValue() == user.getHandValue()) {
				System.out.println("You TIE!");
			}
	}
	
	public void reGame() {
		System.out.println("would you wanna play the game again? choose 1 to keep playing or 2 to quit");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				gameStart = true;
				user.clear();
				dealer.clear();
				break;
			case 2:
				gameStart = false;
				System.out.println("GOOD BYE!");
				break;
		}
	}
}
