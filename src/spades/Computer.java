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
    private int seatNum;
    private int booksWon;
    //private String difficulty;
    private Hand hand = new Hand();
    
    
    
    public Computer (String name, int team, int seatNum){
        this.name = name;
        this.team = team;
        this.seatNum = seatNum;
        //this.difficulty = difficulty;
    }
    
    //add bid method
    
    public void play(int turn){
        
        
        //going first 
        //Pick a random suit and throw out highest card of that suit
        // or
        //check cards in order of Diamonds, clubs, Hearts, Spades to throw out highest card
        
        // going second
        // look at suit established by first player
        // if they don't have suit throw out highest spade
        // if they have a card higher than player one's' card in suit throw it out
        // if not throw out lowest card in suit
        
        // going third
        // look at suit established by first player
        // check to see if they have a card in that suit
        // if no
            // go to non renigging rules
        // if yes 
        // check if teammates card is already higher than player two's card
        // if yes
            // throw out lowest card of that suit
        // if no
            //check if to see if they have a card higher than player 2's card
            // if yes
                //play highert card
            // if no
                //play lowest card
                

        
        // non renigging rules (Player three)
        // Did player 1's (teammate) card beat player two's card already
        // if yes
            // play lowest card of any suit except spades
        // if no 
            // Check if we have spades
            // if no
                // throw out lowest card of any other suit
            // if yes
                // check to see if player 2 put down a spade
                //if no
                    // throw out lowest spade
                // if yes
                // check if we have spades higher than than player 2's
                    // if yes 
                        // throw 1 out
                    // if no
                        // throw out lowest card of any suit except spade
                
        
        
        // (Player four)
        // look at suit established by first player
        // if they have suit
            // check if player 2 (teammate) already won round
            // if yes
                // play lowest card of suit
            // if no
                // check if we have a card that is higher than 1 and 3's card (oppenets)
                    // if yes
                        // play highest card (win range)
                    // if no 
                        // play lowest card
        
                        
                        
        // non renigging rules (Player four)
        // check if teammates card won round already (beat players 1 and 3)
        // if yes
            // play lowest card of any suit except 
        // if no
            //check if we have a spade
            // if no
                // play lowest card of any suit
            // if yes
            // check to see if player 3 put down a spade
                //if no
                    // throw out lowest spade
                // if yes
                // check if we have spades higher than than player 3's
                    // if yes 
                        // throw 1 out
                    // if no
                        // throw out lowest card of any suit except spade
            
        
                        
        //highest cards of suit method
        // this method will allow the computer to check if they have high cards in a
        //specific suit then put them into an array then choose which one to pick
        //this method is used for beating the opponets highest card of a specific suit
    }
    
    public void getName(){
        System.out.println(name);
    }
    
    
    
}

