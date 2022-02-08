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
                if(!isBipartiteGraph(i,coloured,graph)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteGraph(int node, int[] coloured, int[][] graph){

        if(coloured[node]==-1){
            if(coloured[node]==1){
                coloured[node]=0;
            }else if(coloured[node]==0){
                coloured[node]=1;
            }
        }

        for(int elem : graph[node]){
            if(coloured[elem]==-1){
                coloured[elem] = 1 - coloured[node];
                if(!isBipartiteGraph(elem,coloured,graph)){
                    return false;
                }
            }else if(coloured[elem]==coloured[node]){
                return false;
            }
        }
        return true;
    }
}