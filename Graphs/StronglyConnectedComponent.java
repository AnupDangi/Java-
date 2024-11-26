import java.util.*;
public class StronglyConnectedComponent { //0(V+E) for all three steps 3*O(V+E)
    
    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    //create graph

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            //initialize with empty graph
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    //kosaraju Algorithm

    public static void topSort(ArrayList<Edge> graph[],int curr,boolean visited[],Stack<Integer> stk){
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.dest]){
                topSort(graph, e.dest, visited, stk);
            }
        }
        stk.push(curr);
    }
    public static void dfs(ArrayList<Edge>graph[],int curr,boolean visited[]){
        visited[curr]=true;
        System.out.println(curr+" ");
        //visit negibor
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[],int V){
        //step1 create stk and add perform toposort vertices
        Stack<Integer> stk=new Stack<>();
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topSort(graph, i, visited, stk); 
            }
        }

        //step2 transpose of graph
        ArrayList<Edge> transpose[]=new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            visited[i]=false;
            transpose[i]=new ArrayList<>();
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e= graph[i].get(j); //e->src to e->dest
                transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse edge
            }
        }

        //step 3 do dfs from the stack nodes
        int i=0;
        while(!stk.isEmpty()){
            int curr=stk.pop();
            if(!visited[curr]){
                System.out.print("SSC ->");
                dfs(transpose, curr, visited); //ssc
                System.out.println();
            }
        }
    }
   
    public static void main(String[] args) {

        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}
