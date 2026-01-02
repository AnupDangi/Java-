import java.util.*;
public class MountainRanges {
    
    public static int countmountainRange(int n){ //0(n*n)
        int dp[]=new int[n+1];
        //initialize 
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int insidepairs=dp[j];
                int outsidepairs=dp[i-j-1];
                dp[i]+=insidepairs*outsidepairs;
                //dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;//14
        System.out.println(countmountainRange(n));
    }
}
