import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueUsingDeque {
    
    static class Queue{
        Deque<Integer>deque=new LinkedList<>();
        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            return deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
        
        public boolean isEmpty(){
            return deque.isEmpty();
        }
    }

    public static void main(String[]args){
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
