package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.User;

public class Blackjack{
	
	Scanner sc = new Scanner(System.in);
	Dealer dealer;
	User user; //= new User();
	boolean gameStart;
	Deck deck; 
	
	Blackjack(){
		
		gameStart = true;
		//dealer = new Dealer();
		user = new User();

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
		//dealer = new Dealer(choice);
		return choice;
	}

	public static void main(String[] args) {
		Blackjack app = new Blackjack();
		app.launch();
	}

	private void launch() {
		// TODO Auto-generated method stub
		int sizeOfdeck = deckSize();
		dealer = new Dealer(sizeOfdeck);
		deck = new Deck(sizeOfdeck);
		//dealer.shuffle();
		
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
		
		user.getHand().addCard(dealer.dealCard());
		user.getHand().addCard(dealer.dealCard());
		
		System.out.println(user.getHand().toString());
		
		dealer.getHand().addCard(dealer.dealCard());
		dealer.getHand().addCard(dealer.dealCard());
		
		System.out.println(dealer.getHand().showOnehand());
	}

	
	public void playerPlay() {

		System.out.println("1. hit \n2. Stand \n");
		//int choice = sc.nextInt();
		boolean decision = true;
		while(decision) {
			int choice = sc.nextInt();
			try {
				switch(choice) {
					case 1:
						user.getHand().addCard(dealer.dealCard());
						System.out.println("The User card " + user.getHand().toString());
						if(user.getHand().isBlackjack() || user.getHand().isBust()) {
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
		if(dealer.getHand().getHandValue() >= 17) {
			System.out.println("No more hit");
		}
		while(dealer.getHand().getHandValue() < 17) {
			dealer.getHand().addCard(dealer.dealCard());
			//System.out.println();
		}
	}
	
	public void showTheWinner() {
		//boolean userWin = false;
		//boolean dealerWin = false;
		if(user.getHand().isBlackjack()) {
			//userWin = user.isBlackjack();
			System.out.println("you got 21. win!!");
		}
			else if(user.getHand().getHandValue() > dealer.getHand().getHandValue() && user.getHand().getHandValue() < 21 && !user.getHand().isBlackjack()) {
				System.out.println("The User card " + user.getHand().toString() + " is higher than the dealer card " + dealer.getHand().toString());
				System.out.println("User WIN!!");
		}
			else if(dealer.getHand().getHandValue() > user.getHand().getHandValue() && dealer.getHand().getHandValue() <= 21) {
				System.out.println("The Dealer card " + dealer.getHand().toString() + " is higher than the user card " +  user.getHand().toString());
				System.out.println("Dealer WIN!!");
		}
			else if(user.getHand().isBust()) {
				//System.out.println("The User card " + user.getHand().toString());
				System.out.println("You cannot win since you over 21..");
			}
			else if(dealer.getHand().isBust() && !user.getHand().isBust()){
				System.out.println("The dealer card is busted with " + dealer.getHand().toString());
				System.out.println("Dealer is Bust.. you just won!!");
			}
		
			else if(dealer.getHand().isBlackjack()) {
				System.out.println("GAME OVER. DEALER GOT BLACKJACK");
			}
			else if(dealer.getHand().getHandValue() == user.getHand().getHandValue()) {
				System.out.println("You TIE!");
			}
	}
	
	public void reGame() {
		System.out.println("would you wanna play the game again? choose 1 to keep playing or 2 to quit");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				gameStart = true;
				user.getHand().clear();
				dealer.getHand().clear();
				break;
			case 2:
				gameStart = false;
				System.out.println("GOOD BYE!");
				break;
		}
	}
}
