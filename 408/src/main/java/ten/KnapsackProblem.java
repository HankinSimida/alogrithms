package ten;

/**
 * @author hankin
 * @date 2020/10/8 11:19
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3}; // 物品重量
        int[] val = {1500, 3000, 2000}; // 物品对应价值
        int m = 4; // 背包重量
        int n = val.length; // 物品个数

        // v[i][j]表示当前i个物品中能够装入容量为j的背包中最大的价值
        int[][] v = new int[n + 1][m + 1]; // +1表示从0开始
        int[][] path = new int[n + 1][m + 1]; // 记录存放的商品的情况


        // 初始化第一行为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }

        // 初始化第一列为0
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        // 根据前面得到的公式来动态规划处理，不处理第一行和第一列
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                // 公式
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
//                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }


        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品入包\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}
