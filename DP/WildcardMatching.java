import java.util.*;
public class WildcardMatching {//Hard level
    
    public static boolean matchwildcard(String s,String pat){ // TC 0(n*m)
        int n=s.length();
        int m=pat.length();
        boolean dp[][]=new boolean[n+1][m+1];
        
        //fill the initalization
        dp[0][0]=true;//s=""and pat=""
        for(int i=1;i<n+1;i++){ //if pat=""and s="xyz"
            dp[i][0]=false;
        }
        for(int j=1;j<m+1;j++){
            //if char is *
           if(pat.charAt(j-1) == '*'){
               dp[0][j]=dp[0][j-1];
           }
        }
        //bottom up 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //same chars or p.charAt=='?''
                if(s.charAt(i-1)==pat.charAt(j-1)||pat.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(pat.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s="baaabab";//abc
        String pat="*****ba*****ab";//**?b* //**d
        System.out.println(matchwildcard(s,pat));//true

    }
}
