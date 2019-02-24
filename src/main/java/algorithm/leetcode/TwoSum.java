package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    private Map<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            Integer index = map.get(diff);
            if (index != null && index != i) return new int[]{i, index};
            map.put(num, i);
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, 9)));
    }
}
