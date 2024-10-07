public class KthSmallestinBST {
    
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
    static int count=0;
    static int kSmall=0;
    public static int findKthSmallest(Node root,int k){

        return inorder(root, k);
    }
    public static int inorder(Node root,int k){
        if(root==null){
            return 0;
        }
        inorder(root.left, k);
        count++;
        if(count==k){
            kSmall=root.data;
        }
        inorder(root.right, k);
        return kSmall;
    }
    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(6);
        root.right=new Node(11);
        root.right.right=new Node(20);
        int k=3;
        int found=findKthSmallest(root,k);
        System.out.println(found);
    }
}
