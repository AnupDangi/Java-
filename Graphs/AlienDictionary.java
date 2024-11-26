import java.util.*;
public class AlienDictionary {

    public static String findOrder(String[] dict, int N, int K) {
        // Step 1: Create a graph with K nodes for K different characters
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Build the graph by comparing adjacent words
        for (int i = 0; i < N - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int minLength = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int u = word1.charAt(j) - 'a';
                    int v = word2.charAt(j) - 'a';
                    graph.get(u).add(v);
                    break;
                }
            }
        }

        // Step 3: Topological Sort using Kahn's Algorithm (BFS approach)
        int[] indegree = new int[K];
        for (int i = 0; i < K; i++) {
            for (int v : graph.get(i)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.append((char) (u + 'a'));

            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // If the order has K characters, it means we have a valid ordering
        return order.length() == K ? order.toString() : "";
    }

    public static void main(String[] args) {
        String[] dict1 = {"caa", "aaa", "aab"};
        System.out.println(findOrder(dict1, 3, 3)); // Output: A valid order like "cab"

        String[] dict2 = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(dict2, 5, 4)); // Output: A valid order like "bdac"
    }
}

