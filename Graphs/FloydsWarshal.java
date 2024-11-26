import java.util.*;
public class FloydsWarshal {

    final static int INF = 99999, V = 4;

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;

        // Initialize the distance matrix with the input graph values
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        // Update the distance matrix
        for (k = 0; k < V; k++) {  // Pick each vertex as an intermediate vertex
            for (i = 0; i < V; i++) {  // Pick each source vertex
                for (j = 0; j < V; j++) {  // Pick each destination vertex
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution(dist);  // Print the final shortest path distances
    }

    void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = {
            { 0, 5, INF, 10 },
            { INF, 0, 3, INF },
            { INF, INF, 0, 1 },
            { INF, INF, INF, 0 }
        };
        FloydsWarshal fd = new FloydsWarshal();
        fd.floydWarshall(graph);
    }
}
