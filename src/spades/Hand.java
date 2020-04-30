package spades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


/**
 *Creates a hand either for a player or a computer
 * @author keilynmarcuswilliamson
 * 
 */
public class Hand {

    private ArrayList<Card> hand;
    private ArrayList<Card> hand2 = new ArrayList();
    private int seat;
    private int team;
    private String name;

    /**
     * constructor for creating a hand of cards
     */
    public Hand() {
        hand = new ArrayList();
    }

    /**
     * Clears the hand of all elements
     */
    public void clear() {
        hand.clear();
    }

    /**
     * 
     * @return the number of cards in the hand
     */
    public int numOfCards() {
        return hand.size();
    }

    /**
     * Adds a card to the hand
     * @param card card to add to the hand
     */
    public void addcard(Card card) {
        hand.add(card);
    }

    /**
     * removes a card form the hand
     * @param i the index position of the card to remove
     */
    public void removeCard(int i) {
        hand.remove(i);
    }

    /**
     * removes a card form the hand and returns the card
     * @param i the index position of the card to remove
     * @return the index position of the card to remove
     */
    //incase you want to return that card
    public Card removeCard2(int i) {
        return hand.remove(i);
    }

    /**
     * Gets a card in a hand
     * @param i index position of the card to get
     * @return return the index position of the card to get
     */
    public Card getCard(int i) {
        return hand.get(i);
    }
    

    
/**
 * displays hand in order of diamonds, clubs, hearts, and spades
 */
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
                hand2.add(k - 1, card1);
                //System.out.println(k + " " + card1);
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
                hand2.add(k - 1, card1);

                //System.out.println(k + ". " + card1);
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
                hand2.add(k - 1, card1);

