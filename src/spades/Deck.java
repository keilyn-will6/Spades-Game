package spades;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;

/**
 *
 * @author keilynmarcuswilliamson
 */
public class Deck {

    private Card[] deck;
    private ArrayList<Card> newDeck;
    private int currentCard;
    //private Hand hand;

    public Deck() throws IOException {
        String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};

        deck = new Card[52];
        newDeck = new ArrayList();
        currentCard = 0;

        BufferedImage tempCardImage;

        File dir = new File("/Users/keilynmarcuswilliamson/Spades-Game/src/cards");
        File[] file = dir.listFiles();

        for (int suit = 0; suit < 4; suit++) {
            for (int faceNum = 0; faceNum < 13; faceNum++) {

                if (file != null) {
                    tempCardImage = ImageIO.read(file[faceNum + (suit * 13)]);

                    deck[faceNum + (suit * 13)] = new Card(faces[faceNum],
                            suits[suit], // number on the card
                            faceNum + 2, // value of the card
                            tempCardImage); // image of the card

                    Card myCard = new Card(faces[faceNum],
                            suits[suit], // number on the card
                            faceNum + 2, // value of the card
                            tempCardImage);

                    newDeck.add(myCard);
                }

            }

        }

    }

    public void displayDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    public void newDis() {
        for (Card card : newDeck) {
            System.out.println(card);
        }
    }

    public void shuffle() {
        currentCard = 0;

        SecureRandom secureRandom = new SecureRandom();

        for (int firstPlace = 0; firstPlace < 52; firstPlace++) {

            int randomPlace = secureRandom.nextInt(52);
            Card tempPlace = deck[firstPlace];
            deck[firstPlace] = deck[randomPlace];
            deck[randomPlace] = tempPlace;

        }

    }

    public void newShuff() {
        Collections.shuffle(newDeck);
        /*
        SecureRandom secureRandom = new SecureRandom();

        for (int firstPlace = 0; firstPlace < 52; firstPlace++) {

            int randomPlace = secureRandom.nextInt(52);
            
            Card tempPlace = newDeck.get(firstPlace);
            newDeck.add(firstPlace, newDeck.get(randomPlace));
            newDeck.add(randomPlace, tempPlace);

        
       }
         */
    }

    public void deal(Hand hand2) {

        hand2.addcard(newDeck.remove(newDeck.size() - 1));

    }

}
