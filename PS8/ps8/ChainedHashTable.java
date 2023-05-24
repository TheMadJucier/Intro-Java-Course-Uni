/*
 * ChainedHashTable.java
 *
 * Computer Science 112, Boston University
 * 
 * Modifications and additions by:
 *     name: Sir Wadner Simon of Winterfell
 *     email:casseus@bu.edu
 */

import java.util.*;     // to allow for the use of Arrays.toString() in testing

/*
 * A class that implements a hash table using separate chaining.
 */
public class ChainedHashTable implements HashTable {
    /* 
     * Private inner class for a node in a linked list
     * for a given position of the hash table
     */
    private class Node {
        private Object key;
        private LLQueue<Object> values;
        private Node next;
        
        private Node(Object key, Object value) {
            this.key = key;
            values = new LLQueue<Object>();
            values.insert(value);
            next = null;
        }
    }
    
    private Node[] table;      // the hash table itself
    private int numKeys;       // the total number of keys in the table
        
    /* hash function */
    public int h1(Object key) {
        int h1 = key.hashCode() % table.length;
        if (h1 < 0) {
            h1 += table.length;
        }
        return h1;
    }
    
    /*** Add your constructor here ***/

    
    /*
     * insert - insert the specified (key, value) pair in the hash table.
     * Returns true if the pair can be added and false if there is overflow.
     */
    public boolean insert(Object key, Object value) {
        /** Replace the following line with your implementation. **/
        //run hash function
        //check for already occupied bucket, if not
        //put it into array spot
        //return true
        // if it is, put into the bucket, and have the head point to the first node, LLQueue

        if(value.equals(null) || key.equals(null)){
            throw new IllegalArgumentException();
        }
        //running hash
        int hashValue = h1(key);
        
        if(table[hashValue] == null){ // not full
            Node newHash = new Node(key, value);
            table[hashValue] = newHash; 
            numKeys++;
           // System.out.println("Reached: " + numKeys);
           return true;
        }
        if(table[hashValue] != null){ //full
            Node newHash = new Node(key, value); // new node
            Node trav = table[hashValue];
            while(trav != null){ // traversing a bucket, duplicate
                if(trav.key.equals(newHash.key)){
                    //System.out.println("Hello, Humans");
                    trav.values.insert(value);
                    return true;
                    
                    //trav.values.insert(value);
                    
                }
                trav = trav.next;
                
            }
            newHash.next = table[hashValue]; // assigning new Node the refernce of the previous
            table[hashValue] = newHash; // old Node now at the end
            numKeys++;
            return true;
            
            
            
            //Node prev = null;
            //Object newKey = trav.key;
            //System.out.println("Rachel");
           
            //int i = 0; //counts duplicates
            
            // if(i == 1){ // no duplicates
            //     numKeys++;
            // }
            // numKeys = numKeys + 0; // leave it as is
            
           
        }
        return false;
    }
    
    /*
     * search - search for the specified key and return the
     * associated collection of values, or null if the key 
     * is not in the table
     */
    public Queue<Object> search(Object key) { // do I return all the values, how should I return it?
        /** Replace the following line with your implementation. **/
        //run through hash function 
        //check to see if the hash function key already exist
        //if it doesn't return null
        //if it does check to see if its the first one, if it's not run through the entire LLQueue
        // return value if you find it

        int searchKey = h1(key); // getting the search key
        //System.out.println("Searchkey:"+key);


        
        
        //System.out.println("table[searchKey].key: "+table[searchKey].key);
        Node trav = table[searchKey];
        //System.out.println(searchKey);
        if(table[searchKey] == null){
            return null;
        } else{
            //System.out.println("table[searchKey].key: "+key);
            //System.out.println("table:"+table);
            int j = 0;
            while(trav != null){
                //System.out.println("table[j].key: " + table[j].key);
                if(trav.key.equals(key)){
                    //System.out.println("Reached");
                    return trav.values;
                }
                j++;
                trav = trav.next;
            }
        }



        
        

        // if(table[searchKey] == null){
        //     return null;
        // } 
        // if(table[searchKey] != null){
            
            

        // }


        return null;
    }
    
