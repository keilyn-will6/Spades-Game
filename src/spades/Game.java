/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spades;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 *
 * @author keilynmarcuswilliamson
 */
public class Game {

    static ArrayList<Integer> seats = new ArrayList<>(); // indicates the team numbers
    int dealer = 0;
    int turn = 0;
    static int round;
    static int hand;
    static int team1;
    static int team2;
    final int scoreLimit = 0;

    //can use to put cards back in deck 
    ArrayList<Object> playerList = new ArrayList<>(); // all the players in the game
    static Hand[] players = new Hand[4]; // all players in the game 

    static Player player1;
    static Computer Bob;
    static Computer Susan;
    static Computer Leslie;

    public Game() {

    }

    public void play() throws IOException {
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

        //testing
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName());
            players[i].displayHand();
        }

        //player1.displayHand();
        //System.out.println("");
        //Bob.displayHand();
        //System.out.println("");
        //Susan.displayHand();
        //System.out.println("");
        //Leslie.displayHand();
        //System.out.println("");
        // whoever is in seat 1 is dealer
        // create a for loop that goes through players array then goes back to 
        // beginning if the game is not over
        //indicates who puts down the first card every round
        //if round is equal to 1 
        //person next to dealer puts down a card
        //int currentPerson = 0;
        dealer = 0;
        //while ((team1 != scoreLimit || team1 < scoreLimit) || (team2 != scoreLimit || team2 < scoreLimit)) {

        if (dealer == 3) {
            //else turn = dealer +1
            turn = 0;
        } else {
            turn = dealer + 1;
        }

        while (true) {

            //for (int iter = 0; iter < players[0].numOfCards(); iter++) {
            Book book = new Book();
            //keeps track of where players won
            int[] won = new int[4];
            boolean a = true;
            for (int i = 0; i < book.length(); i++) {
                //currentPerson = 0; 
                //change 6 to something more specific
                if (players[turn] == player1) {

                    while (a == true) {

                        try {
                            

                            // ask player what card they would like to put down
                            // j is the number of the card the player wants to put down
                            Scanner scanner = new Scanner(System.in);
                            int input;
                            players[turn].displayHand2();
                            System.out.println("Choose a card to put down");

                            input = scanner.nextInt();
                            System.out.println("");
                            Card playCard = player1.getCard(input - 1);
                            a = false;

                            if (i != 0) {// if you are not the first person to put down a card
                                boolean hasSuit = true;
                                while (hasSuit == true) {
                                    for (int j = 0; j < player1.numOfCards(); j++) {
                                        if (player1.getCard(j).getSuit().equals(book.getCard(0).getSuit())) {
                                            hasSuit = true;
                                            if (!playCard.getSuit().equals(book.getCard(0).getSuit())) {
                                                System.out.println("You still have " + book.getCard(0).getSuit() + " in your hand, put it down" + "\n");
                                                player1.displayHand2();
                                                input = scanner.nextInt();
                                                playCard = player1.getCard(input - 1);
                                                break;
                                            } else {
                                                hasSuit = false;
                                            }
                                        }
                                        if (j == player1.numOfCards() - 1) {
                                            hasSuit = false;

                                        }
                                    }

                                }
                            }

                            System.out.println("You put down the " + player1.getCard(input - 1) + "\n");

                            book.addCard(i, player1.removeCard2(input - 1));
                            won[i] = player1.getSeat() - 1;
                            //won[i] = turn;

                        } catch (InputMismatchException | ArrayIndexOutOfBoundsException | NullPointerException ex) {
                            System.out.println("This is an invalid entry \n");
                            a = true;

                        }
                    }
                } 
                // call the play method for the computer
                else{
                        int down = players[turn].play(players[turn], i, book);

                        System.out.println(players[turn].getName() + " put down " + players[turn].getCard(down) + "\n");
                        book.addCard(i, players[turn].removeCard2(down));
                        won[i] = players[turn].getSeat() - 1;

                    } 

                if (turn == 3) {
                    turn = 0;
                    //break;
                } else {
                    turn++;
                }
            }

            //testing
            for (int i = 0; i < book.length(); i++) {
                System.out.println(i + ". " + book.getCard(i));
            }
            System.out.println("");

            if ("Spades".equals(book.getCard(0).getSuit())) {
                int var = book.checkHighestCard();
                int var2 = won[var];

                //for testing
                System.out.println(players[var2].getName() + " has won the book");

                turn = var2;

            } else {
                int var = book.checkHighestSpade();
                //no spades
                if (var == -1) {
                    int vary = book.checkHighestCard();
                    int var2 = won[vary];

                    //for testing
                    System.out.println(players[var2].getName() + " has won the book");

                    turn = var2;

                } else {
                    int var2 = won[var];

                    //for testing
                    System.out.println(players[var2].getName() + " has won the book");
                    turn = var2;

                }

            }

            //add points to the winning team score
            if (players[turn].getTeam() == 1) {
                team1 += 10;

            } else {
                team2 += 10;
            }

            //}
            round++;

            for (Hand player : players) {
                System.out.println(player.getName());
                player.displayHand2();
            }

        }// end of while loop

        // }
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

    public static void teamsAndSeats() {
        int playerSeat = seatSelect(seats);
        int playerTeam = teamSelect(playerSeat);
        //System.out.println(playerSeat);
        //System.out.println(playerTeam);

        int bobSeat = seatSelect(seats);
        int bobTeam = teamSelect(bobSeat);
        //System.out.println(bobSeat);
        //System.out.println(bobTeam);

        int susanSeat = seatSelect(seats);
        int susanTeam = teamSelect(susanSeat);
        //System.out.println(susanSeat);
        //System.out.println(susanTeam);

        int leslieSeat = seatSelect(seats);
        int leslieTeam = teamSelect(leslieSeat);
        //System.out.println(leslieSeat);
        //System.out.println(leslieTeam);

        player1 = new Player("Keilyn");
        player1.setTeamAndSeat(playerTeam, playerSeat);
        //for testing
        System.out.println("player 1 team " + playerTeam + " player 1 seat " + playerSeat + "\n");

        Bob = new Computer("Bob");
        Bob.setTeamAndSeat(bobTeam, bobSeat);
        //for testing
        System.out.println("bob's team " + bobTeam + " bob's seat " + bobSeat + "\n");

        Susan = new Computer("Susan");
        Susan.setTeamAndSeat(susanTeam, susanSeat);
        //for testing
        System.out.println("Susan team " + susanTeam + " Susan seat " + susanSeat + "\n");

        Leslie = new Computer("Leslie");
        Leslie.setTeamAndSeat(leslieTeam, leslieSeat);
        //for testing
        System.out.println("Leslie team " + leslieTeam + " Leslie seat " + leslieSeat + "\n");

        //Bob = new Computer("Bob", bobTeam, bobSeat);
        //Susan = new Computer("Susan", susanTeam, susanSeat);
        //Leslie = new Computer("Leslie", leslieTeam, leslieSeat);
        players[playerSeat - 1] = player1;
        players[bobSeat - 1] = Bob;
        players[susanSeat - 1] = Susan;
        players[leslieSeat - 1] = Leslie;

        //for testing
        //System.out.println(players.toString());
        for (int i = 0; i < players.length; i++) {
            System.out.println(i + ". " + players[i].getName());
        }

        System.out.println("");

    }

    public static int teamSelect(int i) {
        int j; // team assignment;
        if (i % 2 == 0) {
            j = 2;
        } else {
            j = 1;
        }

        return j;
    }

    public static int seatSelect(ArrayList<Integer> list) {

        SecureRandom secureRandom = new SecureRandom();
        int ran = secureRandom.nextInt(list.size());
        //list.remove(ran);

        return list.remove(ran);

    }

}
