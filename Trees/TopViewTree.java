import java.util.*;
public class TopViewTree {
   
    static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    //hd refers to horizontal distance
    static class Info{
        Node node;
        int hd;
        public Info(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topView(Node root){ //0(n) TC
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();

        int min=0,max=0;
        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            //For horizonatal distance imagine a 2d plane with -ve +ve when we move to left the hd decreases by 1
            //as we move to right the hd increases by 1 
        else{
            if(!map.containsKey(curr.hd)){ //first time my hd is occuring
                map.put(curr.hd,curr.node); //hd acts as key and node as value
            }
            if(curr.node.left!=null){
                q.add(new Info(curr.node.left, curr.hd-1)); // 
                min=Math.min(min,curr.hd-1);
            }            
            //increase by 1
            if(curr.node.right!=null){
                q.add(new Info(curr.node.right,curr.hd+1));
                max=Math.max(max,curr.hd+1);
                }
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
    }
    public static void main(String[]args){

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        topView(root);
    }

}
