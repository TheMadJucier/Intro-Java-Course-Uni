

/**
 * Part 1
 */
public class Part1 {
     int count = 0;
    public static void main(String[] args) {
       
        int arr[] = new int []{1,2,3,4,5};
       printMirror2(arr, 0);
        //printMirror(arr,0);
      // print(arr,1);

    }

    public static void printMirror(int[] arr, int start){ //recursively
        if (arr == null || start < 0) { //(1)
            throw new IllegalArgumentException();
        }
        if((arr.length * 2) <= start){
        
            return;
        } else if(start >= arr.length){
            //System.out.println(arr[start]);
            System.out.println(arr[2*arr.length- start -1]);
            start++;
            printMirror(arr, start);
            //System.out.println(arr[start]); 
            return; 
        } else{
            System.out.println(arr[start]);
            start++;
            printMirror(arr, start);
            return;
        }

    }

    public static void print(int[] arr) {
        // Always check for null references first!
            if (arr == null) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        
    }

    public static void print(int[] arr, int start){
        

        if (arr == null || start > arr.length || start < 0) { //(1)
            throw new IllegalArgumentException();
        }
        if(arr.length-1 == start){
            System.out.println(arr[arr.length-start-1]);
        } else{
            
            print(arr, start+1);
            System.out.println(arr[arr.length-1-start]);
        }
    }


    public static void printMirror2(int[] arr, int start){ //recursively
        if (arr == null || start > arr.length || start < 0) { //(1)
            throw new IllegalArgumentException();
        }if (start > arr.length){
            return;
        }
        else if(arr.length-1 == start){
        
            //System.out.println(arr[start] +"\n" + arr[start-1]);
            System.out.println(arr[start]);
            System.out.println(arr[start]);
        } else{
            System.out.println(arr[start]);
            print(arr, start+1);
            System.out.println(arr[start]);  
        }

    }




}
    
