package labprog;
import java.util.*;

public class matrix {
    public static void main(String[] args) {
        // Check if the number of command-line arguments is correct
        if (args.length != 1) {
            System.out.println("Usage: java matrix <order>");
            return;
        }

        // Parse the order N from command-line arguments
        int N = Integer.parseInt(args[0]);

        // Check if N is a positive integer
        if (N <= 0) {
            System.out.println("Please provide a valid positive integer for the order N.");
            return;
        }

        // Create two matrices of order N
        int[][] matrix1 = generateRandomMatrix(N);
        int[][] matrix2 = generateRandomMatrix(N);

        System.out.println("Matrix 1:");
        printMatrix(matrix1);

        System.out.println("Matrix 2:");
        printMatrix(matrix2);

        // Add the matrices
        int[][] resultMatrix = addMatrices(matrix1, matrix2);

        // Display the result
        System.out.println("Resultant Matrix (Sum of Matrix 1 and Matrix 2):");
        printMatrix(resultMatrix);
    }

    // Function to generate a random matrix of order N
    private static int[][] generateRandomMatrix(int N) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // For simplicity, using random integers between 1 and 10
                matrix[i][j] = (int) (Math.random() * 10) + 1;
            }
        }
        return matrix;
    }

    // Function to add two matrices
    private static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int N = matrix1.length;
        int[][] resultMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    // Function to print a matrix
    private static void printMatrix(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
