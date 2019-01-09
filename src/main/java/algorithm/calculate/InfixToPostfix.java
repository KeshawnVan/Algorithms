package algorithm.calculate;

import data.structure.stack.ArrayStack;
import data.structure.stack.Stack;

public class InfixToPostfix {

    public static String cast(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new ArrayStack<>();
        for (char item : expression.toCharArray()) {
            if (item == ' ') continue;
            if (isOperand(item)) {
                result.append(item);
            } else {
                if (stack.peek() == null || item == '(' || stack.peek() == '(' || notBracket(item) && getPriority(stack.peek()) < getPriority(item)) {
                    stack.push(item);
                } else {
                    if (stack.peek() == null) continue;

                    pop(result, stack, item);

                    push(stack, item);
                }
            }
        }
        while (stack.peek() != null) {
            result.append(" ").append(stack.pop()).append(" ");
        }
        return result.toString();
    }

    private static void push(Stack<Character> stack, char item) {
        if (notBracket(item)) {
            stack.push(item);
        }
    }

    private static void pop(StringBuilder result, Stack<Character> stack, char item) {
        while (stack.peek() != null && (item == ')' || notBracket(item) && getPriority(stack.peek()) >= getPriority(item))) {
            Character character = stack.peek();
            if (character == '(') {
                if (item == ')') {
                    stack.pop();
                }
                break;
            } else {
                result.append(" ").append(character).append(" ");
                stack.pop();
            }
        }
    }

    private static boolean notBracket(char item) {
        return item != '(' && item != ')';
    }

    private static int getPriority(char item) {
        if (isOperand(item)) {
            return 1;
        } else if (item == '+' || item == '-') {
            return 2;
        } else if (item == '*' || item == '/') {
            return 3;
        } else if (item == ')') {
            return 4;
        } else if (item == '(') {
            return 5;
        }
        throw new IllegalArgumentException();
    }

    private static boolean isOperand(char item) {
        return item >= '0' && item <= '9' || item >= 'a' && item <= 'z';
    }
}
