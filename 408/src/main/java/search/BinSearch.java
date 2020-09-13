package search;

/**
 * @author hankin
 * @date 2020/9/13 12:50
 */
public class BinSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 20, 40, 88, 121};
        int i = binSearch(arr, 0, arr.length - 1, 121);
        System.out.println(i);
    }

    /**
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return 下标值，没有返回-1
     */
    private static int binSearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
}
