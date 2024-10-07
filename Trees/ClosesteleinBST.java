public class ClosesteleinBST {
    
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

    static int minDiff=Integer.MAX_VALUE;
    static int closeNode=0;
    public static int findtargetNode(Node root,int target){
        if(root==null){
            return closeNode;
        }
        if(root.data==target){
            return root.data;
        }
        
        //calculate min diff
        int currDiff=Math.abs(root.data-target);

        if(currDiff<minDiff){
            minDiff=currDiff;
            closeNode=root.data;
        }
        if(target<root.data){
            return findtargetNode(root.left, target);
        }
        else{
            return findtargetNode(root.right, target);
        }
    }
    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(6);
        root.right=new Node(11);
        root.right.right=new Node(20);
        System.out.println(findtargetNode(root, 12));

    }
}
