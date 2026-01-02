import java.util.Arrays;

public class Tribonacci {
    
    public static int recursiontribonacci(int n){
        //base case
        if(n==0||n==1||n==2){
            System.out.close();
        }
        if(n==0||n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        
            return recursiontribonacci(n-1)+recursiontribonacci(n-2)+recursiontribonacci(n-3);
    }
   
    public static void printDParray(int dp[]){
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
    }
    //print series using dp
    public static int DPtribonacci(int n){
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);

        //initialize base values 
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;

        if(dp[n]!=-1){
            return dp[n];
        }
        else{ //fill the table
            for(int i=3;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }

        printDParray(dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n=4;
        System.out.println("Tribonacci using recursion"+recursiontribonacci(n));
        System.out.println("Tribonacci using Tabulation "+DPtribonacci(n));
    }
}
