import java.util.ArrayList;

public class LowestCommonAncestor {
    
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
    public static boolean getPath(Node root,int n,ArrayList<Node>path){
        if(root==null){
            return false;
        }

        path.add(root);

        if(root.data==n){
            return true;
        }
        boolean foundLeft=getPath(root.left, n, path);
        boolean foundright=getPath(root.right, n, path);
        
        if(foundLeft||foundright){
            return true;
        }

        //remove when the rootdata doesnot match with the node data 
        path.remove(path.size()-1);
        return false;
    }

    public static Node LCA(Node root,int n1,int n2){//0(n) for both TC and Space Complexity (SP)
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();

        getPath(root,n1,path1);//0(n)
        getPath(root,n2,path2);//0(n)
        
        //Last Common Ancestor
        int i=0;//0(n)
        for(;i<path1.size() &&i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break; 
            }
        }
        //last equal node ->i-1th index
            Node lca=path1.get(i-1);
            return lca;
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
    public static void main(String[]args){

    /*  Tree

             1 
            /  \
            2   3
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

        int n1=4,n2=7;
        System.out.print("The loweset Common Ancestor is "+LCA(root,n1,n2).data);
         System.out.print("\nThe loweset Common Ancestor is "+lca2(root,n1,n2).data);
    }   
}


