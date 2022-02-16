package graph.pepcoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node {
    int vertex;
    int edges;

    public Node(int vertex, int edges) {
        this.vertex = vertex;
        this.edges = edges;
    }
}

public class PerfectFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[n];

        for (int v = 0; v < n; v++) {
            graph[v] = new ArrayList<>();
        }

        for (int e = 0; e < k; e++) {
            String[] inp = br.readLine().split(" ");

            int v1 = Integer.parseInt(inp[0]);
            int v2 = Integer.parseInt(inp[1]);

            graph[v1].add(new Node(v1, v2));
            graph[v1].add(new Node(v2, v1));
        }

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                ArrayList<Integer> list = new ArrayList<>();
                createGraph(graph, v, list, visited);
                lists.add(list);
            }
        }
        int pairs = 0;

        for (int i = 0; i < lists.size(); i++) {
            for (int j = i+1; j <lists.size(); j++) {
                int count = lists.get(i).size() * lists.get(j).size();
                pairs += count;
            }
        }
        System.out.println(pairs);
    }
    public static void createGraph(ArrayList<Node>[] graph,int currV, ArrayList<Integer> list,boolean[] visited){
        visited[currV] = true;
        list.add(currV);

        for(Node edge : graph[currV]){
            if(!visited[edge.edges]){
                createGraph(graph,edge.edges,list,visited);
            }
        }
    }
}
