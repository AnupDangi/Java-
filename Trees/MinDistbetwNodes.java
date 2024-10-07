public class MinDistbetwNodes {
    
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
    public static Node lca2(Node root,int n1,int n2){ //0(n) TC no extra space

        //base case
        if(root==null||root.data==n1 || root.data==n2){
            return root;
        }

       Node leftlca=lca2(root.left,n1,n2);
        Node rightlca=lca2(root.right,n1,n2);
        
        //leftlca=valid  ||rightlca==null
        if(rightlca==null){
            return leftlca;
        }
        if(leftlca==null){
            return rightlca;
        }
        return root;

    }
    public static int lcaDist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }

        int leftDist=lcaDist(root.left, n);
        int rightDist=lcaDist(root.right,n);

        if(leftDist==-1 &&rightDist==-1){
            return -1;
        }
        else if(leftDist==-1){
            return rightDist+1;
        }
        else{
            return leftDist+1;
        }
    }
    public static int MinDist(Node root,int n1,int n2){

        Node lca=lca2(root,n1,n2);
        int dist1=lcaDist(lca,n1);
        int dist2=lcaDist(lca,n2);

        return dist1+dist2;
    }
    public static int kthAncestor(Node root,int node,int k){
        if(root==null){
            return -1;
        }
        if(root.data==node){
            return 0; 
        }
        
        int leftDist=kthAncestor(root.left, node,k);
        int rightDist=kthAncestor(root.right,node,k);

        if(leftDist==-1 && rightDist==-1){
            return -1;
        }
        int max=Math.max(leftDist,rightDist);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }
    public static int TransformToSum(Node root){
        if(root==null){
            return 0;
        }
        int leftchild=TransformToSum(root.left);
        int rightchild=TransformToSum(root.right);
        int data=root.data;
        
        int newLeft=root.left==null?0:root.left.data;
        int newRight=root.right==null?0:root.right.data;
        
        root.data=leftchild+newLeft+newRight+rightchild;

        return data;
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[]args){

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        int n1=4,n2=7;
        System.out.println(MinDist(root,n1 , n2));
        int node =5,k=1;
        kthAncestor(root,node,k);
        /*
         sum of n nodes
             1 
            /  \
            2   3
            / \ / \  
            4 5 6 7

            Expected Output
                 27
                /  \
                9  13
               / \ / \
               0  0 0 0 
         */

         TransformToSum(root);
         preorder(root);
    }
}
