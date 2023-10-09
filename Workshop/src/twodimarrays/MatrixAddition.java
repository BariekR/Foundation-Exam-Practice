package twodimarrays;

import java.util.Arrays;

public class MatrixAddition {
    public static void main(String[] args) {
        int[][] input1 = {{1, 2}, {3, 4}};
        int[][] input2 = {{5, 6}, {7, 8}};

        try {
            int[][] result = matrixAddition(input1, input2);
            for (int i = 0; i < result.length; i++) {
                System.out.println(Arrays.toString(result[i]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[][] matrixAddition(int[][] first, int[][] second) throws Exception {
        if (first == null || second == null || first.length != second.length) {
            throw new Exception("Invalid input");
        }

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i].length != second[j].length) {
                    throw new Exception("Invalid input");
                }
            }
        }

        int[][] result = new int[first.length][first[0].length];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }

        return result;
    }
}
