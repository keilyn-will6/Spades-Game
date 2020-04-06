package spades;

import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author keilynmarcuswilliamson
 */
public class Hand {

    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList();
    }

    public void clear() {
        hand.clear();
    }

    public int numOfCards() {
        return hand.size();
    }

    public void addcard(Card card) {
        hand.add(card);
    }

    public void removeCard(int i) {
        hand.remove(i);
    }

    public Card getCard(int i) {
        return hand.get(i);
    }

    public void displayHand() {
        
        for (int i = 0; i < hand.size(); i++) { 
            if ("Diamonds".equals(hand.get(i).getSuit())) {
                Card card1 = hand.get(i);
                for (int j = i + 1; j < hand.size(); j++) {
                    if ("Diamonds".equals(hand.get(j).getSuit())) {

                        Card card2 = hand.get(j);
                        
                            if (card2.getFaceValue() < card1.getFaceValue()) {
                                //Card tempCar2 = card2;
                                //Card tempCar1 = card1;
                                hand.remove(card2);
                                hand.add(j, card1);
                                hand.remove(card1);
                                hand.add(i, card2);
                                card1 = card2;
                            }
                    }
                }
                System.out.println(card1);
            }
        }

        for (int i = 0; i < hand.size(); i++) {
            if ("Clubs".equals(hand.get(i).getSuit())) {
                Card card1 = hand.get(i);
                for (int j = i + 1; j < hand.size(); j++) {
                    if ("Clubs".equals(hand.get(j).getSuit())) {
                        Card card2 = hand.get(j);
                        if (card2.getFaceValue() < card1.getFaceValue()) {
                            card1 = card2;
                        }
                    }
                }
                System.out.println(card1);
            }
        }

        for (int i = 0; i < hand.size(); i++) {
            if ("Hearts".equals(hand.get(i).getSuit())) {
                Card card1 = hand.get(i);
                for (int j = i + 1; j < hand.size(); j++) {
                    if ("Hearts".equals(hand.get(j).getSuit())) {
                        Card card2 = hand.get(j);
                        if (card2.getFaceValue() < card1.getFaceValue()) {
                            card1 = card2;
                        }
                    }
                }
                System.out.println(card1);
            }
        }

        for (int i = 0; i < hand.size(); i++) {
            if ("Spades".equals(hand.get(i).getSuit())) {
                Card card1 = hand.get(i);
                for (int j = i + 1; j < hand.size(); j++) {
                    if ("Spades".equals(hand.get(j).getSuit())) {
                        Card card2 = hand.get(j);
                        if (card2.getFaceValue() < card1.getFaceValue()) {
                            card1 = card2;
                        }
                    }
                }
                System.out.println(card1);
            }
        }

    }

    

}