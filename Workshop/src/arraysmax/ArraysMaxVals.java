package arraysmax;

import java.util.Arrays;

public class ArraysMaxVals {
    public static void main(String[] args) {
        int[][] input1 = {{1, 5}, {3, 5}, {0, 0}, {7, 9}};
        int[][] input2 = {{1,  5,  9,  7, -5, 300}, {5,  2,  10, -6, 5}, {-3,-10, -2, -5, -3}};

        try {
            int[] result = maxRows(input1);
            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] maxRows(int[][] matrix) throws Exception {
        if (matrix == null) {
            throw new Exception("Null matrix");
        }

        int[] output = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int rowMax = Integer.MIN_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > rowMax) {
                    rowMax = matrix[i][j];
                }
            }
            output[i] = rowMax;
        }

        return output;
    }
}
