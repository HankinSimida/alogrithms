package linkedlist.josephu;

/**
 * @author hankin
 * @date 2020/8/10 21:24
 */
public class CircleSingleLinkedList {
    public static void main(String[] args) {
        Josephu josephu = new Josephu();
        josephu.addBoy(5);
        josephu.getBoy();
        System.out.println("****************");
        josephu.removeBoy(3);
    }
}

class Josephu {
    // 初始化头结点
    private Boy first = new Boy(-1);

    /**
     * 添加环形链表
     *
     * @param nums
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("error");
            return;
        }
        int iBoy = 1;
        Boy curBoy = null;
        while (nums > 0) {
            Boy boy = new Boy(iBoy);
            if (iBoy == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
                iBoy++;
                nums--;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
                iBoy++;
                nums--;
            }

        }
    }

    /**
     * 遍历
     */
    public void getBoy() {
        Boy cur = first;
        while (cur.getNext() != first) {
            System.out.println(cur.getNo());
            cur = cur.getNext();
        }
        System.out.println(cur.getNo());

    }

    /**
     * 出圈
     * 思路：辅助指针指向头结点前一个，每次移动n-1次
     *
     * @param n
     * @return
     */
    public void removeBoy(int n) {
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        while (first != helper) {
            int m = n;
            while (m - 1 > 0) {
                first = first.getNext();
                helper = helper.getNext();
                m--;
            }
            System.out.println(first.getNo());
            first = first.getNext();
            helper.getNext().setNext(null);
            helper.setNext(first);
        }
        System.out.println(first.getNo());
    }

}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
