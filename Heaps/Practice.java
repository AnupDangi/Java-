import java.util.*;

public class Practice {
    static PriorityQueue<Integer> pq=new PriorityQueue<>();

    static List<Integer> getminkList(int arr[],int k){
        List<Integer> result=new LinkedList<>();
        for(int val:arr){
            if(pq.size()<k){
                pq.add(val);
            }
            else{
                if(val>pq.peek()){
                    pq.poll();
                    pq.add(val);
                }
            }
            if(pq.size()>=k){
                result.add(pq.peek());
            }
            else{
                result.add(-1);
            }
        }
        return result;

    }
    public static void main(String[] args) {
        int arr[]={10,20,11,70,50,40,100,5 };
        int k=3;
        List<Integer> list=getminkList(arr,k);
        for( int x:list){
            System.out.print(x+" ");
        }
      
    }
}
