package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node> {
    int vertex;
    int weight;

    Node(){

    }
    Node(int V, int W) {
        vertex = V;
        weight = W;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.weight < node2.weight) {
            return -1;
        }
        if (node1.weight > node2.weight) {
            return 1;
        }
        return 0;
    }
}


public class DijkstrasAlgorithm {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<Node>> adj, int S) {
        // Write your code here
        int[] res = new int[V];
        int[] distance = new int[V];

        for (int i = 0; i < V; i++) {
            distance[i] = 1000000;
        }

        distance[S] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, new Node());
        pq.add(new Node(S, 0));

        while (pq.size() > 0) {
            Node node = pq.poll();

            for (Node elem : adj.get(node.vertex)) {
                if (distance[node.vertex] + elem.weight < distance[elem.vertex]) {
                    distance[elem.vertex] = distance[node.vertex] + elem.weight;
                    pq.add(new Node(elem.vertex, distance[elem.vertex]));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            res[i] = distance[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Node(1,2));
        adj.get(1).add(new Node(0,2));

        adj.get(1).add(new Node(2,4));
        adj.get(2).add(new Node(1,4));

        adj.get(0).add(new Node(3,1));
        adj.get(3).add(new Node(0,1));

        adj.get(3).add(new Node(2,3));
        adj.get(2).add(new Node(3,3));

        adj.get(1).add(new Node(4,5));
        adj.get(4).add(new Node(1,5));

        adj.get(2).add(new Node(4,1));
        adj.get(4).add(new Node(2,1));

        int[] res = dijkstra(n,adj,0);

        for (int i = 0; i <res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}