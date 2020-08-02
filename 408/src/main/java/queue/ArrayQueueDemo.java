package queue;



public class ArrayQueueDemo{

    public static void main(String[] args) {
        ArrayQueue arrayQueue =new ArrayQueue(10);
        arrayQueue.addQueue(10);
        arrayQueue.addQueue(11);
        arrayQueue.addQueue(12);
        arrayQueue.addQueue(13);
        arrayQueue.addQueue(14);
        arrayQueue.addQueue(15);
        arrayQueue.addQueue(16);
        arrayQueue.showHead();
        arrayQueue.poll();
        arrayQueue.showHead();
    }
}



/**
 * 使用数组模拟队列
 *
 * 存在问题：数组无法重复利用，当队列满了之后出队后无法在重复加入数据
 *
 * @author hankin
 * @date 2020/8/2 15:41
 */
class ArrayQueue {

    // maxSize -> 数组最大容量
    // front -> 队列头的前一个位置
    // rear -> 队列尾
    // arr -> 存放数据
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    /**
     * 初始化数组
     *
     * @param maxSize
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        return maxSize - 1 == rear;
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
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("full");
            return;
        } else {
            arr[++rear] = n;
        }
    }

    /**
     * 出队
     * @return
     */
    public int poll(){
        if (isEmpty()){
            throw new RuntimeException("empty");
        }else {
            return arr[++front];
        }
    }

    /**
     * 打印队列
     */
    public void showQueue(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 显示队列头部数据
     */
    public void showHead(){
        if (isEmpty()){
            throw new RuntimeException("empty");
        }
        System.out.println(arr[front+1]);
    }
}

