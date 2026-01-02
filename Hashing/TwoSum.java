import java.util.*;
public class TwoSum {
    
    public static int[] twosum(int arr[],HashMap<Integer,Integer>map,int target){
        for(int i=0;i<arr.length;i++){
            //differnce between target and arr[i] check if that element exist or not 
            int diff=target-arr[i];

            if(map.containsKey(diff)){
                return new int[]{i,map.get(diff)};
            }
            map.put(arr[i], i);
        }
        //if not found
        return new int[]{0,0};
    }
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int target=9;
        int arr[]={2,7,11,15};
        int output[]=new int[2];
        output=twosum(arr, map, target);
        System.out.println(output[1]+","+output[0]);
    }
}
