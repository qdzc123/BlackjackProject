package com.skilldistillery.blackjack.entities;

import java.util.List;

import com.skilldistillery.blackjack.app.BlackjackHand;

public class User {
	
		//private List<Card> hand;
		private BlackjackHand hand = new BlackjackHand();
		//private Deck deck;
		
		
		public User() {
			super();
			//deck = new Deck(deckSize);
		}

		public BlackjackHand getHand() {
			return hand;
		}

		public void setHand(BlackjackHand hand) {
			this.hand = hand;
		}

		
}
