import java.util.*;
public class CatalansNumbers {
    
    public static int catalanRecursion(int n){ //0(2^n)
        if(n==0||n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans+=catalanRecursion(i)*catalanRecursion(n-i-1);
        }

        return ans;
    }
    public static int catalanmemoization(int n,int dp[]){
        //base case
        if(n==0||n==1){
            return 1;
        }
        //if not filled
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        //find the not found value
        for(int i=0;i<n;i++){
            ans+=catalanmemoization(i,dp)*catalanmemoization(n-i-1,dp);
        }
        return ans;
    }
    public static int catalanTabulation(int n){
        int dp[]=new int[n+1];
        //intialize
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println("Catalan using recursion: "+catalanRecursion(n));
         //create a array for memory
         int dp[]=new int[n+1];
         Arrays.fill(dp, -1);
        System.out.println("Catalan using memoization: "+catalanmemoization(n,dp));
        System.out.println("Catalan using tabulation: "+catalanTabulation(n));

    }
}
