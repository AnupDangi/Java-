import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MergeBST {
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    public static void getInOrder(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        getInOrder(root.left, arr);
        arr.add(root.data);
        getInOrder(root.right, arr);
    }
    public static Node mergeBST(Node root1,Node root2){

        //step1 
        ArrayList<Integer> arr1=new ArrayList<>();
        getInOrder(root1,arr1);

        //step2
        ArrayList<Integer> arr2=new ArrayList<>();
        getInOrder(root2, arr2);

        //merge
        int i=0,j=0;
        ArrayList<Integer> merge=new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            //if arr1 elem is less than arr2 elem
            if(arr1.get(i)<arr2.get(j)){
                merge.add(arr1.get(i));
                i++;
            }   

            else{
                merge.add(arr2.get(j));
                j++;
            }
        }

        //remaining elem
        while (i<arr1.size()) {
            merge.add(arr1.get(i));
            i++;
        }
        //for remaining elem
        while (j<arr2.size()) {
            merge.add(arr2.get(j));
            j++;
        }

        //returning the merged sorted array 
        return createBST(merge,0,merge.size()-1);
   }

   public static Node createBST(ArrayList<Integer>arr,int st,int end){
        
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr.get(mid));
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
   }

   public static void  preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
   }
   public static void main(String[] args) {
        /*
             2
            / \
            1 4 
            BST1

             9
            / \
            3 12
            BST2
         */

         Node root1=new Node(2);
         root1.left=new Node(1);
         root1.right=new Node(4);

         
         Node root2=new Node(9);
         root2.left=new Node(3);
         root2.right=new Node(12);


         //Approach 
         //sort both BST1 and BST2 
         //Merge the inorder of both bst1 and bst2 and sort them as well.
        //create bst with the merged array using binary search concept      

        // 0(n+m)->linear

                  /*
                        3
                      /  \ 
                     1    9
                     \    \
                      2    12 
                        
                */

         Node root=mergeBST(root1,root2);
         preOrder(root);
    }
}
