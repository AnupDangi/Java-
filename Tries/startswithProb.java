import java.util.*;

public class startswithProb {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        

        Node(){
            for(int i=0;i<children.length;i++){
                //initialize 
                children[i]=null;
            }
        }
    }
    public static Node root=new Node();

    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            //if idx is new add else move to its children and check 
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            //update search in its children node
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static boolean startswith(String prefix){
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[]={"apple","app","mango","man","woman"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(startswith("apple"));
        System.out.println(startswith("moon"));

    }
}
