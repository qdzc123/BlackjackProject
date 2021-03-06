package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  private List<Card> cards;

  public Deck(int deckSize) {
	  cards = createDeck(deckSize);
  }
  
  

private List<Card> createDeck(int deckSize){
    List<Card> deck = new ArrayList<>();
    int count = 0;
    while(count < deckSize) {
	    for(Suit s : Suit.values()) {
	      for(Rank r : Rank.values()) {
	        deck.add(new Card(r, s));
	      }
	    }
	    count++;
    }
    //shuffle();
    return deck;
  }
  
  public int checkDeckSize() {
    return cards.size();
  }
  
  public void shuffle() {
    Collections.shuffle(cards);
  }
  
  public Card dealCard() {
    return cards.remove(0);
  }
  
  public void dealCard(Hand hand) {
		hand.addCard(dealCard()); // calls above method dealsCard
	}
}
