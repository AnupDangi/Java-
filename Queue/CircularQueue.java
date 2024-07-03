public class CircularQueue {
    
         static class CQueue{
           static  int size;
            static int front;
            static int rear;
            static int Carr[];
            
            CQueue(int newsize)
            {
                size=newsize;
                Carr=new int[size];
                rear=-1;
                front=-1;
            }

            public static boolean isEmpty(){
                return front==-1;
            }

            public static boolean isFull(){
                return (rear+1)%size==front;
            }

            public void add(int data)
            {
                if(isFull())
                {
                    System.out.println("Queue is full ");
                    return;
                }
                if(front==-1)
                {
                    front=0;
                }
                rear=(rear+1)%size;
                Carr[rear]=data;
            }
            
            public static void remove()
            {
                    if(isEmpty())
                    {
                        System.out.println("Queue is Empty");
                        return;
                    }
                    int result=Carr[front];
                    //last element delete 
                    if(rear==front)
                    {
                        rear=-1;
                        front=-1;
                    }
                    else{
                        front=(front+1)%size;
                    }
                    System.out.println("The returned element  is"+result);
            }

            public static void display()
            {
                if(isEmpty())
                {
                    System.out.println("Queue is Empty");
                }
                else{
                    int i=front;
                    while(true)
                    {
                        System.out.println(Carr[i]);
                        if(i==rear)
                        {
                             break;
                        }
                        i=(i+1)%size;
                    }
                    System.out.println();
                }
            }
        }
            public static void main(String[]args)
            {
               CQueue cq=new CQueue(5);
               cq.add(5);
               cq.add(6);
                cq.add(7);
                cq.add(8);
                cq.add(9);
                cq.display();
                cq.remove();
                cq.display();
                cq.add(9);
                cq.display();
                cq.remove();
                cq.display();
                cq.add(10);
                cq.display();

            }
}
