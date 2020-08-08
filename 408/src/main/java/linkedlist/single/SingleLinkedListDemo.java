package linkedlist.single;

import java.util.Stack;

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
        singleLinkedList.addNodeByOrder(hero1);
        singleLinkedList.addNodeByOrder(hero5);
//        singleLinkedList.addNodeByOrder(hero1);
        singleLinkedList.addNodeByOrder(hero4);
        singleLinkedList.addNodeByOrder(hero3);
        singleLinkedList.addNodeByOrder(hero7);

//        singleLinkedList.modifyByNo(hero1);
//        singleLinkedList.deleteNode(hero1);
//        singleLinkedList.showLinkedList(hero1);
        System.out.println(singleLinkedList.getNumberOfNode());
//        System.out.println(singleLinkedList.getLastKNode(0));
//        HeroNode heroNode = singleLinkedList.reverseLinkedList(hero1);

//        singleLinkedList.showLinkedList(heroNode);
//        HeroNode heroNode2 = singleLinkedList.reverseLinkedList2(hero1);
//        singleLinkedList.showLinkedList(heroNode2);

        singleLinkedList.printNode(hero1);

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
     * 删除节点根据node的no来删除
     *
     * @param node
     */
    public void deleteNode(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null && temp.next.no != node.no) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
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
     *
     * @param node
     */
    public void modifyByNo(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null && temp.next.no != node.no) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next.nickName = node.nickName;
            temp.next.name = node.name;
        } else {
            System.out.println("can not find it!");
        }
    }

    /**
     * 显示链表
     */
    public void showLinkedList(HeroNode head) {
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

    /**
     * 链表面试题1：返回有效节点个数
     *
     * @return
     */
    public int getNumberOfNode() {
        HeroNode temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 链表面试题2（sina面试题）：查找单链表中的倒数第K个节点
     *
     * 思路：1、获取链表总长度 len
     *      2、len - n + 1 = 正向遍历的值
     *      3、在长度内正常 长度外 null
     * @param n
     * @return
     */
    public HeroNode getLastKNode(int n) {

        int numberOfNode = getNumberOfNode();
        int differNumber = numberOfNode - n + 1;
        int count = 0;
        if (numberOfNode != 0 && differNumber > 0) {
            HeroNode temp = head;
            while (temp.next != null) {
                count++;
                temp = temp.next;
                if (differNumber == count) {
                    HeroNode k = new HeroNode(temp.no, temp.name, temp.nickName);
                    return k;
                }
            }
        }
        return null;

    }


    /**
     * 链表面试题3（tencent面试题）：反转链表
     */
    public HeroNode reverseLinkedList(HeroNode node){
        HeroNode newHead = new HeroNode(0,"","");
        HeroNode temp = node;
        while (temp!=null){
            temp=temp.next;
            node.next=newHead.next;
            newHead.next=node;

            node=temp;
        }

        return newHead;
    }

    /**
     * 链表面试题3（tencent面试题）：反转链表 递归
     * 其本质就是 压栈的过程，分离出尾结点
     *
     * @param node
     * @return
     */
    public HeroNode reverseLinkedList2(HeroNode node){
        HeroNode newHead = new HeroNode(0,"","");
        newHead.next= reverse(node);
        return newHead;
    }

    private HeroNode reverse(HeroNode node) {
        if (node==null||node.next==null){
            return node;
        }
        HeroNode temp = node.next;
        HeroNode singleNode = reverse(temp);
        temp.next=node;
        node.next=null;
        return singleNode;

    }

    /**
     * 百度面试题：从尾遍历链表
     * 思路：借用栈从头开始压栈 然后 依次出栈
     * @param node
     */
    public void printNode(HeroNode node){
        if (node.next==null){
            return;
        }
        Stack<HeroNode> stack =new Stack<>();
        while (node!=null){
            stack.push(node);
//            stack.push(new HeroNode(node.no,node.name,node.nickName));
            node=node.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
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