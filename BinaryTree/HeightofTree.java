public class HeightofTree {
    
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    public static int heightTree(Node root){
        if(root==null){
            return 0;
        }
        int leftht=heightTree(root.left);
        int rightht=heightTree(root.right);

        //Concept for leftist binary tree

        // if(leftht>rightht){
        //     System.out.println("This is leftist tree");
        // }
        return Math.max(leftht,rightht)+1;
    }
    //Count number of nodes
    public static int countNodes(Node root){
        
        if(root==null){
            return 0;
        }
            int leftcount=countNodes(root.left);
            int rightcount=countNodes(root.right);

        return leftcount+rightcount+1;
    }
    //Calculate Sum of Nodes
    public static int sumofNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftsum=sumofNodes(root.left);
        int rightsum=sumofNodes(root.right);
        return leftsum+rightsum+root.data;
    }
    //Calculate the diameter of a tree
    //Approach 0(n^2)

    public static int diameter1(Node root){
        if(root==null){
            return 0;
        }
        //left diam and right diam
        int leftDiam=diameter1(root.left);
        int rightDiam=diameter1(root.right);
        //Height of left and right tree
        int leftht=heightTree(root.left);
        int rightht=heightTree(root.right);

        //Self diameter
        int selfDiam=leftht+rightht+1;
        return Math.max(selfDiam,Math.max(leftDiam,rightDiam));
    }
    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
    public static Info diameter(Node root){//0(n)
        if(root==null){
            return new Info(0, 0);
        }

        Info leftInfo=diameter(root.left);
        Info rightInfo=diameter(root.right);

        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;

        return new Info(diam, ht);
    } 
    public static void main(String[]args){

        /*
              1 
            /  \
            2  3
           / \ / \  
           4 5 6 7
         
        */

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);

        root.right.left=new Node(6);
        root.right.right=new Node(7);
        
        System.out.println("The height of the tree is:"+heightTree(root));
        //Count total number of nodes
        System.out.println("The total number of nodes are:"+countNodes(root));
        //sum of nodes
        System.out.println("The total sum of nodes is "+sumofNodes(root));
        System.out.println("The diameter of tree is : "+diameter1(root));
        System.out.println("The diameter of the tree is "+diameter(root).diam);
    }
 
}
