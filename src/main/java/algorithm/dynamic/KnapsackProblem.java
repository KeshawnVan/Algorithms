package algorithm.dynamic;

public class KnapsackProblem {

    public static int calculate(int[] items, int weight) {
        boolean[][] states = new boolean[items.length][weight + 1];
        states[0][0] = true;
        states[0][items[0]] = true;
        return calculate(items, weight, states);
    }

    private static int calculate(int[] items, int weight, boolean[][] states) {

        for (int i = 1; i < items.length; i++) {
            for (int j = 0; j <= weight; j++) {
                if (states[i - 1][j]) states[i][j] = true;
            }
            for (int j = 0; j <= weight - items[i]; j++) {
                if (states[i - 1][j]) states[i][j + items[i]] = true;
            }
        }
        for (int i = weight; i >= 0; i--) {
            if (states[items.length - 1][i]) return i;
        }

        return 0;
    }

    public static int advanceCalculate(int[] items, int weight) {
        boolean[] states = new boolean[weight + 1];
        states[0] = true;
        states[items[0]] = true;
        return advanceCalculate(items, weight, states);
    }

    public static int advanceCalculate(int[] items, int weight, boolean[] states) {
        for (int i = 1; i < items.length; i++) {
            for (int j = weight - items[i]; j >= 0; j--) {
                if (states[j]) states[j + items[i]] = true;
            }
        }
        for (int i = weight; i >= 0; i--) {
            if (states[i]) return i;
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] items = new int[]{5, 7, 4, 5, 7, 3, 9, 4, 6};
        System.out.println(calculate(items, 49));
        System.out.println(advanceCalculate(items, 49));
    }
}
