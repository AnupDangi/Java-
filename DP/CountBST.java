import java.util.*;
public class CountBST {
    
    public static int countBST(int n){ //0(n*n)
        //create array
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        int ans=0;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int lefttree=dp[j];
                int rightree=dp[i-j-1];
                dp[i]+=lefttree*rightree;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(countBST(n));
    }
}
