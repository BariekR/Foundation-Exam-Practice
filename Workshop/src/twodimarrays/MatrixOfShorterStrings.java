package twodimarrays;

import java.util.Arrays;

public class MatrixOfShorterStrings {
    public static void main(String[] args) {
        String[][] input1 = {{"apple", "banana", "orange"}, {"cat", "dog", "elephant"}, {"red", "green", "blue"}};
        String[][] input2 = {{"app", "pear", "grape"}, {"rabbit", "fox", "lion"}, {"purple", "pink", "yellow"}};

        try {
            String[][] result = shorterStringsMatrix(input1, input2);
            for (int i = 0; i < result.length; i++) {
                System.out.println(Arrays.toString(result[i]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[][] shorterStringsMatrix(String[][] first, String[][] second) throws Exception {
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

        String[][] result = new String[first.length][first[0].length];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                if (first[i][j].length() < second[i][j].length()) {
                    result[i][j] = first[i][j];
                } else if (first[i][j].length() > second[i][j].length()) {
                    result[i][j] = second[i][j];
                } else {
                    result[i][j] = first[i][j];
                }
            }
        }

        return result;
    }
}
