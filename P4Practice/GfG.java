
import java.util.Scanner;
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Class containing the function to remove Nth node from end
public class GfG {

    // remove the Nth node from last
    static Node removeNthFromEnd(Node head, int N) {
      
        // Initialize two pointers, fast and slow
        Node fast = head;
        Node slow = head;

        // Move fast pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (fast == null)
                return head; 
            fast = fast.next;
        }

        // If fast is null, remove the head node
        if (fast == null) {
            return head.next;
        }

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the Nth node from the end
        slow.next = slow.next.next;

        return head;
    }

    // This function prints the contents of the linked list
    static void printList(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();               // consume leftover newline
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

        head = removeNthFromEnd(head, n);
        printList(head);
    }

}