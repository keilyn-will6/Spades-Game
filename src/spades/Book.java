/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spades;

/**
 *
 * @author keilynmarcuswilliamson
 */
public class Book {

    Card[] bookArray;

    public Book() {
        bookArray = new Card[4];

    }

    public Card getCard(int i) {

        return bookArray[i];
    }

    public String getSuit(int i) {
        Card card = bookArray[i];

        return card.getSuit();
    }

    public int getValue(int i) {
        Card card = bookArray[i];

        return card.getFaceValue();
    }

    public String getFaceName(int i) {
        Card card = bookArray[i];

        return card.getFaceName();
    }

    public void addCard(int i, Card card) {

        bookArray[i] = card;

    }

    public int length() {
        return bookArray.length;
    }

    // return 0 if there are not spades,
    // return the posisiton at which 
    // the spade is at if there are spades
    public int checkHighestSpade() {
        Card tempCard = bookArray[0];
        int iterationNum = -1;
        int returnValue = -1;

        for (int i = 0; i < bookArray.length; i++) {
            tempCard = bookArray[i];
            // try and find first spade in book
            if ("Spades".equals(tempCard.getSuit())) {
                iterationNum = i;
                returnValue = i;
                break;
            }
            if (i == 3) {
                return returnValue; // there are no spades
            }
        }

        for (int i = iterationNum + 1; i < bookArray.length; i++) {
            Card tempCard2 = bookArray[i];
            
            if ("Spades".equals(tempCard2.getSuit())) {
                if (tempCard2.getFaceValue() > tempCard.getFaceValue()) {
                    tempCard = tempCard2;
                    returnValue = i;
                }
            }

        }
        return returnValue; // return the location of the highest spade
        // the person with the corresponding turn number goes first. 
    }

    //checks highest card of suit that the first person threw down
    //determines who wins book, and who starts next
    public int checkHighestCard() {
        Card tempCard;
        tempCard = bookArray[0];
        int returnValue = 0;
        String string1 = tempCard.getSuit();

        for (int i = 1; i < bookArray.length; i++) {
            Card tempCard2;
            tempCard2 = bookArray[i];
            if (string1.equals(tempCard2.getSuit())) {
                if (tempCard2.getFaceValue() > tempCard.getFaceValue()) {
                    tempCard = tempCard2;
                    returnValue = i;
                }
            }

        }

        // indicates turn
        return returnValue;

    }

    @Override
    public String toString() {
        return "{" + bookArray + '}';
    }

}
