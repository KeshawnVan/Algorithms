package algorithm.backtracking;

public class EightQueenProblem {

    public static void calculate() {
        Count count = new Count();
        int[] indexes = new int[8];
        calculate(0, indexes, count);
        System.out.println(count.number);
    }

    private static void calculate(int row, int[] indexes, Count count) {
        if (row == 8) {
            print(indexes);
            count.number++;
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isCorrect(row, column, indexes)) {
                indexes[row] = column;
                calculate(row + 1, indexes, count);
            }
        }
    }

    private static boolean isCorrect(int row, int column, int[] indexes) {
        int leftIndex = column - 1;
        int rightIndex = column + 1;
        for (int rowNumber = row - 1; rowNumber >= 0; rowNumber--) {
            if (indexes[rowNumber] == column) return false;
            if (leftIndex >= 0 && indexes[rowNumber] == leftIndex--) return false;
            if (rightIndex < 8 && indexes[rowNumber] == rightIndex++) return false;
        }
        return true;
    }

    private static void print(int[] indexes) {
        for (int row = 0; row < 8; row++) {
            int column = indexes[row];
            for (int i = 0; i < 8; i++) {
                if (i == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println(" ");
        }
        System.out.println("     ");
    }

    static class Count {
        int number;
    }

    public static void main(String[] args) {
        calculate();
    }
}
