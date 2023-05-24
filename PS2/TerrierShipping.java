/*
 * TerrierShipping.java
 * CS 112, Boston University
 *
 * Completed by: your name and email
 * 
 * Calculates the total shipping charge for a collection of items.
 */

import java.util.*;



public class TerrierShipping {  
      
    /*
     * getShippingType - gets the type of shipping as an integer
     */
    public static int getShippingType(Scanner console){
        System.out.println("Available shipping types:");
        System.out.println("  1) one-day");
        System.out.println("  2) two-day");
        System.out.println("  3) standard");
        System.out.println();
        
        System.out.print("What type of shipping? (enter the number) ");
        int type = console.nextInt();
        return type;
    }

    /*
     * getItemType - gets the type of item as a single-character string
     */
    public static String getItemType(Scanner console){
        System.out.println();
        System.out.println("Item type:");
        System.out.println("  B) book");
        System.out.println("  C) clothing");
        System.out.println("  E) electronics");
        System.out.println("  T) toy");
        System.out.println();
        
        System.out.print("What type of item? (enter the letter or Q to quit) ");
        String itemType = console.next();
        return itemType;
    }


    public static int toyShipping(int shippingType,  int lb){
        //int type = getShippingType(null);
        int cost = 0;
        if(shippingType == 1){
             cost += 499 + 199*lb;
             System.out.println(cost);
             return cost;
        } else if (shippingType == 2){
             cost += 299 + 99*lb;
             return cost;
        } else{
            cost += 199 + 80*lb;
            return cost;
        }

    }

    public static int electronicsShipping(int shippingType,  int lb){
        int cost = 0;
        int type = shippingType;
        if(type == 1){
             cost += 599 + 199*lb;
             return cost;
        } else if (type == 2){
             cost += 399 + 89*lb;
             return cost;
        } else{
            cost += 199 + 80*lb;
            return cost;
        }

    }

    public static int booksAndClothingShipping(int shippingType,  int lb){
        int cost = 0;
        int type = shippingType;
        if(type == 1){ // one day
            if(lb >= 2){
                cost = cost + 399 + 60*lb;
                return cost;
            }else{
                cost = cost + 499;
                return cost;
            }
        } else if (type == 2){ // two-day
            if(lb >= 2){
                cost = cost + 199 + 75*lb;
                return cost;
            }else{
                cost = cost + 499;
                return cost;
            }

        } else{ // standard
            if(lb >= 2){
                cost = cost + 99 + 70*lb;
                return cost;
            }else{
                cost = cost + 499;
                return cost;
            }
            
        }

    }
    
    /* 
     * PUT YOUR ADDITIONAL HELPER METHODS HERE.
     * Remember that you must have at least three additional methods that:
     *   - take one or more parameters
     *   - return a value 
     */
    
    
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);    // for user input
        
        System.out.println("Welcome to Terrier Shipping!");
        System.out.println();
        int shipType = getShippingType(console);
        
        int totalCents = 0;
        boolean hasMoreItems = true;
        
        /*
         * Process one item at a time until the user enters Q. 
         * We use a do-while loop, because we always need 
         * at least one repetition of the loop.
         */
        do {
            String itemType = getItemType(console); 
            System.out.println(itemType);
            //System.out.println(itemType.equalsIgnoreCase("T"));      
            if (itemType.equals("Q")) {
                hasMoreItems = false;
            } else {            
                /*
                 * TO DO: update the right-hand side of the assignment 
                 * statement below to get an integer from the user. 
                 * You MUST use the Scanner object created above 
                 * at the start of main. You may NOT construct an 
                 * additional Scanner object.
                 */
                System.out.print("Weight of item (rounded to nearest pound)? ");
                int weight = console.nextInt();
        
                int itemCharge = 0;
                
                
                if(itemType.equalsIgnoreCase("T")){
                    itemCharge += toyShipping(shipType, weight);
                    System.out.println("Inside: "+itemCharge);
                } else if(itemType.equalsIgnoreCase("B") || itemType.equalsIgnoreCase
                        ("C")){
                    itemCharge += booksAndClothingShipping(shipType, weight);
                } else if(itemType.equalsIgnoreCase("E")){
                    itemCharge += electronicsShipping(shipType, weight);
                } 
            
                /*
                 * TO DO: Add code here that uses conditional execution to 
                 * call one of your static methods to determine the charge
                 * for the current item and assign it to itemCharge.
                 */


                


              
                totalCents += itemCharge;
            }
        } while (hasMoreItems);
            
        System.out.println();
        
        /*
         * TO DO: add the appropriate expression to the right-hand side 
         * of this assignment statement to convert totalCents to dollars.
         */
        double totalDollars = (double) (totalCents)/100;     
        
        // We use printf to ensure that the final result always has
        // two digits after the decimal. 
        System.out.printf("The total charge is: $%.2f\n", totalDollars);   

        console.close();
    }
}