package graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = graph.length;

        boolean[] visited = new boolean[n];

        sourceToTarget(graph, 0, visited, new ArrayList<>(), n, answer);

        return answer;
    }

    private void sourceToTarget(int[][] graph, int currentNode, boolean[] visited, List<Integer> currentPath, int n, List<List<Integer>> answer) {

        if (currentNode == n - 1) {
            currentPath.add(currentNode);
            answer.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        if (visited[currentNode]) {
            return;
        }


        visited[currentNode] = true;
        currentPath.add(currentNode);

        for (int neighbours : graph[currentNode]) {
            sourceToTarget(graph, neighbours, visited, currentPath, n, answer);

        }
        visited[currentNode] = false;
        currentPath.remove(currentPath.size() - 1);
    }
}
