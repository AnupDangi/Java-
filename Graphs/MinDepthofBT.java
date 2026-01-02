import java.util.*;
public class MinDepthofBT {

    static class Node{
        int data;
        Node left,right;
    }

    static class qItem{
        Node node;
        int depth;

        public qItem(Node node,int depth){
            this.node=node;
            this.depth=depth;
        }
    }

    static int minDepth(Node root){ //0(n)
        if(root==null){
            return 0;
        }
        //Taking an extra memroy for Queue which stores nodes information along with its depth 
        Queue<qItem> q=new LinkedList<>();
        qItem qi=new qItem(root, 1);
        q.add(qi);
        
        while(!q.isEmpty()){ //BFS fashion code take left and right nodes and add into queue and check left and right node and increment depth 
                qi=q.remove();
                Node node=qi.node;
                int depth=qi.depth;
                if(node.left==null &&node.right==null){
                    return depth;
                }       
                if(node.left!=null){
                    qi.node=node.left;
                    qi.depth=depth+1;
                    q.add(qi);
                }
                if(node.right!=null){
                    qi.node=node.right;
                    qi.depth=depth+1;
                    q.add(qi);
                }
        }
        return 0;
    }

    static Node newNode(int data){
        Node temp=new Node();
        temp.data=data;
        temp.left=temp.right=null;
        return temp;
    }
        public static void main(String[] args) {
        Node root=newNode(1);
        root.left=newNode(2);
        root.right=newNode(3);
        root.left.left=newNode(4);
        root.left.right=newNode(5);
        

        System.out.println(minDepth(root));
    }
    
}
