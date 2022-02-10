package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = createGraph(numCourses,prerequisites);

        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> recursiveStack = new HashSet<>();
        List<Integer> traversal = new ArrayList<>();

        for(int i = 0; i<numCourses; i++){

            if(visited.contains(i)){
                continue;
            }
            if(isCycle(i,visited,recursiveStack,traversal,graph)){
                return new int[0];
            }
        }


        Collections.reverse(traversal);

        int[] answer = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            answer[i] = traversal.get(i);
        }

        return answer;

    }

    private boolean isCycle(int currentVertex,HashSet<Integer> visited,
                            HashSet<Integer> recursiveStack,
                            List<Integer> traversal,List<List<Integer>> graph){
        visited.add(currentVertex);
        recursiveStack.add(currentVertex);

        for(int neighbour : graph.get(currentVertex)){
            if(!visited.contains(neighbour)){
                if(isCycle(neighbour,visited,recursiveStack,traversal,graph)){
                    return true;
                }
            }

            if(recursiveStack.contains(neighbour)){
                return true;
            }
        }

        traversal.add(currentVertex);
        recursiveStack.remove(currentVertex);
        return false;
    }

    private List<List<Integer>> createGraph(int n, int[][] edges){

        List<List<Integer>> graph = new ArrayList<>(n);

        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int v = edge[0];
            int u = edge[1];

            graph.get(u).add(v);
        }

        return graph;

    }
}