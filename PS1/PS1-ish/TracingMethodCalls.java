public class TracingMethodCalls {
    public static int compute(int x, int y) {
        y += x;
        x = 10 - y;
        System.out.println(x + " " + y + "Compute");
        return x;
    }

    public static double triArea(double base, double height){
        double area = 0.5* base* height;
        return area;
    }

    public static void printFrag(){
        for (int i = 0; i < 3; i++) {
            for (int j = i; j >= 0; j--) { 
                System.out.println(i + " " + j);
            }
            System.out.println("--");
        }
    }
    public static void mulFive(int n) {  //example
        // for (int mul = 5; mul <= n; mul += 5) {
        //     System.out.println(mul);
        // }

        while(n >= 5){
            System.out.println(n);
            n -= 5;
           
        }
    

    }

    public static void print42(){
        for (int i = 0; i <= 42; i++) { 
            System.out.println("I feel loopy!");
        }
    }

    public static void main(String[] args) {
        int x = 6;
        int y = 3;
        System.out.println(x + " " + y);
        y = compute(x, y);
        System.out.println(x + " " + y + "Main");
        x = compute(y, x) + 1;
        System.out.println(x + " " + y + "Main");
        compute(x, x);
        System.out.println(x + " " + y + "Main");

        System.out.println(triArea(3, 6));
        mulFive(25);
        printFrag();
    }


}