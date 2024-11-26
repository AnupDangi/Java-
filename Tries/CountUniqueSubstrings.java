import java.util.*;
public class CountUniqueSubstrings {
    
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;

        Node(){
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
            eow=true;
        }
    }

    public static Node root=new Node();

    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            //check indx exist or not else add
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26 ;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        String str="apple";
        //suffix ->insert in trie
        for(int i=0;i<str.length();i++){
            String suffix=str.substring(i);
          //create trie
            insert(suffix);
        }
        //count nodes
        System.out.println(countNodes(root));
    }
}
 