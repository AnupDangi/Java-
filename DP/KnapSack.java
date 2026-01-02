import java.util.*;
public class KnapSack { //0-1
    
    public static int knapsackrecurison(int val[],int wt[],int maxWt,int n){ //0(2^n)
        //base case 
        if(n==0||maxWt==0){
            return 0;
        }
        if(wt[n-1]<=maxWt){ //valid
            //include
            int ans1= val[n-1]+knapsackrecurison(val, wt, maxWt-wt[n-1], n-1);//decrease from back
            //exclude
            int ans2=knapsackrecurison(val, wt, maxWt, n-1);

            return Math.max(ans1, ans2);
        }
        else{ //not valid
            return knapsackrecurison(val, wt, maxWt, n-1);
        }
        
    }


    public static int knapsack1recurison(int val[],int wt[],int maxWt,int n,int i){
        //base case 
        if(i==n||maxWt==0){
            return 0;
        }
        if(wt[n-1]<=maxWt){ //valid
            //include
            int ans1= val[i]+knapsackrecurison(val, wt, maxWt-wt[i], i+1);//decrease from back
            //exclude
            int ans2=knapsackrecurison(val, wt, maxWt, i+1);

            return Math.max(ans1, ans2);
        }
        else{ //not valid

            return knapsackrecurison(val, wt, maxWt, i+1);
        }
        
    }

    //using memoization or creating table to store repeated values
    public static int knapsackmemoization(int val[],int wt[],int maxWt,int n,int dp[][]){ //0(n*W)
        if(n==0||maxWt==0){
            return 0;
        }

        if(dp[n][maxWt]!=-1){
            return dp[n][maxWt];
        }
        //valid 
        if(wt[n-1]<=maxWt){
            //include
            int ans1=val[n-1]+knapsackmemoization(val, wt, maxWt-wt[n-1], n-1, dp);

            //exclude
            int ans2=knapsackmemoization(val, wt, maxWt, n-1, dp);
            dp[n][maxWt]=Math.max(ans1, ans2);
            return dp[n][maxWt];
        }
        else{//not valid
            dp[n][maxWt]=knapsackmemoization(val, wt, maxWt, n-1, dp);
            return dp[n][maxWt];
        }
    }
    public static int knapsackTabulation(int val[],int wt[],int maxWt){
        int n=val.length;
        int dp[][]=new int[n+1][maxWt+1];
        //initialize with 0 for 0th col
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){

            for(int j=1;j<maxWt+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                if(w<=j){
                    int incProfit=v+dp[i-1][j-w];
                    int excProft=dp[i-1][j];
                    dp[i][j]=Math.max(incProfit,excProft);
                }
                else{//Invalid
                    int excProfit=dp[i-1][j];
                    dp[i][j]=excProfit;
                }
            }
        }
        print(dp);
        return dp[n][maxWt];

    }
    public static void print(int dp[][]){
        System.out.println("The dp array looks like");
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int unboundedKnapsack(int val[],int wt[],int maxWt){
        int n=val.length;
        //1.create dp matrix
        //2.give meaning to the dp matrix indices or store in the form of logic which you want to extract for each subproblem
        //3.always choose the optimal solution from each subproblem and store and return the last index dp array element

        int dp[][]=new int[n+1][maxWt+1];

        //when no item is selected
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        //no item is selected wt is also 0
        for(int j=0;j<maxWt+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<maxWt+1;j++){
                if(wt[i-1]<=j){//include and exclude  dp[i][j-wt[i-1]] we took the same value
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
                }
                else{//invalid
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][maxWt];
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int maxWt=7;
        //memoization
        int dp[][]=new int[val.length+1][maxWt+1];
        for(int i=0;i<=val.length;i++){
            Arrays.fill(dp[i],-1);
        }

        System.out.println("Using Recursion"+knapsackrecurison(val,wt,maxWt,val.length));
        System.out.println("Using Recursion"+knapsack1recurison(val,wt,maxWt,val.length,1));
        int maxProfit=knapsackmemoization(val, wt, maxWt, val.length, dp);
        System.out.println("Using memoization"+maxProfit);

        //tabulation
        System.out.println("Using Tabulation"+knapsackTabulation(val, wt, maxWt));
        System.out.println("Unbounded Knapsack "+unboundedKnapsack(val, wt, maxWt));
    }
}
