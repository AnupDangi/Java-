import java.util.*;
public class DFS {
    static class Edge{
        int source;
        int destination;
        
        Edge(int s,int d){
            this.source=s;
            this.destination=d;
        }
    }
    public static void creategraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            //initialize with new arraylist for each edge
            graph[i]=new ArrayList<>();
        }
        //0->add
        graph[0].add(new Edge(0, 1 ));
        graph[0].add(new Edge(0, 2));

        //1->add
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        //2->add
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        //3->add
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        //4-<add
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        //5->add
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        //6->add 
        graph[6].add(new Edge(6, 5));
    }

    //This utildfs is used when we non-connected components in a graph.
    public static void dfs(ArrayList<Edge> graph[]){
        boolean visi[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            dfsUtil(graph, i, visi);
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[],int curr,boolean visited[]){ //0(V+E)

        //create boolean array
        System.out.println(curr +" ");
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.destination]){
                //next destination as curr for 
                dfsUtil(graph, e.destination,visited);
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[],int curr,boolean visited[]){ //0(V+E)

        //create boolean array
        System.out.println(curr +" ");
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.destination]){
                //next destination as curr for 
                dfs(graph, e.destination,visited);
            }
        }
    }
    public static void hasDirectPath(ArrayList<Edge> graph[],int source,int dest){
        boolean track=false;
        for(int i=0;i<graph[source].size();i++){
            Edge e=graph[source].get(i);
            if(e.destination==dest){
                track=true;
            }
        }
        System.out.println(track);
    }
    public static boolean hasindirectPath(ArrayList<Edge> graph[],int source,int dest,boolean visited[]){ //0(V+E)
            //case 1: if source is same as destination
            if(source==dest){
                return true;
            }  
            visited[source]=true;
            for(int i=0;i<graph[source].size();i++){
                Edge e=graph[source].get(i);
                if(!visited[e.destination]&& hasindirectPath(graph, e.destination, dest,visited)){
                    return true;
                }
            }
            return false;
    }
    public static void main(String[] args) { 
        int V=7;
        ArrayList<Edge> graph[]=new ArrayList[V];
        creategraph(graph);
        boolean visited[]=new boolean[V];
        dfs(graph, 0,visited);
        hasDirectPath(graph, 0, 6); 
        boolean hasPath=hasindirectPath(graph,0,6,new boolean[V]);
        System.out.println(hasPath);
    }
}
