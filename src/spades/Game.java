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
 *Allows the game to be carried out
 * @author keilynmarcuswilliamson
 */
public class Game {

    static ArrayList<Integer> seats = new ArrayList<>(); // indicates the team numbers
    int dealer = 0;
    int turn = 0;
    static int round = 1;
    static int hand;
    static int team1;
    static int team2;
    final int scoreLimit = 150;

    //can use to put cards back in deck
    ArrayList<Object> playerList = new ArrayList<>(); // all the players in the game
    static Hand[] players = new Hand[4]; // all players in the game

    static Player player1;
    static Computer Bob;
    static Computer Susan;
    static Computer Leslie;

    /**
     * Constructor for the game class. instantiates a game
     */
    public Game() {

    }
    /**
     * This method is where the game is ran from
     * and where the user and the computers put down cards
     * @throws IOException  on input error 
     */

    public void play() throws IOException {
        //int dealer = 0;
        //int turn = 0;

        seats.add(1);//can change to begin with 0 instead of 1
        seats.add(2);
        seats.add(3);
        seats.add(4);

        menu();

        System.out.println("Let's begin! \n");

        System.out.println("Enter your name");
        Scanner nameScan = new Scanner(System.in);
        String usersName = nameScan.next();
        boolean b = true;

        while (b == true) {
            b = false;
            if (usersName.length() < 3) {
                System.out.println("\n This is an invalid entry, name must contain at least 3 letters");
                b = true;
                System.out.println("Enter your name");
                nameScan = new Scanner(System.in);
                usersName = nameScan.next();

            } else {
                for (int i = 0; i < usersName.length(); i++) {
                    if (!Character.isLetter(usersName.charAt(i))) {
                        System.out.println("\n This is an invalid entry, Name must contain only letters");
                        b = true;
                        System.out.println("Enter your name");
                        nameScan = new Scanner(System.in);
                        usersName = nameScan.next();
                        break;
                    }
                }

            }
        }
        
        System.out.println("");

        teamsAndSeats(usersName);

        while (team1 < scoreLimit && team2 < scoreLimit) {

            Deck deck = new Deck();
            deck.newShuff();

            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 4; j++) {
                    deck.deal(players[j]);

                }

            }
            System.out.println("Round " + round + "\n");
            showTeam();

            //testing
            for (Hand player : players) {
                player.displayHand();
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
            //dealer = 0;
            if (dealer == 3) {
                //else turn = dealer +1
                turn = 0;
            } else {
                turn = dealer + 1;
            }

            int times = 1;

            while (times < 14) {

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
                                System.out.println("It is you turn! \n");
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
                    } // call the play method for the computer
                    else {
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
                
                System.out.println("----------------------\n");

                //add points to the winning team score
                if (players[turn].getTeam() == 1) {
                    team1 += 10;

                } else {
                    team2 += 10;
                }

                //}
                times++;

                /*
                for (Hand player : players) {
                    System.out.println(player.getName());
                    player.displayHand2();
                }
                */

            }

            round++;
        }

