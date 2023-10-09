package fruitstore;

public class Color implements Comparable<Color> {
    private String name;
    private int[] rgb;

    public Color(String name, int[] rgb) throws IllegalArgumentException {
        this.name = name;

        if (rgb.length != 3
                || rgb[0] < 0 || rgb[0] > 255
                || rgb[1] < 0 || rgb[1] > 255
                || rgb[2] < 0 || rgb[2] > 255) {
            throw new IllegalArgumentException("Invalid RGB format");
        }
        this.rgb = rgb;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Color other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = Integer.compare(this.rgb[0], other.rgb[0]);
        }
        if (result == 0) {
            result = Integer.compare(this.rgb[1], other.rgb[1]);
        }
        if (result == 0) {
            result = Integer.compare(this.rgb[2], other.rgb[2]);
        }
        return result;
    }
}
