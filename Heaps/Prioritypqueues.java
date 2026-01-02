import java.util.*;
public class Prioritypqueues {
    
    public static void main(String[] args) {
        //PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        pq.add(55);//add 0(logn)
        pq.add(34);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());//0(1)
            pq.remove();
        }
    }
}
