/*
 * Methods6.java
 * 
 * Code added by: name and email --> Wadner Simon, casseus@bu.edu
 * 
 *
 * Practice with static methods, part I
 */

public class Methods6 {
    /*
     * 0) printVertical - takes a string s and prints the characters of 
     *    the string vertically -- with one character per line.
     */
    public static void printVertical(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
        }

        
    }

    public static void printEveryOther(String s){ // prints every other character in String S
        String everyOther = "";
        for (int i = 0; i < s.length(); i++) { // from printVerticle
            //System.out.println(i);
            if ( i == 0){
                everyOther +=  "" +s.charAt(i);
            } else if (i % 2 == 0){ // even
                everyOther = everyOther + "" +s.charAt(i);
            } 

        }

        System.out.println(everyOther);
    }

    public static int longerLen(String s1, String s2){ // returns the value of the longest String S
        if(s1.length() >= s2.length()) return s1.length();
        else return s2.length();
    }

    public static int secondIndex(String s, char a){
        int counter = 0;
        
        for(int i = 0; i <= s.length()-1; i++){
            //System.out.println(s.charAt(i));
            //System.out.println("s.charAt("+i+"): " + s.charAt(i));
            if(s.charAt(i) == a){
                counter++;
                if(counter == 2){
                    return i;
                    
                } else{
                    continue;
                }
            } else{
                continue;
            }
                
        }

        return -1;
    }

    public static void main(String[] args) {
        /* Sample test call */
        //printVertical("method");   
        //printEveryother("method");  
        //int x = secondIndex("Banana", 'a'); 
        //System.out.println(x);

    }
}
