import java.util.*;
public class SlidingWindowMaximum {
    
    //This approach takes 0(nlogk) TC
    static class Pairs implements Comparable<Pairs>{
        int value; 
        int indx;

        public Pairs(int value,int index){
            this.value=value;
            this.indx=index;
        }
        @Override
        public int compareTo(Pairs p2){
            //compare based on descending order
            return p2.value-this.value;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=new int[arr.length-k+1];

        PriorityQueue<Pairs> pq=new PriorityQueue<>();

        //Step 1. add first max element into pq

        for(int i=0;i<k;i++){
            pq.add(new Pairs(arr[i], i));
        }

        //first max element that is the first maximum element
        res[0]=pq.peek().value;


        //step2  traverse from k to length of array and then add and remove based on the condition given below 
        for(int i=k;i<arr.length;i++){
            //remove the unbounded index which is less than i-k 
            while(pq.size()>0 && pq.peek().indx<=(i-k)){
                pq.remove();
            }
            pq.add(new Pairs(arr[i], i));
            res[i-k+1]=pq.peek().value;
        }
        int i=0;
        while (i<res.length) {
            System.out.print(res[i]+" ");
            i++;
        }
    }

}
