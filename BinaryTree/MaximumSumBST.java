public class MaximumSumBST {
    
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
    public static int maxSumBST(Node root){
        if(root==null){
            return 0;
        }
        if(root.data>root.left.data &&root.data<root.right.data){
            return maxSumBST(root.left);
        }
    }
    public static void main(String[] args) {
        Node root=new Node(5);
        root.left=new Node(9);
        root.left.left=new Node(6);
        root.left.left.left=new Node(8);
        root.left.left.right=new Node(7);
        root.right=new Node(2);
        root.right.right=new Node(3);

        int max=maxSumBST(root);
        System.out.println(max);
    }
}
