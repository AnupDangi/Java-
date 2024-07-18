import java.util.*;
public class JCFQueue {
    
    public static void main(String[]args){
        //Queue is implement using two classes one is LinkedList
        //1.Using Linkedlist class
        //2. ArrayDeque
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(4);
    //    / q.remove();
        while(!q.isEmpty()){
            System.out.println(q.peek()); 
            q.remove();
           }
        
        Queue<Integer> qd=new ArrayDeque<>();
        qd.add(1);
        qd.add(2);
        qd.add(3);
        qd.remove();
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
