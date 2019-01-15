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

    public static int calculateValue(int[] itemWeights, int[] itemValues, int weight) {
        int[] values = new int[weight + 1];
        for (int i = 1; i <= weight; i++) {
            values[i] = -1;
        }
        values[0] = 0;
        values[itemWeights[0]] = itemValues[0];
        return calculateValue(itemWeights, itemValues, weight, values);
    }

    public static int calculateValue(int[] itemWeights, int[] itemValues, int weight, int[] values) {
        for (int i = 1; i < itemWeights.length; i++) {
            for (int j = weight - itemWeights[i]; j >= 0; j--) {
                if (values[j] >= 0) {
                    int value = values[j] + itemValues[i];
                    if (value > values[j + itemWeights[i]]) {
                        values[j + itemWeights[i]] = value;
                    }
                }
            }
        }
        return getMaxValue(values);
    }

    private static int getMaxValue(int[] values) {
        int maxValue = -1;
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }


    public static void main(String[] args) {
        int[] items = new int[]{5, 7, 4, 5, 7, 3, 9, 4, 6};
        int[] values = new int[]{5, 7, 5, 5, 7, 3, 9, 4, 6};
        System.out.println(calculate(items, 49));
        System.out.println(advanceCalculate(items, 49));
        System.out.println(calculateValue(items, values, 49));
    }
}
