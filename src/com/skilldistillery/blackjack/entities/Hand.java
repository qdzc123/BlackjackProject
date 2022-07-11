package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

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

	public void clear() {
		cards.clear();
	}
	
	public abstract int getHandValue();	

	@Override
	public String toString() {
		return "Hand cards = " + getCards() + "";
	}
	
	public String showOnehand() {
		return "one of hand card is " + getCards().get(0);
	}
	
	//public List<Card> getHand() {
	//	return cards;
	//}
}
