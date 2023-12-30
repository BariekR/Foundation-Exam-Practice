public class Diamond {
    public static String print(int height) {
        if (height < 0 || height % 2 == 0) {
            return null;
        }

        height = height / 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= height; i++) {
            sb.append(printSpaces(height - i));
            sb.append(printStars(2 * (i - 1) + 1));
            sb.append("\n");
        }
        for (int i = height - 1; i >= 1; i--) {
            sb.append(printSpaces(height - i));
            sb.append(printStars(2 * (i - 1) + 1));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String printSpaces(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String printStars(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
