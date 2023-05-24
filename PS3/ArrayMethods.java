import java.util.*;
/**
 * ArrayMethods
 */
public class ArrayMethods {

    public static void process(int[] vals){ //

        if(vals == null){
            throw new IllegalArgumentException(); // can we use a try and catch block
        }else{
            for(int i = 0; i <vals.length; i++){
                if(vals[i] % 2 == 0){ //If an element is even, it should be doubled.
                    vals[i] *= 2;
                } else{ 
                    vals[i] *= -1;
                }
            }
        }
    
        
    }

    public static String[] extractBU(String[] words){
        if(words == null){
            throw new IllegalArgumentException();
        } else {
        String extract [];
        int count = 0;
        //declare new array, and initalise a count variable
        //Run through array, and count how many instances of words
        // create a new array with count length
        // go through array again, and copy the words

        for(int i = 0; i < words.length; i++){ // counting how many instances of these words have "b,u,B, or U"
            if(words[i].charAt(0) == 'U' || 
                words[i].charAt(0) == 'B' || 
                words[i].charAt(0) == 'u' || 
                words[i].charAt(0) == 'b' ){
                    count++;
            } else continue;
            //System.out.println(count);
        }

        extract = new String[count];; // has "count" number of spaces
        int extractIndex = 0;
        for(int i = 0; i < words.length; i++){
            
            if(words[i].charAt(0) == 'U' || 
                words[i].charAt(0) == 'B' || 
                words[i].charAt(0) == 'u' || 
                words[i].charAt(0) == 'b' ){
                //System.out.println(words[i] );
                //System.out.println(i);
                extract[extractIndex] = words[i];
                extractIndex++;
                
            } else continue;
            
            //extract[i] = words[i]; // assigning the value at words[i] to extract[i]
            
        }

            return ( extract ); // returning extract
        }
        
    }

    public static void moveToEnd(int[] vals, int n){

        //create array of size vals.length-n and copy values of vals starting from n
        // create array and copy values of vals starting from 0 to n-1
        //use for loop to run through values of arr1 and put them into vals
        //use another for loop to run through arr2 and put them into vals

        if(vals == null || n < 0 || vals.length < n){ // checking for bad parameters
            throw new IllegalArgumentException();
        } else if( n == 0 || vals.length == n){ // checking if valid but useless parameters
            
        } else{

            int endArr [] = new int [vals.length - n]; // n to end
            int endArrIndex = 0; // starting index
            int begArr [] = new int [n]; // 0 to n
            int begArrIndex = 0; // starting index to negate i in second for loop
    
            for(int i = 0; i < vals.length; i++){ // copying vals values into the temporary arrays
                if(i < n){ // n to end
                    System.out.println("i: " + i);
                    begArr[i] = vals[i]; // coping begining portion
                    System.out.println(Arrays.toString(begArr));
    
               
                } else {
                    System.out.println("i: " + i);
                    endArr[endArrIndex] = vals[i]; // copying end portion
                    endArrIndex++; // increasing index along with i
                    System.out.println(Arrays.toString(endArr));
                }
            }
    
            for(int i = 0; i < vals.length;i++){ // updating, "shifting", the values of vals with temporary arrays
                if(i < vals.length-n){ // endArr dimensions
                    vals[i] = endArr[i]; //copying
                } else{ // beg arr dimensions
                    vals[i] = begArr[begArrIndex]; //copying
                    begArrIndex++; // updating
                }
            }

        }


    }

