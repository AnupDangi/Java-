import java.util.*;
public class DequeImplement {
    
    public static void main(String[] args) {   
        Deque<Integer> deque=new LinkedList<>();
        deque.addFirst(1);//1
        deque.addFirst(2);//2
        deque.addLast(4);
        deque.addLast(6);
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Peeked from front"+deque.getFirst());
        System.out.println("Peeked from Rear"+deque.getLast());
        System.out.println(deque);
    }
}
