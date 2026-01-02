import java.util.*;
public class DijkstrasAlgo {
    
    static class Edge{
        int source;
        int dest;
        int weight;
        Edge(int s,int d,int wt){
            this.source=s;
            this.dest=d;
            this.weight=wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));
        
        graph[1].add(new Edge(1, 2,1));
        graph[1].add(new Edge(1, 3,7));

        graph[2].add(new Edge(2, 4,3));
        
        graph[3].add(new Edge(3, 5,1));
        
        graph[4].add(new Edge(4, 3,2));
        graph[4].add(new Edge(4, 5,5));

    }

    //Compares path between to 
    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
            //path based sorting for my pairs
        }
    }

    public static void dijkstraAlgo(ArrayList<Edge> graph[], int src) { // TC: V + ElogV
        int dist[] = new int[graph.length];
    
        // Step 1: Initialize all distances as MAX_VALUE (infinity) except for the source
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
    
        // Create a visited array to keep track of visited nodes
        boolean vis[] = new boolean[graph.length];
    
        // Step 2: Set up a priority queue to process nodes in order of shortest known distance
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        // Add the source node to the priority queue with distance 0
        pq.add(new Pair(src, 0)); 
    
        // Main loop: Continue until the priority queue is empty
        while (!pq.isEmpty()) {
            // Extract the node with the minimum distance from the queue
            Pair curr = pq.remove();
    
            // If the node hasn't been visited yet
            if (!vis[curr.n]) {
                vis[curr.n] = true; // Mark the node as visited
    
                // Iterate over all neighbors of the current node
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.source; // Source node
                    int v = e.dest;   // Destination node
                    int wt = e.weight; // Weight of the edge between u and v
    
                    // Relaxation step: update distance if a shorter path is found
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt; // Update distance to the neighbor
                        pq.add(new Pair(v, dist[v])); // Add updated distance to the queue
                    }
                }
            }
        }
        int total=0;
        for(int i=0;i<dist.length;i++){
            total+=dist[i];
            System.out.println("Source " +src +" to " +i+ " -> "+dist[i]);
        }
        System.out.println("The total distance covered through shortest distance is "+total);
    }
    
    public static void main(String[] args) {
        
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        int src=0;
        dijkstraAlgo(graph,src);
    }
}
