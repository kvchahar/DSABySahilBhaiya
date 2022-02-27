package graph;

import java.util.ArrayList;
class Nodes {
    int vertex;
    int weight;

    public Nodes(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Prim_sAlgorithm {

    private static void primeAlgo(ArrayList<ArrayList<Nodes>> adj, int n) {
        int[] keys = new int[n];
        boolean[] mst = new boolean[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            keys[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        keys[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            int minI = Integer.MAX_VALUE, u = 0;
            for (int v = 0; v < n; v++) {
                if (!mst[v] && keys[v] < minI) {
                    minI = keys[v];
                    u = v;
                }
            }

            mst[u] = true;

            for (Nodes vt : adj.get(u)) {
                if (!mst[vt.vertex] && vt.weight < keys[vt.vertex]) {
                    parent[vt.vertex] = u;
                    keys[vt.vertex] = vt.weight;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(parent[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Nodes>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Nodes(1, 2));
        adj.get(1).add(new Nodes(0, 2));

        adj.get(1).add(new Nodes(2, 3));
        adj.get(2).add(new Nodes(1, 3));

        adj.get(0).add(new Nodes(3, 6));
        adj.get(3).add(new Nodes(0, 6));

        adj.get(1).add(new Nodes(3, 8));
        adj.get(3).add(new Nodes(1, 8));

        adj.get(1).add(new Nodes(4, 5));
        adj.get(4).add(new Nodes(1, 5));

        adj.get(2).add(new Nodes(4, 7));
        adj.get(4).add(new Nodes(2, 7));

        primeAlgo(adj, n);
    }
}
