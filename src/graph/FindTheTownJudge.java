package graph;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for (int[] ints : trust) {
            int vertex = ints[0];
            int edge = ints[1];

            outDegree[vertex] += 1;
            inDegree[edge] += 1;
        }

        for (int i = 1; i <= n; i++) {
            if (outDegree[i] == 0 && inDegree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
