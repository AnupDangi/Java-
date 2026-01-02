import java.util.*;
public class LongestcommonSubstring {
    
    public static int lenCommonSubstring(String s1,String s2){

        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];

        //fill the array initialize 
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }

        int ans=0;

        //now fill the table where (i,j) is the longestcommonsubstring for that particular index of string
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s1="abcde";
        String s2="abcge";
        int ans=lenCommonSubstring(s1,s2);
        System.out.println(ans);
    }
}
