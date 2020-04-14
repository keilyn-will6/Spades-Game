/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spades;

/**
 *
 * @author keilynmarcuswilliamson
 */
public class Computer extends Hand {
    private String name;
    private int team;
    private int dealNum;
    private int booksWon;
    private String difficulty;
    private Hand hand = new Hand();
    
    public Computer (String name, int team, int dealNum, String difficulty){
        this.name = name;
        this.team = team;
        this.dealNum = dealNum;
        this.difficulty = difficulty;
    }
    
    public void play(){
        
    }
    
    
    
}
