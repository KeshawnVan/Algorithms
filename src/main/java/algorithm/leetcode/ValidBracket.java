package algorithm.leetcode;


import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidBracket {

    public boolean isValid(String s) {

        List<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(0, c);
            }

            if (c == ')') {
                if (stack.isEmpty()) return false;
                Character character = stack.remove(0);
                if (character != '(') return false;
            }

            if (c == ']') {
                if (stack.isEmpty()) return false;
                Character character = stack.remove(0);
                if (character != '[') return false;
            }

            if (c == '}') {
                if (stack.isEmpty()) return false;
                Character character = stack.remove(0);
                if (character != '{') return false;
            }
        }
        return stack.isEmpty();
    }

}
