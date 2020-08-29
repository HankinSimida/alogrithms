package recursion;

/**
 * @author hankin
 * @date 2020/8/29 10:25
 */
public class Queue8 {

    private final int MAX = 8;
    private int[] array = new int[MAX];
    private static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 =new Queue8();
        queue8.check(0);
        System.out.printf("一共%d解法",count);
    }

    /**
     * 打印
     */
    private void print() {
        count++;
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * 校验第n个皇后与之前相比是否冲突
     *
     * @param n 第n个皇后
     * @return Math.abs(i - n)==Math.abs(array[i]-array[n]) -> 对角线检测
     * array[i]==array[n] -> 同一列检测
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 放置第n个皇后
     *
     * @param n
     */
    private void check(int n) {
        if (n == MAX) {
            print();
            return;
        }
        for (int i = 0; i < MAX; i++) {
            //每个皇后都从第一列开始
            array[n] = i;
            if (judge(n)) {
                //校验通过接着放
                check(n + 1);
            }
        }
    }

}
