public class SearchBST {
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
        //if less than root node
        if(value<root.data){
            root.left=BuildBST(root.left, value);
        }
        else{
            root.right=BuildBST(root.right, value);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean searchBST(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return searchBST(root.left, key);
        }
        else{
           return searchBST(root.right, key);
        }

    }
    public static void main(String[] args) {
        
        int values[]={8,5,6,3,4,1,10,11,14};

        Node root=null;
        for(int i=0;i<values.length;i++){
            root=BuildBST(root,values[i]);
        }
        inorder(root);
        int key=1;
        //0(H) time complexity 
        System.out.println((searchBST(root, key))?"found":"NotFound");

    }
}
