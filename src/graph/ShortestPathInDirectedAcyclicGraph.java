package graph;

import java.util.ArrayList;
import java.util.Stack;

class Pairs{
    int vertex;
    int weight;

    public Pairs(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
public class ShortestPathInDirectedAcyclicGraph {

    public static void topoSort(int node,boolean[] visited,Stack<Integer> stack, ArrayList<ArrayList<Pairs>> adj){
        visited[node] = true;

        for(Pairs elem : adj.get(node)){
            if(!visited[elem.vertex]){
                topoSort(elem.vertex,visited,stack,adj);
            }
        }
        stack.add(node);
    }

    public static void shortestPath(int source, ArrayList<ArrayList<Pairs>> adj, int N){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];

        for (int i = 0; i <N; i++) {
            if(!visited[i]){
                topoSort(i,visited,stack,adj);
            }
        }
        for (int i = 0; i <N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;

        while (!stack.empty()){
            int node = stack.pop();

            if(distance[node]!=Integer.MAX_VALUE){
                for(Pairs pair : adj.get(node)){
                    if(distance[node]+ pair.weight < distance[pair.vertex]){
                        distance[pair.vertex] = distance[node] + pair.weight;
                    }
                }
            }
        }

        for (int i = 0; i <N; i++) {
            System.out.print(distance[i]+" ");
        }
    }
    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Pairs>> adj = new ArrayList<>();

        for (int i = 0; i <n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pairs(1,2));
        adj.get(0).add(new Pairs(4,1));
        adj.get(1).add(new Pairs(2,3));
        adj.get(2).add(new Pairs(3,6));
        adj.get(4).add(new Pairs(2,2));
        adj.get(4).add(new Pairs(5,4));
        adj.get(5).add(new Pairs(3,1));
        shortestPath(0,adj,n);
    }
}
