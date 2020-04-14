package spades;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Card {
   private String faceName, suit;
   private int faceValue;
   private BufferedImage cardImage;
   
   public Card (String face, String suit, int value, BufferedImage image ){
    faceName = face;
    this.suit = suit;
    faceValue = value;
    cardImage = image;
   }
   
   
   public int getFaceValue(){
       
       return faceValue;
   }

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) {
        this.faceName = faceName;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public BufferedImage getCardImage() {
        return cardImage;
    }

    public void setCardImage(BufferedImage cardImage) {
        this.cardImage = cardImage;
    }
    
    @Override
   public String toString(){
       
       return faceName + " of " + suit;
   } 
   
  
  
  
   
   
   
} // end class Card