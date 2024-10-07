public class RangeSumBST {
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
    public static int sum=0;    
    public static int SumofRange(Node root,int k1,int k2){
        if(root==null){
            return 0;
        }
        if(root.data>=k1&& root.data<=k2){
            sum+=root.data;
        }
        SumofRange(root.left, k1, k2);
        SumofRange(root.right, k1, k2);

        return sum;
    }  
    public static void main(String[] args) {

            Node root=new Node(8);
            root.left=new Node(5);
            root.right=new Node(11);
            root.left.left=new Node(3);
            root.left.right=new Node(6);
            root.right.right=new Node(20);

            //ranges 
            int k1=3;
            int k2=20;
            System.out.println(SumofRange(root,k1,k2));

        }    
}