    public static boolean hasXOfAKind(int[] vals, int x){

        //create x counter, counts if any number goes up to x
        //create for loop to go through each element of the array
        //create a variable to check for a specific index
        //check each element for to see how many times it appears
        //create do while loop to run through code until this is true

        if(vals == null || x == 1){ // invalid parameters
            throw new IllegalArgumentException();
        }else if (vals.length == 0){ //empty array
            return ( false );
        } else if(vals.length != 0 && x == 1){ // array where x is 1, so every value can acheive this
            return ( true );
        } else { //all parameters are normal
            int appears = 0; // holds how many times an index shows
            int specificIndex = 0; // looks at a specific index

            do { // goes through vals and checks how many times each value appears, 
                // it throws away the smallest appearnece while keeping the largest and breaking if it's found
                
                if(specificIndex == vals.length) { // makes sure specificIndex isn't out of bounds
                    break;
                } else {
                    appears = 0; // resetting appears for new run of for loop
                    for(int i = 0; i < vals.length; i++){ // running through vals
                        System.out.println("specific index: " + specificIndex);
                        if(vals[i] == vals[specificIndex]){ // checking to see if this index is the same
                            //System.out.println("vals[" + i +"] == vals["+vals[specificIndex]+"]: True" );
                            //System.out.println("appears: " + appears);
                            appears++;
                            
                        } else continue;
                    }
                    //resetting how many appearances so next index is ready
                    specificIndex++; // updates and moves on to next index
                }
            } while (appears <= x); // running until an index appears that many times
            //System.out.println("outside reached");
            //System.out.println("appears: " +appears);
            if(appears == x){ // checks to see if they're equal
                return ( true );
            } else {return ( false );} // they're not equal
        }
    

    }

    public static int[] combine(int[] vals1, int[] vals2) {
        // create new array for the sums of vals1 and vals2 with length of the longer one
        //check to see which array is longest
        //create if blocks for each instance
        //create for loop to sum arrays

        if(vals1 == null || vals2 == null || vals1.length == 0 || vals2.length == 0){ // checking valid parameters
            throw new IllegalArgumentException();
        } else {
            int sumArr[]; // don't know which vals is longest
            if(vals1.length > vals2.length){
                sumArr = new int[vals1.length];
                for(int i = 0; i < vals2.length; i++){
                    sumArr[i] = vals1[i] + vals2[i]; // sums all values until length of vals2, the smallest is up
                }
                
                for(int k = vals2.length; k < vals1.length; k++){ // runs through remained of var1(largest) 
                    //to adds it to sumArr's end
                    sumArr[k] = vals1[k]; // copying rest of k
                }
    
                return ( sumArr );
            } else if(vals1.length < vals2.length){ // vals2 is larger
                sumArr = new int[vals2.length];
                
                for(int i = 0; i < vals1.length; i++){
                    sumArr[i] = vals1[i] + vals2[i]; // sums all values until length of vals2, the smallest is up
                }
                
                for(int k = vals1.length; k < vals2.length; k++){ // runs through remained of var1(largest) 
                    //to adds it to sumArr's end
                    sumArr[k] = vals2[k]; // copying rest of k
                }
    
                return ( sumArr );
    
    
    
            }else { // they're equal
                sumArr = new int[vals1.length]; // doesn't matter which one is chosen
                for(int i = 0; i < vals1.length; i++){ // doesn't matter which length
                    sumArr[i] = vals1[i] + vals2[i]; // sums all values until length of vals2, the smallest is up
                }
    
                return ( sumArr );
    
            }
        }
        

        

    }

    public static void main(String[] args) {
        // int[] a1 = {1, 2, 6, 5, -8, -10, -11};
        // ArrayMethods.process(a1);
        // System.out.println(Arrays.toString(a1));   
        
        // String[] a2 = {"Build", "up", "your", "best", "self"};
        // String[] a3 = ArrayMethods.extractBU(a2);
        // System.out.println(Arrays.toString(a3));

        // int[] a4 = {1, 2, 3, 4, 5, 6, 7, 8};
        // ArrayMethods.moveToEnd(a4, 3);
        // System.out.println(Arrays.toString(a4));

        // int[] vals1 = {2, 8, 4, 8, 5, 6, 8};
        // int[] vals2 = {9, 6, 9, 7, 9, 7, 9, 9};
        // System.out.println(hasXOfAKind(vals2, 6));

        int[] a5 = {1, 2, 3, 4};  // same array as above
        int[] a8 = {5, 6, 7, 8, 9, 11};
        int[] a9 = ArrayMethods.combine(a5, a8);
        System.out.println(Arrays.toString(a9));
        
    }

    
}