package stack.simple;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author hankin
 * @date 2020/8/15 22:16
 */
public class SimpleArrarStackDemo {
    public static void main(String[] args) {
        /*ArrayStack arrayStack =new ArrayStack(4);
        arrayStack.push(15);
        arrayStack.push(16);
        arrayStack.push(17);
        arrayStack.push(18);
        arrayStack.list();
        arrayStack.pop();
        arrayStack.list();*/
        String express = "-10+20*25";
        char c = express.charAt(0);
        char[] s={c};
        int[] numArr = new int[3];
        int k=0;
        char[] charaOper = new char[2];
        int t = 0;
        String digitalStr = new String(s);
        for (int i = 1; i < express.length(); i++) {
            if (Character.isDigit(express.charAt(i))){
                digitalStr+=express.charAt(i);
                if (i==express.length()-1){
                    numArr[k]=Integer.valueOf(digitalStr);
                }
            }else {
                numArr[k]=Integer.valueOf(digitalStr);
                k++;
                digitalStr= "";
                charaOper[t]=express.charAt(i);
                t++;
            }
        }
        Arrays.stream(numArr).forEach(x-> System.out.println(x+" "));
        System.out.println(charaOper);
        Stack<Integer> numNeedDealWith = new Stack<>();
        Stack<Character> charNeedDealWith = new Stack<>();
        for (int i = 0; i < charaOper.length; i++) {
            if (i==0){
                numNeedDealWith.push(numArr[i]);
                charNeedDealWith.push(charaOper[i]);
                numNeedDealWith.push(numArr[i+1]);
            }
            else {

                int i1 = numArr[2] * numNeedDealWith.pop();
                numNeedDealWith.push(i1);
            }

        }
        int i = numNeedDealWith.pop() + numNeedDealWith.pop();
        System.out.println(i);
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