package graph;

import java.util.*;

public class ShortestPathInUndirectedGraph {
    private static void shortestPath(List<List<Integer>> adj, int N, int src) {

        int[] distance = new int[N];

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i <N; i++) {
            for(int elem : adj.get(i)){
                graph.get(i).add(elem);
            }
        }

        for (int i = 0; i < N; i++) {
            distance[i] = 10000000;
        }

        Queue<Integer> queue = new LinkedList<>();
        distance[src] = 0;

        queue.add(src);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int elem : graph.get(currentNode)) {
                if ((distance[currentNode] + 1) < distance[elem]) {
                    distance[elem] = distance[currentNode] + 1;
                    queue.add(elem);
                }
            }
        }
        for (int i = 0; i <N; i++) {
            System.out.print(distance[i] + " ");
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
                graph.add(Arrays.asList(1, 3));
                graph.add(Arrays.asList(0, 2, 3));
                graph.add(Arrays.asList(1, 6));
                graph.add(Arrays.asList(0, 4));
                graph.add(Arrays.asList(3, 5));
                graph.add(Arrays.asList(4, 6));
                graph.add(Arrays.asList(2, 5, 7, 8));
                graph.add(Arrays.asList(6, 8));
                graph.add(Arrays.asList(6, 7));
                shortestPath(graph,9,0);
    }
}
