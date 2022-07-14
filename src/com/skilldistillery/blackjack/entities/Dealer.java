package com.skilldistillery.blackjack.entities;

import java.util.Collections;
import java.util.List;

import com.skilldistillery.blackjack.app.BlackjackHand;

public class Dealer {
	
	//private Hand hand;
	private BlackjackHand hand = new BlackjackHand();
	private Deck deck;
	
	public BlackjackHand getHand() {
		return hand;
	}
	
	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}
	
	
	 public Card dealCard() {
		  return deck.dealCard();
		  }
	
	
	public Dealer(int choice) {
		super();
		deck = new Deck(choice);
		deck.shuffle();
	}


}