        endGame();

    }
    
    /**
     * This method lets the user know that the game is over because one team
     * has reached the final score.
     * It lets the user know what team which team has one as well as
     * what the final score was.
     */

    public void endGame() {
        if (team1 > scoreLimit && team2 > scoreLimit && team1 > team2) {
            System.out.println("Team 1 wins");
            if (player1.getTeam() == 1) {
                System.out.println("\nYou win!!!!");
            } else {
                System.out.println("\nSorry, you lose");
            }
        } else if (team1 > scoreLimit && team2 > scoreLimit && team2 > team1) {
            System.out.println("Team 2 wins");
            if (player1.getTeam() == 2) {
                System.out.println("\nYou win!!!!");
            } else {
                System.out.println("\nSorry, you lose");
            }
        } else if (team1 >= scoreLimit) {
            System.out.println("Team 1 wins");
            if (player1.getTeam() == 1) {
                System.out.println("\nYou win!!!!");
            } else {
                System.out.println("\nSorry, you lose");
            }
        } else if (team2 >= scoreLimit) {
            System.out.println("Team 2 wins");
            if (player1.getTeam() == 2) {
                System.out.println("\nYou win!!!!");
            } else {
                System.out.println("\nSorry, you lose");
            }
        }

        System.out.println("Final Score Team 1 " + team1 + " Team 2 " + team2);
        System.out.println("-----------------------------------------------");
    }

    /**
     * This method is where the teams are chosen.
     * @param s This parameter is a String and is sent from the play() method, where the 
     * user enters their name.
     */
    public static void teamsAndSeats(String s) {
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

        player1 = new Player(s);
        player1.setTeamAndSeat(playerTeam, playerSeat);
        //for testing
        //System.out.println("\nYour team is " + playerTeam + " " + s + "'s seat " + playerSeat + "\n");

        Bob = new Computer("Bob");
        Bob.setTeamAndSeat(bobTeam, bobSeat);
        //for testing
        //System.out.println("bob's team " + bobTeam + " bob's seat " + bobSeat + "\n");

        Susan = new Computer("Susan");
        Susan.setTeamAndSeat(susanTeam, susanSeat);
        //for testing
        //System.out.println("Susan team " + susanTeam + " Susan seat " + susanSeat + "\n");

        Leslie = new Computer("Leslie");
        Leslie.setTeamAndSeat(leslieTeam, leslieSeat);
        //for testing
        //System.out.println("Leslie team " + leslieTeam + " Leslie seat " + leslieSeat + "\n");

        //Bob = new Computer("Bob", bobTeam, bobSeat);
        //Susan = new Computer("Susan", susanTeam, susanSeat);
        //Leslie = new Computer("Leslie", leslieTeam, leslieSeat);
        players[playerSeat - 1] = player1;
        players[bobSeat - 1] = Bob;
        players[susanSeat - 1] = Susan;
        players[leslieSeat - 1] = Leslie;

        System.out.println("Here are all the player \n");
        for (Hand player : players) {
            System.out.println(player.getName() + "\n");
        }

        if (leslieTeam == playerTeam) {
            System.out.println("\nYour teammate is Leslie \n ");

        } else if (susanTeam == playerTeam) {
            System.out.println("\nYour teammate is Susan \n");

        } else if (bobTeam == playerTeam) {
            System.out.println("\nYour teammate is Bob \n");

        }

        //for testing
        //System.out.println(players.toString());
        /*
        for (int i = 0; i < players.length; i++) {
            System.out.println(i + ". " + players[i].getName());
        }
         */
        System.out.println("");

    }

    /**
     * This method is used by the teamsAndSeats() method that helps puts the
     * player on teams by seeing whether the number that they are given 
     * (either 0,1,2,3) % 2 is equal to 0; 
     * @param i is the number given a specific player
     * @return returns the team the player is on (either 1   or 2)
     */
    public static int teamSelect(int i) {
        int j; // team assignment;
        if (i % 2 == 0) {
            j = 2;
        } else {
            j = 1;
        }

        return j;
    }
    
    /**
     * This method shows each team what players make up that team, and
     * what that team's score is.
     * is also allows the player to decide to continue to the next round, or 
     * quit.
     */

    public void showTeam() {
        System.out.println("Team 1 score " + team1);
        System.out.println("---------------");
        for (Hand player : players) {
            if (player.getTeam() == 1) {
                System.out.println(player.getName());
            }
        }

        System.out.println("\nTeam 2 score " + team2);
        System.out.println("---------------");
        for (Hand player : players) {
            if (player.getTeam() == 2) {
                System.out.println(player.getName());
            }
        }

        boolean x = true;
        while (x == true) {
            try {
                System.out.println("\n1.Continue");
                System.out.println("2.Quit");

                Scanner userInput = new Scanner(System.in);
                int input = userInput.nextInt();

                if (input == 1) {
                    x = false;
                } else if (input == 2) {
                    System.exit(0);
                } else if (input > 2 || input < 1) {
                    System.out.println("This is an invalid entry");
                }

            } catch (InputMismatchException ex) {
                System.out.println("this is an invalid, entry");
            }

            System.out.println("");

        }
        
    }

    
/**
 * This method is used by the teamsAndSeats() method to help select what "seat"
 * each player will sit in. this method picks a random number from the list
 * to assign to a specific player. This helps to then determine the team.
 * @param list List that contains the numbers (1,2,3, or 4)  
 * @return a random value from the list to assign to a player
 */
    public static int seatSelect(ArrayList<Integer> list) {

        SecureRandom secureRandom = new SecureRandom();
        int ran = secureRandom.nextInt(list.size());
        //list.remove(ran);

        return list.remove(ran);

    }
/**
 * This is the beginning menu that allows the player to choose to see the rules
 * of the game, play a game, or quit.
 */
    public void menu() {
        boolean a = true;
        while (a == true) {

            try {

                System.out.println("-----------------");
                System.out.println("Welcome to spades!");
                System.out.println("-----------------");
                System.out.println("1.Rules");
                System.out.println("2.Play");
                System.out.println("3.Quit \n");
                Scanner menuScan = new Scanner(System.in);
                int input = menuScan.nextInt();

                switch (input) {
                    case 1:
                        a = false;
                        rulesMenu();
                        break;
                    case 2:
                        a = false;
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("This is an invalid entry \n");

            }
        }

    }
    
    /**
     * This method is displays the rules menu, and allows the user to 
     * go back to the main menu after reading the rules.
     * 
     */

    public void rulesMenu() {
        boolean a = true;
        while (a == true) {

            try {
                System.out.println("Rules \n");
                System.out.println("The game is scored by hands, and the winner "
                        + "must reach 150 points first. The first player "
                        + "on the dealer's \nleft makes the opening lead, and players "
                        + "must follow suit, if possible. If a player cannot follow suit, "
                        + "they may \nplay a trump (spade) or discard (any other suit). "
                        + "The book is won by the player "
                        + "who plays the highest trump or if no trump \nwas played, the player "
                        + "who played the highest card in the suit led. The player who wins t"
                        + "he book leads next. \nPlay continues until none of the players "
                        + "have any cards left. Each hand is worth 13 books.\n ");
                
                System.out.println("1.Go back to menu \n");
                Scanner menuScan = new Scanner(System.in);
                int input = menuScan.nextInt();

                if (input == 1) {
                    a = false;
                    menu();
                }

            } catch (InputMismatchException ex) {
                System.out.println("This is an invalid entry \n");

            }
        }

    }

}
