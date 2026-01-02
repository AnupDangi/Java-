import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class ReverseLinkedlist {

    
public static Node reverseLL(Node head){
    Node prev=null;
    Node curr=head;
    while(curr!=null){
        Node next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    return prev;
}

public static void printList(Node head){
    Node curr=head;
    while(curr!=null){
        System.out.print(" "+curr.data);
        curr=curr.next;
    }
}
public static Node middleNode(Node head) {
    Node slow = head, fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
            // consume leftover newline
    String str = sc.nextLine();  // full line with spaces

    String[] parts = str.trim().split("\\s+"); // split by spaces

    Node head = null;
    Node temp = null;

    for (String p : parts) {
        int val = Integer.parseInt(p);
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            temp = newNode;
        } else {
            temp.next = newNode;
            temp = temp.next;
        }
    }
    System.out.println(middleNode(head).data);
    printList(head);

    // head = reverseLL(head);
    printList(head);
    }
}
