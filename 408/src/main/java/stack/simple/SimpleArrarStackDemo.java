package stack.simple;

/**
 * @author hankin
 * @date 2020/8/15 22:16
 */
public class SimpleArrarStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack =new ArrayStack(4);
        arrayStack.push(15);
        arrayStack.push(16);
        arrayStack.push(17);
        arrayStack.push(18);
        arrayStack.list();
        arrayStack.pop();
        arrayStack.list();
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return stack[top--];
    }

    /**
     * 遍历
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack[%d]=%d\n", i, stack[i]);

            }
        }
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("Full");
            return;
        } else {
            stack[++top] = value;
        }
    }

    /**
     * 栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }
}