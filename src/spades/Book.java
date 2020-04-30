/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spades;

/**
 *Creates a book. Book is an array of four cards placed down by every player.
 * is allows the cards to be compared to see who has won.
 * @author keilynmarcuswilliamson
 */
public class Book {

    Card[] bookArray;
    
    /**
     * Constructor for a book. An array that holds 4 elements(cards)
     */

    public Book() {
        bookArray = new Card[4];

    }

    /**
     * Gets a card a a specific position
     * @param i index position where to get card
     * @return returns card at the specified return position
     */
    public Card getCard(int i) {

        return bookArray[i];
    }

    /**
     * Gets the suit of a card at a specific index position
     * @param i index position of card
     * @return card at specified index position
     */
    public String getSuit(int i) {
        Card card = bookArray[i];

        return card.getSuit();
    }

    /**
     * Gets the value of the card at a specific index position.
     * @param i i index position of card
     * @return card at specified index position
     */
    public int getValue(int i) {
        Card card = bookArray[i];

        return card.getFaceValue();
    }

    /**
     * Gets the Face name of a card at a specific index position.
     * @param  i i index position of card
     * @return card at specified index position
     */
    public String getFaceName(int i) {
        Card card = bookArray[i];

        return card.getFaceName();
    }

    /**
     * Adds a card to the book (array).
     * @param i index of where to add card in the book array
     * @param card card to add to the book
     */
    public void addCard(int i, Card card) {

        bookArray[i] = card;

    }

    /**
     * 
     * @return returns the amount of elements in book
     */
    public int length() {
        return bookArray.length;
    }

    // return 0 if there are not spades,
    // return the posisiton at which 
    // the spade is at if there are spades
    
    /**
     * Gets highest spade in book. return 0 if there are no spades
     * @return the index position of the highest spade in the book
     * 
     */
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
    
    /**
     * determines who wins book, and who starts next
     * @return the highest card in the book based on the rules of spades
     */
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

    /**
     * prints out the book array
     * @return 
     */
    @Override
    public String toString() {
        return "{" + bookArray + '}';
    }

}
