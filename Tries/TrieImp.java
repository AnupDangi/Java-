import java.util.*;
public class TrieImp {
    
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false; //end of word

        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    } 
    public static Node root=new Node();
    public static void insert(String word){ //0(L)//largest word length
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    //serach in trie
    public static boolean serachword(String key){
            Node curr=root;
            for(int level=0;level<key.length();level++){
                int idx=key.charAt(level)-'a';
                if(curr.children[idx]==null){
                    return false;
                }
                curr=curr.children[idx];
            }
            return curr.eow==true;
    }

    public static void main(String[] args) {//0(L)
        String words[]={"the","a","there","their","any","thee"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(serachword("the"));
        System.out.println(serachword("thor"));
        System.out.println(serachword("any"));
        System.out.println(serachword("an"));

    }
}
