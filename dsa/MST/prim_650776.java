package MST;

import java.util.Arrays;

public class prim_650776 {
    private int[][] graph;
    private int countOfVertices;

    public prim_650776(int[][] graph) {
        this.graph = graph;
        this.countOfVertices = graph.length;
    }

    public int[][] getMST() {
        return getMST(0);
    }

    public int[][] getMST(int source) {
        int[] parent = new int[countOfVertices];
        int[] key = new int[countOfVertices];
        boolean[] mstSet = new boolean[countOfVertices];

        for (int i = 0; i < countOfVertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[source] = 0;
        parent[source] = -1;

        for (int i = 0; i < countOfVertices - 1; i++) {
            int u = findMinKeyVertex(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < countOfVertices; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        int[][] mst = new int[countOfVertices][countOfVertices];
        for (int i = 0; i < countOfVertices; i++) {
            if (parent[i] != -1) {
                mst[parent[i]][i] = graph[i][parent[i]];
            }
        }

        return mst;
    }

    public static void showTreeAdjacency(int[][] mst) {
        for (int[] row : mst) {
            System.out.println(Arrays.toString(row));
        }
    }

    private int findMinKeyVertex(int[] key, boolean[] mstSet) {
        int minKey = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < countOfVertices; v++) {
            if (!mstSet[v] && key[v] < minKey) {
                minKey = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        prim_650776 mst = new prim_650776(new int[][] { { 0, 2, 0, 6, 0 }, 
        { 2, 0, 3, 8, 5 }, 
        { 0, 3, 0, 0, 7 },
        { 6, 8, 0, 0, 9 }, 
        { 0, 5, 7, 9, 0 } });
        System.out.println("-input--");
        for (int[] row : mst.graph)
            System.out.println(Arrays.toString(row));
        System.out.println("----");
        prim_650776.showTreeAdjacency(mst.getMST());
        System.out.println("----");
        prim_650776.showTreeAdjacency(mst.getMST(2));
    }
}
