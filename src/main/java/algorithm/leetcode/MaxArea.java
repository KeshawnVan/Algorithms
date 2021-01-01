package algorithm.leetcode;


import org.junit.Assert;

/**
 * @author YuMing
 * @Date 2021/1/1 11:12 上午
 * 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {

    public static int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int leftValue = height[left];
            int rightValue = height[right];
            int area = Math.min(leftValue, rightValue) * (right - left);
            if (area > maxArea) maxArea = area;
            if (leftValue > rightValue) {
                right--;
            } else {
                left++;
            }

        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] case1 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assert.assertEquals(49, maxArea(case1));
        int[] case2 = new int[]{4, 3, 2, 1, 4};
        Assert.assertEquals(16, maxArea(case2));
        int[] case3 = new int[]{1, 2, 1};
        Assert.assertEquals(2, maxArea(case3));
    }
}
