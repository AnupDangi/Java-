import java.util.*;
public class LongestCommonSubsequence {
    
    public static int lcs(String str1,String str2,int n,int m){

        //base case
        if(n==0||m==0){
            return 0;
        }

        //Case 1 if character  matches
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return 1+ lcs(str1, str2, n-1, m-1);
        }
        //if doenot matches we have two choices to reduce the length of first string or second string 
        //take max among first and second choice
        else{
            int ans1=lcs(str1, str2, n-1, m);
            int ans2=lcs(str1, str2, n, m-1);
            return Math.max(ans1,ans2);
        }
        
    }
    public static int lcsmemoization(String str1,String str2,int n,int m,int dp[][]){
        if(n==0|| m==0){
            return 0;
        }

        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return dp[n][m]=lcsmemoization(str1, str2, n-1, m-1, dp)+1;
        }
        else{ //if different then take maximum
            int ans1=lcsmemoization(str1, str2, n-1, m,dp);
            int ans2=lcsmemoization(str1, str2, n, m-1, dp);
            return Math.max(ans1,ans2);
        }
    }
    //0(m*n)
    public static int lcstabulation(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];

        //initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }

        //no filling the table 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }

                //different
                else{
                    int ans1=dp[i][j]=dp[i-1][j];
                    int ans2=dp[i][j]=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m]; 
    }

    public static void main(String[] args) {
        String str1="abcde";
        String str2="ace";
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1]; 
        //initialization
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        
        System.out.println("Using Recursion: "+lcs(str1,str2,str1.length(),str2.length()));

        System.out.println("Using Memoization: "+lcsmemoization(str1, str2, n, m,dp));
        System.out.println("Using Tabulation: "+lcstabulation(str1, str2));
    }
}
