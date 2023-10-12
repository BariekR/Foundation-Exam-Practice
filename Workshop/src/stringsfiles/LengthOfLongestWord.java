package stringsfiles;

import java.util.Arrays;

public class LengthOfLongestWord {
    public static void main(String[] args) {
        System.out.println(longestWord("Hello there! General Kenobi?"));
    }

    public static int longestWord(String input) {
        String[] words = input.split("\\W+");
        System.out.println(Arrays.toString(words));

        int max = 0;
        for (String word : words) {
            if (word.length() > max) {
                max = word.length();
            }
        }

        return max;
    }
}
