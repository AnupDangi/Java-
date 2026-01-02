import java.util.*;
public class Prefix {
    
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int freq;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
                freq=1;
        }
    }
    public static Node root=new Node();

    public static void insert(String word){ //count frequency ,and create new node if not of that character exist in trie else update
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            else{
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
        }
           curr.eow=true;
    }

    public static void findPrefix(Node root,String ans){ //0(L) no of levels in a trie ie longest word 
        //approach to find the prefix 
        //pass root and ans string with empty string check if children ! is null and add that character into ans and when root.frequency 
        //is 1 then print that answer. 
        if(root==null){
            return;
        }
        if(root.freq==1){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<root.children.length;i++){

            if(root.children[i]!=null){
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        String words[]={"zebra","dog","duck","dove"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        root.freq=-1;
        findPrefix(root, "");
    }
}
