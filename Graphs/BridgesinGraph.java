import java.util.*;
public class BridgesinGraph {
    static class  Edge {
        int src;
        int dest;

        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void detectBridges(ArrayList<Edge> graph[],int V){
        int dt[]=new int[V];
        int lowt[]=new int[V];

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].size();i++){
                Edge e=graph[i].get(j);
                

            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,int par,int dt[],int low[],boolean visited[],int time){

        visited[curr]=true;
        dt[curr]=low[curr]=++time; // first time from 0 to 1 
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i); //e.src ----e.dest

            int neigh=e.dest;
            if(neigh==par){ //dest is same as parent donot do anything
                continue; 
            }
            else if(!visited[neigh]){ //if neigh are not visited and update dt and low 
                    dfs(graph, neigh, curr, dt, low, visited, time);
                    low[curr]=Math.min(low[curr],low[neigh]);
                    if(dt[curr]<low[neigh]){
                        System.out.println("Bridges: "+curr+"-----"+neigh);
                    }
                }  
            else  {
                    low[curr]=Math.min(low[curr], dt[neigh]);
                }
            }
    }

    public static void tarjanBridges(ArrayList<Edge> graph[],int V){
        //two arrays for discovery time and lowest time 
        int dt[]=new int[V];
        int low[]=new int[V];

        int time=0;
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(graph,i,-1,dt,low,visited,time);
            }
        }
    }
    public static void createGraph(ArrayList<Edge> graph[],int V){
        //initialize empty graph
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        //add nodes
        // graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));
       
        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));
        
        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));

        // graph[3].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        // graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph,V);
        tarjanBridges(graph,V);
        
    }
}
