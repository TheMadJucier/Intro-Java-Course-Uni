import java.util.Scanner;

/*
 * Find Area of Circle
 * Name:
 * casse
 */

public class Circular {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);

        System.out.println("Whats the diamter of your land?: ");
        int diameter = user.nextInt();
        double radius = diameter/2;
        double area = Math.round(radius* radius * Math.PI);

        System.out.println("The area of the circle is approximately: " 
            + "\n" + Math.round(area) + " square feet" +
            "\n" + (int) Math.floor(area/9) + " square yards plus " + (int) Math.abs((area) - ((int) Math.floor(area/9)) * 9) +" square feet");

        user.close();
        
       


    }
}