    /* 
     * remove - remove from the table the entry for the specified key
     * and return the associated collection of values, or null if the key 
     * is not in the table
     */
    public Queue<Object> remove(Object key) {
        /** Replace the following line with your implementation. **/
        int searchKey = h1(key); // getting the search key

        Node trav = table[searchKey];
        Node prev = null;
        System.out.println(searchKey);
        if(table[searchKey] == null){
            return null;
        } else{
            
            while(trav != null){
                
                if(trav.key.equals(key) && prev != null && trav.next != null){ // middle node
                    System.out.println("Reached");
                    Queue<Object> tempValues = trav.values;
                    prev = trav.next;  //pointing to the following node
                    trav.next = null;
                    numKeys--;
                    return tempValues;
                } else if(trav.key.equals(key) && prev == null && trav.next != null){// first node
                    Queue<Object> tempValues = trav.values;
                    prev = trav;
                    table[searchKey] = trav.next; // assigning dummy head to following node
                    trav.next = null;
                    numKeys--;
                    return tempValues;
                } else if(trav.key.equals(key) && prev != null && trav.next == null){// end node
                    Queue<Object> tempValues = trav.values;
                    prev.next = null; // losing refernce of trav
                    numKeys--;
                    return tempValues;
                } else if(trav.key.equals(key) && trav.next == null){
                    Queue<Object> tempValues = trav.values;
                    table[searchKey] = null; // losing refernce of trav
                    numKeys--;
                    return tempValues;
                    
                }
                
                prev = trav;
                trav = trav.next;
            }
        }
            

        


        return null;
    }


    public int getNumKeys(){
        return numKeys;
    }

    public double load(){
        return (double) getNumKeys() / table.length;
    }

    public Object [] getAllKeys(){
        //arrive at a hash key
        // go through the linked list n*n times to find all keys without duplicates

        LLList getAllHumans = new LLList();

        for(int i = 0; i < table.length; i++){ // going through outer array
            if(table[i] != null){
                Node outerTrav = table[i];
                getAllHumans.addItem(outerTrav.key, 0); //adding an item to the node
                while(outerTrav != null){
                    Object currentkey = outerTrav.key;
                    int duplicateCounter = 0;
                    for(int j = 0; j < getAllHumans.length(); j++){
                        if(getAllHumans.getItem(j).equals(currentkey)){
                            duplicateCounter++;
                            continue;
                        }
                    }
                    if(duplicateCounter == 0){
                        getAllHumans.addItem(currentkey, 0);
                    }
                    outerTrav = outerTrav.next;
                }
                continue;
            }
            

        }

        Object [] darksouls = new Object [getAllHumans.length()];
        System.out.println(Arrays.toString(darksouls));
        System.out.println(getAllHumans.length());
        System.out.println(getAllHumans.toString());
        for(int i = getAllHumans.length()-1 ; i >= 0 ;i--){
        
            darksouls[i] = getAllHumans.getItem(getAllHumans.length()-1-i);
            System.out.println();
        }

        return darksouls;

    }
    public void resize(int girth){
        ChainedHashTable John117 = new ChainedHashTable(girth);

        for(int i = 0; i < table.length; i++){ // going through outer array 
            if(table[i] != null && table[i].next != null){ // duplicates
                System.out.println("["+i+"]: " + table[i].key);
                Node outerTrav = table[i];
                while(outerTrav != null){
                    John117.insert(outerTrav.key, outerTrav.values);
                    outerTrav = outerTrav.next;
                }
                
            } else{
                if(table[i] != null){
                    John117.insert(table[i].key, table[i].values);
                }
                
            }
            
        }
        table = John117.table;
        numKeys = John117.getNumKeys();


    }
    
    
    /*** Add the other required methods here ***/
    ChainedHashTable(int tableSize){ //constructor 
        if(tableSize < 0 ){ // valid arguments
            throw new IllegalArgumentException();
        }
        table = new Node[tableSize]; 
    }

   
    
    
    /*
     * toString - returns a string representation of this ChainedHashTable
     * object. *** You should NOT change this method. ***
     */
    public String toString() {
        String s = "[";
        
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                s += "null";
            } else {
                String keys = "{";
                Node trav = table[i];
                while (trav != null) {
                    keys += trav.key;
                    if (trav.next != null) {
                        keys += "; ";
                    }
                    trav = trav.next;
                }
                keys += "}";
                s += keys;
            }
        
            if (i < table.length - 1) {
                s += ", ";
            }
        }       
        
        s += "]";
        return s;
    }

    public static void main(String[] args) {
        /** Add your unit tests here **/
        // ChainedHashTable table = new ChainedHashTable(5);
        // table.insert("howdy", 15);
        // table.insert("goodbye", 10);
        // table.insert("apple", 5);
        // System.out.println(table);
        // table.resize(7);
        // System.out.println(table.getNumKeys());
        // System.out.println(table);

        // ran out of time for unti test :|


      
    }
}
