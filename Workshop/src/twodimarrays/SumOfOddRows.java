package twodimarrays;

import java.util.Arrays;

public class SumOfOddRows {
    public static void main(String[] args) {
        int[][] input1 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] input2 = {{4, 5, 2}, {1, 6, 3}, {7, 3, 8}, {9, 0, 1}, {3, 8, 7}};

        try {
            System.out.println(sumOddRows(input1));
            System.out.println(sumOddRows(input2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumOddRows(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Null input");
        }

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }
}
