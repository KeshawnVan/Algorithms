package algorithm.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
public class IntegerReverse {

    public int reverse(int x) {
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        int result = 0;
        while (x != 0) {
            int nextX = x / 10;
            int right = x % 10;
            if (result > max || (result == max && right > 7)) return 0;
            if (result < min || (result == min && right < -8)) return 0;
            result = result * 10 + right;
            x = nextX;
        }
        return result;
    }

    public static void main(String[] args) {
        IntegerReverse integerReverse = new IntegerReverse();
        System.out.println(integerReverse.reverse(123));
    }
}
