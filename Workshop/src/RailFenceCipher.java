import java.util.*;

public class RailFenceCipher {

    public static void main(String[] args) {
        System.out.println(decode("WEAREDISCOVEREDFLEEATONCE", 15));
    }
    static String encode(String s, int n) {
        StringBuilder[] sb = new StringBuilder[n];
        String output = "";
        int index = 0;
        boolean goingDown = true;

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));

            if (goingDown && index < n - 1) {
                index++;
            } else if (goingDown && index == n - 1) {
                index--;
                goingDown = false;
            } else if (!goingDown && index > 0) {
                index--;
            } else {
                index++;
                goingDown = true;
            }
        }

        for (StringBuilder sBuilder : sb) {
            output += sBuilder.toString();
        }

        return output;
    }

    static String decode(String s, int n) {
        // first part
        int segmentLength = (n - 1) * 2;
        int numberOfSegments = s.length() / segmentLength;
        int remainingChars = s.length() - segmentLength * numberOfSegments;

        int[] numberOfCharsInLines = new int[n];

        for (int i = 0; i < numberOfCharsInLines.length; i++) {
            if (i == 0 || i == numberOfCharsInLines.length - 1) {
                numberOfCharsInLines[i] = remainingChars > i ? numberOfSegments + 1 : numberOfSegments;
            } else {
                if (i > 2 * n - remainingChars - 2) {
                    int addition = remainingChars > n ? 2 : 1;
                    numberOfCharsInLines[i] = remainingChars > i ? numberOfSegments * 2 + addition : numberOfSegments * 2;
                } else {
                    numberOfCharsInLines[i] = remainingChars > i ? numberOfSegments * 2 + 1 : numberOfSegments * 2;
                }
            }
        }

        // second part
        List<Queue<Character>> lines = new ArrayList<>();
        int charCounter = 0;
        for (int i = 0; i < n; i++) {
            lines.add(new LinkedList<>());
            for (int j = 0; j < numberOfCharsInLines[i]; j++) {
                lines.get(i).add(s.charAt(charCounter));
                charCounter++;
            }
        }

        // third part
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean goingDown = true;
        int aaa = s.length();

        for (int i = 0; i < s.length(); i++) {
            sb.append(lines.get(index).remove());

            if (goingDown && index < n - 1) {
                index++;
            } else if (goingDown && index == n - 1) {
                index--;
                goingDown = false;
            } else if (!goingDown && index > 0) {
                index--;
            } else {
                index++;
                goingDown = true;
            }
        }

        return sb.toString();
    }
}
