import java.util.Arrays;

/**
 * Problem5
 */
public class Problem5 {
    public static void main(String[] args) {
        //make one combine array
        //sort array--> merge sort
        int[] a1 = {10, 5, 7, 5, 9, 4};
        int[] a2 = {7, 5, 15, 7, 7, 9, 10};
        int[] result1 = union(a1, a2);
        System.out.println("a1: " + Arrays.toString(a1));
        System.out.println("result1: " + Arrays.toString(result1));

        int[] a3 = {0, 2, -4, 6, 10, 8};
        int[] a4 = {12, 0, -4, 8};
        int[] result2 = union(a3, a4);
        System.out.println("a2: " + Arrays.toString(a2));
        System.out.println("result2: " + Arrays.toString(result2)); 
        
    }

    public static int[] union(int[] a1, int[] a2){
         //make one combine array
        //sort array--> merge sort

        if(a1 == null || a2 == null){
            throw new IllegalArgumentException();
        }
        
    

        int arrUnion [] = new int[a1.length+a2.length];
        mergeSort(a1); //nlogn
        mergeSort(a2);//nlogn

        for(int i = 0; i < arrUnion.length; i++){ //n
            if(i < a1.length){
                arrUnion[i] = a1[i];
            }
            else{
                arrUnion[i] = a2[Math.abs(arrUnion.length-i-a2.length)]; //positive index
            }

            
        }
        mergeSort(arrUnion); // nlogn
        int temp [] = new int [arrUnion.length];


        int duplicate = 0;
        for(int i = 0; i < temp.length; i++){ //n
            if(i != temp.length - 1 && arrUnion[i] == arrUnion[i+1]){ // duplicate
                duplicate++;
                continue;
            }

            temp[i-duplicate] = arrUnion[i];
        }
        //System.out.println(Arrays.toString(arrUnion));

        //f(n) =  nlogn + nlogn + n + + nlogn + n= 
        //O(n) = nlogn

        return temp;
        


    }


    /* merge - helper method for mergesort */
    private static void merge(int[] arr, int[] temp, 
      int leftStart, int leftEnd, int rightStart, int rightEnd)
    {
        int i = leftStart;    // index into left subarray
        int j = rightStart;   // index into right subarray
        int k = leftStart;    // index into temp
        
        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; k++;
            } else {
                temp[k] = arr[j];
                j++; k++;
            }
        }
        
        while (i <= leftEnd) {
            temp[k] = arr[i];
            i++; k++;
        }
        while (j <= rightEnd) {
            temp[k] = arr[j];
            j++; k++;
        }
        
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
    }
    
    /** mSort - recursive method for mergesort */
    private static void mSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int middle = (start + end)/2;
        mSort(arr, temp, start, middle);
        mSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle + 1, end);
    }
    
    /** mergesort */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mSort(arr, temp, 0, arr.length - 1);
    }
    
}