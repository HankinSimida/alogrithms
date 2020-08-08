package linkedlist.doublelinkedlist;


/**
 * @author hankin
 * @date 2020/8/8 15:26
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        NodeData hero1 = new NodeData(1, "宋江", "及时雨");
        NodeData hero2 = new NodeData(2, "卢俊义", "玉麒麟");
        NodeData hero3 = new NodeData(3, "吴用", "智多星");
        NodeData hero4 = new NodeData(4, "公孙胜", "入云龙");
        NodeData hero5 = new NodeData(5, "关胜", "大刀");
        NodeData hero6 = new NodeData(6, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList =new DoubleLinkedList();
        doubleLinkedList.addNode(hero1);
        doubleLinkedList.addNode(hero2);
        doubleLinkedList.addNode(hero3);
        doubleLinkedList.addNode(hero4);
        doubleLinkedList.addNode(hero5);
        doubleLinkedList.addNode(hero6);
        doubleLinkedList.modifyByNo(new NodeData(6,"小林","豹子头"));
        doubleLinkedList.deleteNode(new NodeData(2, "卢俊义", "玉麒麟"));
        doubleLinkedList.showLinkedList(hero1);
    }

}

/**
 * 双向链表
 */
class DoubleLinkedList{
    private NodeData head =new NodeData(0,"","");

    /**
     * 返回头结点
     * @return
     */
    public NodeData getHead(){
        return head;
    }

    /**
     * 显示链表
     */
    public void showLinkedList(NodeData head) {
        if (head.next == null) {
            System.out.println("Empty");
        } else {
            NodeData temp = head;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    /**
     * 添加链表
     *
     * @param node
     */
    public void addNode(NodeData node) {
        NodeData temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre=temp;
    }

    /**
     * 根据no 修改节点内容
     *
     * @param node
     */
    public void modifyByNo(NodeData node) {
        NodeData temp = head;
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
     * 删除节点根据node的no来删除
     *
     * @param node
     */
    public void deleteNode(NodeData node) {
        NodeData temp = head;
        while (temp.next != null && temp.next.no != node.no) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp=temp.next;
            temp.pre.next=temp.next;
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }
            // help gc
            temp.pre=null;
            temp.next=null;


        } else {
            System.out.println("No this node");
        }
    }
}


class NodeData{
    public int no;
    public String name;
    public String nickName;
    public NodeData next;
    public NodeData pre;

    public NodeData(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "NodeData{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public NodeData getNext() {
        return next;
    }

    public void setNext(NodeData next) {
        this.next = next;
    }

    public NodeData getPre() {
        return pre;
    }

    public void setPre(NodeData pre) {
        this.pre = pre;
    }
}
