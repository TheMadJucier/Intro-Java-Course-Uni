

/*
 * Card.java
 *
 * A blueprint class for objects that represent a single playing card
 * that has a rank and a suit.
 * 
 * starter code: CS 112 Staff (cs112-staff@cs.bu.edu)
 * completed by: <your name and email>
 */

public class Card {
    /* constants for the ranks of non-numeric cards */
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    
    /* other constants for the ranks */
    public static final int FIRST_RANK = 1;
    public static final int LAST_RANK = 13;
    
    /* 
     * class-constant array containing the string representations
     * of all of the card ranks. 
     * The string for the numeric rank r is given by RANK_STRINGS[r].
     */
    public static final String[] RANK_STRINGS = {
      null, "A", "2", "3", "4", "5", "6",
      "7", "8", "9", "10", "J", "Q", "K"
    };

    //instance variables
    private int rank;
    private char suit;
    
    /* 
     * class-constant array containing the char representations
     * of all of the possible suits.
     */
    public static final char[] SUITS = {'C', 'D', 'H', 'S'};

    //Constructors

    public Card(int rank, char suit){
      if((isValidSuit(suit) && (rank >=1 && rank <=13 ))){
        this.rank = rank;
        this.suit = suit;
        
      } 
       else{
        throw new IllegalArgumentException();
      }
      
    }

    public Card(String card){
      //create two if statements for two strings and three strings
      //call rankNum for the rank
      //call isValidSuit
      //use this keyword to assign rank and suit
      // correct for valid parameters

      
      if(card == null){ //invalid parameter
        throw new IllegalArgumentException();
      } else{ // valid parameters

        if(card.length() == 2){ //XY
          String psuedoRank = card.substring(0, 1); /* gets second character, 
          can be hardcoded since this only for two*/ 
          char pseudoSuit = card.charAt(1);// "Y" in "XY"
          
          if(isValidSuit(pseudoSuit) && ((rank >= 1 || rank <= 9)|| psuedoRank == "Q" || psuedoRank == "K" || psuedoRank == "J"  )){
            this.suit = pseudoSuit;
            this.rank = rankNumFor(psuedoRank);
          } else{ // illegal suit
            throw new IllegalArgumentException(); 
          }

          
          
        } else { // "XYZ"
          String psuedoRank = card.substring(0, 2); /* gets "XY" of "XYZ", where Z is suit
          can be hardcoded since this only for two*/ 
          char pseudoSuit = card.charAt(2); //"Z" in "XYZ"

          
          if(isValidSuit(pseudoSuit) && (psuedoRank  == "13" 
          || psuedoRank.equals("10") 
          || psuedoRank.equals("11")
          || psuedoRank.equals("12"))){ //valid numbers
            
            this.suit = pseudoSuit; //initializes instance var
            this.rank = rankNumFor(psuedoRank); // converts to int
          } else{ // illegal suit
            
            throw new IllegalArgumentException(); 
          }
          
          // checking valid parameters
          
          
        }
      }
      
      
    }

    public int getRank(){
      return ( this.rank );

    }

    public char getSuit(){
      return ( this.suit );
    }

    public boolean isAce(){
      if(getRank() == ACE){
        return ( true );
      } else {
        return ( false );
      }
    }

    public boolean isFaceCard(){
      if(getRank() <= 10 && getRank() >=1 ){ //non-face card
        return ( false );
      } else{ // face card: 11,12,13--> J,Q,K
        return ( true );
      }

    }

    public int getValue(){
      if(this.isFaceCard()){ // checks if the current object has a face card
        return ( 10 );
      } else{ //checks if current object has normal card
        return getRank(); 
      }
    }

    public String toString(){
      return RANK_STRINGS[getRank()] + "" + getSuit();
    }

    public boolean sameSuitAs(Card other){ 
      if(other == null){ // invalid parameter
        return ( false );
      } else if(this.suit == other.suit){ // suits are equals
        return ( true );
      } else{ // suits not equals
        return ( false );
      }
    }

    public boolean equals(Card other){
      if(other == null){
        return ( false );
      } else if (this.getRank() == other.getRank() && this.getSuit() == other.suit){
        return ( true );
      } else {
        return ( false );
      }
      
    }
    
    /* Put the rest of the class definition below. */

    public static int rankNumFor(String rankNum){
      if(rankNum == null){ // valid parameters
        //System.out.println("reached null");
        return -1;
      } else{
        for(int i = 1; i < RANK_STRINGS.length; i++){ // going through RANK_STRINGS array, ignores first index
          //System.out.println("RANK_STRINGs["+i+"]: " + RANK_STRINGS[i] + ", rankNum: " + rankNum);
          if(RANK_STRINGS[i].equals(rankNum)){ // checking if the rank is in the string
            return i;
          } else continue;
        }
        
        return ( -1 ); // doesn't appear in array

      }
    }

    public static boolean isValidSuit(char suit){
        // similar structure to ranNumFor
        for(int i = 0; i < SUITS.length; i++){ // going through SUITS array
          //System.out.println("SUIT["+i + "]: " + ""+ suit);
          if(SUITS[i] == suit){ // checking if the suit is in SUITS
            return true;
          } else continue;
        }
        return false; // doesn't appear in Char array
    }



    public static void main(String[] args) {
      Card c1 = new Card("4H");
      System.out.println(c1.getValue());      
      Card c2 = new Card("QS");
      System.out.println(c2.getValue());
    }
}
