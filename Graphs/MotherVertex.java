import java.util.*;
public class MotherVertex {
    
     static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
            adj.get(u).add(v);
     }
    
     static void DFSUtil(ArrayList<ArrayList<Integer>> adj,int v,boolean[]visited){
        visited[v]=true;
        for(int x:adj.get(v)){
            if(!visited[x]){
                DFSUtil(adj, x, visited);
            }
        }
     }
     static int motherVertex(ArrayList<ArrayList<Integer>>g,int V){
            boolean visited[]=new boolean[V];
            int v=-1;

            for(int i=0;i<V;i++){
                if(!visited[i]){
                    DFSUtil(g, i, visited);
                    v=i;
                }
            }
            Arrays.fill(visited, false); // Reset visited array for the check
        DFSUtil(g, v, visited);

        // Step 3: Verify if all vertices were visited in the second DFS
        for (boolean val : visited) {
            if (!val) {
                return -1; // If any vertex is not visited, then `v` is not a mother vertex
            }
        }
        return v; // Return the mother vertex
    }
    public static void main(String[] args) {
        int V=5;
        int E=8;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>()); // initialize empty arraylist 
        }
        // addEdge(0,1,adj);
        // addEdge(0,2,adj);
        // addEdge(1,3,adj);
        // addEdge(4,1,adj);
        // addEdge(6,4,adj);
        // addEdge(5,6,adj);
        // addEdge(5,2,adj);
        // addEdge(6,0,adj);

        addEdge(1,0,adj);
        addEdge(2,1,adj);
        addEdge(0,2,adj);
        addEdge(0,3,adj);
        addEdge(3,4,adj);
        
        
        System.out.println("The mother vertex is"+motherVertex(adj, V));
    }
}
