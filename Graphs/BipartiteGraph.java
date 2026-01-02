import java.util.*;

public class BipartiteGraph {

    static class Edge{
        int source;
        int dest;
        Edge(int source,int dest){
            this.source=source;
            this.dest=dest;
        }
    }


    public static void createGraph(ArrayList<Edge> graph[]){
        //implement graph and store all its edges and vertices
        for(int i=0;i<graph.length;i++){
            //make a arraylist for each edge in a graph where edge information is stored
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]){
        //Use graph coloring algorithm
        //color each and every vertices
        int color[]=new int[graph.length];
        for(int i=0;i<color.length;i++){
            color[i]=-1;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){ //BFS
                q.add(i);
                color[i]=0; //yellow imagine or let
                while (!q.isEmpty()) {
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e=graph[curr].get(j); //e.dest
                        //Case 1 : there is not color assign color other than curr node color 
                        if(color[e.dest]==-1){
                            int nextColor=color[curr]== 0 ?1:0; //1 let other color ie blue or xyz other than yellow which is already let 
                            color[e.dest]=nextColor;
                            q.add(e.dest);
                        }
                        //case 2 when e.destination and curr color is same  not bipartite
                        else if(color[e.dest]==color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //If graph doesn't have cycle ->Bipartite

        //implement graph using adjacency list ie Array of list 
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        //implement bipartite graph algorithm for which we are using modified bfs along with its utility method for which we can do modification
        System.out.println(isBipartite(graph));
    }
}
