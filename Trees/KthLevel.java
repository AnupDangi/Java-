import java.util.*;

public class KthLevel {
    
    public static class Node{
        int data;
        Node left; 
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    //Here LOT refers to level order traversal
    public static void KLevelLOT(Node root,int level,int k ){

        //Create a queue 
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                level++;
                if(!q.isEmpty()){
                    q.add(null);
                }
                if(level>k){
                     break;
                }
            }
            else{
                if(level==k){
                    System.out.print(currNode.data+" ");
                }

                //enqueue the left and right children for the next level
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }
    //using recursion TC 0(n)
    public static void KLevel(Node root,int level,int k){
        //base case
        if(root==null){
            return;
        }
        //If matches the level then print and return back 
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }

          //left parent call and check recursively
        KLevel(root.left, level+1, k);
        //Same for right as well
        KLevel(root.right,level+1,k);
    }
    public static void main(String[]args){

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        int k=3;
        System.out.println("Using Recursion");
        KLevel(root, 1, k);
        System.out.println("\nUsing Level Order Traversal");
        KLevelLOT(root, 1, k);
    } 
}
