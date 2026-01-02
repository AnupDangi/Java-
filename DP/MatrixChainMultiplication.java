import java.util.*;
public class MatrixChainMultiplication {
    
    //minimum cost matrix 
    public static int MCM(int arr[],int i,int j){
        //base case
        if(i==j){ //no multiplication possible
            return 0;
        }

        int ans=Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
            //if cost for each matrix from i to k 
            int cost1=MCM(arr, i, k);

            //cost from k+1 to j
            int cost2=MCM(arr, k+1, j);
            //add all three cost ie adding two matrixes cost and compare with ans if minimum then update

            int cost3=arr[i-1]*arr[k]*arr[j];
            //add all three cost ie adding two matrixes cost and compare with ans if minimum then update

            int finalCost=cost1+cost2+cost3;

            ans=Math.min(ans,finalCost);
        }

        return ans;
    }

    public static int mcmMem(int arr[],int i,int j,int dp[][]){
        if(i==j){
            return 0;
        }
        //if calculated earlier
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        //else calculate
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1=mcmMem(arr, i, k, dp);
            int cost2=mcmMem(arr, k+1, j, dp);
            int cost3=arr[i-1]*arr[k]*arr[j];
            int finalCost=cost1+cost2+cost3;
            ans=Math.min(ans,finalCost);
        }
        return dp[i][j]=ans;
    }
    public static void printDP(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int mcmTabulation(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];
        
        //initialization
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }

        //bottom-up
        for(int len=2;len<=n-1;len++){
            for(int i=1;i<=n-len;i++){
                //col
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(dp[i][j],cost1+cost2+cost3);
                }
            }
        }
        printDP(dp);
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        int i=1;
        int n=arr.length;
        int j=n-1;
        //System.out.println(MCM(arr,i,j));  
        int dp[][]=new int[n][n];

        for(int k=0;k<n;k++){
            Arrays.fill(dp[k], -1);
        }
        System.out.println("Matrix Chain Multiplication using recursion: "+MCM(arr, i, j));
        System.out.println("Matrix Chain Multiplication using memoization: "+mcmMem(arr, i, j, dp));
        System.out.println("Matrix Chain Multiplication using Tabulation:"+mcmTabulation(arr));
    }

}
