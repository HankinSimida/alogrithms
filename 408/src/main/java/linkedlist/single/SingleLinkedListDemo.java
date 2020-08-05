package linkedlist.single;

/**
 * 单链表
 *
 * @author hankin
 * @date 2020/8/4 17:55
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero5 = new HeroNode(5, "关胜", "大刀");
        HeroNode hero7 = new HeroNode(6, "秦明", "霹雳火");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
       /* singleLinkedList.addNode(hero1);
        singleLinkedList.addNode(hero2);
        singleLinkedList.addNode(hero3);
        singleLinkedList.addNode(hero4);
        singleLinkedList.addNode(hero5);
        singleLinkedList.showLinkedList();*/

        singleLinkedList.addNodeByOrder(hero2);
        singleLinkedList.addNodeByOrder(hero5);
//        singleLinkedList.addNodeByOrder(hero1);
        singleLinkedList.addNodeByOrder(hero4);
        singleLinkedList.addNodeByOrder(hero3);
        singleLinkedList.addNodeByOrder(hero7);

        singleLinkedList.modifyByNo(hero1);
        singleLinkedList.deleteNode(hero1);
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

    public void deleteNode(HeroNode node){
        HeroNode temp = head;
        while (temp.next != null&&temp.next.no!=node.no) {
            temp = temp.next;
        }
        if (temp.next != null){
            temp.next= temp.next.next;
        }else {
            System.out.println("No this node");
        }
    }

    /**
     * 按顺序来添加节点
     *
     * @param node
     */
    public void addNodeByOrder(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null && temp.next.no < node.no) {
            temp = temp.next;
        }
        if (temp.next != null && temp.next.no == node.no) {
            return;
        }
        HeroNode bigNode = temp.next;
        temp.next = node;
        node.next = bigNode;
    }

    /**
     * 根据no 修改节点内容
     * @param node
     */
    public void modifyByNo(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null&&temp.next.no!=node.no) {
            temp = temp.next;
        }
        if (temp.next != null){
            temp.next.nickName=node.nickName;
            temp.next.name=node.name;
        }else {
            System.out.println("can not find it!");
        }
    }



    /**
     * 显示链表
     */
    public void showLinkedList() {
        if (head.next == null) {
            System.out.println("Empty");
        } else {
            HeroNode temp = head;
            while (temp != null) {
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