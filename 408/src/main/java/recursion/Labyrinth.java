package recursion;

/**
 * @author hankin
 * @date 2020/8/23 11:11
 */
public class Labyrinth {
    public static void main(String[] args) {
        int[][] arr = new int[8][7];

        //init arr
        initArr(arr);
//        printArr(arr);
        solveProblem(arr, 1, 1);

        printArr(arr);

    }

    /**
     * @param arr
     * @param row    出发的行
     * @param column 出发的列
     * @return
     */
    private static boolean solveProblem(int[][] arr, int row, int column) {

        if (arr[6][5] == 2) {
            return true;
        } else {
            if (arr[row][column] == 0) {
                arr[row][column] = 2;

                //规则 下->右->上->左
                if (solveProblem(arr, row + 1, column)) {
                    return true;
                } else if (solveProblem(arr, row, column + 1)) {
                    return true;
                } else if (solveProblem(arr, row - 1, column)) {
                    return true;
                } else if (solveProblem(arr, row, column - 1)) {
                    return true;
                } else {
                    arr[row][column] = 3;
                    return false;
                }
            } else {

                return false;
            }
        }

    }


    private static void printArr(int[][] arr) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initArr(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        for (int i = 0; i < column; i++) {
            arr[0][i] = 1;
            arr[7][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            arr[i][0] = 1;
            arr[i][6] = 1;
        }
        arr[3][1] = 1;
        arr[3][2] = 1;
    }
}
