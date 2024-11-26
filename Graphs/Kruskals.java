import java.util.*;
public class Kruskals {
    
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;
        int src;

        public Edge(int s,int d,int cost){
            this.src=s;
            this.dest=d;
            this.cost=cost;
        }

        @Override
        public int compareTo(Edge e2){
            //compare based on cost in ascending order
            return this.cost-e2.cost;
        }

    }
    static int n=4;
    static int par[]=new int[n];
    static int rank[]=new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i; //parent of self at first initialize
        }
    }
    //find parent 
    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        //optimized to store same parent 
        return par[x]=find(par[x]);
    }
    public static void union(int a,int b){
        //steps find parent of each vertex
        int parA=find(a);
        int parB=find(b);

        if(rank[parA]==rank[parB]){
            par[parA]=parB; //update par of parentofA to parB
            rank[parA]++; //update
        }
        else if (rank[parA]<rank[parB]) {
            par[parA]=parB;   
        }
        else{
            par[parB]=parA;
        }

    }
    public static void createGraph(ArrayList<Edge> edges){
        //edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    public static void MSTkruskals(ArrayList<Edge> edges,int V){
        init();
        //sort in ascending order
        Collections.sort(edges);//0(ELogE)
        int mstCost=0;
        int count=0;

        for(int i=0;count<V-1;i++){
            //take edges
            Edge e=edges.get(i);
            //(src,dest,wt)
            int parA=find(e.src); //a =src
            int parB=find(e.dest);//b=dest

            if(parA!=parB){  
                union(e.src, e.dest);
                mstCost+=e.cost;
                count++;
            }
        }
        System.out.println(mstCost);
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> edges=new ArrayList<>();
        createGraph(edges);
        MSTkruskals(edges, V);
    }
}
