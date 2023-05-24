

public class Methods7 {
    public static void main(String[] args) {
        printDiag("method");
        
        System.out.println(lastN("programming", 5));
        //System.out.println( remSub("variable", "var"));
        //System.out.println(interLeave("Hello2", "World"));
       
    }

    public static String spaceMaker(String s, int i){ // prints space i amount of times
        String dash = s;
        
        return dash;
    }


    public static void printDiag(String s){ //print diagonal string of characters
        String space = " ";
        for (int i = 0; i < s.length(); i++) { // from printVerticle
            for(int j = 0; j < i; j++){
                System.out.print(space);
            }
            System.out.println(s.charAt(i));
        }
    }

    public static String lastN(String s, int n){ // i don't need a loop, but i already did it so Im not redoing it
        if(n > s.length()) return s;
         else{
            String last = "";
            last += s.substring(s.length()-n);
            return last;
        }
        
        
        
    }

    public static String remSub(String s, String sub){
        String c = "";
        int c_index = s.indexOf(sub);
        if(c_index == -1){
            return s;
        } else{
            //String del = s.replace(sub,"");
            c += s.substring(0,c_index) + s.substring(c_index+sub.length());
            return c;
        } 
        
    }

    public static String interleave(String s1, String s2){
        String s1_1 ="";
        if(s1.length() == 0){
            return s2;
        } else if (s2.length() == 0){
            return s1;
        }else if( s1.length() > s2.length()){
            for(int a = 0; a <s2.length(); a++){
                s1_1 += s1.charAt(a) + "" + s2.charAt(a);
            }
            s1_1 += s1.substring(s2.length()-1);
            return s1_1;
        } else if( s2.length() > s1.length()){
            for(int a = 0; a <s1.length(); a++){
                s1_1 += s1.charAt(a) + "" + s2.charAt(a);
            }
            s1_1 += s1.substring(s1.length()-1);
            return s1_1;
        
        } else if( s2.length() == s1.length()){
            for(int a = 0; a <s1.length(); a++){
                s1_1 += s1.charAt(a) + "" + s2.charAt(a);
            }
            //s1_1 += s1.substring(s1.length()-1);
            return s1_1;
        } else{
            return s1;
        }  

    }
    
}
