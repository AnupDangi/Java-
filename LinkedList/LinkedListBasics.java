import java.util.ArrayList;
import java.util.Arrays;
public class LinkedListBasics {
    
    public static class Node{
        int data;
        Node next; // next is reference var similar to pointer which is self refrential pointer of 
        // same type as in C

        public Node(int data) //Node class constructors 
        {
            // refer to current data and next ptr or ref var in memory ie null for the first node
            this.data=data;
            this.next=null;
        }
    }
        // make head and tail node
        public static Node head,tail;
        public static int size;
        //public static Node tail;

        public void addFirst(int data)
        {
            //step1 =create new node
             Node newNode=new Node(data);
             size++;
            //base case
            if(head==null)
            {
                //if head is null that means there is no node
                head=tail=newNode;
                return;
            }
            //step2
            //link the newnode to head 
            newNode.next=head;//link

            //step3 head=newnode
            head=newNode;
        }
        public void addLast(int data)
        {
            //create newnode to add at last
            Node newNode=new Node(data);
            size++;
            // checks whether there exist a node or not
            if(head==null)
            {
                head=tail=newNode;
                return;
            }
            //step1 point newnode to tail
           tail.next=newNode;
            // step2 update the tail
            tail=newNode;
            //step3 update the next of newnode or tail as
        }

        public void printList() //0(n)
        {
            if(head==null)
            {
                System.out.print("Linked List is null");
            }
            // point temp to head
              Node temp=head;
            // traverse till the null of Linkedlist
            while(temp!=null)
            {
                System.out.print(temp.data+"->"+"");
                temp=temp.next;
            }
            System.out.println("null");
        }

        public void addmiddle(int data, int index) //0(n)
        {
            if(index==0)
            {
                addFirst(data);
                return;
            }
            Node newNode=new Node(data);
            size++;
            Node temp=head; //for traversal
            int i=0; //track temp
            while(i<index-1)
            {
                //update the temp
                temp=temp.next;
                i++;
            }
            // when temp-> previous of the temp next 
            //update the newnode 
            newNode.next=temp.next;
            temp.next=newNode;
        }  

        // public void sizeLinkedlist() 0(n)
        // {
        //     Node temp=head;
        //     int count=1;
        //     while(temp.next!=null)
        //     {
        //         temp=temp.next;
        //         count++;
        //     }
        //     System.out.println(count);
        // }

        public void removeFirst()
        {
            if(head==null)
            {
                System.out.println("List is empty");
                return;
            }
            if(size==1)
            {
                int val=head.data;
                head=tail=null;
                System.out.println("The the deleted value is" +val);
                size=0; //for the single node after removing
                return;
            }
            int val=head.data;
            // assign the head with the next of head garbage will be collected by java garbage collector
            head=head.next;
            System.out.println("The deleted node is "+val);
            size--;
        }
        public void removeLast()
        {
            //to traverse through the list
            Node temp=head;

            if(head==null)
            {
                System.out.println("List is empty");
                return;
            }
            //if we have single node
            if(size==1)
            {
                int val=tail.data;
                head=tail=null;
                System.out.println("The deleted node is "+val);
                size=0;
                return;
            }
            //traverse till the secondlast
            while(temp.next!=tail) // goes till the secondlast node of the list
            {
                temp=temp.next;
            }
            int val=tail.data;
            System.out.println("The node to be deleted is "+val);
            temp.next=null;
            tail=temp; //make the new tail
            size--;
        }
        public int searchKeyiterative(int key)
        {
            Node temp=head;
            int i=0;
            while(temp!=null)
            {
                //key found
                if(temp.data==key)
                {
                    return i;  //return index
                }
                temp=temp.next;
                i++;
            }
            //key not found
            return -1;
        }
        // This is the recursive function which recursively changes the head and return value
        public int helper(Node head,int key) //0(n)
        {
            if(head==null)
            {
                return -1;
            }
            if(head.data==key)
            {
                return 0;
            }
            int index=helper(head.next,key);
            if(index==-1)
            {
                return -1;
            }
            return index+1;
        }
        //important
        public int recursiveSearch(int key)
        {
            return helper(head,key);
        }
        
        public void reverselist()
        {
            Node prev=null;
            Node curr=head;
            Node next;

            while(curr!=null)
            {
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            head=prev;
        }
        //mostimp
        public void deleteNthfromEnd(int n)
        {
            //calculate size
            int size=0;
            Node temp=head;
            while(temp!=null)
            {
                temp=temp.next;
                size++;
            }
            if(n==size)
            {
                head=head.next; //remove first node
                return;
            }
            //other cases size-n
            Node prev=head;
            int i=1; //start index
            int iToFind=size-n;
            while(i<iToFind) //runs till the prev node
            {
                prev=prev.next;
                i++;
            }
            // 
            prev.next=prev.next.next;
        }
        //imp
        public void deletenthandnthnodeplusfromEnd(int n, int nthPlus) 
        {
            int size=0;
            Node temp=head;
            while(temp!=null)
            {
                temp=temp.next;
                size++;
            }
            Node prev=head;
            int i=1;
            int totraverse=(size-n);
            while(i<totraverse)
            {
                prev=prev.next;
            }
            prev.next=prev.next.next.next;

        }
        //Check palindrome using ArrayList
        public boolean checkpalindrome(ArrayList<Integer>list)
        {
            int start=0;
            int end=list.size()-1;
            while(start<end)
            {
                if(list.get(start)!=list.get(end))
                {
                    return false;
                }
                start++;
                end--;
            }
            return true;
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
        LinkedListBasics ll=new LinkedListBasics(); 

        // Dont write operation in main methods perform operations in method
        // ll.head=new Node(1);
        // ll.head.next =new Node(2);
        ll.addFirst(2);
        ll.addFirst(1);           
        ll.addLast(3);
        ll.addLast(4);
        ll.addmiddle(9, 2);
        System.out.println("Size of Singly Linked List is "+ll.size);
        ll.printList();
        ll.removeFirst();
        System.out.println("Size of Singly Linked List is "+ll.size);
        ll.printList();
        ll.removeLast();
        System.out.println("Size of Singly Linked List is "+ll.size);
        ll.printList();
        int searchkey=ll.searchKeyiterative(3);
        System.out.printf("key is found at %dnd index using iterative method\n",searchkey);
        System.out.printf("Key is found at %dnd using recursive method\n",ll.recursiveSearch(3));
        //ll.reverselist();
        ll.printList();
        //ll.deleteNthfromEnd(3);
        ll.printList();
        ll.deletenthandnthnodeplusfromEnd(3,4);
        ll.printList();
        ArrayList<Integer>list=new ArrayList<>();
        list.addAll(Arrays.asList(1,2,1,2,1));
        System.out.println(ll.checkpalindrome(list));
        System.out.println("The linkedlist below is a zigzag linkedlist");
        ll.addFirst(1);
        ll.addLast(5);
        ll.addFirst(3);
        ll.addFirst(5);
        ll.printList();
        ll.zigZag();
        ll.printList();
       // ll.sizeLinkedlist();
    }
}
