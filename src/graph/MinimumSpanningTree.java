package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair2 implements Comparable<Node>{
    int vertex;
    int cost;

    Pair2(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node node){
        return this.cost - node.cost;
    }
}

public class MinimumSpanningTree {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair2> queue = new PriorityQueue<>();
        int[] costs = new int[V];
        boolean[] visited = new boolean[V];
        queue.add(new Pair2(0, 0));

        int ans = 0;

        while (!queue.isEmpty()) {
            Pair2 currentPair = queue.remove();


            if (visited[currentPair.vertex])
                continue;

            ans += currentPair.cost;

            visited[currentPair.vertex] = true;
            costs[currentPair.vertex] = currentPair.cost;

            ArrayList<ArrayList<Integer>> neighbours = adj.get(currentPair.vertex);

            for (ArrayList<Integer> neighbour : neighbours) {
                int currentNeighbour = neighbour.get(0);
                int currentWeight = neighbour.get(1);

                if (visited[currentNeighbour])
                    continue;

                queue.add(new Pair2(currentNeighbour, currentWeight));
            }
        }
        return ans;
    }
}