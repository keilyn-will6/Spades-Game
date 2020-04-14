package spades;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author carlosespejo
 */
public class SpadesStart{

    public static void main(String[] args) throws IOException {

        //StartGUI startGame = new StartGUI();
        //startGame.setVisible(true); 
        Deck deckOfCards = new Deck();
        System.out.println("\n Deck ");
        
        deckOfCards.newDis();

        deckOfCards.newShuff();
        System.out.println("\n Shuffled Deck ");
        deckOfCards.newDis();
        //Card aceOfSpade = new Card("Ace","Spades ",14,ImageIO.read(new File ("/Users/keilynmarcuswilliamson/Spades-Game/src/cards/ace_of_spades.png")));
        Hand player1 = new Hand();
        //player1.addcard(aceOfSpade);
        
        deckOfCards.deal(player1);
        System.out.println("\n Player Hand ");
        player1.displayHand();
        
        //System.out.println(deckOfCards.deal());
        
        //Card aceOfSpade = new Card("Ace","Spades ",14,ImageIO.read(new File ("/Users/keilynmarcuswilliamson/Spades-Game/src/cards/ace_of_spades.png")));
        //System.out.print(aceOfSpade);

    }
    //PlayGUI test = new PlayGUI();
    //test.setVisible(true);

}
//newGame.printWinners();