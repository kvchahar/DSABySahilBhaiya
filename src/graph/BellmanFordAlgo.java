package graph;

public class BellmanFordAlgo {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int src = edge[0];
                int dest = edge[1];
                int weight = edge[2];

                if (distance[src] != Integer.MAX_VALUE)
                    distance[dest] = Math.min(distance[dest], distance[src] + weight);
            }
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];

            if (distance[src] != Integer.MAX_VALUE && distance[dest] > distance[src] + weight) {
                return 1;
            }
        }

        return 0;
    }
}
