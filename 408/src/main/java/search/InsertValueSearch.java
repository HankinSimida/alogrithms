package search;

/**
 * 差值查找（自适应查找）：
 *  应用：数据有序，且分布均匀
 *  本质：预测查找的数据在数组长度的占比
 * @author hankin
 * @date 2020/9/15 22:43
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 20, 40, 88, 121};
        int i = insertFindValueSearch(arr, 0, arr.length - 1, 12);
        System.out.println(i);
    }

    private static int insertFindValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("hello");
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertFindValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertFindValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
