/*
 * Palindrome.java
 *
 * Computer Science 112
 *
 * Modifications and additions by:
 *     name:
 *     username:
 */
   
public class Palindrome {
    // Add your definition of isPal here.

    public static boolean isPal(String str){
        //use stack to determine if it is a palindrome
        //convert string to stack to store original string (one iteration)
        //upon each conversion into stack, convert each char to Char.toLower
        //also for check if it's a punctuation or space
        //convert stack to queue
        // compare queue.remove with stack.pop
        //if same move on, if not break and return false
        //if all passed, return true
        if(str == null){
            return false;
        }
        if(str.equals(" ")){
            return false;
        }
        if(str.equals("")){
            return false;
        }
       

        LLStack<Character> pal1 = new LLStack<Character>(); //LL is better since size is unknown
        int x = 0;
        while(x <= str.length()-1){
            
            char current = Character.toLowerCase(str.charAt(x));
            if(current == ' ' || !(Character.isLetter(current))){// if its a character or space
                x++;
                continue;
            }
            pal1.push(current); // adding to the stack
            x++;
        } // pal1 will be filled

        LLQueue<Character> pal2 = new LLQueue<Character>();
        int j = 0;
        while(j <= str.length()-1){
           
            char current = Character.toLowerCase(str.charAt(j));
            if(current == ' ' || !(Character.isLetter(current))){// if its a character or space
                j++;
                continue; //isLetter() isn't a string method :)
            }
            pal2.insert(current); // adding to the LLQueue
            j++;
        } // pal1 will be filled
       

        //comparison
        while(true){
            if(pal1.peek() != pal2.peek()){
                return false;
            }
            if(pal1.isEmpty()){
                return true;
            }
            pal1.pop();
            pal2.remove();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            boolean expected = true;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
        /*
         * Add five more unit tests that test a variety of different
         * cases. Follow the same format that we have used above.
         */
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(1) Testing on \"Racecar\"");
        try {
            boolean results = isPal("racecar");
            boolean expected = true;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests

        System.out.println("(2) Testing on \"Soothin Jasmine Tea\"");
        try {
            boolean results = isPal("Soothin Jasmine Tea");
            boolean expected = false;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests

        System.out.println("(3) Testing on \"Empty\"");
        try {
            boolean results = isPal("");
            boolean expected = false;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests

        System.out.println("(4) Testing on \"Space\"");
        try {
            boolean results = isPal(" ");
            boolean expected = false;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests

        System.out.println("(5) Testing on \"Free Bird\"");
        try {
            boolean results = isPal("Free Bird");
            boolean expected = false;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests

        System.out.println();    // include a blank line between tests

        System.out.println("(6) Testing on \"CS112\"");
        try {
            boolean results = isPal("Free Bird");
            boolean expected = false;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
    }
}