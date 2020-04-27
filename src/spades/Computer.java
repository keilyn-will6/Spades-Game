/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spades;

import java.util.Random;

/**
 *
 * @author keilynmarcuswilliamson
 */
public class Computer extends Hand {

    private String name;
    //private int team;
    //private int seatNum;
    private int booksWon;
    //private String difficulty;
    private Hand hand = new Hand();

    public Computer(String name) {
        this.name = name;
        //this.team = team;
        //this.seatNum = seatNum;
        //this.difficulty = difficulty;
    }

    //add bid method
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
                    //check and see if you have any clubs
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
                        if ("Spades".equals(hand.getCard(j).getSuit())) {
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
        } // going second
        // look at suit established by first player
        // if they don't have suit throw out highest spade
        // if they have a card higher than player one's' card in suit throw it out
        // if not throw out lowest card in suit
        else if (turn == 2) {
            Card teammate = book.getCard(0);
            Card opponent = book.getCard(1);

            //throwing out card of suit established by player 1
            for (int i = 0; i < hand.numOfCards(); i++) {
                int itNum = i;
                // see if you have a card in the suit established by player 1/ teammate
                if (hand.getCard(i).getSuit().equals(book.getCard(0).getSuit())) {
                    //check if opponent's card beat teammate's card
                    // (if they put down the same suit but opponent's card is higher)
                    // or if opponent put down a spade
                    if (opponent.getSuit().equals(teammate.getSuit()) && opponent.getFaceValue() > teammate.getFaceValue()) {
                        // look and see if we have a card higher than opponent's card in the same suit
                        for (int j = i + 1; j < hand.numOfCards(); j++) {
                            Card temp = hand.getCard(j);
                            
                            if (temp.getFaceValue() > opponent.getFaceValue() && temp.getSuit().equals(teammate.getSuit())) {
                                itNum = j;
                                return itNum;
                            }

                        }
                    }// if opponent put down a spade, or teammate already beat opponents card
                    return itNum;
                }
            } // if you dont have a card in that suit check if player1's/ teammate's card
            // beat player2's/opponet's card
            if ((teammate.getSuit().equals(opponent.getSuit()) && teammate.getFaceValue() > opponent.getFaceValue())
                    || ("Spades".equals(teammate.getSuit()) && !"Spades".equals(opponent.getSuit())) || (!"Spades".equals(teammate.getSuit())
                    && !"Spades".equals(opponent.getSuit()) && !opponent.getSuit().equals(teammate.getSuit()))) {
                //  in first position
                // if teamates card beat opponents card play lowest card in deck t
                //hat is not spade unless thats all you have
                int itNum = lowestInHand(hand);
                return itNum;

            }
            
            // if teammate's card does not beat opponents card, check and see if you have a card that 
            //  will beat their card ( higher card in the same suit)
            // if opponent has a card in the same suit as teamate that is not
            // a spade but you have a spade throw it out
      
            for (int i = 0; i < hand.numOfCards(); i++) {
                if(teammate.getSuit().equals(opponent.getSuit())){
                    for (int j = i ; j < hand.numOfCards(); j++) {
                        if("Spades".equals(hand.getCard(j).getSuit())){
                            return j;
                        }
                    }
                }// at this point the only card that will beat teammates card is a spade
                else if (("Spades".equals(hand.getCard(i).getSuit()) && "Spades".equals(opponent.getSuit()))
                        && (hand.getCard(i).getFaceValue() > opponent.getFaceValue())) {
                    return i;

                }
            }
            
            // if you do not have a card that will beat opponets card throw out
            // smallest card of any suit except spades unless that is all you have
            int itNum = lowestInHand(hand);
                return itNum;

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
            //check to see if you have a card higher than player 2's card
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
            // check if they have suit
            // if no go to nonreniggin rules
            // if yes
            // check if (teammate) already won round
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
            // throw out lowest card of any suit except spade unless thats all we have left
            // highest cards of suit method unless thats all we have
            // this method will allow the computer to check if they have high cards in a
            //specific suit then put them into an array then choose which one to pick
            //this method is used for beating the opponets highest card of a specific suit
        }else if(turn == 3){
            Card opponent = book.getCard(0);
            Card teammate = book.getCard(1);
            Card opponent2 = book.getCard(2);

            //throwing out card of suit established by player 1
            for (int i = 0; i < hand.numOfCards(); i++) {
                int itNum = i;
                // see if you have a card in the suit established by player 1/ opponent
                if (hand.getCard(i).getSuit().equals(book.getCard(0).getSuit())) {
                    //check if opponent's (1 and 2) card beat teammate's card
                    // (if they put down the same suit but opponent's card is higher)
                    // or if opponent put down a spade
                    if ((opponent.getSuit().equals(teammate.getSuit()) && opponent.getFaceValue() > teammate.getFaceValue())
                            || (opponent2.getSuit().equals(teammate.getSuit()) && opponent2.getFaceValue() > teammate.getFaceValue())) {
                        // look and see if we have a card higher than opponent's card in the same suit
                        for (int j = i + 1; j < hand.numOfCards(); j++) {
                            Card temp = hand.getCard(j);
                            
                            if ((temp.getFaceValue() > opponent.getFaceValue() && temp.getSuit().equals(teammate.getSuit()))
                                    && (temp.getFaceValue() > opponent2.getFaceValue() && temp.getSuit().equals(teammate.getSuit()))) {
                                itNum = j;
                                return itNum;
                            }

                        }
                    }// if opponent put down a spade, or teammate already beat opponents card
                    return itNum;
                }
            }
            
            // if you dont have a card in that suit check if teammate's card
            // beat opponet2 and opponent1 cards
            if (((teammate.getSuit().equals(opponent.getSuit()) && teammate.getFaceValue() > opponent.getFaceValue())
                    || ("Spades".equals(teammate.getSuit()) && !"Spades".equals(opponent.getSuit())) || (!"Spades".equals(teammate.getSuit())
                    && !"Spades".equals(opponent.getSuit()) && !opponent.getSuit().equals(teammate.getSuit()))) 
                    && ((teammate.getSuit().equals(opponent2.getSuit()) && teammate.getFaceValue() > opponent2.getFaceValue())
                    || ("Spades".equals(teammate.getSuit()) && !"Spades".equals(opponent2.getSuit())) || (!"Spades".equals(teammate.getSuit())
                    && !"Spades".equals(opponent2.getSuit()) && !opponent2.getSuit().equals(teammate.getSuit())))) {
                //  in first position
                // if teamates card beat opponents card play lowest card in deck t
                //hat is not spade unless thats all you have
                int itNum = lowestInHand(hand);
                return itNum;

            }
            
            // if teammate's card does not beat both opponents cards, check and see if you have a card that 
            //  will beat their card ( higher card in the same suit)
            // if opponent has a card in the same suit as teamate that is not
            // a spade, but you have a spade throw it out
      
            for (int i = 0; i < hand.numOfCards(); i++) {
                if((teammate.getSuit().equals(opponent.getSuit())) && (teammate.getSuit().equals(opponent2.getSuit()))){
                    for (int j = i ; j < hand.numOfCards(); j++) {
                        if("Spades".equals(hand.getCard(j).getSuit())){
                            return j;
                        }
                    }
                }// at this point the only card that will beat teammates card is a spade
                else if ((("Spades".equals(hand.getCard(i).getSuit()) && "Spades".equals(opponent.getSuit()))
                        && (hand.getCard(i).getFaceValue() > opponent.getFaceValue())) ||
                        (("Spades".equals(hand.getCard(i).getSuit()) && "Spades".equals(opponent2.getSuit()))
                        && (hand.getCard(i).getFaceValue() > opponent2.getFaceValue()))) {
                    return i;

                }
            }
            
            // if you do not have a card that will beat opponets card throw out
            // smallest card of any suit except spades unless that is all you have
            int itNum = lowestInHand(hand);
                return itNum;
            
            
            
            
        }
        return 0;

    }

    @Override
    public String getName() {
        return name;
    }

    public int lowestInHand(Hand hand) {
        
        for (int i = 0; i < hand.numOfCards(); i++) {
            Card lowest = hand.getCard(i);
            int itNum = i;
            if ("Spades".equals(hand.getCard(i).getSuit())) {
                return itNum;
            } else {
                for (int j = i + 1; j < hand.numOfCards(); j++) {
                    Card temp = hand.getCard(j);
                    if ((temp.getFaceValue() < lowest.getFaceValue()) && (!"Spades".equals(temp.getSuit()))) {
                        lowest = temp;
                        itNum = j;
                    }
                }
                return itNum;

            }

        }

        return 0;
    }

}
