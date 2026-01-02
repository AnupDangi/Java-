import java.util.*;
public class MinOpToHalfSum {
    
    static int minops(ArrayList<Integer> nums){
        int sum=0;
        //get the sum of the array
        for(int i=0;i<nums.size();i++){
            sum+=nums.get(i);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        //add into priority queue in desceding order
        
        //logn
        pq.addAll(nums);

        double temp=sum;
        //count for the number of iteration to half the sum array 
        int count=0;
        while(temp>sum/2.0){
            int x=pq.poll();
            temp-=x/2.0;
            pq.add(x/2);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.addAll(Arrays.asList(1,5,8,19));
        int count=minops(list);
        System.out.println(count);
    }
}
