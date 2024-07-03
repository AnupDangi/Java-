import java.util.*;
public class LinkedListPalindrome {
    public  static class Node
    {
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
        if(head==null)
        {
            head=tail=newNode;
            size++;
            return;
        }
        newNode.next=head;
        head=newNode;
        size++;
    }
    public void addLast(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=tail=newNode;
            size++;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        size++;
    }

    public void deleteFront(int data)
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        int val=head.data;
        System.out.println("The data which is deleted is "+val);
        head=head.next;
        size--;
    }

    public void deleteLast(int data)
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp!=tail)//till secondlast index
        {
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;
    }   
    public void printlist()
    {
            if(head==null)
            {
                System.out.println("List is empty");
                return;
            }
            Node temp=head;
            while(temp!=null)
            {
                System.out.print(temp.data+"->"+" ");
                temp=temp.next;
            }
            System.out.println("null");

    }

    //To Find Palindrome
    //1.Find the middle node
    //2.Reverse the second half of the linkedlist
    //3.check if (1st half==2ndhalf)

    //1. find middle node Using Slow Fast Approach
    private Node findMid(Node head) 
    {
        Node slow =head;
        Node fast=head;
        while(fast!=null &&fast.next!=null)
        {
            slow=slow.next; //+1
            fast=fast.next.next;//2
        }
        return slow; //this is midNode
    }
     //
     public boolean checkPalindrome()
     {
        //if head points to no element and head.next ==null base condition
        if(head==null||head.next==null)
        {
            return true;
        }
        //step 1. find mid
        Node midNode=findMid(head);

        // step2 . reverse 2nd half
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null)
        {
            // update and assign the prev curr and next
            next=curr.next; // find the next node 
            curr.next=prev; // link back the curr.next to prev
            prev=curr;//make prev as curr and update 
            curr=next; //update the next as curr
        }
        Node right=prev; //right half head
        Node left=head;  

        //step 3 - Check left half and right half

        while(right!=null)
        {
            if(left.data!=right.data)
            {
                return false;
            } 
            left=left.next;
            right=right.next;
        }
           
        return false;
     }
     public static boolean isCycle() //Floyd's Cycle Finding Algorithm(FCFA)
     {
        Node slow=head;
        Node fast=head;

        while(fast!=null &&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                System.out.println("This is the node at which the linked list is circular : "+ slow.data);
                return true; //Cycle exist
            }
        }
        return false; //cycle dosent exist
     }
     public static void printList()
     {
        if(head==null)
        {
            System.out.println("The list is empty");
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
     }
     public static void removeCycle()
     {
        // 1.detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
            {
                cycle=true;
                break;
            }
        }
            if(cycle==false)
            {
                return;
            }
        //1. Find metting point

        slow=head;
        Node prev=null;
        while(slow!=fast)
        {
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        //1. remove cycle-> last.next=null ie prev
        prev.next=null;
     }

    public static void main(String[]args)
    {
        // LinkedListPalindrome llp=new LinkedListPalindrome();
        // llp.addFirst(2);
        // llp.addFirst(1);
        // llp.addLast(3);
        // llp.addLast(4);
        // llp.addLast(5);
        // llp.printlist();
        // System.out.println(llp.size);
        // System.out.println(llp.checkPalindrome());

        //create a cyclic linked list
        head=new Node(1);
        Node temp=new Node(2);
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=temp;
        //1->2->3->2
        
        //Cycle exist
        System.out.println(isCycle());
       // printList();
        removeCycle();
        //Cycle doesnot exist
        System.out.println(isCycle());
        
    }
}
