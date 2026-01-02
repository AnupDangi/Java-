import java.util.*;

public class MinTimeRotAllOrange {

    public static int orangesRotting(int[][] grid) { //0(r*c) 
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        // Count fresh oranges and add all initial rotten oranges to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        // If there are no fresh oranges initially, return 0
        if (freshOranges == 0) {
            return 0;
        }

        int level = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Process each level of BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean newRotten = false;
            
            // Process all oranges at the current level
            for (int i = 0; i < size; i++) {
                int[] cell = queue.remove();
                int x = cell[0];
                int y = cell[1];

                // Spread rot to adjacent cells
                for (int[] dir : directions) {
                    int newRow = x + dir[0];
                    int newCol = y + dir[1];

                    // Check if adjacent cell is within bounds and is a fresh orange
                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Rot the fresh orange
                        freshOranges--;
                        queue.add(new int[] { newRow, newCol });
                        newRotten = true;
                    }
                }
            }

            // Only increment the time if there was a new rotten orange at this level
            if (newRotten) {
                level++;
            }
        }

        // If there are still fresh oranges, return -1
        return freshOranges == 0 ? level : -1;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] grid = new int[N][N];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the grid elements (0 for empty, 1 for fresh orange, 2 for rotten orange):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("Minimum time to rot all oranges: " + orangesRotting(grid));
        sc.close();
    }
}
