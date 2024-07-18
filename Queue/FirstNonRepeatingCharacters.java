import java.util.*;
public class FirstNonRepeatingCharacters {
    
    public static void printNonRepeating(String str){
        int freq[]=new int[26];//'a-z'
        Queue<Character> chq=new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            chq.add(ch);
            freq[ch-'a']++;

            //until queue is empty and freq of letter is >1 remove the element from the front
            while(!chq.isEmpty() &&freq[chq.peek()-'a']>1){
                chq.remove();
            }
            //if all the leters are removed means there are all repeating charcters so print -1
            if(chq.isEmpty())
            {
                System.out.print(-1+"");
            }
            //else print the letter
            else{
                System.out.print(chq.peek()+" ");
            }
        }
    }
    public static void main(String[]args){
        String abc="aabccxb";
        printNonRepeating(abc);
    }
}
