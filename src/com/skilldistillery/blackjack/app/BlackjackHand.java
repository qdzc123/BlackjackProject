package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Hand;

public class BlackjackHand extends Hand {

	public int getHandValue(){
		int totalValue = 0;
	
		for(int i = 0 ;i < cards.size() ; i++) {
			totalValue += cards.get(i).getValue();
		}
		return totalValue;
	}
	
	public void showHand() {
		for(int i = 0; i< cards.size(); i++) {
			cards.get(i);
		}
	}
	
	public boolean isBlackjack(){
		if(getHandValue() == 21) {
			return true;
		}
		return false;
	}
	
	public boolean isBust(){
		if(getHandValue() > 21) {
			return true;
		}
		return false;
	}
	
	public boolean isHard(){
		return false;
		
	}
	
	public boolean isSoft(){
		return false;
		
	}

	@Override
	public String toString() {
		return "card is " + cards;
	}
	
}
