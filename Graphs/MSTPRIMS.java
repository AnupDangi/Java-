import java.util.*;
public class MSTPRIMS {
    
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
            for(int i=0;i<graph.length;i++){
                graph[i]=new ArrayList<>();
            }

            //add all edges 
            graph[0].add(new Edge(0, 1, 10));
            graph[0].add(new Edge(0, 3, 30));
            graph[0].add(new Edge(0, 2, 15));

            graph[1].add(new Edge(1, 0, 10));
            graph[1].add(new Edge(1, 3, 40));
            
            graph[2].add(new Edge(2, 0, 15));
            graph[2].add(new Edge(2, 3, 50));

            graph[3].add(new Edge(3, 0, 30));
            graph[3].add(new Edge(3, 2, 50));
            graph[3].add(new Edge(3, 1, 40));

    }

    static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost; //ascending order
        }
    }
    public static void primsMST(ArrayList<Edge> graph[],int V){
        boolean visited[]=new boolean[graph.length];

        //make a priority queue to store pair
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        //add source it can be randomly 
        pq.add(new Pair(0, 0)); //start with 0th node and 0 cost to visit it

        int finalCost=0;

        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            //visit and until it is empty 
            if(!visited[curr.v]){
                visited[curr.v]=true;
                finalCost+=curr.cost;

                //traverse all its neighbor 
                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e=graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("final cost of MST ="+finalCost);
    }
    public static void main(String[]args){
        int V=4;
        ArrayList<Edge> graph[]=new ArrayList[V];

        createGraph(graph);
        primsMST(graph, V);
    }

}
