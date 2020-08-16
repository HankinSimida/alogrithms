package stack;

import java.util.Stack;

/**
 * @author hankin
 * @date 2020/8/16 15:47
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";
        String[] strArr = strToArr(suffixExpression);
        int value = calcValue(strArr);
        System.out.println(value);
    }

    private static int calcValue(String[] strArr) {
        Stack<String> stack = new Stack<>();
        for (String item : strArr) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                int res;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else {
                    res = num1 * num2;
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private static String[] strToArr(String suffixExpression) {
        return suffixExpression.split(" ");
    }
}
