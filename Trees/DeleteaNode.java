import java.util.*;

import javax.naming.LinkException;
public class DeleteaNode {
    
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
    public static Node BuildBST(Node root,int value){
        if(root==null){
            root=new Node(value);
            return root;
        }
        //build left bst
        if(value<root.data){
            root.left=BuildBST(root.left, value);
        }
        //build right bst
        else{
            root.right=BuildBST(root.right, value);
        }
        return root;
    }

    public static boolean SearchNode(Node root,int key){
        if(root==null){
            return false;
        }
        if(key==root.data){
            return true;
        }
        //key is greateer than root
        if(key>root.data){
            return SearchNode(root.right, key);
        }
        else{
            return SearchNode(root.left, key);
        }
    }
    public static void inorder(Node root,List<Integer>arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        //arr.add(root.data);
        System.out.print(root.data+" ");
        inorder(root.right,arr);
    }

    public static Node delete(Node root,int value){
        if(root.data<value){
            root.right=delete(root.right, value);
        }
        else if(root.data>value){
            root.left=delete(root.left, value);
        }
        else{//found the value to delete
            //Case 1 -leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2 -node contains one child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            //case 3-both children
            //always the inorder successor node is present on the right of the root 
            Node inOrdSuc=findInOrderSuccessor(root.right);
            root.data=inOrdSuc.data;
            root.right=delete(root.right, inOrdSuc.data);
        }
        return root;
    }
    //Utility Function to calculate inOrder Successor
    public static Node findInOrderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printInRange(Node root,int k1,int k2){
       if(root==null){
            return;
       }
        //Case 1: lies between left and right subtree
        if(root.data>=k1 &&root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        //Case 2 : if root.data is less than k1 
        else if(root.data<k1){
            printInRange(root.left, k1, k2);
        }
        //Case 3: if root.data is greater than k1
        else{
            printInRange(root.right, k1, k2);
        }
    }
    public static void printPath(ArrayList<Integer>path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null\n");
    }
    public static void printRoot2Leaf(Node root,ArrayList<Integer> path){
       
        if(root==null){
            return;
        }
        path.add(root.data);

        if(root.left==null &&root.right==null){
            printPath(path);
        }

        else{
            printRoot2Leaf(root.left,path);
            printRoot2Leaf(root.right,path);
        }
         path.remove(path.size()-1);
    }
    //0(n)
    public static void ValidateBST(Node root){
        List<Integer> arr=new ArrayList<>();
        inorder(root,arr);

     for(int i=1;i<arr.size();i++){
        if(arr.get(i)<=arr.get(i-1)){
            System.out.println("this is not a valid bst");
            return;
        }
     }
     System.out.println("this is a valid bst");
    }
    //Approach 2 TC 0(n)
    public static boolean isValidBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }

        //1.min!=null compare with root left
        if(min!=null && root.data<=min.data){
            return false;
        }
        // compare with root right
        else if(max!=null &&root.data>=max.data){
            return false;
        } 
        else{
            //for left subtree max is root and for right subtree min is root and max is max
            return isValidBST(root.left, min, root)&& isValidBST(root.right, root, max);
        }
    }
    public static Node mirrorBST(Node root){
        if(root==null){
            return null;
        }
       Node leftsubtree=mirrorBST(root.left);
        Node rightsubtree=mirrorBST(root.right);
        root.left=rightsubtree;
        root.right=leftsubtree;
        return root;
    }
    public static void main(String[] args) {
        // int nodes[]={8,5,3,1,4,6,10,11,14};
        // Node root=null;
        // for(int i=0;i<nodes.length;i++){
        //     root=BuildBST(root,nodes[i]);
        // }
        // inorder(root);
        // System.out.println("\n"+SearchNode(root,5));
        // root=delete(root,5);
        // System.out.println();
        // inorder(root);
        // System.out.println();   
        // printInRange(root, 5, 12);

        Node root=new Node(8);
        root.left=new Node(5);
        root.right=new Node(10);
        root.left.left=new Node(3);
        root.left.right=new Node(6);
        root.right.right=new Node(11);

        // printRoot2Leaf(root,new ArrayList<>());
        // ValidateBST(root);
        // if(isValidBST(root, null, null)){
        //     System.out.println("valid");
        // }
        // else{
        //     System.out.println("Not valid");
        // }
        mirrorBST(root);
        inorder(root, null);
    }
} 
