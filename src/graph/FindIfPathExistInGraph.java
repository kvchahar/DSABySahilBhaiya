package graph;

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // BFS

//         List<Integer>[] list = new ArrayList[n];

//         for(int i = 0; i<n; i++){
//             list[i] = new ArrayList<>();
//         }

//         for(int i = 0; i<edges.length; i++){
//             int vertex = edges[i][0];
//             int edge = edges[i][1];

//             list[vertex].add(edge);
//             list[edge].add(vertex);
//         }

//         Queue<Integer> queue = new LinkedList<>();
//         boolean[] visited = new boolean[n];

//         queue.add(source);

//         while(queue.size()>0){
//             int currentPath = queue.remove();

//             if(visited[currentPath])
//                 continue;

//             if(currentPath==destination){
//                 return true;
//             }

//             visited[currentPath] = true;

//             for(int values : list[currentPath]){
//                 queue.add(values);

//             }
//         }

//          return false;






        // DFS

        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n];

        for(int i = 0; i<edges.length; i++){
            int vertex = edges[i][0];
            int edge = edges[i][1];

            graph[vertex].add(edge);
            graph[edge].add(vertex);
        }

        dfs(source,destination,visited,graph);

        return visited[destination];

    }

    private void dfs(int source, int destination,boolean[] visited,List<Integer>[] graph){

        visited[source] = true;

        if(source==destination){
            return;
        }

        for(int paths : graph[source]){
            if(!visited[paths]){
                dfs(paths,destination,visited,graph);
            }
        }
    }
}
