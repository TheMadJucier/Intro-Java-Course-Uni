public class midtermPractice {
    

   

    public static void main(String[] args) {
        String s1 = removePadding("--------------Hello--World---");
        System.out.println(s1);
        
        
        
        

    }
    public static String removePadding(String s){
        if(s == null){
            throw new IllegalArgumentException();

        }
        if(!(s.charAt(0) == '-' )){
            return s;
        }
        if(!(s.charAt(0) == '-' ) && !(s.charAt(s.length()-1) == '-')){
            return s;
        }
        else{
            String paddingRest = removePadding(s.substring(1));
            String paddingRest2 = removePadding(paddingRest.substring(0, paddingRest.length()-1));
            return paddingRest2;
        }
    }
    
}
