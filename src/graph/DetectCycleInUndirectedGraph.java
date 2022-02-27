package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {

    // BFS

    // // Function to detect cycle in an undirected graph.
    // public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    //     boolean[] visited = new boolean[V+1];

    //     for(int i = 0; i<V; i++){
    //         if(!visited[i]){
    //             if(isCyclePresent(i,adj,visited)){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // private boolean isCyclePresent(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
    //     Queue<Pair> queue = new LinkedList<>();

    //     queue.add(new Pair(node,-1));
    //     visited[node] = true;

    //     while(!queue.isEmpty()){

    //         Pair pair = queue.poll();
    //         int childNode = pair.x;
    //         int parentNode = pair.y;

    //         for(int child : adj.get(childNode)){
    //             if(visited[child]==false){
    //                 visited[child]=true;
    //                 queue.add(new Pair(child,childNode)); // parentNode becomes childNode here
    //             }

    //             else if(child!=parentNode){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }




    // DFS

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V+1];

        for(int i = 0; i<V; i++){
            if(!visited[i]){
                if(isCyclePresent(i,-1,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclePresent(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[node] = true;

        for(int elem : adj.get(node)){
            if(!visited[elem]){
                if(isCyclePresent(elem,node,adj,visited)) return true;
            }else if(elem!=parent){
                return true;
            }
        }
        return false;
    }
}




