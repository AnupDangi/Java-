import java.util.*;
public class ChepestFlightswithinKStops {
    
    public static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static void createGraph(int flights[][],ArrayList<Edge> graph[]){
       //initialize null arraylist for each edge
       for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
       }
       
        for(int i=0;i<flights.length;i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];
        
            Edge e=new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }
    static class Route implements Comparable<Route>{
        int v;
        int cost;
        int stops;

        Route(int v,int cost,int stops){
            this.v=v;
            this.cost=cost;
            this.stops=stops;
        }
        @Override
        //sorting based on k based on ascending order
        public int compareTo(Route r2){
            return this.stops-r2.stops;
        }
    }

    public static int cheapestFlights(int n,int flights[][],int src,int dest,int k){
        //create a graph
        ArrayList<Edge> graph[]=new ArrayList[n];
        createGraph(flights, graph);

        //create distance array 
        int dist[]=new int[graph.length];
        //initialize the distance with maximum value 
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        //create a queue and then add all elements sorting based on k stops 
        Queue<Route> q=new LinkedList<>();
        //add first element into q strating from source node
        q.add(new Route(src, 0, 0));

        while (!q.isEmpty()) {
            Route currroute=q.remove();
            if(currroute.stops>k){
                break;
            }
            //visit currroute paths or members
            for(int i=0;i<graph[currroute.v].size();i++){
                //get every edge info    
                Edge e=graph[currroute.v].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;

                //update new minimum dist when stops<=k and dist[u] is not equals to max infinity
                if( currroute.cost+wt<dist[v]&& currroute.stops<=k){
                    dist[v]=dist[u]+wt;
                    q.add(new Route(v, wt, currroute.stops+1));
                }
            }
        }
        //dist[dest]
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dist[dest];
        }
    }
    public static void main(String[] args) {
         int n=4;
         int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
         int src=0,dst=3,k=1;
         int cheapflight= cheapestFlights(n, flights, src, dst, k);
         System.out.println(cheapflight);
    }
}
