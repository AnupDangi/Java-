public class QueueBasics{
    static class Queue {
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        // Constructor
        public Queue(int newsize)
        {
            size=newsize;
            arr=new int[size];
            rear=-1;
            front=-1;
        }
        public static boolean isEmpty()
        {
                return rear==-1;
        }
        public static void add(int data)
        {
            if(rear==size-1)
            {
                System.out.println("Queue is full");
                return;
            }
            if(front==-1)
            {
                front=0;
            }
            arr[++rear]=data;
        }
        public static void delete()
        {
            if(isEmpty())
            {
                System.out.println("Queue is Empty");
                return;
            }
                System.out.println("The deleted element is :"+arr[front]);
                if(front>=rear)
                {
                    front=-1;
                    rear=-1;
                }
                else{
                        front++;
                }
        }
        public static void display()
        {
            if(isEmpty())
            {
                System.out.println("Queue is empty");
                return;
            }

            for(int i=front;i<=rear;i++)
            {
                System.out.println(arr[i]);
            }  
        }
    }
        public static void main(String[] args) {
            Queue q=new Queue(5);//size
            q.add(5);
            q.add(6);
            q.add(7);
            q.add(8);
            q.add(9);
            q.display();
            q.delete();
            q.display();
        }
    }
