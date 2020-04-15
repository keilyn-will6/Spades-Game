/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spades;

/**
 *
 * @author carlosespejo
 */
public class Player extends Hand{

    private String name;
    private int team;
    private int seatNum;
    private int booksWon;
    private Hand hand = new Hand();

    public Player(String name, int team, int seatNum) {
        this.name = name;
        this.team = team;
        this.seatNum = seatNum;
        
    }

    public Card play(int playCard) {

        return hand.removeCard2(playCard);

    }
    
    public void getName(){
        System.out.println(name);
    }
    
    

}
