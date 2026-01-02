import java.util.ArrayList;
import java.util.Vector;

public class Solution {
    
    // Inner class to represent a pair of tasks
    // where `first` is dependent on `second`.
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Method to create a graph from the list of prerequisites
    // Each task will have a list of tasks that depend on it
    static ArrayList<ArrayList<Integer>> makeGraph(int numTasks, Vector<Pair> prerequisites) {
        // Initialize the adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numTasks);
        for (int i = 0; i < numTasks; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        // Add edges based on prerequisites (dependencies)
        for (Pair pre : prerequisites) {
            graph.get(pre.second).add(pre.first);
        }
        
        return graph;
    }

    // Method to compute the indegree of each task
    // `indegree` represents the number of prerequisites for each task
    static int[] computeIndegree(ArrayList<ArrayList<Integer>> graph) {
        int[] degrees = new int[graph.size()];

        // Count the number of incoming edges for each node (task)
        for (ArrayList<Integer> neighbors : graph) {
            for (int neighbor : neighbors) {
                degrees[neighbor]++;
            }
        }

        return degrees;
    }

    // Method to determine if it is possible to finish all tasks
    // based on the prerequisites (checking for cycles in the graph)
    static boolean canFinish(int numTasks, Vector<Pair> prerequisites) {
        // Build the graph and compute indegrees
        ArrayList<ArrayList<Integer>> graph = makeGraph(numTasks, prerequisites);
        int[] degrees = computeIndegree(graph);

        // Loop through all tasks and attempt to perform topological sorting
        for (int i = 0; i < numTasks; i++) {
            int j = 0;

            // Find a task with indegree 0 (no prerequisites remaining)
            for (; j < numTasks; j++) {
                if (degrees[j] == 0) break;
            }

            // If no such task is found, it means we have a cycle
            if (j == numTasks) return false;

            // Mark this task as processed
            degrees[j] = -1;

            // Reduce indegree of all tasks that depend on the current task
            for (int neighbor : graph.get(j)) {
                degrees[neighbor]--;
            }
        }

        return true; // No cycle found, possible to finish all tasks
    }

    public static void main(String[] args) {
        int numTasks = 4; // Total number of tasks
        Vector<Pair> prerequisites = new Vector<>();

        // Define prerequisites as pairs (1 depends on 0, 2 depends on 1, etc.)
        prerequisites.add(new Pair(2, 1));
        prerequisites.add(new Pair(1, 0));
        prerequisites.add(new Pair(3, 2));

        // Check if it is possible to finish all tasks
        if (canFinish(numTasks, prerequisites)) {
            System.out.println("Possible to finish all tasks");
        } else {
            System.out.println("Impossible to finish all tasks");
        }
    }
}
