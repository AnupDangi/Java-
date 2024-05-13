import java.util.*;

public class DoublyLL {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head, tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        // tail=newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("The linked list is empty");
            return;
        }
        if(size==1)
        {
            int val=head.data;
            System.out.println("The deleted node is"+val);
            head=tail=null;
            size--;
            return;
        }
        int val=head.data;
        System.out.println("The deleted node is"+val);
        head = head.next;
        head.prev=null;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("The linked list is empty");
            return;
        }
         
        if (size==1) {
            int val=tail.data;
            System.out.println("The deleted node is"+val);
            head = tail = null;
            size--;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        int val=temp.data;
        System.out.println("The deleted node is"+val);
        temp=temp.prev;
        temp.next=null;
        tail=temp;
        size--;
    }

    public void printtailpos() {
        if (tail != null) {
            System.out.printf("The tail is at position index %d and data is %d\n ", size, tail.data);
            tail = tail.next;
        }
    }

    public void printls() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverseDll()
    {
        if(head==null)
        {
            return;
        }
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;

    }
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        // dll.addLast(9);
        // dll.addLast(10);
        // dll.printls();
        dll.printtailpos();
        System.out.println("This is the linked list before deleting the first node");
        dll.printls();
        System.out.println("This is the linked list after deleting the first node");
        // Remove First
        // dll.removeFirst();
        // dll.printls();
        // Remove last
        dll.removeLast();
        dll.removeLast();
        dll.printls();
        dll.reverseDll();
        dll.printls();
        System.out.println(size);
    }

    // public static void main(String[]args)
    // {
    // This is the dynamically user based linked list size and node data

    // DoublyLL dll=new DoublyLL();
    // Scanner sc=new Scanner(System.in);
    // int totaldata=sc.nextInt();
    // int nodedata[]=new int[totaldata];
    // //first scan all the data then call the methods
    // for(int i=0;i<totaldata;i++)
    // {
    // nodedata[i]=sc.nextInt();
    // }
    // for(int i=0;i<nodedata.length;i++)
    // {
    // //call the methods
    // dll.addFirst(nodedata[i]);
    // dll.addLast(nodedata[i]);
    // }

    // // dll.addLast(9);
    // // dll.addLast(10);
    // //dll.printls();
    // dll.printtailpos();
    // System.out.println("This is the linked list before deleting the fist node");
    // dll.printls();
    // System.out.println("This is the linked list after deleting the fist node");
    // dll.removeFirst();
    // dll.printls();
    // System.out.println(size);
    // }
}
