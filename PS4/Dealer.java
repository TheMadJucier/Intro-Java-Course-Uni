//import java.util.Scanner;
import java.util.*;

/**
 * Dealer
 */
public class Dealer extends Player {
    private boolean revealDealerCard;

    public Dealer(){
        super("dealer");
        this.revealDealerCard = false;
    }

    //mutator
    public void revealFirstCard(){
        this.revealDealerCard = true;
    }

    

    @Override
    public void printHand(){
        //check value of revealDealerCard
        //print appropritate String
        String printHand = "";
        if(this.revealDealerCard == false){ // reveals first card "XX .... ""
            //System.out.println("false");
            for(int i = 0; i < this.getNumCards(); i++){ // running through hand
                //System.out.println("Number of cards: " + this.getNumCards());
                //System.out.println("i: " +i);
                if(i == 0){ // hidding first card
                    printHand += "XX" + "  ";
                    continue;
                } else{
                    printHand += getCard(i) + "  "; // adding specific card plus 2 empty spaces
                    continue;
                    
                }
            

            }
            System.out.println(printHand);
            
            
            //Model: XX  7C  QD  (value = 21)
        } else{ // revealFirstCard is True
            //System.out.println("True"); 
            super.printHand();       
            
        
        }
    }

    @Override
    public boolean wantsHit(Scanner scanner, Player object2){
        /*
         * If the user’s hand has a value that is less than 17, 
         * the dealer should take hits until the value of her hand 
         * exceeds the value of the user’s hand.If the user’s hand has a value of 17 
         * or more, the dealer should take hits until the value of her hand matches or 
         * exceeds the value of the user’s hand, unless the user has Blackjack 
         * (in which case the dealer should hold, regardless of the value of her own hand).
         */

         //Check value of dealer's hand compared to user's
         
         
         if(object2.getHandValue() < 17){
            do {
                return true;
            } while (this.getHandValue() <= object2.getHandValue()); // will exceed user
         } else if(object2.getHandValue() >= 17){
            do {
                return true;
            } while (this.getHandValue() < object2.getHandValue()); // will exceed user
         } else{
            return false;
         }
    }

    @Override
    public void discardCards(){
        //run through hand method and set all values to null if they aren't already
    
       super.discardCards();
       this.revealDealerCard = false;

    }


    
}