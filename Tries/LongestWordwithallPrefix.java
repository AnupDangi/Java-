import java.util.*;
public class LongestWordwithallPrefix {
    
     static class Node{
        Node children[]=new Node[26];
        boolean eow;

        Node(){
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
        }
     }
     public static Node root=new Node();

     public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
     } 
     public static boolean searchword(String key){
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
     public static String ans="";
     public static void longestWord(Node root,StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){  //a ,b,c,d smaller lexicography
            if(root.children[i]!=null && root.children[i].eow==true){
                    char ch=(char)(i+'a');
                    temp.append(ch);
                    if(temp.length()>ans.length()){
                        ans=temp.toString();
                    }
                    //recursive call
                    longestWord(root.children[i], temp);
                    //backtrack
                    //and remove the last index element 
                    temp.deleteCharAt(temp.length()-1);
                }
        }
     }
    public static void main(String[] args) {
        String words[]={"a","banana","app","appl","ap","apply","apple"};
        
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
