import java.util.*;
public class ConnectNRopes {
    
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int arr[]={2,3,3,4,6};
        int i=0;
        while(i<arr.length){
            pq.add(arr[i]);
            i++;
        }
        
        int cost=0;
        while(pq.size()>1){
            int min1=pq.remove();
            int min2=pq.remove();
            cost+=min1+min2;
            pq.add(min1+min2);
        }
        System.out.println("Cost of connecting n ropes= "+cost);
    }
}
