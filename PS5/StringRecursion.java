
public class StringRecursion {
    public static void main(String[] args) {
        System.out.println(trim(" hello   world "));
        //System.out.println(lastIndexOf('r', "roreororro"));
        //System.out.println(contains("recursion", 'z'));
        //printEveryOther("method");
    }


    public static void printEveryOther (String str){
        //final String STR = str;
        //check null cases
        //base case
        //recursive case
        if(str == null || str.equals("")){
            System.out.println();
        }
        if(str.length() == 1){
            System.out.print(str.charAt(0));
        }else{
            printEveryOther(str.substring(0, str.length()-1));
            if(str.indexOf(str.charAt(str.length()-1)) % 2 == 0){
                System.out.print(str.substring(str.length()-1));
            } else{
                //System.out.println("Hello: " + str.charAt(str.length()-1));
                System.out.print("");
            }
            
         
        }

    }

    public static boolean contains(String str, char ch){
        //base case
        //go back in string
        if(str == null || str.equals("")){
            return false;
        }
        if(str.length() == 1){
            return false;
        }else{
            boolean cont = contains(str.substring(0, str.length()-1), ch);
            if((cont == true)){
                cont = true;
                return cont;
            } else if(str.charAt(str.length()-1) == ch){
                //System.out.println("Hello: " + str.charAt(str.length()-1));
                cont = true;
                return cont;
            } else{
                cont = false;
                return cont;
            }
            
         
        }

    }

    public static int lastIndexOf(char ch, String str){
         //base case
        //go back in string
        if(str == null || str.equals("")){
            return -1;
        }
        if(str.length() == 0){
            return -1;
        }else{
            int last = lastIndexOf(ch,str.substring(0, str.length()-1));
            // System.out.println(" Index: " + str.indexOf(str.charAt(str.length()-1)));
            // System.out.print(" Char: " + str.charAt(str.length()-1) );
            // System.out.print(" last:" + last);
            // System.out.print(",  str.charAt(str.length()-1) == ch " + (str.charAt(str.length()-1) == ch));
            if(str.charAt(str.length()-1) == ch){
                //System.out.println("lasst: " );
                //System.out.println("Hello: " + str.charAt(str.length()-1));
                last = str.length()-1;
                return last;
            } else{
                return last;
            }
            
         
        }
    }

    public static String trim(String str){
        
        if(str == null){
            return null;
        } if(str.equals("")){
            return "";
        }
        if(str.equals(' ')){
            return str;
        } else if(str.length() == 0){
            return "";
        } else{
            String string = "";
            if(str.charAt(0) == ' '){
                string = trim(str.substring(1)); // leading spaces
            } else{
                string = str;
                if(str.charAt(str.length()-1) == ' '){
                    string = trim(str.substring(0,str.length()-1));

                } else{
                    string = str;
                }
                
            }
            return string;
        }
        

        
        
            
         
        
    }

  
}
