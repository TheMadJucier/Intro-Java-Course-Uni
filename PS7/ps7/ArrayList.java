import java.util.HashSet;

/*
 * ArrayList.java
 *
 * Computer Science 112, Boston University
 * 
 * modified by: Wadner Simon
 */

/*
 * A class that implements our simple List interface using an array.
 */
public class ArrayList implements List {
    private Object[] items;     // the items in the list
    private int length;         // # of items in the list
    
    /*
     * Constructs an ArrayList object with the specified maximum size
     * for a list that is initially empty.
     */
    public ArrayList(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("max size must be positive");
        }
        items = new Object[maxSize];
        length = 0;
    }
    
    /*
     * Constructs an ArrayList object containing the items in the specified
     * array, and with a max size that is twice the size of that array 
     * (to allow room for growth).
     */
    public ArrayList(Object[] initItems) {
        items = new Object[2 * initItems.length];        
        for (int i = 0; i < initItems.length; i++) {
            items[i] = initItems[i];
        }
        
        length = initItems.length;
    }
    
    /*
     * length - returns the number of items in the list 
     */
    public int length() {
        return length;
    }
    
    /* 
     * isFull - returns true if the list is full, and false otherwise
     */
    public boolean isFull() {
        return (length == items.length);
    }
    
    /* getItem - returns the item at position i in the list */
    public Object getItem(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        
        return items[i];
    }
    
    /* 
     * addItem - adds the specified item at position i in the list,
     * shifting the items that are currently in positions i, i+1, i+2,
     * etc. to the right by one.  Returns false if the list is full,
     * and true otherwise.
     */
    public boolean addItem(Object item, int i) {
        if (item == null || i < 0 || i > length) {
            throw new IllegalArgumentException();
        } else if (isFull()) {
            return false;
        }
        
        // make room for the new item
        for (int j = length - 1; j >= i; j--) {
            items[j + 1] = items[j];
        }
        
        items[i] = item;
        length++;
        return true;
    }
    
    /* 
     * removeItem - removes the item at position i in the list,
     * shifting the items that are currently in positions i+1, i+2,
     * etc. to the left by one.  Returns a reference to the removed
     * object.
     */
    public Object removeItem(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        
        Object removed = items[i];
        
        // fill in the "hole" left by the removed item
        for (int j = i; j < length - 1; j++) {
            items[j] = items[j + 1];
        }
        items[length - 1] = null;
        
        length--;
        return removed;
    }
    
    /*
     * toString - converts the list into a String of the form 
     * {item0, item1, ...}
     */
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < length; i++) {
            str = str + items[i];
            if (i < length - 1) {
                str = str + ", ";
            }
        }
        
        str = str + "}";
        return str;
    }
    
    /*
     * iterator - returns an iterator for this list
     */
    public ListIterator iterator() {
        // not yet implemented. You do NOT need to do so!
        return null;
    }

    void rotate(int k){
        //given an array list
        //use a circular queue to preserve order 
        //size of queue will be the same size as given ArrayList that calls it
        //a series of insertions and removals, so that we can maintian the list
        //but the entire queue maintains the same properites
        //1.remove end
        //2.shift everything
        //3. add previous end to fron
        //thats one rotation

        if(k < 0 || k > this.length){
            throw new IllegalArgumentException(); 
        }
        if( k == 0){
            return;
        }


        
        //System.out.println("Inside: " + this.length);
        ArrayList arr = new ArrayList(this.length);
        for(int i = 0; i < this.length; i++){ //performs rotation
            //System.out.println((i+k) % this.length);
            arr.items[(i+k) % this.length] = this.items[i]; //circular, from slides
            
        }
        
        for(int i = 0; i < this.length; i++){ //performs rotation repopulating 
            this.items[i] = arr.items[i];
            
        }

      
        //System.out.println("Hello");



        
        //5tSystem.out.println(arr.toString());
        
    }
    public static void main(String[] args) {
        

        System.out.println("--- Testing Rotate LList ---");
        System. out.println();
        System.out.println("(0) Testing tree.rotate() on tree from Problem 6, ...");
        
        try {
            String[] letters3 = {"a", "b", "c", "d", "e", "f"};
            ArrayList list3 = new ArrayList(letters3);
            System.out.println(list3.toString());
            list3.rotate(4);
            System.out.println("Outside: " + list3);
        
        
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }

        System.out.println("--- Testing Rotate LList ---");
        System.out.println();
        System.out.println("(0) Testing tree.rotate() on tree from Problem 6, ...");
        try {
            String[] letters1 = {"a", "b", "c", "d", "e", "f","g", "h", "i"};
            ArrayList list1 = new ArrayList(letters1);
            //System.out.println(list1.toString());
            list1.rotate(4);
            System.out.println("Outside: " + list1);
        
        
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }


    }
}
