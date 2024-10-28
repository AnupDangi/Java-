import java.util.*;
public class WordBreakProb {
    
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;

        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root= new Node();

    //insert
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int indx=word.charAt(i)-'a';
            if(curr.children[indx]==null){
                curr.children[indx]=new Node();  
            }
            curr=curr.children[indx];
        }
        curr.eow=true;
    }

    //serach
    public static boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    public static boolean wordBreak(String key){//0(n)
        //base case
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            //substring (begidx,lastidx)
            if(search(key.substring(0,i))&&
                wordBreak(key.substring(i))){
                    return true;
                }
            }
            return false;
        }
    
    public static void main(String[] args) {
         
       String arr[]={"i","like","sam","samsung","mobile","ice"};
       for(int i=0;i<arr.length;i++){
            //insert 
            insert(arr[i]);
       }
       String key="ilikesamsung";
       System.out.println(wordBreak(key));
    }
}
