import java.util.*;

public class SizeLargestRegInBooleanMatrix {
    
    // Variables to store the number of rows and columns in the matrix
    static int Row;
    static int Col;

    // Method to check if a cell is valid for processing
    public static boolean isValid(int[][] matrix, int row, int col, boolean[][] visited) {
        // A cell is valid if:
        // 1. It is within the bounds of the matrix
        // 2. Its value is 1 (part of a region)
        // 3. It has not been visited yet
        return (row >= 0 && row < Row && col >= 0 && col < Col && matrix[row][col] == 1 && !visited[row][col]);
    }

    // Method to perform DFS and calculate the size of the region
    public static int dfsRegionSize(int[][] matrix, int row, int col, boolean[][] visited) {
        // Directions for 8 possible movements (up, down, left, right, and diagonals)
        int[] rowDirection = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDirection = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        // Mark the current cell as visited
        visited[row][col] = true;
        // Initialize region size to count the current cell
        int regionSize = 1;

        // Explore all 8 possible directions
        for (int k = 0; k < 8; k++) {
            // Calculate new row and column indices
            int newRow = row + rowDirection[k];
            int newCol = col + colDirection[k];

            // If the new cell is valid, recursively calculate its region size
            if (isValid(matrix, newRow, newCol, visited)) {
                regionSize += dfsRegionSize(matrix, newRow, newCol, visited);
            }
        }
        // Return the total size of the region found
        return regionSize;
    }

    // Method to find the largest region in the matrix
    public static int largestRegion(int[][] matrix) {
        // Set the number of rows and columns
        Row = matrix.length;
        Col = matrix[0].length;

        // Create a visited matrix to keep track of visited cells
        boolean[][] visited = new boolean[Row][Col];
        int maxRegion = 0; // Variable to store the maximum region size

        // Iterate through each cell in the matrix
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                // If the current cell is part of a region (value is 1) and not visited
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    // Call DFS to calculate the size of this region
                    int currentRegionSize = dfsRegionSize(matrix, i, j, visited);
                    // Update the maximum region size if the current region is larger
                    maxRegion = Math.max(maxRegion, currentRegionSize);
                }
            }
        }
        
        // Return the size of the largest region found
        return maxRegion;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of rows (n) and columns (m) from input
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Initialize the matrix with n rows and m columns
        int[][] mat = new int[n][m];
        Row = n; // Assign number of rows
        Col = m; // Assign number of columns

        // Populate the matrix with user input
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.nextInt(); // Read each element
            }
        }

        // Print the size of the largest region found
        System.out.println("Largest Region Size: " + largestRegion(mat));
        sc.close(); // Close the scanner to free up resources
    }
}
