import java.util.*;
public class AllPathfromSrctotarget {
    
    static class Edge{
        int source;
        int dest;

        Edge(int s,int d){
            this.source=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    //Exponential time complexity ie 0(V)
    public static void printAllPath(ArrayList<Edge> graph[],int src,int target,String path){
        if(src==target){    
            System.out.println(path+target);
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            printAllPath(graph, e.dest, target, path+src);
        }
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        int src=5;
        int target=1;
        printAllPath(graph, src, target, "");
    }
}
 