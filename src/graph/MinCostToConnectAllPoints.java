package graph;

import java.util.*;

public class MinCostToConnectAllPoints {
    public static int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int n = points.length; // node count

        for(int i = 0; i < n; i++) {
            int[] iCo = points[i];
            for(int j = i+1; j < n; j++) {
                int[] jCo = points[j];
                int[] edge1 = new int[]{i, j, Math.abs(iCo[0]-jCo[0])+Math.abs(iCo[1]-jCo[1])};
                int[] edge2 = new int[]{j, i, Math.abs(iCo[0]-jCo[0])+Math.abs(iCo[1]-jCo[1])};
                graph.computeIfAbsent(i, k->new ArrayList<>()).add(edge1);
                graph.computeIfAbsent(j, k->new ArrayList()).add(edge2);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[2]-b[2]); // pg for edges sorted by cost minHeap
        Set<Integer> mst = new HashSet(); // Set to record nodes pushed in mst
        int cost = 0;
        if(graph.isEmpty()) return cost;

        mst.add(0);
        for(int[] edge: graph.get(0)) {
            pq.add(edge);
        }

        while(!pq.isEmpty()) {
            // get current min weight
            int[] curMinEdge = pq.poll();
            int nextNode = curMinEdge[1];

            if(!mst.contains(nextNode)) {
                mst.add(nextNode);
                cost += curMinEdge[2];
                // add all edges for next node
                for(int[] edge: graph.get(nextNode)) {
                    // we need to check if node already in tree here as well to avoid adding duplicate edges to save time
                    if(mst.contains(edge[1])) continue;
                    pq.add(edge);
                }
            }
        }


        return mst.size() == n? cost: -1;
    }

    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
    }
}