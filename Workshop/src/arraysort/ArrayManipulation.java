package arraysort;

import java.util.Arrays;

public class ArrayManipulation {
    public static void main(String[] args) {
        int[] numbers = new int[]{0, 1, 3, 8, 4, 6, 9};
        int[] numbersToSort = new int[]{10, 5, 12, 46, 13, 8, 3};

        System.out.println("Doubled even");
        System.out.println(Arrays.toString(doubleArray(numbers, "even")));
        System.out.println("Sort from max to min");
        System.out.println(Arrays.toString(sortArrayDesc(numbersToSort)));
        System.out.println("Sort from min to max");
        System.out.println(Arrays.toString(sortArrayAsc(numbersToSort)));
    }

    public static int[] doubleArray(int[] input, String oddOrEven) {
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0 && oddOrEven.equals("even")) {
                input[i] *= 2;
            } else if (i % 2 != 0 && oddOrEven.equals("odd")) {
                input[i] *= 2;
            }
        }
        return input;
    }

    public static int[] sortArrayDesc(int[] input) {
        // [10, 5, 12, 46, 13, 8, 3]

        for (int i = 0; i < input.length; i++) {
            int currentValue = input[i];
            int max = Integer.MIN_VALUE;
            int maxIndex = i;

            for (int j = i + 1; j < input.length; j++) {
                if (input[j] > max) {
                    max = input[j];
                    maxIndex = j;
                }
            }

            if (max > currentValue) {
                input[i] = max;
                input[maxIndex] = currentValue;
            }
        }

        return input;
    }

    public static int[] sortArrayAsc(int[] input) {
        // [10, 5, 12, 46, 13, 8, 3]

        for (int i = 0; i < input.length; i++) {
            int currentValue = input[i];
            int min = Integer.MAX_VALUE;
            int minIndex = i;

            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < min) {
                    min = input[j];
                    minIndex = j;
                }
            }

            if (min < currentValue) {
                input[i] = min;
                input[minIndex] = currentValue;
            }
        }

        return input;
    }
}
