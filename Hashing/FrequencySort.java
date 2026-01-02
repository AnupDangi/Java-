import java.util.*;
public class FrequencySort {
    
    public static String frequencySort(String s1){
        HashMap<Character,Integer> map=new HashMap<>();
        //store character and frequency
        for(int i=0;i<s1.length();i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
        }
        //use concept of priorityqueue 
        List<Character> characters=new ArrayList<>(map.keySet());

        //sort based on descending order
        characters.sort((a,b)->map.get(b)-map.get(a));

        //use string builder to build result string 
        StringBuilder sb=new StringBuilder();
        for(char c:characters){
            int frequency=map.get(c);
            //for appending 
            
            for(int i=0;i<frequency;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s1="cccaaa";
        System.out.println(frequencySort(s1));
    }
}
