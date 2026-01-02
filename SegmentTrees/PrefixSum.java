import java.util.*;
public class PrefixSum {
    
    public static void prefixSum(int arr[]){
        int n=arr.length;
        int prefix[]=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        for(int i=0;i<prefix.length;i++){
            System.out.print(prefix[i]+" ");
        }
        //range of prefix sum 
        int i=2;
        int j=5;
        System.out.println(prefix[j]-prefix[i]);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        prefixSum(arr);
    }
}
