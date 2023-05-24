/**
 * Node
 */
public class Node {
    private int val;
        private Node next;
        public static void main(String[] args) {
            Node test = new Node();
            test.val = 1;
            test.next = null;
            
            Node newNode;


            while(true){

            }
            

        }



        public static int numEvenRec(Node first){
            if(first == null){
                return 0;
            } else{
                int countRest = numEvenRec(first.next);
                if(first.val %2 == 0){
                    countRest++;
                    return countRest;
                }
                else{
                    return countRest;
                }
            }
        }
    
}