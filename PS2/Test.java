import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str1 = "Write a string";
        String str2 = "about spring";
        String s = str1.substring(0,2).toLowerCase()+str2.charAt(2) + str1.substring(3,11) + str2.charAt(2) + str1.substring(12);
        System.out.println(s);

        //int[] values = {1, 3, 5, 7, 9, 11, 13};
        //mystery(values);

        int[][] twoD = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16} };
        twoD[1][2] = 14;
        System.out.println("5.2: " + twoD[1][2]);

        for(int i= 0;i< twoD.length;i++){
            System.out.println(twoD[i][0]);
        }
        System.out.println();

        for(int i= twoD.length-1;i > -1;i--){
           for(int j = twoD.length-1;j > -1; j-- ){
                if(i + j == 3)
                    System.out.println(twoD[i][j]);
                else continue;
           }
        }
        
    }
    public static void mystery(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            System.out.println("i: " + i);
            int val1 = arr[i + 1];
            System.out.println("Val1: " + val1 );
            int val2 = arr[i + 2];
            System.out.println("Val2: " + val2 );
            arr[i] = val1 + val2;
            System.out.println("arr[" + i + "]" + arr[i]);
            System.out.println("arr: " + Arrays.toString(arr));

        // What values do the variables have here,
        // for each value of the loop variable `i`?
        }
        System.out.println("End: "+ Arrays.toString(arr));
     }
}
