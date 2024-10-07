public class Subtree {
    
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
    //when the subroot matches with first matched node data then this function works
    public static boolean isIdentical(Node node,Node subroot){
       //Identical condition 1 for null
        if(node==null &&subroot==null){
            return true;
        }
        //Non-identical condition for null
        else if(node==null ||subroot==null||node.data!=subroot.data){
            return false;
        }
        //left subtree is non-identical
        if(!isIdentical(node.left, subroot.left)){
            return false;
        }
        //right subtree is non-identical
        if(!isIdentical(node.right, subroot.right)){
            return false;
        }
        //else this part is true 
        return true;
    }

    //Check for the complete match with subtree
    public static boolean isSubtree(Node root,Node subroot){
        if(root==null){
            return false;
        }
        if(root.data==subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        // boolean leftAns=isSubtree(root.left, subroot);
        // boolean rightAns=isSubtree(root.right, subroot);
        
        return isSubtree(root.left, subroot)||isSubtree(root.right, subroot);
        
    }
 
    public static void main(String[] args) {
        /*
        - Tree
              1 
            /  \
            2  3
           / \ / \  
           4 5 6 7
         
        
        - Subtree
            2  
            / \   
            4 5
            
    */
    Node root=new Node(1);
    root.left=new Node(2);
    root.right=new Node(3);
    root.left.left=new Node(4);
    root.left.right=new Node(5);
    root.right.left=new Node(6);
    root.right.right=new Node(7);

    //Subtree 
        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);

        System.out.println(isSubtree(root, subroot)); 
    }
} 
