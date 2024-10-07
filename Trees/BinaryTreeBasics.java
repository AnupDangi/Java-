import java.util.*;
public class BinaryTreeBasics {
   static class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        this.left=left;
        this.right=right;
        }
   }
   public static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
   
    //To print in preorder format
    public static void preorder(Node root){
        if(root==null){
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }   
    //Inorder
    public static void inorder(Node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    //Postorder
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    //Using queue concept
    public static void levelOrder(Node root){
        System.out.println();
        System.out.println("LevelOrder: ");

        if(root==null){
            return;
        }
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }
            else{
                System.out.print(currNode.data +" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }
}
    public static void main(String[]args){
        //build tree 
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        System.out.println("Preorder:");
        tree.preorder(root);
        System.out.println(" \nInOrder: ");
        tree.inorder(root);
        System.out.println("\nPostOrder: ");
        tree.postorder(root);
        tree.levelOrder(root);
    }
} 