import java.util.*;
public class TopologicalSortUsingBFS {
    
    static class Edge{
        int source;
        int dest;

        Edge(int s,int d){
            this.source=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        //initialize the graph with arraylist
    for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>(); 
    }

    graph[2].add(new Edge(2,3));
    graph[3].add(new Edge(3, 1));

    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));

    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));

}

public static void calculateindegree(ArrayList<Edge> graph[], int indegree[]) {
    // Calculate the indegree of each node
    for (int i = 0; i < graph.length; i++) {
        int v = i; // Current node
        for (int j = 0; j < graph[v].size(); j++) {
            Edge e = graph[v].get(j);
            // Increment indegree for the destination node of each edge
            indegree[e.dest]++;
        }
    }
}

public static void topSort(ArrayList<Edge> graph[]) {
    int indegree[] = new int[graph.length]; // Array to store indegrees of all nodes
    calculateindegree(graph, indegree);     // Populate the indegree array using helper function

    Queue<Integer> q = new LinkedList<>(); // Queue to manage nodes with 0 indegree

    // Add all nodes with 0 indegree to the queue to start topological sorting
    for (int i = 0; i < indegree.length; i++) {
        if (indegree[i] == 0) {
            q.add(i);
        }
    }

    // Perform BFS-based topological sort
    while (!q.isEmpty()) {
        int curr = q.remove();  // Remove node with 0 indegree
        System.out.println(curr + " "); // Print node as part of topological order

        // Reduce indegree of all neighboring nodes by 1 (simulate removing edges)
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            indegree[e.dest]--;

            // If indegree of a neighbor becomes 0, add it to the queue
            if (indegree[e.dest] == 0) {
                q.add(e.dest);
            }
        }
    }
    System.out.println(); // Newline after topological order output
}
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
