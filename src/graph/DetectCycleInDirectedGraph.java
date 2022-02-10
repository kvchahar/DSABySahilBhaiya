package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraph {

    // DFS


    // Function to detect cycle in a directed graph.
    // public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    //     HashSet<Integer> visited = new HashSet<>();
    //     HashSet<Integer> recursiveStack = new HashSet<>();

    //     for(int i = 0; i<V; i++){
    //         if(visited.contains(i)){
    //             continue;
    //         }
    //         if(isCyclePresent(i,visited,recursiveStack,adj)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // private boolean isCyclePresent(int node, HashSet<Integer> visited, HashSet<Integer> recursiveStack,
    // ArrayList<ArrayList<Integer>> adj){
    //     visited.add(node);
    //     recursiveStack.add(node);

    //     for(int elem : adj.get(node)){
    //         if(!visited.contains(elem)){
    //             if(isCyclePresent(elem,visited,recursiveStack,adj)){
    //                 return true;
    //             }
    //         }else if(recursiveStack.contains(elem)){
    //             return true;
    //         }
    //     }
    //     recursiveStack.remove(node);
    //     return false;
    // }







    // Kahn's algo BFS

    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){

        int[] inDegree = new int[V];

        for(int i = 0; i<V; i++){
            for(int edge : adj.get(i)){
                inDegree[edge]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i<V; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int currentNode = queue.poll();

            count++;

            for(int elem : adj.get(currentNode)){
                inDegree[elem]--;
                if(inDegree[elem]==0){
                    queue.add(elem);
                }
            }
        }

        if(count==V)
            return false;
        return true;
    }
}
