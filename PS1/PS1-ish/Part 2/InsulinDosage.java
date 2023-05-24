/*
 * InsulinDosage.java
 * 
 * This program computes the dosage of insulin that a person should
 * take before a meal, based on the person's current blood sugar, 
 * their target blood sugar, the amount of exercise they have performed
 * recently, and two characteristics of the meal they are about to consume.
 * 
 * CS 112 Course Staff (cs112-staff@cs.bu.edu)
 * 
 * completed by: Wadner Simon, casseus@bu.edu
 * partner (if any): n/a
 */

//import java.text.BreakIterator;
import java.util.*;

public class InsulinDosage {

    
    public static void main(String[] args) {
        // Create a Scanner that can read from the console.
        Scanner scan = new Scanner(System.in);
        
        /*
         * TO DO: replace each of the 0s below with a method
         * call that gets an integer from the user.
         * You MUST use the Scanner object created above
         * at the start of main. You may NOT construct an
         * additional Scanner object.
         */
        System.out.print("current blood sugar: ");
        int currentSugar = scan.nextInt();
        System.out.print("target blood sugar: ");
        int targetSugar = scan.nextInt();
        System.out.print("carbohydrate equivalency: ");
        int carbEquiv = scan.nextInt();
        System.out.print("carbohydrates to consume: ");
        int carbConsume = scan.nextInt();
        System.out.print("amount of exercise (0-3): ");
        int exercise = scan.nextInt();
        
        /*
         * TO DO: complete the rest of the program below.
         */
        
        
        double dosage = (double) (currentSugar-targetSugar)/55 + (double) carbConsume/carbEquiv - exercise;
        //System.out.println(dosage + "Test");
        if (dosage == 1.0)
        { // one
            System.out.println("recommended dosage:" + dosage + " unit");
        } else if (dosage > 0.0 && dosage != 1.0)
        { //greater than 0 and not 1
            if(Math.floor(dosage) == dosage)
            { // if whole number{}
                System.out.println("recommended dosage: " + (int) dosage + " units");
            } else 
            { // a decimal 
                System.out.println(dosage + " units");
            }
        } else if (dosage <= 0.0) 
        {  // less than or equal to zero
            System.out.println("0.0 units");
        } 

	

        // Leave this line unchanged.
        scan.close();
    }
}
