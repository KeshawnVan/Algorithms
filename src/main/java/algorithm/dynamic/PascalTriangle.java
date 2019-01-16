package algorithm.dynamic;

public class PascalTriangle {

    public static int calculateShortestPath(int[][] triangle) {
        int[][] states = new int[triangle.length][];
        for (int i = 0; i < states.length; i++) {
            states[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                states[i][j] = Integer.MAX_VALUE;
            }
        }
        states[0][0] = 5;
        return calculateShortestPath(triangle, states);
    }

    public static int calculateShortestPath(int[][] triangle, int[][] states) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j - 1 >= 0) {
                    int leftParentPath = states[i - 1][j - 1];
                    int path = triangle[i][j] + leftParentPath;
                    if (path < states[i][j]) states[i][j] = path;
                }
                if (j < triangle[i - 1].length) {
                    int rightParentPath = states[i - 1][j];
                    int path = triangle[i][j] + rightParentPath;
                    if (path < states[i][j]) states[i][j] = path;
                }
            }
        }
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < states[states.length - 1].length; i++) {
            if (states[states.length - 1][i] < minPath) minPath = states[states.length - 1][i];
        }
        return minPath;
    }


    public static void main(String[] args) {
        int[][] triangle = new int[5][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];
        }
        triangle[0][0] = 5;

        triangle[1][0] = 7;
        triangle[1][1] = 8;

        triangle[2][0] = 2;
        triangle[2][1] = 3;
        triangle[2][2] = 4;

        triangle[3][0] = 4;
        triangle[3][1] = 9;
        triangle[3][2] = 6;
        triangle[3][3] = 1;

        triangle[4][0] = 2;
        triangle[4][1] = 1;
        triangle[4][2] = 9;
        triangle[4][3] = 4;
        triangle[4][4] = 5;

        int shortestPath = calculateShortestPath(triangle);
        System.out.println(shortestPath);
    }
}
