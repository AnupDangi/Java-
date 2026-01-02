public class QueueLL {
    static class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class QueueULL{
        static Node head=null;
        static Node tail=null;
        


        public static boolean isEmpty(){
            return head==null &&tail==null;
        }

        //add 
        public static void add(int data){ //0(1)
            Node newNode=new Node(data);
            if(head==null)
            {
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public static void remove(){ //0(1)
            if(isEmpty()){
                System.out.println("Empty Queue");
                return;
            }
            int front=head.data;
            System.out.println("The deleted data is"+front);
            if(tail==head){
                tail=head=null;
            }
            else{
                head=head.next;
            }
        }
        public static int peekFront(){ //0(1)
            if (isEmpty()) {
                System.out.println("No element is there ");
                return -1;
            }
            else{
                return head.data;
            }
        }
        public static int peekLast()
        {
            if(isEmpty())
            {
                System.out.println("No element is there");
                return -1;
            }
            else{
                return tail.data;
            }
        }
        public static void displayAll(){
            if(isEmpty()){
                System.out.println("Queue is Empty ");
                return;
            }
            Node temp=head;
            while(temp.next!=null)
            {
                System.out.println(temp.data);
                temp=temp.next;
            }
            System.out.println(temp.data);
        }
    }
    public static void main(String[]args){
        //Here qull is queue using linked list
        QueueULL qull=new QueueULL();
        qull.add(1);
        qull.add(2);
        qull.add(3);
        qull.displayAll();
        System.out.println("The element at the front position is"+qull.peekFront());
        System.out.println("The element at the rear position is"+qull.peekLast());
        while(!qull.isEmpty())
        {
            //System.out.println(qull.peek());
            qull.remove();
        }
    }
    
}
