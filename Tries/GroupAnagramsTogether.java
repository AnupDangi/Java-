import java.util.*;
class TrieNode{
    List<String>data;
    TrieNode children[];
    boolean isEnd;
    TrieNode(){
        data=new ArrayList<>();
        children=new TrieNode[26];
        isEnd=false;
    }
}
public class GroupAnagramsTogether {
    static TrieNode root;
    List<List<String>>ans;
    public List<List<String>> groupAnagrams(String[]strs){
        ans=new ArrayList<>();
        root=new TrieNode();

        for(String word:strs){
            build(word);
        }
        dfs(root);

        return ans;
    }
    public void build(String s){
        TrieNode temp=root;
        char[]word=s.toCharArray();
        Arrays.sort(word);
        for(char c:word){
            TrieNode child=temp.children[c-'a'];
            if(child==null){
                temp.children[c-'a']=new TrieNode();
            }
            temp=temp.children[c-'a'];
        }
            temp.isEnd=true;
            temp.data.add(s);
    }
    public void dfs(TrieNode root){
        if(root.isEnd){
            ans.add(root.data);
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                dfs(root.children[i]);
            }
        }
    }
    public static void main(String[] args) {
        String strs[]={"eat","tea","tan","ate","nat","bat"};
        GroupAnagramsTogether gat=new GroupAnagramsTogether();
        System.out.println(gat.groupAnagrams(strs));
    }
}
