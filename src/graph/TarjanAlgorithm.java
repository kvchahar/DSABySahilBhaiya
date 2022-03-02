package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarjanAlgorithm {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = createGraph(n,connections);

        return findCriticalConnections(n,graph);
    }

    private List<List<Integer>> findCriticalConnections(int n, List<Integer>[] graph){
        int[] discoveryTime = new int[n];
        int[] minimumTime = new int[n];

        Arrays.fill(discoveryTime,-1);
        Arrays.fill(minimumTime,-1);

        List<List<Integer>> answer = new ArrayList<>();

        int[] time = {0};

        tarjanAlgorithm(graph,discoveryTime,minimumTime,0,-1,answer,time);

        return answer;
    }

    private void tarjanAlgorithm(List<Integer>[] graph, int[] discTime, int[] minTime,int currentVertex, int currentParent, List<List<Integer>> answer,int[] time){

        discTime[currentVertex] = time[0];
        minTime[currentVertex] = time[0];
        time[0] += 1;

        for(int neigh : graph[currentVertex]){
            if(neigh==currentParent)
                continue;

            if(discTime[neigh]!=-1){
                minTime[currentVertex] = Math.min(minTime[currentVertex],discTime[neigh]);
                continue;
            }

            tarjanAlgorithm(graph,discTime,minTime,neigh,currentVertex,answer,time);
            minTime[currentVertex] = Math.min(minTime[currentVertex],minTime[neigh]);

            if(discTime[currentVertex]<minTime[neigh]){
                List<Integer> articulationPoints = new ArrayList<>();
                articulationPoints.add(currentVertex);
                articulationPoints.add(neigh);

                answer.add(articulationPoints);
            }
        }
        return;
    }

    private List<Integer>[] createGraph(int n, List<List<Integer>> connections){

        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(List<Integer> neigh : connections){
            int u = neigh.get(0);
            int v = neigh.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        return graph;
    }
}