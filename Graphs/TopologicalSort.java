import java.util.*;

public class TopologicalSort {
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

    public static void topoSort(ArrayList<Edge> graph[]) {
        // Boolean array to mark visited nodes
        boolean visi[] = new boolean[graph.length];
        
        // Stack to store the topologically sorted order
        Stack<Integer> s = new Stack<>();
        
        // Traverse all nodes to ensure each one is included in the sort,
        // even if the graph is disconnected
        for (int i = 0; i < graph.length; i++) {
            // If node i has not been visited, perform a DFS from that node
            if (!visi[i]) {
                topoSortUtil(graph, i, visi, s); // Call DFS helper function
            }
        }
    
        // Print the nodes in topologically sorted order by popping from the stack
        while (!s.isEmpty()) {
            System.out.println(s.pop() + " ");
        }
    }
    
    public static void topoSortUtil(ArrayList<Edge> graph[], int curr, boolean[] visi, Stack<Integer> s) {
        // Mark the current node as visited
        visi[curr] = true;
    
        // Process all adjacent nodes of the current node (DFS)
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
    
            // If adjacent node (neighbor) has not been visited, recursively perform DFS
            if (!visi[e.dest]) {
                topoSortUtil(graph, e.dest, visi, s);
            }
        }
        // After visiting all neighbors, push the current node to the stack
        // This ensures nodes are added in reverse of their dependencies
        s.push(curr);
    }
    

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        topoSort(graph);
    }
}
