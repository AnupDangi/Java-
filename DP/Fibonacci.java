import java.util.*;
public class Fibonacci {
    //Memoization TC O(n+1)
    public static int fib(int n,int f[]){
        //base case
        if(n==0||n==1){
            return n;
        }
        if(f[n]!=0){ //fib(n) is already calculate then dont calculate
            return f[n];
        }
        f[n]=fib(n-1,f)+fib(n-2,f); //store into array
        return f[n];
    }

    public static int sum(int n){ //not uses dp and cannot be solved
        if(n==0||n==1){
            return n;
        }
        return n+sum(n-1);
    }

    public static int fibTabulation(int n){//TC 0(n)
        int dp[]=new int[n+1];
        //initialize the base case
        dp[0]=0;
        dp[1]=1;

        //dp tabulation steps:
        //1. Initialize the dp array with known values like base values
        //2. iterative over loop till n from unknown value
        //3.return answer from the bottom value or n the value where answer is stored

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
}
    public static void main(String[] args) {
        int n=5;
        int f[]=new int[n+1]; //from 0 to n // at start 0,0,0
        System.out.println(fib(n,f));
        System.out.println(sum(n));
        
        System.out.println(fibTabulation(n));
    }
}
