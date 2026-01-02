import java.util.*;
public class ConnectingCities {

    public static class Edge implements Comparable<Edge>{
        int dest;
        int cost;

        Edge(int d,int wt){
            this.dest=d;
            this.cost=wt;
        }

        @Override
        public int compareTo(Edge e2){
            return this.cost-e2.cost; //ascending order based on cost of all edges
        }
    }

    public static int minimumCostConnectCities(int cities[][],int V){ //0(V*E)
        ArrayList<Edge> graph[]=new ArrayList[V];
        //createGraph(cities,graph,V);
        int finalCost=0;
        //add edges in priorityqueue sort based on 
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        boolean visited[]=new boolean[V];
        //add dest and cost initialize  
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge curr=pq.remove();

            if(!visited[curr.dest]){
                visited[curr.dest]=true;
                finalCost+=curr.cost;
                //visit all neighbor
                for(int i=0;i<cities[curr.dest].length;i++){
                    if(cities[curr.dest][i]!=0){
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;

    }
    public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        int V=cities.length;
        int minDist=minimumCostConnectCities(cities, V);
        System.out.println(minDist);
    }
}
