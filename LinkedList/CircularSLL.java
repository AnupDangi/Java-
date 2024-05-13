public class CircularSLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head, tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
        size++;

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("The linked list doesn't contain any node");
            return;
        }
        head = head.next;
        tail.next = head;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            head = tail = null;
            System.out.println("The linked list doesn't contain any node");
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int val = tail.data;
        System.out.println("The deleted node is" + val);
        tail = temp;
        tail.next = head;
        size--;
    }

    public void addmiddle(int data, int index) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = newNode;
            return;
        }
        int track = 0;
        Node temp = head;
        while (track < index - 1) {
            temp = temp.next;
            track++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    

    public void printls() {
        Node temp = head;
        System.out.print(temp.data + "->");
        temp = temp.next;
        while (temp != head) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("head");
    }
    
    public static void main(String[] args) {
        CircularSLL csll = new CircularSLL();
        csll.addFirst(5);
        csll.addFirst(3);
        csll.addFirst(2);
        csll.addFirst(1);
        csll.addLast(5);
        csll.addLast(8);

        // 1->2->3->5->5->8->head
        csll.printls();
        csll.removeFirst();
        csll.removeLast();
        csll.addmiddle(6, 2);
        csll.printls();
    }
}
