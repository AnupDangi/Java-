import java.util.*;
public class LargestSubarraySumwith0 {
    public static void main(String[] args) { //0(n)
        int arr[]={15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer> map=new HashMap<>();
        //(sum,index)
        //Iterate over the array 
        int sum=0;
        int len=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            //check if the sum already exists
            if(map.containsKey(sum)){
                //j- map.get(sum) means 
                len=Math.max(len,i-map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        System.out.println("largest subarray with sum as 0=> "+len);
        
        //Brute force

        // int maxlen=0;
        // for(int i=0;i<arr.length;i++){
        //     int sum=0;
        //     for(int j=i;j<arr.length;j++){
        //         sum+=arr[j];
        //         if(sum==0){
        //             maxlen=Math.max(maxlen,j-i+1);
        //         }
        //     }
        // }
        // System.out.println(maxlen);
    }
}
