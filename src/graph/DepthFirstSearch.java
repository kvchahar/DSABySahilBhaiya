package graph;

import java.util.ArrayList;

public class DepthFirstSearch {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> graph = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        for(int i = 0; i<V; i++){
            if(!visited[i]){
                dfs(i,graph,adj,visited);
            }
        }

        return graph;
    }

    private void dfs(int node, ArrayList<Integer> graph, ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        graph.add(node);

        visited[node] = true;

        for(int val : adj.get(node)){
            if(!visited[val]){
                dfs(val,graph,adj,visited);
            }
        }
    }
}
