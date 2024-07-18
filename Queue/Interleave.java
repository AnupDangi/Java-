import java.util.*;

public class Interleave {
    

    public static void interLeave(Queue<Integer>q){
        Queue<Integer> firstHalf=new LinkedList<>();
        int size=q.size();
        //removing the first half element from the main queue to firsthalf temopary Queue
        for(int i=0;i<size/2;i++){
            firstHalf.add(q.remove());
        }
        //Until the firstHalf is empty remove each element and add to the main queue's rear and remove the main's queue's element form
        //the front and add to the rear of main queue or same queue this should be done after addition from firsthalf is done consecutively

        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[]args){
        Queue<Integer> q=new LinkedList<>();
        //q.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.println("Before Interleaving");
        System.out.println(q);
        System.out.println("After Interleaving");
        interLeave(q);
        System.out.println(q);
        
    }
}
