package matrixrotate;

import java.util.Arrays;

public class MatrixRotate {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}};

        System.out.println(Arrays.toString(rotateMatrix(matrix)[0]));
        System.out.println(Arrays.toString(rotateMatrix(matrix)[1]));
        System.out.println(Arrays.toString(rotateMatrix(matrix)[2]));
    }

    public static int[][] rotateMatrix(int[][] matrix) {
        int[][] output = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                output[i][j] = matrix[matrix.length - 1 - j][i];
            }
        }

        return output;
    }
}
