package algorithm.calculate;

import data.structure.stack.ArrayStack;
import data.structure.stack.Stack;

public class InfixToPostfix {

    private static final char BLANK = ' ';

    public static String cast(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new ArrayStack<>();
        for (char item : expression.toCharArray()) {
            if (isBlank(item)) continue;

            if (isOperand(item)) {
                result.append(item);
            } else if (item == '(' || stack.peek() == null) {
                stack.push(item);
            } else if (item == ')') {
                while (stack.peek() != null) {
                    Character character = stack.pop();
                    if (character == '(') {
                        break;
                    } else {
                        result.append(character);
                    }
                }
            } else if (notBracket(item)) {
                if (getPriority(stack.peek()) < getPriority(item)) {
                    stack.push(item);
                } else {
                    while (stack.peek() != null && getPriority(stack.peek()) >= getPriority(item)) {
                        Character character = stack.peek();
                        if (character == '(') {
                            break;
                        } else {
                            result.append(stack.pop());
                        }
                    }
                    stack.push(item);
                }
            }
        }
        while (stack.peek() != null) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private static boolean isBlank(char item) {
        return item == BLANK;
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
