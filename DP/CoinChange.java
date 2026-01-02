import java.util.*;
public class CoinChange {
    //find the number of ways
    public static int coinChange(int coins[],int sum){
        //make a dp array as two variables are changing ie coins and sum 
        int n=coins.length;
        int dp[][]=new int[n+1][sum+1];

        //initialize variable 
        // sum=0 i->coins j->sum/change
        for(int i=1;i<n+1;i++){
            dp[i][0]=1;
        }
        //for sum
        for(int j=1;j<sum+1;j++){
            dp[0][j]=0;
        }
        
        // TC 0(n*sum)
        //solve 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                //valid case
                if(coins[i-1]<=j){
                    //sum of included and excluded coins
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
    public static void main(String[] args) {
        int coins[]={2,5,3,6};
        int sum=10;
        //it is a variation of unbounded knapsack as a coin can be selected for n times  
        System.out.println("Total number of ways "+coinChange(coins,sum));

    }

    
}
