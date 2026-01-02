import java.io.*;
import java.util.*;

public class MinimumTimeFillSlots {

    /**
     * This method calculates the minimum time required to fill all slots in the range [1, N]
     * starting from the initial filled slots in the array 'arr'.
     *
     * @param arr An array of integers representing the initially filled slots.
     * @param N The total number of slots (from 1 to N).
     * @param k The number of initially filled slots (i.e., length of the array 'arr').
     */
    public static void minTime(int arr[], int N, int k) {
        // Create a queue to process the slots in a BFS manner
        Queue<Integer> q = new LinkedList<>();
        
        // Boolean array to track whether a slot is already filled or not (visited)
        boolean vis[] = new boolean[N + 1];
        
        // Time counter to track the minimum time required to fill all slots
        int time = 0;

        // Add the initially filled slots to the queue and mark them as visited
        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
            vis[arr[i]] = true;  // Mark the current slot as filled
        }

        // Process the queue until all slots are filled
        while (!q.isEmpty()) {
            int size = q.size(); // Store the current size of the queue (i.e., slots to process for this step)
            for (int i = 0; i < size; i++) {
                int curr = q.poll(); // Get the current slot

                // Check if the slot to the left (curr-1) is within bounds and not yet filled
                if (curr - 1 >= 1 && !vis[curr - 1]) {
                    vis[curr - 1] = true;  // Mark the slot as filled
                    q.add(curr - 1);       // Add it to the queue for further processing
                }
                
                // Check if the slot to the right (curr+1) is within bounds and not yet filled
                if (curr + 1 <= N && !vis[curr + 1]) {
                    vis[curr + 1] = true;  // Mark the slot as filled
                    q.add(curr + 1);       // Add it to the queue for further processing
                }
            }
            time++;  // Increase the time after processing all current slots
        }
        
        // The actual time is time - 1 because the last iteration does not count (queue is empty)
        System.out.println(time - 1);
    }

    /**
     * Main method to run the program with a specific example.
     */
    public static void main(String[] args) {
        int N = 6;  // Total number of slots
        int arr[] = {1,2,3,4,5};  // Initially filled slots
        int k = arr.length;  // Number of initially filled slots
        minTime(arr, N, k);  // Call the method to compute minimum time
    }
}
