package graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] visited = new int[V+1];
        // ArrayList<Integer> traversal = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<V; i++){
            if(visited[i]==0){
                dfs(i,adj,visited,stack);
            }
        }

        int[] ans = new int[V];

        for(int i = 0; i<V; i++){
            ans[i] = stack.pop();
        }
        return ans;
    }

    private static void dfs(int currentVertex, ArrayList<ArrayList<Integer>> adj, int[] visited,Stack<Integer> stack){
        visited[currentVertex] = 1;

        for(int neighbour : adj.get(currentVertex)){
            if(visited[neighbour]==0){
                dfs(neighbour,adj,visited,stack);
            }
        }

        stack.push(currentVertex);
    }
}