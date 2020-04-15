/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spades;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;


/**
 *
 * @author keilynmarcuswilliamson
 */
public class Game  {
   static ArrayList <Integer> seats = new ArrayList<>(); // indicates the team numbers
   int dealer = 0;
   int turn = 0;
   
   //can use to put cards back in deck 
   ArrayList <Object> playerList = new ArrayList<>(); // all the players in the game
   static Hand[] players = new Hand[4]; // all players in the game 
   
   static Player player1;
   static Computer Bob;
   static Computer Susan;
   static Computer Leslie;
   
    
    public Game(){
        
    }
    
    public void play()throws IOException {
        //int dealer = 0;
        //int turn = 0;
        
        Deck deck = new Deck();
        deck.newShuff();
        
        seats.add(1);//can change to begin with 0 instead of 1
        seats.add(2);
        seats.add(3);
        seats.add(4);
        
        teamsAndSeats();
        
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck.deal(players[j]);
                
            }
            
        }
        
        player1.displayHand();
        System.out.println("");
        Bob.displayHand();
        System.out.println("");
        Susan.displayHand();
        System.out.println("");
        Leslie.displayHand();
        System.out.println("");
        
        
        
        
        
        //ArrayList <Object> playerList = new ArrayList<>(); // all the players in the game
        
        //Object[] players = new Object[4]; // all players in the game 
        /*
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
        
        player1 = new Player("Keilyn",playerTeam,playerSeat);
        Bob = new Computer("Bob",0,1);
        Susan = new Computer("Susan",0,1);
        Leslie = new Computer("Leslie",0,1);
*/
        
        
        
    }
    
    public static void teamsAndSeats(){
        int playerSeat = seatSelect(seats);
        int playerTeam = teamSelect(playerSeat);
        System.out.println(playerSeat);
        System.out.println(playerTeam);
        
        int bobSeat = seatSelect(seats);
        int bobTeam = teamSelect(bobSeat);
        System.out.println(bobSeat);
        System.out.println(bobTeam);
        
        int susanSeat = seatSelect(seats);
        int susanTeam = teamSelect(susanSeat);
        System.out.println(susanSeat);
        System.out.println(susanTeam);
        
        int leslieSeat = seatSelect(seats);
        int leslieTeam = teamSelect(leslieSeat);
        System.out.println(leslieSeat);
        System.out.println(leslieTeam);
        
        player1 = new Player("Keilyn",playerTeam,playerSeat);
        Bob = new Computer("Bob",bobTeam,bobSeat);
        Susan = new Computer("Susan",susanTeam,susanSeat);
        Leslie = new Computer("Leslie",leslieTeam,leslieSeat);
        
        players[playerSeat-1] = player1;
        players[bobSeat-1] = Bob;
        players[susanSeat-1] = Susan;
        players[leslieSeat-1] = Leslie;
        
        
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
    
}
