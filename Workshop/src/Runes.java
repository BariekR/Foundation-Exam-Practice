public class Runes {
    public static int solveExpression(final String expression) {
        String[] elements = getElements(expression);

        for (int i = 0; i < 10; i++) {
            if (containsSameDigit(elements[0], i) || containsSameDigit(elements[1], i) || containsSameDigit(elements[2], i)) {
                continue;
            }

            String s1 = elements[0].replaceAll("\\?", String.valueOf(i));
            String s2 = elements[1].replaceAll("\\?", String.valueOf(i));
            String s3 = elements[2].replaceAll("\\?", String.valueOf(i));

            if (startsWithZero(s1) || startsWithZero(s2) || startsWithZero(s3)) {
                continue;
            }

            int n1 = Integer.parseInt(s1);
            int n2 = Integer.parseInt(s2);
            int n3 = Integer.parseInt(s3);

            if (elements[3].equals("+")) {
                if (n1 + n2 == n3) {
                    return i;
                }
            } else if (elements[3].equals("-")) {
                if (n1 - n2 == n3) {
                    return i;
                }
            } else {
                if (n1 * n2 == n3) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static String[] getElements(String expression) {
        String[] elements = new String[4];

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        if (expression.charAt(i) == '-') {
            sb.append('-');
            i++;
        }

        while (i < expression.length()) {
            char letter = expression.charAt(i);
            if (letter == '+' || letter == '-' || letter == '*') {
                elements[j] = sb.toString();
                elements[3] = String.valueOf(letter);
                sb = new StringBuilder();
                j++;
                i++;
                break;
            } else {
                sb.append(letter);
                i++;
            }
        }

        if (expression.charAt(i) == '-') {
            sb.append('-');
            i++;
        }

        while (i < expression.length()) {
            char letter = expression.charAt(i);
            if (letter == '=') {
                elements[j] = sb.toString();
                sb = new StringBuilder();
                j++;
                i++;
            } else {
                sb.append(letter);
                i++;
            }
        }

        elements[j] = sb.toString();

        return elements;
    }

    private static boolean startsWithZero(String element) {
        return (element.charAt(0) == '0' && element.length() != 1) || (element.startsWith("-0"));
    }

    private static boolean containsSameDigit(String element, int i) {
        return element.contains(String.valueOf(i));
    }

}
