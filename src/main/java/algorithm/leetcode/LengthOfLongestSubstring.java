package algorithm.leetcode;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YuMing
 * @Date 2020/12/30 10:35 上午
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int maxLength = 0;
        int maxLengthIndex = 0;
        Map<Character, Integer> char2IndexMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length;i++) {
            char c = chars[i];
            Integer sameCharIndex = char2IndexMap.get(c);
            if (sameCharIndex != null) {
                maxLengthIndex = Math.max(maxLengthIndex, sameCharIndex + 1);
            }
            maxLength = Math.max(maxLength, i - maxLengthIndex + 1);
            char2IndexMap.put(c, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String case1 = "abcabcbb";
        Assert.assertEquals(lengthOfLongestSubstring(case1), 3);
        String case2 = "bbbbb";
        Assert.assertEquals(lengthOfLongestSubstring(case2), 1);
        String case3 = "pwwkew";
        Assert.assertEquals(lengthOfLongestSubstring(case3), 3);
        String case4 = "";
        Assert.assertEquals(lengthOfLongestSubstring(case4), 0);
        String case5 = "aab";
        Assert.assertEquals(lengthOfLongestSubstring(case5), 2);
        String case6 = "dvdf";
        Assert.assertEquals(lengthOfLongestSubstring(case6), 3);
        String case7 = "asjrgapa";
        Assert.assertEquals(lengthOfLongestSubstring(case7), 6);
    }
}
