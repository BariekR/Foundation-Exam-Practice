package twodimarrays;

import java.util.Arrays;

public class ArrayTranspose {
    public static void main(String[] args) {
        int[][] input1 = {{1,2}, {3,4}, {5,6}};
        int[][] input2 = {{1, 2, 3}, {3, 4, 5, 6}, {6, 7, 8}};

        try {
            int[][] result = transpose(input1);
            for (int i = 0; i < result.length; i++) {
                System.out.println(Arrays.toString(result[i]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[][] transpose(int[][] matrix) throws IllegalArgumentException {
        if (matrix == null) {
            throw new IllegalArgumentException("Null input");
        }

        int rowLength = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != rowLength) {
                throw new IllegalArgumentException("Invalid argument");
            }
        }

        int[][] result = new int[rowLength][matrix.length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }

        return result;
    }
}
