package algorithm.calculate;

import data.structure.stack.ArrayStack;
import data.structure.stack.Stack;

public class PostfixExpressionCalculate {

    public static int calculateWithInfix(String infixExpression) {
        return calculate(InfixToPostfix.cast(infixExpression));
    }

    public static int calculate(String postfixExpression) {
        Stack<Integer> stack = new ArrayStack<>();
        for (char item : postfixExpression.toCharArray()) {
            if (isOperand(item)) {
                stack.push(cast(item));
            } else {
                Integer items1 = stack.pop();
                Integer items2 = stack.pop();
                switch (item) {
                    case '+':
                        stack.push(items1 + items2);
                        break;
                    case '-':
                        stack.push(items2 - items1);
                        break;
                    case '*':
                        stack.push(items1 * items2);
                        break;
                    case '/':
                        stack.push(items1 / items2);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        return stack.peek();
    }

    private static boolean isOperand(char item) {
        return item >= '0' && item <= '9';
    }

    private static Integer cast(char c) {
        return Integer.decode(c + "");
    }
}
