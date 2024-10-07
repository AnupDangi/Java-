import java.util.*;
public class SortedArraytoBalBST {

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

    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node createBalancedBST(int arr[],int st,int end){

        //base case
        if(st>end){
            return null;
        }

        int mid=(st+end)/2;
        Node root=new Node(arr[mid]);
        //create root left subtree
        root.left=createBalancedBST(arr, st, mid-1);
        root.right=createBalancedBST(arr, mid+1, end);
        
        return root;
    }
    public static void inOrder(Node root,List<Integer>arr){
        if(root==null){
            return;
        }
        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }
    public static Node createBST(List<Integer>arr,int st,int end){
       if(st>end){
        return null;
       }
        int mid=(st+end)/2;
        Node root =new Node(arr.get(mid));
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }
    public static Node BalancedBST(Node root){
        if(root==null){
            return null;
        }
        //to store sorted array 
        List<Integer> arr=new ArrayList<>();
        inOrder(root, arr);
        //to create the balanced bst using previous 
        root=createBST(arr, 0, arr.size()-1);
        return root;
    }
    public static void 
    public static void main(String[]main){
        // int arr[]={3,5,6,8,10,11,12};

        //     /*
        //               8
        //             /  \
        //             5   11
        //            / \  /  \
        //            3  6 10 12
        //      */ 

            //  Node root=createBalancedBST(arr, 0, arr.length-1);
            //  preOrder(root);
            Node root=new Node(8);
            root.left=new Node(6);
            root.right=new Node(10);
            root.left.left=new Node(5);
            root.left.left.left=new Node(3);
            root.right.right=new Node(11);
            root.right.right.right=new Node(12);
            root= BalancedBST(root);
            preOrder(root);
    }
    
}
