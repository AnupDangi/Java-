import java.util.HashMap;
public class Practice {
    
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
  public static boolean checkUnivalued(Node root){
    if(root==null){
        return true;
    }
    if(root.left!=null&&root.data!=root.left.data){
        return false;
    }
    if(root.right!=null &&root.data!=root.right.data){
       return false;
    }
    return checkUnivalued(root.left)&&checkUnivalued(root.right);
  }

  public static Node invertBinaryTree(Node root){
 
    if(root==null){
        return null;
    }
    //swap left and right subtrees
    Node lefttree=invertBinaryTree(root.left);
    Node righttree=invertBinaryTree(root.right);
    root.left=righttree;
    root.right=lefttree;

    return root;
  }
  public static void preorder(Node root){
    if(root==null){
        return;
    }
    System.out.println(root.data+" ");
    preorder(root.left);
    preorder(root.right);
  
}
public static Node delleafNodes(Node root,int value){
    if(root==null){
        return null;
    }
    root.left=delleafNodes(root.left, value);
    root.right=delleafNodes(root.right, value);
    if(root.data==value &&root.left==null &&root.right==null){
        return null;
    }
    return root;
    
}
    static HashMap<String,Integer> map=new HashMap<>();
    public static String inorder(Node root){
        if(root==null){
            return "";
        }
        String str="(";
        str+=inorder(root.left);
        str+=Integer.toString(root.data);
        str+=inorder(root.right);
        str+=")";

        //check the nonrepetead string and add into substring 
        map.put(str,map.getOrDefault(str, 0)+1);

        //if it is occuring more that once print the root
        if(map.get(str)==2){
            System.out.print("\nDuplicate Subtree root: "+root.data);
        }
        return str;
    }

    public static void printAllDups(Node root){
        
        inorder(root);
    }
            static int maxpathsum(Node root){
                //int maxValue[]=new int[1];
            int maxValue=Integer.MIN_VALUE;
                MaximumPathSum(root, maxValue);
                return maxValue;
            }
            //logic function and helper function
            //passed array to store maxvalues and compare max value for left right and data 
            public static int MaximumPathSum(Node root,int maxValue){
                    if(root==null){
                        return 0;
                    }
                    int leftsum=MaximumPathSum(root.left,maxValue);
                    int rightsum=MaximumPathSum(root.right,maxValue);
                    maxValue=Math.max(maxValue,leftsum+rightsum+root.data);
                    return root.data+Math.max(leftsum,rightsum);
            }
    public static void main(String[] args) {
        
        // Node root=new Node(2);
        // root.left=new Node(2);
        // root.right=new Node(2);
        // root.left.left=new Node(2);
        // root.left.right=new Node(2);

        // Node root=new Node(1);
        // root.left=new Node(2);
        // root.right=new Node(3);
        // root.left.left=new Node(4);
        // root.left.right=new Node(5);
        // root.right.left=new Node(6);
        // root.right.right=new Node(7);

        // Node root=new Node(1);
        // root.left=new Node(3);
        // root.right=new Node(3);
        // root.left.left=new Node(3);
        // root.left.right=new Node(2);
        R
        // Node root=new Node(1);
        // root.left=new Node(4);
        // root.right=new Node(3);
        // root.left.left=new Node(3);
        // root.right.left=new Node(4);
        // root.right.right=new Node(3);
        // root.right.left.left=new Node(3);

        Node root=new Node(-10);
        root.left=new Node(9);
        root.right=new Node(20);
        root.right.left=new Node(15);
        root.right.right=new Node(7);

        // System.out.println(checkUnivalued(root));
        // invertBinaryTree(root);
        // int value=3;
        // delleafNodes(root, value);
        // preorder(root);
        //Find all duplicate Subtrees
        //printAllDups(root); 
        System.out.println(maxpathsum(root));
    }
}
