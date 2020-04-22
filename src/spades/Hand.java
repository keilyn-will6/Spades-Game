package spades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
    private ArrayList<Card> hand2 = new ArrayList();
    private int seat;
    private int team;
    private String name;

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

    //incase you want to return that card
    public Card removeCard2(int i) {
        return hand.remove(i);
    }

    public Card getCard(int i) {
        return hand.get(i);
    }

    public void organize() {
        int count = 0;
        boolean org = true;
        int diamondCount = 0;

        for (int i = 0; i < 13; i++) {
            if ("Diamonds".equals(hand.get(i).getSuit())) {

                for (int j = count; j < 13; j++) {
                    if ("Diamonds".equals(hand.get(j).getSuit())) {
                        Card temp1 = hand.get(i);
                        Card temp2 = hand.get(j);

                        if (temp1 != temp2) {
                            hand.remove(temp1);
                            hand.remove(temp2);
                            hand.add(i, temp2);
                            hand.add(j, temp1);
                            count++;
                            diamondCount++;

                            break;
                        }

                    }
                    count++;

                }

                while (org) {
                    for (int j = 0; j < diamondCount; j++) {
                        int index = j;
                        Card smallest = hand.get(j);
                        for (int k = j + 1; k < diamondCount; k++) {
                            //Card smallest = hand.get(j);

                            Card temp1 = hand.get(k);
                            Card temp2;

                            if (smallest.getFaceValue() > temp1.getFaceValue()) {
                                smallest = temp1;
                                index = k;
                                //temp2 = temp1;
                            }
                        }

                        Card temp = hand.remove(index);
                        Card temp2 = hand.remove(j);

                        hand.remove(index);
                        hand.remove(j);
                        hand.add(index, temp2);
                        hand.add(j, temp);

                    }

                }

            }
        }
    }

    public void displayHand() {
        int k = 1;
        

        for (int i = 0; i < hand.size(); i++) {
            if ("Diamonds".equals(hand.get(i).getSuit())) {
                Card card1 = hand.get(i);
                for (int j = i + 1; j < hand.size(); j++) {
                    if ("Diamonds".equals(hand.get(j).getSuit())) {

                        Card card2 = hand.get(j);

                        if (card2.getFaceValue() < card1.getFaceValue()) {
                            
                            hand.remove(card2);
                            hand.add(j, card1);
                            hand.remove(card1);
                            hand.add(i, card2);
                            card1 = card2;

                        }
                    }

                }
                hand2.add(k-1, card1);
                System.out.println(k + " " + card1);
                k++;
                //Card tempCar1 = hand.remove(place);
                //Card tempCar2; 

                //place++;
            }
        }

        for (int i = 0; i < hand.size(); i++) {
            if ("Clubs".equals(hand.get(i).getSuit())) {
                Card card1 = hand.get(i);
                for (int j = i + 1; j < hand.size(); j++) {
                    if ("Clubs".equals(hand.get(j).getSuit())) {
                        Card card2 = hand.get(j);
                        if (card2.getFaceValue() < card1.getFaceValue()) {
                            hand.remove(card2);
                            hand.add(j, card1);
                            hand.remove(card1);
                            hand.add(i, card2);
                            card1 = card2;
                        }
                    }
                }
                hand2.add(k-1, card1);
                
                System.out.println(k + ". " + card1);
                k++;
            }
        }

        for (int i = 0; i < hand.size(); i++) {
            if ("Hearts".equals(hand.get(i).getSuit())) {
                Card card1 = hand.get(i);
                for (int j = i + 1; j < hand.size(); j++) {
                    if ("Hearts".equals(hand.get(j).getSuit())) {
                        Card card2 = hand.get(j);
                        if (card2.getFaceValue() < card1.getFaceValue()) {
                            hand.remove(card2);
                            hand.add(j, card1);
                            hand.remove(card1);
                            hand.add(i, card2);
                            card1 = card2;
                        }
                    }
                }
                hand2.add(k-1, card1);
                
                System.out.println(k + ". " + card1);
                k++;
            }
        }

        for (int i = 0; i < hand.size(); i++) {
            if ("Spades".equals(hand.get(i).getSuit())) {
                Card card1 = hand.get(i);
                for (int j = i + 1; j < hand.size(); j++) {
                    if ("Spades".equals(hand.get(j).getSuit())) {
                        Card card2 = hand.get(j);
                        if (card2.getFaceValue() < card1.getFaceValue()) {
                            hand.remove(card2);
                            hand.add(j, card1);
                            hand.remove(card1);
                            hand.add(i, card2);
                            card1 = card2;
                        }
                    }
                }
                hand2.add(k-1, card1);
                System.out.println(k + ". " + card1);
                k++;
            }
        }
        
        hand.clear();
        hand = hand2;
        /*
        for (int i = 0; i < hand2.size(); i++) {
            System.out.println(hand2.get(i));
        }
*/

        System.out.println("\n");

        
    } //end of displayHand()
    
    public void displayHand2(){
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i+1 + " " + hand.get(i));
        }
        
        System.out.println("");
    }

    public void setSeat(int i) {
        seat = i;
    }

    public int getSeat() {
        return seat;
    }

    public void setTeamAndSeat(int i, int j) {
        team = i;
        seat = j;
    }

    public int getTeam() {
        return team;
    }

    public String getName() {

        return name;
    }

    @Override
    public String toString() {
        return "{" + name + '}';
    }

}//end of class 
