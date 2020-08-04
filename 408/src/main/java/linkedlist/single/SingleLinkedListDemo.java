package linkedlist.single;

/**
 * 单链表
 *
 * @author hankin
 * @date 2020/8/4 17:55
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 =new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 =new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 =new HeroNode(3,"吴用","智多星");
        HeroNode hero4 =new HeroNode(4,"公孙胜","入云龙");
        HeroNode hero5 =new HeroNode(5,"关胜","大刀");
        SingleLinkedList singleLinkedList =new SingleLinkedList();
        singleLinkedList.addNode(hero1);
        singleLinkedList.addNode(hero2);
        singleLinkedList.addNode(hero3);
        singleLinkedList.addNode(hero4);
        singleLinkedList.addNode(hero5);
        singleLinkedList.showLinkedList();

    }
}


/**
 * 规定 head不能移动
 * 需要借助辅助变量来操作
 * 操作链表
 */
class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加链表
     *
     * @param node
     */
    public void addNode(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 显示链表
     */
    public void showLinkedList() {
        if (head.next == null) {
            System.out.println("Empty");
        } else {
            HeroNode temp = head;
            while (temp.next != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }
}


/**
 * 定义链表的结点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}