import java.util.*;
public class CycleDetectIndirectgraph {
    
    static class Edge{
        int source;
        int dest;

        Edge(int source,int dest){
            this.source=source;
            this.dest=dest;
        }
    }
    public static void creategraph(ArrayList<Edge>graph[]){

        for(int i=0;i<graph.length;i++){
            //initialize the arraylist for each edge
            graph[i]=new ArrayList<>(); 
        }

        //add into graph
        //0's vertices 
        graph[0].add(new Edge(0, 1));
         graph[0].add(new Edge(0, 3));
        //  graph[0].add(new Edge(0, 2));
         
         //1's vertices
        
         graph[1].add(new Edge(1, 0));
         graph[1].add(new Edge(1, 2));
         
         //2's vertices
        //  graph[2].add(new Edge(2,0));
         graph[2].add(new Edge(2,1));
         graph[2].add(new Edge(2,4));

         //3's vertices
         graph[3].add(new Edge(3, 0));

         //4's vertices
         graph[4].add(new Edge(4, 2));
    }


    //perform dfs 
    public static boolean detectCycle(ArrayList<Edge> graph[]){
            boolean visited[]=new boolean[graph.length];
            for(int i=0;i<graph.length;i++){
                if(!visited[i]){
                    //-1 parent for the source or start 
                    if(detectCycleUtil(graph, visited, i, -1)){
                        return true;
                    }
                }
            }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>graph[],boolean visited[],int curr,int parent){ //0(V+E)

        visited[curr]=true;
        //call it's neighbor
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);

            //case 3 if neighbor is not visited and detectcycle return that it exists then return true
            if(!visited[e.dest]){
                if(detectCycleUtil(graph, visited, e.dest, curr)){
                    return true;
                }
            }
            //case 1 already the destination is visited and dest is not same as source then return true
            else if(visited[e.dest] &&e.dest!=parent){
                return true;
            }
            //case 2 ->do nothing when when it is visited but cycle doestnot returns
        }
        return false;
    }
    public static void main(String[] args) {
        
        //create a Adjancey List ie Array of List ie arrayList of edges 
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        
        creategraph(graph);
        System.out.println(detectCycle(graph));
    }
}
