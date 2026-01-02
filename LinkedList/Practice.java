import java.util.LinkedList;

public class Practice {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head = null, tail = null;
    public static int size = 0;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void printls() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void getIntersection(Node head1, Node head2) // TC O(l1*l2) no of nodes in l1 and l2 lists
    {
        System.out.println(" ");
        int nofound = 0;
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp.data == head2.data) {
                    System.out.println("The intersection node is " + temp.data);
                    return;
                } else {
                    nofound = 0;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        if (nofound == 0) {
            System.out.println("There is no intersection point");
        }
    }

    // public void deleteMnodesafterNnodes(Node head,int movepos, int deleteNnodes)
    // {
    // Node temp = head,update;
    // int count;
    // while (temp != null) {
    // // Move temp to the node after N nodes
    // for ( count = 1; count <=movepos && temp != null; count++) {
    // temp = temp.next;
    // }

    // // Check if temp is null or if there are no more nodes to process
    // if (temp == null) {
    // return;
    // }
    // update=temp.next;
    // for(count=1;count<=deleteNnodes&& update != null;count++)
    // {
    // Node curr=temp;
    // update=update.next;
    // }
    // temp.next=update;
    // temp=update;
    // }
    // }

    public static Node deleteNodesAfterMNodes(Node head, int M, int N) {
        Node curr = head;
        Node prev = null;
        int count;

        while (curr != null) {
            // Skip M nodes
            for (count = 1; count <= M && curr != null; count++) {
                prev = curr;
                curr = curr.next;
            }

            // Delete next N nodes
            for (count = 1; count <= N && curr != null; count++) {
                Node temp = curr;
                curr = curr.next;
                temp.next = null; // Disconnect node from the list
            }

            // Update pointers to skip deleted nodes
            prev.next = curr;
        }

        return head;
    }

    public void swapNodes(int posnode1, int posnode2) {
        if (posnode1 == posnode2) {
            return;
        }
        Node prev1 = null, curr1 = head;
        Node prev2 = null, curr2 = head;
        // Find nodes at positions
        for (int i = 1; curr1 != null && i < posnode1; i++) {
            // update prev
            prev1 = curr1;
            curr1 = curr1.next;
        }
        for (int i = 1; curr2 != null && i < posnode2; i++) {
            prev2 = curr2;
            curr2 = curr2.next;
        }

        // Check if nodes at posnode1 and posnode2 exist
        if (curr1 == null || curr2 == null) {
            System.out.println("Nodes are not found");
        }
        // Update pointers to swap nodes

        if (prev1 != null) {
            prev1.next = curr2;
        } else {
            head = curr2;
        }
        if (prev2 != null) {
            prev2.next = curr1;
        } else {
            head = curr1;
        }

        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;

    }

    public void segregateEvenOdd() {
        //if list is null
        if (head == null || head.next == null) {
            return; // No need to segregate if the list is empty or has only one node
        }

        Node end = head;
        Node prev = null;
        Node curr = head;

        //Find the end node 
        while (end.next != null) {
            end = end.next;
        }

        Node newEnd = end;
        
        // segregate the odd nodes to the end 
        while (curr.data % 2 != 0 && curr != end) {
            newEnd.next = curr;
            curr = curr.next;
            newEnd.next.next = null;
            newEnd = newEnd.next;
        }
        
        //if curr node is even then move to the beginning ie head updating prev and curr to track the nodes
        if (curr.data % 2 == 0) {
            head = curr;
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    newEnd.next = curr;
                    newEnd = curr;
                    curr = prev.next;
                }
            }
        }
         else {
            prev = curr;
        }
        //handling the case for last node is odd
        if (newEnd != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            newEnd.next = end;
        }
    }
     
    //Merging N lists
    public  Node SortedMerge(Node a,Node b) // this function sorts each node element among two nodes at a time
    {
        //create a result node to return and compare 
        Node result=null;
        if(a==null)
        {
            return b;
        }
        else if(b==null)
        {
            return a;
        }
        //if the first node data is smaller or equals make it as result and make recursive call with first node.next and compare with b
        if(a.data<=b.data)
        {
            result=a;
            result.next=SortedMerge(a.next,b);
        }
        else{
            //if not so then b is the smallest and call b.next
            result=b;
            result.next=SortedMerge(a,b.next);
        }
        return result; // return the result to the caller  
    }

    // This method is used to merge the array of list and make recursive call to SortedMerge and sort the two list elements
    public Node mergeKLists(Node arr[],int last)
    {
        //here last is the number of lists
        while(last!=0)
        {
            int i=0,j=last;
            //until i reaches the last node
            while(i<j)
            {
                //assign to arr[i] after sorting 
                arr[i]=SortedMerge(arr[i],arr[j]); //for the first call node[0] and node[2]ie last node is passed with head
                i++;
                j--;
                if(i>=j)
                {
                    last=j;
                }
            }
        }
        return arr[0]; //return the first arr[0] node as head through which nodes can be accessed
    }


    public void printList(Node node)
    {
        while(node!=null)
        {
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
    
    public static void main(String[] args) {
        Practice ll = new Practice();
        // ll.addFirst(1);
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addLast(4);
        // ll.addLast(5);

        // Node head1, head2;
        // head1 = new Node(10);
        // head2 = new Node(3);

        // Node newNode = new Node(6);
        // head2.next = newNode;

        // newNode = new Node(9);
        // head2.next.next = newNode;

        // newNode = new Node(15);
        // head1.next = newNode;

        // head2.next.next.next = newNode;
        // newNode = new Node(30);

        // head1.next.next = newNode;
        // head1.next.next.next = null;
        // ll.getIntersection(head1, head2);

        // Output
        // head1 -> 10->15->30
        // |
        // V
        // head2 -> 3->6->9->15->30
        // ll.printls();

        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printls();
        int movepos = 2;
        int deleteNnodes = 2;
        // Node result=deleteNodesAfterMNodes(head,movepos,deleteNnodes);

        System.out.println("\n Linked list after deletion");
        // ll.swapNodes(2,4); //it works
        ll.segregateEvenOdd();
        ll.printls();


        //This input is only for Merging three lists
        int k=3;//list
        int n=4;//data
        Node arr[]=new Node[k];

            //list 1
        arr[0]=new Node(1);
        arr[0].next=new Node(3);
        arr[0].next.next=new Node(4);
        arr[0].next.next.next=new Node(5);

        //list2
        arr[1]=new Node(2);
        arr[1].next=new Node(4);
        arr[1].next.next=new Node(6);
        arr[1].next.next.next=new Node(8);
    
        //list3
        arr[2]=new Node(0);
        arr[2].next=new Node(9);
        arr[2].next.next=new Node(10);
        arr[2].next.next.next=new Node(11);
        
        System.out.println("This is the sorted merged list of three lists");

        Node head=ll.mergeKLists(arr,k-1);
        ll.printList(head);




    }
}
