import java.util.*;

public class CycleDetectinDirectedgraph {

    static class Edge{
        int source;
        int dest;

        public Edge(int s,int d){
            this.source=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
            //initialize the graph with arraylist
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>(); 
        }

        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        // Array to keep track of visited nodes
        boolean visi[] = new boolean[graph.length];
        
        // Array to keep track of nodes currently in the recursive stack
        boolean stack[] = new boolean[graph.length];
    
        // Loop through all nodes to handle disconnected components
        for (int i = 0; i < graph.length; i++) {
            // If node i is unvisited, check for cycle starting from that node
            if (!visi[i]) {
                // Call helper function to detect cycle starting from node i
                if (isCycleUtil(graph, i, visi, stack)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle found
    }
    
    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean visi[], boolean stack[]) {
        // Mark current node as visited
        visi[curr] = true;
        
        // Add current node to the recursive stack
        stack[curr] = true;
    
        // Traverse all adjacent nodes (neighbors) of the current node
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
     
            // If neighbor is already in the stack, a cycle exists
            if (stack[e.dest]) { // Cycle found
                return true;
            }
    
            // If neighbor is unvisited, recursively check for cycles in its path
            if (!visi[e.dest] && isCycleUtil(graph, e.dest, visi, stack)) {
                return true; // Cycle found in deeper recursion
            }
        }
    
        // Remove current node from the stack before returning
        stack[curr] = false;
        return false; // No cycle found in this path
    }
    
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