                //System.out.println(k + ". " + card1);
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
                hand2.add(k - 1, card1);
                //System.out.println(k + ". " + card1);
                k++;
            }
        }

        hand.clear();
        
        for (int i = 0; i < hand2.size(); i++) {
            hand.add(i,hand2.get(i)); 
        }
        
        hand2.clear();
        
        /*
        for (int i = 0; i < hand2.size(); i++) {
            System.out.println(hand2.get(i));
        }
         */

        System.out.println("\n");

    } //end of displayHand()

    /**
     * Displays the elements (cards) in a hand 
     */
    public void displayHand2() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + 1 + ". " + hand.get(i));
        }

        System.out.println("");
    }

    /**
     * sets the seat if a player
     * @param i is the integer value to set the seat to
     */
    public void setSeat(int i) {
        seat = i;
    }

    /**
     * 
     * @return the seat 
     */
    public int getSeat() {
        return seat;
    }

    /**
     * sets the teams and seat 
     * @param i the team to set to
     * @param j the seat to set to
     */
    public void setTeamAndSeat(int i, int j) {
        team = i;
        seat = j;
    }

    /**
     * get the team
     * @return the team 
     */
    public int getTeam() {
        return team;
    }

    /**
     * 
     * @return the name of the player
     */
    public String getName() {

        return name;
    }

    /**
     * This methods allows the player (computer) to choose what card to play
     * @param hand are the cards associated with the computer object
     * @param turn the turn that they are putting down a card. This drastically
     * effects the choice of what card to put down.
     * @param book the cards already at play if turn != 0 (going first)
     * @return the index value that of the card that the computer has chosen to 
     * put down.
     */
    public int play(Hand hand, int turn, Book book) {

        //going first 
        //Pick a random suit and throw out highest card of that suit
        // or
        //check cards in order of Diamonds, clubs, Hearts, Spades to throw out highest card
        if (turn == 0) {

            for (int i = 0; i < hand.numOfCards(); i++) {
                //check and see if you have any diamonds
                //if so throw out highest
                if ("Diamonds".equals(hand.getCard(i).getSuit())) {
                    Card card = hand.getCard(i);
                    int itnum = i;
                    for (int j = +1; j < hand.numOfCards(); j++) {
                        if (("Diamonds".equals(hand.getCard(j).getSuit()))
                                && (hand.getCard(j).getFaceValue() > card.getFaceValue())) {
                            Card card2 = hand.getCard(j);
                            card = card2;
                            itnum = j;
                        }

                    }
                    return itnum;
                    // check and see if you have any clubs
                    //if so throw out highest 
                } else if ("Clubs".equals(hand.getCard(i).getSuit())) {
                    Card card = hand.getCard(i);
                    int itnum = i;
                    for (int j = +1; j < hand.numOfCards(); j++) {
                        if (("Clubs".equals(hand.getCard(j).getSuit()))
                                && (hand.getCard(j).getFaceValue() > card.getFaceValue())) {
                            Card card2 = hand.getCard(j);
                            card = card2;
                            itnum = j;
                        }

                    }

                    return itnum;
                    // check and see if you have any clubs
                    //if so throw out highest

                } else if ("Hearts".equals(hand.getCard(i).getSuit())) {
                    Card card = hand.getCard(i);
                    int itnum = i;
                    for (int j = +1; j < hand.numOfCards(); j++) {
                        if (("Hearts".equals(hand.getCard(j).getSuit()))
                                && (hand.getCard(j).getFaceValue() > card.getFaceValue())) {
                            Card card2 = hand.getCard(j);
                            card = card2;
                            itnum = j;
                        }

                    }

                    return itnum;
                    //check and see if you have any Spades
                    //if so throw out highest   
                } else if ("Spades".equals(hand.getCard(i).getSuit())) {
                    Card card = hand.getCard(i);
                    int itnum = i;
                    for (int j = +1; j < hand.numOfCards(); j++) {
                        if (("Spades".equals(hand.getCard(j).getSuit()))
                                && (hand.getCard(j).getFaceValue() > card.getFaceValue())) {
                            Card card2 = hand.getCard(j);
                            card = card2;
                            itnum = j;
                        }

                    }

                    return itnum;

                }
            }
        } else if (turn == 1) {
            Card car = book.getCard(0);
            String suit = car.getSuit();

            //throwing out card of suit established by player 1
            for (int i = 0; i < hand.numOfCards(); i++) {
                if (hand.getCard(i).getSuit().equals(book.getCard(0).getSuit())) {
                    Card card1 = hand.getCard(i);
                    int itNum = i;
                    for (int j = i + 1; j < hand.numOfCards(); j++) {
                        if ((hand.getCard(j).getSuit().equals(book.getCard(0).getSuit()))
                                && (hand.getCard(j).getFaceValue() > book.getCard(0).getFaceValue())) {

                            Card card2 = hand.getCard(j);
                            if (card2.getFaceValue() > card1.getFaceValue()) {
                                card1 = card2;
                                itNum = j;

                            }

                        }
                    }
                    return itNum;
                }

            }
            // else throw out highest spade

            for (int i = 0; i < hand.numOfCards(); i++) {
                if ("Spades".equals(hand.getCard(i).getSuit())) {
                    Card card1 = hand.getCard(i);
                    int itNum = i;
                    for (int j = i + 1; j < hand.numOfCards(); j++) {
                        if ("Spades".equals(book.getCard(j).getSuit())) {
                            Card card2 = hand.getCard(j);
                            if (card2.getFaceValue() > card1.getFaceValue()) {
                                card1 = card2;
                                itNum = j;
                            }

                        }

                    }
                    return itNum;
                }
            }
            // else throw out highest spade
        }

        // going second
        // look at suit established by first player  D
        // if they don't have suit throw out highest spade D
        // if they have a card higher than player one's' card in suit throw it out D
        // if not throw out lowest card in suit D
        // going third
        // look at suit established by first player
        // check to see if they have a card in that suit
        // if no
        // go to non renigging rules
        // if yes 
        // check if teammates card is already higher than player two's card
        // if yes
        // throw out lowest card of that suit
        // if no
        //check if to see if they have a card higher than player 2's card
        // if yes
        //play highert card
        // if no
        //play lowest card
        // non renigging rules (Player three)
        // Did player 1's (teammate) card beat player two's card already
        // if yes
        // play lowest card of any suit except spades
        // if no 
        // Check if we have spades
        // if no
        // throw out lowest card of any other suit
        // if yes
        // check to see if player 2 put down a spade
        //if no
        // throw out lowest spade
        // if yes
        // check if we have spades higher than than player 2's
        // if yes 
        // throw 1 out
        // if no
        // throw out lowest card of any suit except spade
        // going fourth 
        // look at suit established by first player
        // if they have suit
        // check if player 2 (teammate) already won round
        // if yes
        // play lowest card of suit
        // if no
        // check if we have a card that is higher than 1 and 3's card (oppenets)
        // if yes
        // play highest card (win range)
        // if no 
        // play lowest card
        // non renigging rules (Player four)
        // check if teammates card won round already (beat players 1 and 3)
        // if yes
        // play lowest card of any suit except 
        // if no
        //check if we have a spade
        // if no
        // play lowest card of any suit
        // if yes
        // check to see if player 3 put down a spade
        //if no
        // throw out lowest spade
        // if yes
        // check if we have spades higher than than player 3's
        // if yes 
        // throw 1 out
        // if no
        // throw out lowest card of any suit except spade
        //highest cards of suit method
        // this method will allow the computer to check if they have high cards in a
        //specific suit then put them into an array then choose which one to pick
        //this method is used for beating the opponets highest card of a specific suit
        return 0;
    }

    /**
     * 
     * @return returns the name of the player
     */
    @Override
    public String toString() {
        return "{" + name + '}';
    }

}//end of class 
