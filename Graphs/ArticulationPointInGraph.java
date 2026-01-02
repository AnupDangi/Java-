import java.util.*;
public class ArticulationPointInGraph {
    static class Edge{
        int src;
        int dest;

        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[],int V){
        //initialize empty graph
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add( new Edge(4,3));

    }
    public static void dfs(ArrayList<Edge> graph[],int curr,int par,int dt[],int low[],boolean visited[],int time,boolean ap[]){
            visited[curr]=true;

            dt[curr]=low[curr]=++time;
            int children=0; //track children
            
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                int neigh=e.dest;

                if(par==e.dest){  
                    continue;
                }
                else if(visited[neigh]){ // already visited
                    low[curr]=Math.min(low[curr],low[neigh]);//update the low
                }
                
                else{
                    //not visited then visit the neigh making it curr and passing to function 
                    dfs(graph, neigh, curr, dt, low, visited, time,ap);
                    low[curr]=Math.min(low[curr], dt[neigh]);//update the low of curr vertex if not visited
                    if(par!=-1 && dt[curr]<=low[neigh]){
                        ap[curr]=true;
                    }
                    children++;
                }
            }
            if(par==-1 && children>1){
                ap[curr]=true;
            }
    }
    public static void getAP(ArrayList<Edge> graph[],int V){
        int dt[]=new int[V];
        int low[]=new int[V];   
        int time=0;
        boolean visited[]=new boolean[V];
        boolean ap[]=new boolean[V]; //to track articulation point in larger graphs multiple times articulation vetex may be printed 
        //or found multiple times so to manage that keep a boolen array.
        for(int i=0;i<V;i++){
            if(!visited[i]){
                //perform dfs
                dfs(graph, i, -1, dt, low, visited, time,ap);   
            }
        }
        for(int i=0;i<ap.length;i++){
            if(ap[i]){
                System.out.println("AP: " +i);
            }
        }
    }

    public static void main(String[] args) {
        
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph,V);
        getAP(graph, V);

    }
}
