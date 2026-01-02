import java.util.*;
public class BellManFord {
    
    public static class Edge{
        int source;
        int dest;
        int wt;
        Edge(int source,int dest,int wt){
            this.source=source;
            this.dest=dest;
            this.wt=wt;
        }
    }
    //create a graph 
    // public static void createGraph(ArrayList<Edge> graph[]){  O(V*E)

    //     for(int i=0;i<graph.length;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     graph[0].add(new Edge(0, 1, 2));
    //     graph[0].add(new Edge(0, 2, 4));

    //     graph[1].add(new Edge(1, 2, -4));
        
    //     graph[2].add(new Edge(2, 3, 2));
        
    //     graph[3].add(new Edge(3, 4, 4));

    //     graph[4].add(new Edge(4, 1, -1));
    // }

    //create 2nd graph
    public static void createGraph2(ArrayList<Edge> graph){
            graph.add(new Edge(0, 1, 2));
            graph.add(new Edge(0, 2, 4));
            graph.add(new Edge(1, 2, -4));
            graph.add(new Edge(2, 3, 2));
            graph.add(new Edge(3, 4, 4));
            graph.add(new Edge(4, 1, -1));
    }

    // public static void bellmanFord(ArrayList<Edge> graph[],int source){
    //     int dist[]=new int[graph.length];
    //     for(int i=0;i<dist.length;i++){
    //         if(i!=source){
    //             dist[i]=Integer.MAX_VALUE;
    //         }
    //     }
    //     int V=graph.length;
    //     //
    //     for(int i=0;i<V-1;i++){
    //         //edges O(E)
    //         for(int j=0;j<graph.length;j++){
    //             for(int k=0;k<graph[j].size();k++){
    //                 Edge e=graph[j].get(k);
    //                 //u,v,wt
    //                 int u=e.source;
    //                 int v=e.dest;
    //                 int wt=e.wt;

    //                 //relaxation
    //                 if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
    //                         dist[v]=dist[u]+wt;                   
    //                 }
    //             }
    //         }
    //     }
    //     for(int i=0;i<dist.length;i++){
    //         System.out.println(dist[i]+" ");
    //     }
    // }


    public static void bellmanFord2(ArrayList<Edge> graph,int source,int V){
        int dist[]=new int[V];
        for(int i=0;i<dist.length;i++){
            if(i!=source){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        //  *V - TC
        for(int i=0;i<V-1;i++){
            //edges 0(E)
                for(int j=0;j<graph.size();j++){
                    Edge e=graph.get(j);
                    //u,v,wt
                    int u=e.source;
                    int v=e.dest;
                    int wt=e.wt;

                    //relaxation
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                            dist[v]=dist[u]+wt;                   
                    }
                }
         }
        for(int i=0;i<dist.length;i++){
            System.out.println(dist[i]+" ");
        }
    }
    public static void main(String[] args) {
        int V=5;
        //ArrayList<Edge> graph[]=new ArrayList[V];
        ArrayList<Edge> graph=new ArrayList<>();

        // createGraph(graph);
            createGraph2(graph);
            bellmanFord2(graph, 0, V);
        // bellmanFord(graph, 0);
    }
}
