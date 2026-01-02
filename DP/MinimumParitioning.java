import java.util.*;
public class MinimumParitioning {
    
    public static int minimumParitioning(int arr[]){//0(n*W)
        int n=arr.length;
        //find sum
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int W=sum/2;
        //create dp array
        int dp[][]=new int[n+1][W+1];

        //row initialization
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        //column intialization 
        for(int j=0;j<W+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                //valid
                if(arr[i-1]<=j){
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }
                else{//invalid
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        int sum1=dp[n][W];
        int sum2=sum-sum1;
        return Math.abs(sum2-sum1);
    }
    public static void main(String[] args) {

        int arr[]={1,6,11,5};
        System.out.println(minimumParitioning(arr));
    }
}
