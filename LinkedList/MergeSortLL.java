public class MergeSortLL { //TC(nlogn)
    
    public static class Node{
        int data;
        Node next;
        public Node(int data)
        {
            this.data=data;
            this.next=null;
            
        }
    }
       public static Node head,tail;
        public static int size=0;

    public void addFirst(int data)
    {   
        Node newNode=new Node(data);
        size++;
        if(head==null)
        {
            head=tail=newNode;
            return;
        }   
        newNode.next=head;
        head=newNode;
    }
    public void printls()
    {
        if(head==null)
        {
            System.out.println("LinkedList is empty");
            return;
        }
        if(size==1)
        {
            System.out.print(head.data+ "null");
            size--;
            return;
        }
         Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
            size--;
        }
        System.out.println("null");
    }

     Node getMid(Node head)
    {
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow; //This is mid node
    }
    public Node merge(Node head1, Node head2)
    {   
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while(head!=null && head2!=null)
        {
            //for head1 data is less than or equals to head2 data
            if(head1.data<=head2.data)
            {
                //point the temp next to head1 
                temp.next=head1;
                //update the head1
                head1=head1.next;
                //update the temp node 
            }
            else{ //if head2 is less than head1

                temp.next=head2;
                //update the head2
                head2=head2.next;
            }
            temp=temp.next;
        }
            while(head1!=null)
            {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            while(head2!=null)
            {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        
        return mergedLL.next;
    }
     public Node mergeSort(Node head)
    {
        //if there is only one node then it is sorted and  return it 
        if(head==null ||head.next==null)
        {
            return head;
        }

        //else follow these steps 
        //1. find mid
        // call another method to find out mid

          Node mid=getMid(head);

        //2.left and right MS

        //right head will give another head for the next linkedlist
        Node rightHead=mid.next;
        mid.next=null; //break the left and right linked list making mid as null
        //call 
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

        //merge
        return merge(newLeft,newRight);

    }
        public void zigZag()
        {
            //find mid
            Node slow=head;
            Node fast=head.next;
            while(fast!=null &&fast.next!=null)
            {
                slow=slow.next;
                fast=fast.next.next;
            }
            Node mid=slow;

            //reverse 2nd half from the mid.next node
            Node curr=mid.next;
            mid.next=null;
            Node prev=null;
            Node next;
            while(curr!=null)
            {
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            Node left=head;
            Node right=prev;
            Node nextL,nextR;

            //alt merge
            while(left!=null && right!=null)
            {
                //zig zig the nodes using left and right ptr
                nextL=left.next;
                left.next=right;
                nextR=right.next;
                right.next=nextL;

                //update the left ptr to next of left and same for right as well
                left=nextL;
                right=nextR;
            }
        }
    public static void main(String[]args)
    {
        MergeSortLL msl=new MergeSortLL();
        msl.addFirst(2);
        msl.addFirst(3);
        msl.addFirst(1);
        msl.addFirst(4);
        msl.addFirst(5);
        //5->4->1->3->2
        msl.printls();
        msl.head=msl.mergeSort(msl.head);
        System.out.println("This is the sorted linked list");
        msl.printls();
        //1->2->3->4->5->null
        msl.zigZag();
        //1->5->2->4->3->null
        msl.printls();
    }
}
