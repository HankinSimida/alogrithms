package ten;

import java.util.Arrays;

/**
 * 普利姆算法：最小生成树
 *
 * @author hankin
 * @date 2020/10/17 17:19
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verx = data.length;

        // 1000表示不连通
        int[][] weight = {
                {1000, 5, 7, 1000, 1000, 1000, 2},
                {5, 1000, 1000, 9, 1000, 1000, 3},
                {7, 1000, 1000, 1000, 8, 1000, 1000},
                {1000, 9, 1000, 1000, 1000, 4, 1000},
                {1000, 1000, 8, 1000, 1000, 5, 4},
                {1000, 1000, 1000, 4, 5, 1000, 6},
                {2, 3, 1000, 1000, 4, 6, 1000}};
        MGraph mGraph = new MGraph(verx);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph, verx, data, weight);
        minTree.showGraph(mGraph);

        minTree.prim(mGraph,0);
    }
}

class MGraph {

    // 图节点个数
    int verx;
    // 存放结点数据
    char[] data;
    // 存放边 邻接矩阵
    int[][] weight;

    public MGraph(int verx) {
        this.verx = verx;
        data = new char[verx];
        weight = new int[verx][verx];
    }
}

class MinTree {
    /**
     * @param graph  图对象
     * @param verx   顶点个数
     * @param data   顶点值 A B C ...
     * @param weight 邻接矩阵
     */
    void createGraph(MGraph graph, int verx, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verx; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verx; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * @param graph
     * @param v     顶点生成 'A'->0 'B'->1
     */
    public void prim(MGraph graph, int v) {
        int[] visited = new int[graph.verx];

        // 标记这个节点为已访问
        visited[v] = 1;

        // h1 & h2 记录连个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 1000;

        // 每次访问生成一条边 边的个数为 顶点数-1
        for (int k = 1; k < graph.verx; k++) {

            // 外循环：已访问的节点
            for (int i = 0; i < graph.verx; i++) {
                // 内循环：选择即将被访的节点(外循环未访问的)中最小的
                for (int j = 0; j < graph.verx; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> :" + minWeight);

            // h1->i:已访问, h2->j:未访问，所以只需存取h2
            visited[h2] = 1;

            // 重置
            minWeight = 1000;
        }

    }

    void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }
}
