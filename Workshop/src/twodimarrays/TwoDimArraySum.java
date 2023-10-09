package twodimarrays;

import java.util.Arrays;

public class TwoDimArraySum {
    public static void main(String[] args) {
        int[][] input1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        try {
            int[][] result = sumRowsAndColumns(input1);
            for (int i = 0; i < result.length; i++) {
                System.out.println(Arrays.toString(result[i]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[][] sumRowsAndColumns(int[][] matrix) throws Exception {
        if (matrix == null) {
            throw new Exception("Null input");
        }

        int[][] result = new int[2][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            int columnSum = 0;
            for (int j = 0; j < matrix.length; j++) {
                rowSum += matrix[i][j];
                columnSum += matrix[j][i];
            }
            result[0][i] = rowSum;
            result[1][i] = columnSum;
        }

        return result;
    }
}
