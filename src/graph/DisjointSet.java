package graph;

import java.util.Scanner;

public class DisjointSet {

    static int findParent(int node,int[] parent){
        if(node==parent[node]){
            return node;
        }

        return parent[node] = findParent(parent[node],parent);
    }

    static void union(int v1, int v2,int[] parent,int[] rank){
        v1 = findParent(v1,parent);
        v2 = findParent(v2,parent);

        if(rank[v1]<rank[v2]){
            parent[v1] = v1;
        }else if(rank[v1]>rank[v2]){
            parent[v2] = v1;
        }else{
            parent[v1] = v2;
            rank[v2]++;
        }
    }

    public static void main(String[] args) {
        int n = 7;
        Scanner sc = new Scanner(System.in);
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i = 1; i<=n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int u=0,v=0;
        while (n!=0){
            u = sc.nextInt();
            v = sc.nextInt();
            union(u,v,parent,rank);
            n-=1;
            if(findParent(u,parent)!=findParent(v,parent)){
                System.out.println("Different Component");
            }else {
                System.out.println("Same");
            }
        }

    }
}
