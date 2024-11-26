import java.util.*;
public class DetectCycleUndirectedUsingBFS {
    
    static class Edge{
        int source;
        int dest;

        Edge(int s,int d){
            this.source=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        //initialize the null arraylist for each edge in a graph
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        //add edges and vertices
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    public static boolean detectCycle(int src,ArrayList<Edge> graph[]){//0(V+E)
        //Using BFS detect cycle in undirected graph
        int N=graph.length;
        //1. Implement BFS using Queue
        boolean[]vis=new boolean[N];
        Queue<Integer> q=new LinkedList<>();
        int []parent=new int[N];
        Arrays.fill(parent, -1);
        q.add(src);
        vis[src]=true;
        while(!q.isEmpty()){
            int curr=q.remove();

            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                int dest=e.dest;
                if(!vis[dest]){
                    vis[dest]=true;
                    parent[dest]=curr; //set the parent of the destination as curr node who called it 
                    q.add(dest);
                }
                else if(parent[curr]!=dest){//if the destination is already visited and the parent of curr node is not the same as destination 
                    //if it is already visited and it's not the parent of the current node,a cycle is detected
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        int src=0;
        System.out.println(detectCycle(src,graph));
    }
}
