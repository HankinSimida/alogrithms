package arr.sparsearr;

/**
 * @author hankin
 * @date 2020/8/1 15:46
 */
public class SparseArray {
    public static void main(String[] args) {
        // 初始化二维数组
        int[][] chessArray = initArray();
        printArray(chessArray,"原始数组：");

        // 二维数组 -> 稀疏数组
        // 1、遍历非0个数
        int num = findNotZeroNumbers(chessArray);

        // 2、创建稀疏数组
        int[][] sparseArr = createSparseArray(chessArray, num);
        printArray(sparseArr,"稀疏数组：");

        // 稀疏数组 -> 二维数组
        int[][] chessArray2 = getChessArrayBySparseArray(sparseArr);
        printArray(chessArray2,"复原后的数组：");


    }

    private static int[][] getChessArrayBySparseArray(int[][] sparseArr) {
        // 获取首行首列 得知数组大小
        int[][] chessArray2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 填充非0数据
        for (int i =1;i<sparseArr.length;i++){
           chessArray2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        return chessArray2;
    }

    private static int[][] createSparseArray(int[][] chessArray, int num) {
        // 行 列 非O 个数
        int[][] sparseArray = new int[num + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = num;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];

                }
            }
        }
        return sparseArray;

    }

    private static int findNotZeroNumbers(int[][] chessArray) {
        int count = 0;
        for (int[] row : chessArray) {
            for (int data : row) {
                if (data != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[][] initArray() {
        // 二维数组 11*11
        // 0:无棋子 1：黑子 2：白子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        return chessArr;
    }

    private static int[][] printArray(int[][] chessArray,String msg){
        System.out.println(msg);
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return chessArray;
    }
}
