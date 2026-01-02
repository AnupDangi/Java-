import java.util.*;

// Union-Find class to detect cycles in an undirected graph
public class UnionFind {
    int V, E; // Number of vertices and edges

    Edge edge[]; // Array of edges

    // Inner class to represent an edge between two nodes
    class Edge {
        int src, dest; // Source and destination vertices of an edge
    };

    // Constructor to initialize a graph with V vertices and E edges
    UnionFind(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E]; // Create an array to store all edges
        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge(); // Initialize each edge
        }
    }

    // Method to find the root of a given node i using path compression
    int find(int parent[], int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    // Method to perform union operation on two sets
    void Union(int parent[], int x, int y) {
        parent[x] = y; // Make y the parent of x
    }

    // Method to check if a cycle exists in the graph
    int isCycle(UnionFind graph) {
        int parent[] = new int[graph.V]; // Array to store parent of each vertex

        // Initialize each vertex as its own parent
        for (int i = 0; i < graph.V; ++i) {
            parent[i] = i;
        }

        // Iterate through all edges and apply union-find algorithm
        for (int i = 0; i < graph.E; ++i) {
            int x = graph.find(parent, graph.edge[i].src); // Find root of source
            int y = graph.find(parent, graph.edge[i].dest); // Find root of destination

            // If x and y have the same root, a cycle is detected
            if (x == y) {
                return 1;
            }
            // Union the two vertices
            graph.Union(parent, x, y);
        }
        return 0; // No cycle found
    }

    // Main method to create a graph and check for cycles
    public static void main(String[] args) {
        int V = 3, E = 3; // Number of vertices and edges
        UnionFind graph = new UnionFind(V, E); // Create a graph

        // Define edges
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        // Check if the graph contains a cycle
        if (graph.isCycle(graph) == 1) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
}
