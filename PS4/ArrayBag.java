/* 
 * ArrayBag.java
 *
 * A blueprint class for objects that represent a bag of other objects --
 * i.e., a collection of items in which the items do not have a position.
 * This implementation uses an array to store to objects in the bag.
 *
 * Computer Science 112
 *
 * modified by: <name>, <email>
 */

import java.util.*;

public class ArrayBag {
    /** 
     * The array used to store the items in the bag.
     */
    private Object[] items;
    
    /** 
     * The number of items in the bag.
     */
    private int numItems;
    
    public static final int DEFAULT_MAX_SIZE = 50;
    
    /**
     * Constructor with no parameters - creates a new, empty ArrayBag with 
     * the default maximum size.
     */
    public ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE];
        this.numItems = 0;
    }
    
    /** 
     * A constructor that creates a new, empty ArrayBag with the specified
     * maximum size.
     */
    public ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be > 0");
        }
        this.items = new Object[maxSize];
        this.numItems = 0;
    }
    
    /**
     * numItems - accessor method that returns the number of items 
     * in this ArrayBag.
     */
    public int numItems() {
        return this.numItems;
    }
    
    /** 
     * add - adds the specified item to this ArrayBag. Returns true if there 
     * is room to add it, and false otherwise.
     * Throws an IllegalArgumentException if the item is null.
     */
    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be non-null");
        } else if (this.numItems == this.items.length) {
            return false;    // no more room!
        } else {
            this.items[this.numItems] = item;
            this.numItems++;
            return true;
        }
    }
    
    /** 
     * remove - removes one occurrence of the specified item (if any)
     * from this ArrayBag.  Returns true on success and false if the
     * specified item (i.e., an object equal to item) is not in this ArrayBag.
     */
    public boolean remove(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                // Shift the remaining items left by one.
                for (int j = i; j < this.numItems - 1; j++) {
                    this.items[j] = this.items[j + 1];
                }
                this.items[this.numItems - 1] = null;
                
                this.numItems--;
                return true;
            }
        }
        
        return false;  // item not found
    }
    
    /**
     * contains - returns true if the specified item is in the Bag, and
     * false otherwise.
     */
    public boolean contains(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * grab - returns a reference to a randomly chosen item in this ArrayBag.
     */
    public Object grab() {
        if (this.numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }
        
        int whichOne = (int)(Math.random() * this.numItems);
        return this.items[whichOne];
    }
    
    /**
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        Object[] copy = new Object[this.numItems];
        
        for (int i = 0; i < this.numItems; i++) {
            copy[i] = this.items[i];
        }
        
        return copy;
    }
    
    /**
     * toString - converts this ArrayBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < this.numItems; i++) {
            str = str + this.items[i];
            if (i != this.numItems - 1) {
                str += ", ";
            }
        }
        
        str = str + "}";
        return str;
    }

    /*
     * This method should return the maximum number of items that the 
     * called ArrayBag is able to hold. This value does not depend on 
     * the number of items that are currently in the ArrayBag. 
     * Rather, it is the same value as the maximum size specified when 
     * the ArrayBag was created.
     */

    public int size(){
        return ( this.items.length );

    }

    /*
     * This method should return a count of the number of times that the 
     * parameter item occurs in the called ArrayBag. 
    */

    public int count(Object item){
        //initialize an item frequency tracker
        //create for loop to go through bag
        //check and update instances of said item

        int itemFrequency = 0;
        for(int i = 0; i < this.numItems;i++){
            if(this.items[i].equals(item)){
                itemFrequency++;
            }
        }

        return itemFrequency;
    }

    public boolean reduceSize(int decrease){
        //check if decrease is too big compared to current number of items
        //create temp array to copy values with specific size
        //return true if possible, return true if not possible

        if(decrease == 0){ // effectively no decrease
            //System.out.println("Reache2d");
            return true;
        } else if(decrease < 0){ //negative
            throw new IllegalArgumentException();
        } else{
           // System.out.println(this.size() - decrease);
            //System.out.println(this.numItems);
            if(this.size() - decrease > this.numItems){ // checks if new size is bigger than numItems
                //System.out.println("Reached 3");
                //System.out.println("Reached");
                ArrayBag tempBag = new ArrayBag(this.size()-decrease); //creates new Array
                for(int i = 0; i < tempBag.size(); i ++){
                    //System.out.println("Tempbag: " + tempBag.toString());
                    //System.out.println("This bag: " + this.toString());
                    tempBag.items[i] = this.items[i];
                }
                this.items = tempBag.items; // point this to tempbags
                return true;
                
            } else{
                return false;
    
            }
        }

        

    }

    public boolean equals(ArrayBag other){
        //if two items have the same number of items and the same item frequency they are equal
        //create for loop to call count method for each item
        
        int trueCounter = 0;
        //int falseCounter = 0;

        for(int i = 0; i < this.numItems; i++){
            if(this.items[i] == null || other.items[i] == null){
                break;
            } else if(this.count(items[i]) == other.count(items[i])){
                trueCounter++; 
                continue;
            } else{
                 return ( false );
            }
        }

        if(trueCounter == this.numItems()){ // may be redunant, but whatever
            return ( true );
        } else{
            return ( false );
        }
        
    }

    public ArrayBag subtract(ArrayBag other){
        /*
         * This method should create and return an ArrayBag 
         * containing one occurrence of any item from the called 
         * ArrayBag object that is not also present in the ArrayBag 
         * represented by the parameter other.
        */

        //copy contents of this to subtract Array
        //run through new array
        //remove duplicates
        //check if this contains other items and delete them
        //first delete any duplicates in 


        if(Objects.isNull(other)){ // check if paramter is null
            throw new IllegalArgumentException();
        } else if(this.size() == 0){
            ArrayBag subtract = new ArrayBag(1); // giving default size of 1 if empty this
            return subtract;
        }

        ArrayBag subtract = new ArrayBag(this.numItems);
        

        for(int i = 0; i < this.numItems; i++){ //removes any
            if(other.contains(this.items[i])){ // in both
                // System.out.println("Subtract.numItems: " + subtract.numItems);
                // System.out.println("True" + this.items[i]);
                // System.out.println("this.items["+i+"]: " + this.items[i]);
                // subtract.remove(subtract.items[i]);
                continue;
            } else if(this.count(this.items[i]) >= 1){ //removes duplicate
                 subtract.add(this.items[i]);
                 //continue; //doing nothing
            }else{
                 // building new array
                 continue;
                
            }
        }

        //removing duplicates
        for(int i = 0; i < subtract.numItems; i++){
            if(subtract.count(subtract.items[i]) > 1){
                subtract.remove(subtract.items[i]);
            }
            //System.out.println("Removing duplicates subtract: " + subtract.toString());
        }

        return subtract;





    }
    
    /* Test the ArrayBag implementation. */
    public static void main(String[] args) {
        //Test public int size()
        // System.out.println("Test public int size()");
        // ArrayBag b1 = new ArrayBag(10);
        // System.out.println(b1.size());

        // System.out.println(); //blank line

        // //Test: public int count(Object item)
        // System.out.println("Test: public int count(Object item)");
        // ArrayBag b2 = new ArrayBag(10);
        // int[] vals = {7, 5, 3, 7, 7, 2, 5};
        // for (int x : vals) {
        //     b2.add(x);
        // }
        
        // System.out.println(b2.count(2));
        // System.out.println(b2.count(7));
        // System.out.println(b2.count(8));
        // System.out.println(b2.toString()); //array was not changed

        // System.out.println();

        
        //Test: public boolean reduceSize(int decrease)
        // ArrayBag b3 = new ArrayBag(8);
        // b3.add("hello");
        // b3.add("world");
        // System.out.println(b3);
        // System.out.println("size before: " + b3.size());
        
        // b3.reduceSize(5);
        // System.out.println(b3);
        // System.out.println("size after: " + b3.size());
    
        // b3.reduceSize(5);
        // System.out.println(b3);
        // System.out.println("size after: " + b3.size());
        // System.out.println();


        // //Test:public boolean equals(ArrayBag other)
        // System.out.println("Test:public boolean equals(ArrayBag other)");
        // ArrayBag b02 = new ArrayBag(10);
        // int[] vals02 = {5,6,6,7};
        // for (int x : vals02) {
        //     b02.add(x);
        // }
        // ArrayBag b01 = new ArrayBag(10);
        // int[] vals01 = {7,6,5};
        // for (int x : vals01) {
        //     b01.add(x);
        // }

        // System.out.println(b01.equals(b02));
        // System.out.println(b01.toString());
        // System.out.println(b02.toString());



        // ArrayBag b5 = new ArrayBag(10);
        // String[] letters5 = {"a", "a", "b", "d", "f", "f", "f", "g"};
        // for (String ltr: letters5) {
        //     b5.add(ltr);
        // }
        // System.out.println(b5);
        
        // ArrayBag b6 = new ArrayBag(7);
        // String[] letters6 = {"b", "c", "e", "e", "g"};
        // for (String ltr: letters6) {
        //     b6.add(ltr);
        // }
        // System.out.println(b6);
        
        // ArrayBag b7 = b5.subtract(b6);
        // System.out.println(b7);
        // System.out.println(b7.numItems());
        // System.out.println(b7.size());
        // System.out.println(b5);   // make sure original bags are unchanged
        // System.out.println(b6);
    }
}
