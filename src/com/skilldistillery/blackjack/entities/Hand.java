package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.app.BlackjackHand;

public abstract class Hand {
	protected List<Card> cards;
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public List<Card> getHand() {
		return cards;
	}

	public void clear() {
		cards.clear();
	}
	
	public abstract int getHandValue();	

	@Override
	public String toString() {
		return "Hand cards = " + getCards() + "";
	}
	
	public String showOnehand() {
		return "One of dealer's hand card is " + getCards().get(0);
	}

	//public abstract boolean isBlackjack();

	//public abstract boolean isBust();
	
	//public List<Card> getHand() {
	//	return cards;
	//}
}
