
import java.util.*;
public class BFS {
    static class Edge{
        int source;
        int destination;
        int weight;

        Edge(int s,int d,int w){
            this.source=s;
            this.destination=d;
            this.weight=w;
        }
    }

    public static void creategraph(ArrayList<Edge>graph[]){
            for(int i=0;i<graph.length;i++){
                //initialize with new arraylist for each edge
                graph[i]=new ArrayList<>();
            }
            //0->add
            graph[0].add(new Edge(0, 1, 1));
            graph[0].add(new Edge(0, 2, 1));

            //1->add
            graph[1].add(new Edge(1, 0, 1));
            graph[1].add(new Edge(1, 3, 1));

            //2->add
            graph[2].add(new Edge(2, 0, 1));
            graph[2].add(new Edge(2, 4, 1));

            //3->add
            graph[3].add(new Edge(3, 1, 1));
            graph[3].add(new Edge(3, 4, 1));
            graph[3].add(new Edge(3, 5, 1));

            //4-<add
            graph[4].add(new Edge(4, 2, 1));
            graph[4].add(new Edge(4, 3, 1));
            graph[4].add(new Edge(4, 5, 1));

            //5->add
            graph[5].add(new Edge(5, 3, 1));
            graph[5].add(new Edge(5, 4, 1));
            graph[5].add(new Edge(5, 6, 1));

            //6->add 
            graph[6].add(new Edge(6, 5, 1));

    }
    //When we have  Non connected component of graph
    public static void bfs(ArrayList<Edge> graph[]){
        boolean visi[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visi[i]){
                bfsUtil(graph,visi);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>graph[],boolean visi[]){ //0(V+E) max of V,E ||  for matrix 0(V^2)  
        //1.use queue
        Queue<Integer> q=new LinkedList<>();    
        boolean[] visited=new boolean[graph.length];
        //add first element as source=0
        q.add(0);

        //remove all element in such a way that removing first element marks the visited array and add its connected vertices into q
        while(!q.isEmpty()){
            int curr=q.remove();
            
            if(!visited[curr]){
                //1.print 
                //2.mark the curr as visited
                //3.add all its connected vertices into queue
                System.out.print(curr);
                visited[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    //take out all edge
                    Edge e=graph[curr].get(i);
                    //add destination of curr which is the neighbor
                    q.add(e.destination);
                }
            }
        }
    }

    // public static void bfs(ArrayList<Edge>graph[]){ //0(V+E) max of V,E ||  for matrix 0(V^2)  
    //     //1.use queue
    //     Queue<Integer> q=new LinkedList<>();    
    //     boolean[] visited=new boolean[graph.length];
    //     //add first element as source=0
    //     q.add(0);

    //     //remove all element in such a way that removing first element marks the visited array and add its connected vertices into q
    //     while(!q.isEmpty()){
    //         int curr=q.remove();
            
    //         if(!visited[curr]){
    //             //1.print 
    //             //2.mark the curr as visited
    //             //3.add all its connected vertices into queue
    //             System.out.print(curr);
    //             visited[curr]=true;
    //             for(int i=0;i<graph[curr].size();i++){
    //                 //take out all edge
    //                 Edge e=graph[curr].get(i);
    //                 //add destination of curr which is the neighbor
    //                 q.add(e.destination);
    //             }
    //         }
    //     }
    // }
    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge> graph[]=new ArrayList[V];
        creategraph(graph);
        bfs(graph);
    }

}
