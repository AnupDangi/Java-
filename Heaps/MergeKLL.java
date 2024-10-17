import java.util.*;
import java.io.*;
    
    class Node{
        int data;
        Node link;

        Node(int data){
            this.data=data;
            link=null;
        }
    }
    //creating a comparable class of Node type to compare all the elements in ascending order

    class NodeComparator implements Comparator<Node>{
        public int compare(Node k1,Node k2){
            if(k1.data>k2.data){
                return 1;
            }
            else if(k1.data<k2.data){
                return -1;
            }
            return 0;
        }
    }

public class MergeKLL {

    //pass array of node and no of linked list
    static Node mergeKList(Node[] arr,int k){

        PriorityQueue<Node> queue=new PriorityQueue<>(new NodeComparator());

        Node at[]=new Node[k];
        Node head=new Node(0);
        Node last=head;
        for(int i=0;i<k;i++){
            if(arr[i]!=null){
                queue.add(arr[i]);
            }
        }
        if(queue.isEmpty()){
            return null;
        }

        while(!queue.isEmpty()){
            Node curr=queue.poll();
            last.link=curr;
            last=last.link;
            if(curr.link!=null){
                queue.add(curr.link);
            }
        }
        return head.link;
    }

    public static void printList(Node node){
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.link;

        }
    }
        
    public static void main(String[] args) {
        int k=3,N=3;
        //first sorted LL
        Node [] ll=new Node[N];
        Node head1=new Node(1);
        ll[0]=head1;
        head1.link=new Node(3);
        head1.link.link=new Node(5);
        head1.link.link.link=new Node(7);
        
        //second sorted LL
       
        Node head2=new Node(2);
        ll[1]=head2;
        head2.link=new Node(4);
        head2.link.link=new Node(6);
        head2.link.link.link=new Node(8);


        //third sorted LL
        Node head3=new Node(0);
        ll[2]=head3;
        head3.link=new Node(9); 
        head3.link.link=new Node(10);
        head3.link.link.link=new Node(11);

        Node res=mergeKList(ll,N);
        if(res!=null){
            printList(res);
        }
        System.out.println();
    }
}
