package algorithm.backtracking;

public class KnapsackProblem {

    /**
     * @param i      当前遍历物品的位置
     * @param cw     当前背包内的重量
     * @param items  物品集合
     * @param weight 背包最大重量
     * @param max    最接近背包最大重量的方案
     */
    public static void calculate(int i, int cw, int[] items, int weight, Max max) {

        if (cw == weight || i == items.length) {
            if (cw > max.weight) {
                max.weight = cw;
            }
            return;
        }

        calculate(i + 1, cw, items, weight, max);
        if (cw + items[i] <= weight) {
            calculate(i + 1, cw + items[i], items, weight, max);
        }
    }

    static class Max {
        int weight;
    }

    public static void main(String[] args) {
        int[] items = new int[]{5, 7, 4, 5, 7, 3, 9, 4, 6};
        Max max = new Max();
        calculate(0, 0, items, 49, max);
        System.out.println(max.weight);
    }
}
