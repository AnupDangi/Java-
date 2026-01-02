import java.util.*;
public class ValidAnagrams {
    
    public static boolean checkAnagram(String s,String t){
        HashMap<Character,Integer> hmap=new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                //occured more than one time
                if(hmap.containsKey(ch)){
                    hmap.put(ch, hmap.get(ch)+1);
                }
                //occured  for the first time
                else{
                    hmap.put(ch, 1);
                }
            }
            
            //for next t array remove the 
                for(int i=0;i<t.length();i++){
                    char ch=t.charAt(i);
                    //occured more than one time
                    if(hmap.get(ch)!=null){
                        if(hmap.get(ch)==1){
                            hmap.remove(ch);
                        }
                        else{
                             hmap.put(ch, hmap.get(ch)-1);
                        }
                    }
                    else{
                        return false;
                    }
    }
            return hmap.isEmpty();
}
    public static void main(String[] args) {
        //valid anagrams
        HashMap<Character,Integer> hmap=new HashMap<>();

        String s="knee";
        String t="keen";
        System.out.println(checkAnagram(s,t));
       
    }
}
