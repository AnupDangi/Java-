 
import java.io.*;
import java.util.*;
 
class MinCostPathInGrid{
    
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
 
    // Custom class for representing
    // row-index, column-index &
    // distance of each cell
    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int distance;
        
        Cell(int x, int y, int distance) 
        {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
 
        @Override
        public int compareTo(Cell c2) {
            return this.distance - c2.distance;
        }
    }
 
    // method to check whether current
    // cell is inside grid or not
    static boolean isInsideGrid(int i, int j, int rows, int cols)
    {
        return (i >= 0 && i < rows &&
                j >= 0 && j < cols);
    }
 
    // Method to return shortest path from 
    // top-corner to bottom-corner in 2D grid
    static int shortestPath(int[][] grid)
    {
        int num_row = grid.length;
        int num_col = grid.length;
        int[][] dist = new int[num_row][num_col];
        
        // Initializing distance array by INT_MAX 
        for(int i = 0; i < num_row; i++)
        {
            for(int j = 0; j < num_col; j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // Initialized source distance as
        // initial grid position value
        dist[0][0] = grid[0][0];
        
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
                    
        // Insert source cell to priority queue
        pq.add(new Cell(0, 0, dist[0][0]));
 
        while (!pq.isEmpty())
        {
            Cell curr = pq.remove();
            for(int i = 0; i < 4; i++)
            {
                int curr_row = curr.x + dx[i];
                int curr_col = curr.y + dy[i];
                
                if (isInsideGrid(curr_row, curr_col, num_row, num_col))
                {
                    if (dist[curr_row][curr_col] > 
                        dist[curr.x][curr.y] + 
                        grid[curr_row][curr_col])
                    {   
                        // Insert cell with updated distance 
                        dist[curr_row][curr_col] = dist[curr.x][curr.y] +
                                        grid[curr_row][curr_col];
                                            
                        pq.add(new Cell(curr_row, curr_col, 
                                dist[curr_row][curr_col]));
                    }
                }
            }
        }
        return dist[num_row - 1][num_col - 1];
    }
 
    // Driver code
    public static void main(String[] args) 
    throws IOException
    {
        int[][] grid = { { 31, 100, 65, 12, 18 },
                        { 10, 13, 47, 157, 6 },
                        { 100, 113, 174, 11, 33 },
                        { 88, 124, 41, 20, 140 },
                        { 99, 32, 111, 41, 20 } };
                        
        System.out.println(shortestPath(grid));
    }
}