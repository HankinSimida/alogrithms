package queue;

/**
 * @author hankin
 * @date 2020/8/2 16:23
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue arrayQueue =new CircleArrayQueue(8);
        arrayQueue.addQueue(10);
        arrayQueue.addQueue(11);
        arrayQueue.addQueue(12);
        arrayQueue.addQueue(13);
        arrayQueue.addQueue(14);
        arrayQueue.addQueue(15);
        arrayQueue.addQueue(16);

        arrayQueue.showQueue();
        System.out.println("************");
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        arrayQueue.addQueue(17);
        arrayQueue.addQueue(18);
        arrayQueue.addQueue(19);
//        arrayQueue.showHead();
        System.out.println("************");
        arrayQueue.showQueue();
    }
}

class CircleArrayQueue {

    private int maxSize;

    // 指向首个数据
    private int front;

    // 指向尾部的后一个数据
    private int rear;
    private int[] arr;

    /**
     * 初始化数组
     *
     * @param maxSize
     */
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断队列是否满了
     * 预留一个空位
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判读队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加数据
     *
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("full");
            return;
        } else {
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }
    }

    /**
     * 出队
     *
     * @return
     */
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        } else {
            int num = arr[front];
            front = (front + 1) % maxSize;
            return num;
        }
    }

    /**
     * 打印队列
     */
    public void showQueue() {
        for (int i = front; i < front+ size(); i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列头部数据
     */
    public void showHead() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        System.out.println(arr[front]);
    }
}
