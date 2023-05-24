/**
 * ps1.2
 */
import java.util.*;

public class hello {
    public static void main(String[] args) {
        // int a = 10;
        // int b = 4;
        // double c = 4;
        // double d = 4.0;

        // System.out.println(a + d);
        // System.out.println( a + "d");
        // System.out.println(b / a);
        // System.out.println(c / a);
        // System.out.println(d / a);
        // System.out.println(a / b * d);
        // System.out.println((double)(a / b));
        // System.out.println((double)a / b);
        // System.out.println(1 + 2 + "3");
        // System.out.println(1 + "2" + 3);

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter three numbers: ");
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            
            if (a <= b) {
                if (b > c || c < 4) {
                    System.out.println("diamond");/* */
                } else {
                    System.out.println("ruby");/* */
                }
                System.out.println("pearl");/* */
            } else if (b >= c) { // a =5 
                if (!(a > b)) {
                    System.out.println("copper");
                } else if (b == c && b < 5) {
                    System.out.println("bronze");/* */
                }
                System.out.println("silver");/* */
                if (a < c) {
                    System.out.println("gold");
                }
            } else {
                System.out.println("penny");/* */
                if (a == b) {
                    System.out.println("dime");
                } else {
                    System.out.println("nickel");/* */
                }
            }
        }
        System.out.println("done");
    
    }

    
    
}

