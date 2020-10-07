package ten;

/**
 * @author hankin
 * @date 2020/10/7 14:56
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(5,'A','B','C');
    }

    public static void hanoitower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个：" + a + " -> " + c);
        } else {
            // n-1个 a->b
            hanoitower(num - 1, a, c, b);
            // 最后一个 a->c
            System.out.println("第" + num + "个：" + a + " -> " + c);
            // 所有 b->c
            hanoitower(num - 1, b, a, c);
        }
    }
}
