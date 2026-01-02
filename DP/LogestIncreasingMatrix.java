import java.util.*;

public class LogestIncreasingMatrix {
    
    // Recursive function to compute the longest increasing path starting from cell (x, y)
    public static int LongestIncreasingMatrix(int matrix[][], int dp[][], int n, int m, int x, int y) {

        // Check if this cell has not been calculated
        if (dp[x][y] < 0) { 
            int result = 0;

            // Base case: If we reach the bottom-right corner, the path length is 1
            if (x == n - 1 && y == m - 1) { 
                return dp[x][y] = 1;
            }

            // If we reach the last row or last column, at least one valid path exists
            if (x == n - 1 || y == m - 1) { 
                result = 1;
            }

            // Move downward if the next value is greater
            if (x + 1 < n && matrix[x][y] < matrix[x + 1][y]) { 
                result = 1 + LongestIncreasingMatrix(matrix, dp, n, m, x + 1, y);
            }

            // Move rightward if the next value is greater, and compare results to take the maximum
            if (y + 1 < m && matrix[x][y] < matrix[x][y + 1]) { 
                result = Math.max(result, 1 + LongestIncreasingMatrix(matrix, dp, n, m, x, y + 1));
            }

            // Store the computed result in the dp array
            dp[x][y] = result;
        }

        // Return the memoized or computed value for cell (x, y)
        return dp[x][y];
    }

    // Wrapper function to initialize the dp array and call the recursive function
    public static int wrapper(int matrix[][], int n, int m) {

        // Initialize dp array with size (n x m), filled with -1
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start the computation from the top-left corner (0, 0)
        return LongestIncreasingMatrix(matrix, dp, n, m, 0, 0);
    }

    public static void main(String[] args) {

        // Example matrix input
        // int matrix[][] = {
        //     {1, 2, 3, 4},
        //     {2, 2, 3, 4},
        //     {3, 2, 3, 4},
        //     {4, 5, 6, 7}
        // };

        int matrix[][] = {{1, 2}, {3, 4}}; // Test case: Small 2x2 matrix

        // Get dimensions of the matrix
        int n = matrix.length;
        int m = matrix[0].length;

        // Call the wrapper function and print the result
        System.out.println(wrapper(matrix, n, m));
    }
}
