package spades;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * this class is where a a card is created
 * @author keilynmarcuswilliamson
 */

public class Card {
   private String faceName, suit;
   private int faceValue;
   private BufferedImage cardImage;
   
   /**
    * Creates an instance of a card
    * @param face string of value
    * @param suit suit if the card
    * @param value integer value associated with the card
    * @param image image of the card
    */
   public Card (String face, String suit, int value, BufferedImage image ){
    faceName = face;
    this.suit = suit;
    faceValue = value;
    cardImage = image;
   }
   
   /**
    * 
    * @return returns the value of the card(2-14)
    */
   public int getFaceValue(){
       
       return faceValue;
   }
/**
 * 
 * @return returns the faceName of the card
 */
    public String getFaceName() {
        return faceName;
    }
/**
 * 
 * @param faceName sets the faceName of the card
 */
    public void setFaceName(String faceName) {
        this.faceName = faceName;
    }

    /**
     * Gets the suit of a card.
     * @return returns the suit of a card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Sets the suit of a card
     * @param suit sets the suit of a card to a specific string
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    /**
     * 
     * @return returns the card image
     */
    public BufferedImage getCardImage() {
        return cardImage;
    }
    
    /**
     * 
     * @param cardImage sets the card image to a specific image file
     */

    public void setCardImage(BufferedImage cardImage) {
        this.cardImage = cardImage;
    }
    
    /**
     * 
     * @return the a card with it's associated faceName and suit
     */
    @Override
   public String toString(){
       
       return faceName + " of " + suit;
   } 
   
  
  
  
   
   
   
} // end class Card