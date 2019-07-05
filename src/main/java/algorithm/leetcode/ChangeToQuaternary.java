package algorithm.leetcode;

public class ChangeToQuaternary {

    public static String change(long num) {
        String result = "";
        while (num > 0) {
            result = num % 4 + result;
            num = num / 4;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(change(11));
    }
}
