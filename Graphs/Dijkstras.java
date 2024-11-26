import java.lang.reflect.Array;
import java.util.*;
public class Dijkstras {
    
    static class Edge{
        int source;
        int dest;
        int wt;

        Edge(int source,int dest,int wt){
            this.source=source;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        //initialize new arraylist for each edge 
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        //add nodes ,dest and wt
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 4));
        
        graph[2].add(new Edge(2, 3, 2));
        
        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, 1));
        
    }
    //make one class with comparable interface
     static class Pair implements Comparable<Pair>{
        int node;
        int path;

        Pair(int node,int path){
            this.node=node;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.path-this.path; //ascending order
        }
     }

    //dijstras algo
    public static void dijstras(ArrayList<Edge> graph[],int source){

        //create a dist array to store the shortest path 
        int dist[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=source){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        //make a priority Queue of pair to keep track of all the node and store in ascending order
        PriorityQueue<Pair> p=new PriorityQueue<>();    
        //add  source node pair with no path to it 
        p.add(new Pair(source, 0));
        //keep track of boolean visited array
        boolean visited[]=new boolean[graph.length];

        while (!p.isEmpty()) {
            //get the curr node
            Pair curr=p.remove();
            if(!visited[curr.node]){
                //make it visited
                visited[curr.node]=true;

                //iterate over all of its members and get the minimum dist
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    //from that edge get its source,dest and wt then compare
                    int u=e.source;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        p.add(new Pair(v, dist[v]));
                    }   
                }
            }
        }
        System.out.println("Printing all the shortest path form source to dest");
        for(int i=0;i<dist.length;i++){
            System.out.println(source+"->"+i+ " ="+dist[i]);
        }

    }   

    public static void main(String[] args) {
        //ArrayList of edges[] 
        int N=5;
        ArrayList<Edge> graph[]=new ArrayList[N];
        createGraph(graph); 
        dijstras(graph, 0);
    }
}
