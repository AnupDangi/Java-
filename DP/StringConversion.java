import java.util.*;

public class StringConversion {
    
    public static int strConversion(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        // Initialization of DP table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Check if characters are the same
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } 
                // Different characters
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";
        int lcs = strConversion(str1, str2);
        System.out.println("Longest Common Subsequence Length: " + lcs);
        System.out.println("Deletions: " + (str1.length() - lcs)); // Deletions
        System.out.println("Insertions: " + (str2.length() - lcs)); // Insertions
    }
}
