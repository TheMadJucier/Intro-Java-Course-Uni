/*
 * First test client for the Card problem.
 * 
 * Do not use until after you have completed parts 1-5.
 */

public class Client1 {
    public static void processCard(Card c) {
        int rank = c.getRank();
        System.out.println("    getRank: " + rank);
        char suit = c.getSuit();
        System.out.println("    getSuit: " + suit);
        boolean ace = c.isAce();
        System.out.println("      isAce: " + ace);
        boolean faceCard = c.isFaceCard();
        System.out.println(" isFaceCard: " + faceCard);
        int value = c.getValue();
        System.out.println("   getValue: " + value);
        System.out.println();
    }
    
    public static void main(String[] args) {  
        System.out.println("card c1 (Jack of Spades):");
        Card c1 = new Card(11, 'S');         // first constructor
        processCard(c1);
        
        System.out.println("card c2 (5 of Diamonds):");
        Card c2 = new Card(5, 'D');          // first constructor
        processCard(c2);
        
        System.out.println("card c3 (Queen of Hearts):");
        Card c3 = new Card("QH");         // second constructor
        processCard(c3);
        
        System.out.println("card c4 (10 of Clubs):");
        Card c4 = new Card("10C");       // second constructor
        processCard(c4);
        
        // Try to create invalid Cards. You may want to add additional tests
        // for invalid values.
        System.out.println("Trying to create a Card with a suit of 'B'...");
        try {
            Card c5 = new Card(7, 'B');
            System.out.println("failed to throw an IllegalArgument Exception.");
            processCard(c5);           
        } catch(IllegalArgumentException e) {
            System.out.println("correctly threw an IllegalArgumentException.");
        }
        System.out.println();
        
        System.out.println("Trying to create a Card using the string \"14D\"...");
        try {
            Card c6 = new Card("14D");
            System.out.println("failed to throw an IllegalArgumentException.");
            processCard(c6);           
        } catch(IllegalArgumentException e) {
            System.out.println("correctly threw an IllegalArgumentException.");
        }
        System.out.println();
    }
}
