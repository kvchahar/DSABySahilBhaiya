package graph;

import java.util.Arrays;

public class IsBipartite {

    // BFS


//      public boolean isBipartite(int[][] graph)
//     {

//          int[] coloured = new int[graph.length];
//          Arrays.fill(coloured,-1);

//          for(int i = 0; i<graph.length; i++){
//              if(coloured[i]==-1){
//                  if(!isBipartiteGraph(i,coloured,graph)){
//                      return false;
//                  }
//              }
//          }
//          return true;
//     }

//     private boolean isBipartiteGraph(int node, int[] coloured, int[][] graph){


//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(node);

//         coloured[node] = 1;

//         while(!queue.isEmpty()){
//             int currentNode = queue.remove();

    //             for(int elem : graph[currentNode]){
//                 if(coloured[elem]==-1){
//                     coloured[elem] = 1 - coloured[currentNode];
//                     queue.add(elem);
//                 }else if(coloured[elem]==coloured[currentNode]){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }



    // DFS
    public boolean isBipartite(int[][] graph)
    {

        int[] coloured = new int[graph.length];
        Arrays.fill(coloured,-1);

        for(int i = 0; i<graph.length; i++){
            if(coloured[i]==-1){
                if(!isBipartiteGraph(i,coloured,0,graph)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteGraph(int node, int[] coloured, int color,int[][] graph){

        if(coloured[node]!=-1){
            return coloured[node] == color;
        }

        coloured[node] = color;

        for(int neighbour : graph[node]){
            if(!isBipartiteGraph(neighbour,coloured,1-color,graph)){
                return false;
            }
        }
        return true;
    }
}