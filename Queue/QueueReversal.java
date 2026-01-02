import java.util.*;
public class QueueReversal {

    public static void queueReverse(Queue<Integer> q){
        //Create a temporary Stack and push all the elements from the front of the queue
        Stack<Integer> stk=new Stack<>();
        while(!q.isEmpty()){
            stk.push(q.remove());
        }
        //Printing the elements while popping from the stack
        while(!stk.isEmpty())
        {
            q.add(stk.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.addAll(Arrays.asList(1,2,3,4,5));
         for(Integer num:q){
            System.out.println(num);
         }

        queueReverse(q);
        System.out.println(q);
    }

}

