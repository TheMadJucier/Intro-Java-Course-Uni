
import java.util.*;
public class Player {
    private String name;
    private Card [] hand;
    //private String n;
    private int numCards; // number of cards will never exceed Mac_CARDS_PER_PLAYEr

    //Constructor
    public Player(String name){ // name of the player
        this.name = name;
        this.hand = new Card[Blackjack.MAX_CARDS_PER_PLAYER];
        this.numCards = 0; // player just created, the number of cards they have is zero
    }

    //accessor methods
    public String getName(){ // returns player's name
        return ( name );
    }

    public int getNumCards(){ // returns current number of cards
        return ( numCards );
    }

    public Card getCard(int index){
        //check for valid arguments
        // returns card at index location
        

        if(hand[index] == null || index > Blackjack.MAX_CARDS_PER_PLAYER){ 
            // checks if index is a null value or if larger than allowed number of cards
            //System.out.println("Halo Reach");
            //System.out.println("index: " + index);
            //System.out.println(Arrays.toString(hand));
            throw new IllegalArgumentException();
         } else{
            //System.out.println("hand["+index+"]: " + hand[index]);
            return hand[index]; // returns value of hand at that index
        }
        //System.out.println("getCard: " + hand[index]);

        

    }



    //toString Override
    
    public String toString(){
        return ( "" + name + "" ); // returning (printing) player's name
    }

    //mutator methods

    public void addCard(Card object){
        //check for illegal arugments
        //adds card object's card to hand array


        if(Objects.isNull(object)|| this.numCards == Blackjack.MAX_CARDS_PER_PLAYER){
            //System.out.println("illegeal argument");
            throw new IllegalArgumentException();
        } else{
            for(int i = 0; i< hand.length; i++){ // scours array to find empty spot
                if(hand[i] == null){ // an empty array has null at the values
                    //System.out.println("reached");
                    hand[i] = object;
                    this.numCards++;
                    //System.out.println(Arrays.toString(hand));
                    break;
                } else{
                    
                    continue;
                }
            }
        }
    }

    public int getHandValue(){
        //intialize a variable to store handvalue
        //create a forloop to run through Hand
        //Use getValue to find value
        //create card object to access getValue
        //store and add it to variable

        int handValue = 0;
        //int numberOfAces = 0;
        for(int i = 0; i < this.hand.length; i++){
            
            if(hand[i] == null){ // will end at the null value
                break;
            }else{
                
                //Card value = new Card(hand[i]); //creating temporary object to fetch current value
                if(hand[i].getRank() == 1 && handValue <= 10){
                    handValue += 11;
                } else{
                    handValue += hand[i].getValue();
                    continue;
                }
                
            }
        }
         // if by some miracle the hand is full
        return handValue;
    }

    public void printHand(){
        //declare a string that will store the hand
        //run through hand and appened contents of hand
        //call getHandValue 
        //return string

        String printHand = "";

        //Model: 4H  7C  QD  (value = 21)

        for(int i = 0; i < this.hand.length; i++){ // running through hand
            //System.out.println("Printing Hand before: " + printHand);
            if(this.hand[i] == null){ // checking if end of hand
                printHand += "(value = " + getHandValue() + ")"; // apending hand value
                //System.out.println("1");
                //System.out.println("print hand: " + printHand + "(value = " + getHandValue() + ")");
                
                
                break;
            } else{
                //System.out.println("2");
                //System.out.println("getcard("+i+"): " + getCard(i));
                printHand += getCard(i) + "  "; // adding specific card plus 2 empty spaces
                
            }
           //System.out.println("Printing Hand Reached: " + printHand);

        }
        System.out.println(printHand);

        
       
    }



    public boolean hasBlackjack(){
        if(this.getNumCards() == 2 && this.getHandValue() == 21){
            return true;
        } else{
            return false;
        }
    }
    public boolean wantsHit(Scanner scanner, Player object2){
        //build scanner object
        //ask player if they want to hit
        //check what player wants
        // returns boolean value

        System.out.println("Do you want to hit (Y/N or y/n)");
        String hit = scanner.nextLine();

        if(hit.equalsIgnoreCase("y")){
            return ( true );
        } else{
            return ( false );
        }

    }

    public void discardCards(){
        //run through hand method and set all values to null if they aren't already
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == null){
                break;
            } else{
                hand[i] = null;
            }
        }
        this.numCards = 0;

    }






    
}
