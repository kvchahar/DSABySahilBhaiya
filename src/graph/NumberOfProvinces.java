package graph;


import java.util.ArrayList;

public class NumberOfProvinces {
    public int findCircleNum(int[][] grid) {
        int n = grid.length;
        int ways = 0;
        boolean[] visited = new boolean[n];

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int v = 0; v < n; v++) {
            for (int e = 0; e < n; e++) {
                if (grid[v][e] == 1) {
                    graph[v].add(e);
                    graph[e].add(v);
                }
            }
        }

        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                totalProvinces(v, graph, visited);
                ways++;
            }
        }
        return ways;
    }

    private void totalProvinces(int currentNode, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[currentNode] = true;

        for (int neighbour : graph[currentNode]) {
            if (!visited[neighbour]) {
                totalProvinces(neighbour, graph, visited);
            }
        }
    }
}