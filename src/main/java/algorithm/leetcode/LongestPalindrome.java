package algorithm.leetcode;

import org.junit.Assert;

/**
 * @author YuMing
 * @Date 2020/12/31 11:23 上午
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int l1 = getMaxPalindromeLengthByCenterIndex(s, i, i);
            int l2 = getMaxPalindromeLengthByCenterIndex(s, i, i + 1);
            int l = Math.max(l1, l2);
            if (l > (end - start + 1)) {
                start = i - (l - 1) / 2;
                end = i + l / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int getMaxPalindromeLengthByCenterIndex(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        String case1 = "babad";
        Assert.assertEquals("bab", longestPalindrome(case1));
        String case2 = "cbbd";
        Assert.assertEquals("bb", longestPalindrome(case2));
        String case3 = "a";
        Assert.assertEquals("a", longestPalindrome(case3));
        String case4 = "ac";
        Assert.assertEquals("a", longestPalindrome(case4));
        String case5 = "ccc";
        Assert.assertEquals("ccc", longestPalindrome(case5));
    }
}
