import java.util.*;
public class TopViewofBT {
   static class Node{
        int data;
        Node left;
        Node right;
        int hd;
       public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            this.hd=Integer.MAX_VALUE;
        }
    }
    //Approach
    //1.Use horizontal distance concept
    //2.Create a TreeMap to store all horizontal distance and other array value node along with curr node
    //3. if horizontaldistance doesnot exist into map then add
    //4.if exist compare the existing hd with curr update the maximum hd 
    public static void bottomViewHelper(Node root,int curr,int hd,TreeMap<Integer,int[]>map){
        if(root==null){
            return;
        }
        //if node for a particular HD is not present,add into map
        if(!map.containsKey(hd)){
            map.put(hd,new int[]{root.data,curr});
        }

        //compare height for already present node at similar horizontal distance
        else{
            int []p=map.get(hd);
            //update the currnode if it is greater or equals to height 
            if(p[1]<=curr){
                p[1]=curr;
                p[0]=root.data;
            }
            //update the map with the modified entry
            map.put(hd, p);
        }
        //call for left subtree
        //for left horizontal distance decreases by one and node increases by 1
        bottomViewHelper(root.left, curr+1, hd-1, map);
        //for right horizontal distance increases and node increases by one 
        bottomViewHelper(root.right, curr+1, hd+1, map);
    }

    public static void printBottomView(Node root){
        //Map to store Horizontal Distance ,Height and Data.
        TreeMap<Integer,int[]>map=new TreeMap<>();
        bottomViewHelper(root, 0, 0, map);

        //prints the values stroed in map
        for(int val[]:map.values()){
            System.out.print(val[0]+" ");
        }
    }
    public static void main(String[] args) {

      Node root=new Node(20);
      root.left=new Node(8);
      root.right=new Node(22);
      root.left.left=new Node(5);
      root.left.right=new Node(3);
      root.right.left=new Node(4);
      root.right.right=new Node(25);
      root.left.right.left=new Node(10);
      root.left.right.right=new Node(14);
      System.out.println("Bottom View of the given binary tree:");
      printBottomView(root);
    }
}
