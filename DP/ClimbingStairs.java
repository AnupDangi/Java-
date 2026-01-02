import java.util.*;
public class ClimbingStairs {
    
    //recursively
    public static int climbStairs(int n){ //here the TC is O(2^n) exponential
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static int memoclimbStairs(int n,int dp[]){ //O(n+1)=O(n) and space complexity is same as O(n)
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        //store if dp of n and return if dp of n is not !=0
        if(dp[n]!=-1){
            return dp[n];
        }

        //store dp of n
        dp[n]=memoclimbStairs(n-1, dp)+memoclimbStairs(n-2, dp);
        return dp[n];
    }

    public static int tabulationClimb(int n){ //0(n+1)
        //1.create empty table  and initalize
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        //2.initalize known value 
            dp[0]=1;
            dp[1]=1; //dp[0]+dp[-1] ie 1+0=1
        if(n<0){
            dp[n]=0;
        }
        //3. Iterate over the values and fill the table
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    //climbing stairs with variation with allowed three steps 1,2,3 steps jumps using memoization
    public static int variationclimbStairs(int n,int ways[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        //return if ways is not empty than means it is already fill 
        if(ways[n]!=-1){
            return ways[n];
        }
        //store ways of n
        ways[n]=variationclimbStairs(n-1,ways)+variationclimbStairs(n-2, ways)+variationclimbStairs(n-3, ways);
        return ways[n];
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println("Using Recursion: "+climbStairs(n));
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Using Memoization: "+memoclimbStairs(n, dp));

        System.out.println("Using Tabulation: "+tabulationClimb(n));

        int ways[]=new int[n+1];
        Arrays.fill(ways, -1);
        System.out.println("With Slight Variation: "+variationclimbStairs(n, ways));
    }
}
