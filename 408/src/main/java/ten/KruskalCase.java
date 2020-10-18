package ten;

import java.util.Arrays;

/**
 * @author hankin
 * @date 2020/10/18 13:08
 */
public class KruskalCase {

    // 边的个数
    private int edgeNum;
    // 顶点数组
    private char[] vertexs;
    // 邻接矩阵
    private int[][] matrix;
    // 不连通
    private static final int INF = Integer.MAX_VALUE;

    public KruskalCase(char[] vertexs, int[][] matrix) {
        int vlen = vertexs.length;
        this.vertexs = vertexs;
        this.matrix = matrix;
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    this.edgeNum++;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%15d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 边排序
     *
     * @param edges
     */
    private void sortEdges(EData[] edges) {

        for (int i = 0; i < edges.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 返回ch对应的下标
     *
     * @param ch
     * @return
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中边放到EData[]数组中
     * EData[] 形式 [['A','B',12],['B','F',7],...]
     *
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }

        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点，用于后面判断两个顶点的终点是否相同
     *
     * @param ends 记录各个顶点对应的终点是哪个
     * @param i    表示传入的顶点对应的下标
     * @return 下标对应的终点的下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskal() {
        // 表示最后结果数组的索引
        int index = 0;
        // 保存已有最小生成树中每个顶点在最小生成树的终点
        int[] ends = new int[edgeNum];
        // 创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgeNum];

        // 获取图中 所有边的集合 一共12个
        EData[] edges = getEdges();
        sortEdges(edges);

        //遍历edges数组 判断回路 & 最小 成功则加入rets
        for (int i = 0; i < edgeNum; i++) {
            // 获取第i条边的第一个顶点（起点）
            int p1 = getPosition(edges[i].start);
            // 获取第i条边的第2个顶点
            int p2 = getPosition(edges[i].end);

            // 获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd(ends, p1);
            // 获取p2这个顶点在已有最小生成树中的终点
            int n = getEnd(ends, p2);

            // 判断是否构成回路
            if (m != n) {
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }
        System.out.println(Arrays.toString(rets));
    }

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}};
        KruskalCase kruskalCase = new KruskalCase(vertexs, matix);
        EData[] edges = kruskalCase.getEdges();
        kruskalCase.print();
        kruskalCase.kruskal();
//        kruskalCase.sortEdges(edges);
//        System.out.println(Arrays.toString(edges));
    }
}

// 边
class EData {
    // 边的一个点
    char start;
    // 边的另外一个点
    char end;
    // 边的权值
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "<=" + start +
                "," + end +
                "> =" + weight +
                '}';
    }
}