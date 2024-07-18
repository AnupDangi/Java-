public class RatinMaze  {

    public static void printSolution(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        // Check if (x, y) is within the maze bounds and is an open cell
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    public static boolean solveMazeUtil(int maze[][], int x, int y, int output[][]) {
        // Base case: Check if position is out of bounds or not safe
        if (!isSafe(maze, x, y)) {
            return false;
        }

        // Mark current position as part of solution path
        output[x][y] = 1;

        // Check if current position is destination
        if (x == maze.length - 1 && y == maze.length - 1) {
            printSolution(output);
            return true;
        }

        // Recursive calls for down and right movements
        if (solveMazeUtil(maze, x + 1, y, output)) {
            return true;
        }
        if (solveMazeUtil(maze, x, y + 1, output)) {
            return true;
        }

        // Backtrack if neither down nor right leads to destination
        output[x][y] = 0;
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        int output[][] = new int[maze.length][maze.length]; // Initialize output matrix

        if (!solveMazeUtil(maze, 0, 0, output)) {
            System.out.println("No solution exists.");
        }
    }
}
