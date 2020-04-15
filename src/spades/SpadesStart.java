package spades;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
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
        
        //offset by -1
        
        Game game = new Game();
        game.play();
        
        /*
        ArrayList <Integer> seats = new ArrayList<>(); // indicates the team numbers
        seats.add(1);
        seats.add(2);
        seats.add(3);
        seats.add(4);
        
        
        ArrayList <Object> playerList = new ArrayList<>(); // all the players in the game
        
        Object[] players = new Object[4]; // all players in the game 
        
        int playerSeat = seatSelect(seats);
        int playerTeam = teamSelect(playerSeat);
        System.out.println(playerSeat);
        System.out.println(playerTeam);
        
        int computerOneSeat = seatSelect(seats);
        int computerOneTeam = teamSelect(computerOneSeat);
        System.out.println(computerOneSeat);
        System.out.println(computerOneTeam);
        
        int computerTwoSeat = seatSelect(seats);
        int computerTwoTeam = teamSelect(computerTwoSeat);
        System.out.println(computerTwoSeat);
        System.out.println(computerTwoTeam);
        
        int computerThreeSeat = seatSelect(seats);
        int computerThreeTeam = teamSelect(computerThreeSeat);
        System.out.println(computerThreeSeat);
        System.out.println(computerThreeTeam);
        
        
        
        Deck deckOfCards = new Deck();
        System.out.println("\n Deck ");
        
        deckOfCards.newDis();

        deckOfCards.newShuff();
        System.out.println("\n Shuffled Deck ");
        deckOfCards.newDis();
        //Card aceOfSpade = new Card("Ace","Spades ",14,ImageIO.read(new File ("/Users/keilynmarcuswilliamson/Spades-Game/src/cards/ace_of_spades.png")));
        Player player1 = new Player("Keilyn",0,2);
        //player1.addcard(aceOfSpade);
        
        deckOfCards.deal(player1);
        System.out.println("\n Player Hand ");
        player1.displayHand();
        //player1.removeCard(0);
        //player1.displayHand();
        
        
        //Computer comp1 = new Computer("bob",0,1,"hard");
        
        
        
       // player team and seat selection
      
       
       //place player in players or playerList according to their seat number
        
          
        
        int dealer = 0;
        int turn = 0;
        
        //System.out.println(deckOfCards.deal());
        
        //Card aceOfSpade = new Card("Ace","Spades ",14,ImageIO.read(new File ("/Users/keilynmarcuswilliamson/Spades-Game/src/cards/ace_of_spades.png")));
        //System.out.print(aceOfSpade);
*/

    }
    
    public static int teamSelect(int i){
        int j; // team assignment;
        if(i % 2 == 0){
            j = 2;
        }else{
            j = 1;
        }
        
        return j;
    }
    
    public static int seatSelect(ArrayList<Integer> list){
        
        SecureRandom secureRandom = new SecureRandom();
        int ran = secureRandom.nextInt(list.size());
        //list.remove(ran);

        return list.remove(ran);
        
      
        }
    
    //PlayGUI test = new PlayGUI();
    //test.setVisible(true);

}
//newGame.printWinners();