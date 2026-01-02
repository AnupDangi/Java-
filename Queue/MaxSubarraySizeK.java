import java.util.*;
public class MaxSubarraySizeK {
    
    public static int[] slidingWindow(int arr[],int k){
        int ans[]= new int[arr.length-k+1];
        //Using Deque we can solve this problem
        Deque<Integer> deq=new LinkedList<>();
        int max=0;
        int ansidx=0;
        for(int i=0;i<arr.length;i++)
        {
            //remove numbers from out of poll
            if(!deq.isEmpty()&&deq.peek()==i-k){
                deq.poll();
            }
            while(!deq.isEmpty() &&arr[deq.peekLast()]<arr[i]){
                deq.pollLast();
            }
            deq.offer(i);
            if(i>=k-1){
                ans[ansidx++]=arr[deq.peek()];
            }
        }
        return ans;
    }
    public static void main(String[]args){
        int n=9;
        int k=3;
        int arr[]={1,2,3,1,4,5,2,3,6};
        //output expected 3 3 4 5 5 6
        //This problem is basically sliding window problem
        System.out.println(Arrays.toString(slidingWindow(arr,k)));
    }
}
