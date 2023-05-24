/**
 * Problem2
 */
public class Problem2 {
    public static void main(String[] args) {
        int arr [] = {42,6,8,1,6,2};
        
        System.out.println(numUnqiue(arr));
        
    }

    public static int numUnqiue(int[] arr){
        mergeSort(arr);
        int numUnique = 0;
        for(int i = 0; i < arr.length; i++){
            //System.out.println(i+1);
            if(i < arr.length-1 && arr[i] == arr[i+1]){
                //System.out.println("True");
                //System.out.println("arr[i+1] && arr[i]: " + "" + (arr[i+1]) + "" + "" + arr[i]);
                continue;
            }
            numUnique++;
        }
        return numUnique;

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