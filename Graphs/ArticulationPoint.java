import java.util.ArrayList;

class ArticulationPoint {
    static int time; // Static variable to keep track of discovery time

    // Method to add an undirected edge between two nodes u and v
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Utility method to find articulation points using DFS
    static void APUtil(ArrayList<ArrayList<Integer>> adj, int u, boolean visited[], int disc[], int low[], int parent, boolean isAP[]) {
        int children = 0; // Count of children in DFS tree
        visited[u] = true; // Mark the current node as visited
        disc[u] = low[u] = ++time; // Initialize discovery time and low value

        // Iterate over all adjacent vertices of u
        for (Integer v : adj.get(u)) {
            if (!visited[v]) { // If v is not visited, it is a child of u in DFS tree
                children++;
                APUtil(adj, v, visited, disc, low, u, isAP); // Recur for DFS

                // Check if the subtree rooted at v has a connection back to an ancestor of u
                low[u] = Math.min(low[u], low[v]);

                // If u is not root and low value of one of its child is more than discovery value of u
                if (parent != -1 && low[v] >= disc[u]) {
                    isAP[u] = true;
                }
            } else if (v != parent) { // Update low value of u for parent function calls
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // If u is root of DFS tree and has two or more children
        if (parent == -1 && children > 1) {
            isAP[u] = true;
        }
    }

    // Function to find and print all articulation points
    static void AP(ArrayList<ArrayList<Integer>> adj, int V) { //0(V+E)
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        time = 0;

        // Initialize parent and visited, and start DFS traversal
        int parent = -1;
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                APUtil(adj, u, visited, disc, low, parent, isAP);
            }
        }

        // Print articulation points
        for (int u = 0; u < V; u++) {
            if (isAP[u]) {
                System.out.print(u + " ");
            }
        }
        System.out.println();
    }

    // Main method to test the above code
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj1.add(new ArrayList<>());
        }

        addEdge(adj1, 1, 0);
        addEdge(adj1, 0, 2);
        addEdge(adj1, 2, 1);
        addEdge(adj1, 0, 3);
        addEdge(adj1, 3, 4);

        System.out.println("Articulation points in first graph");
        AP(adj1, V);

        V = 4;
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj2.add(new ArrayList<>());
        }

        addEdge(adj2, 0, 1);
        addEdge(adj2, 1, 2);
        addEdge(adj2, 2, 3);

        System.out.println("Articulation points in second graph");
        AP(adj2, V);

        V = 7;
        ArrayList<ArrayList<Integer>> adj3 = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj3.add(new ArrayList<>());
        }

        addEdge(adj3, 0, 1);
        addEdge(adj3, 1, 2);
        addEdge(adj3, 2, 0);
        addEdge(adj3, 1, 3);
        addEdge(adj3, 1, 4);
        addEdge(adj3, 1, 6);
        addEdge(adj3, 3, 5);
        addEdge(adj3, 4, 5);

        System.out.println("Articulation points in third graph");
        AP(adj3, V);
    }
}
