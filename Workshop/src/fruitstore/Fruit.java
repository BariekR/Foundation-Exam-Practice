package fruitstore;

public class Fruit {
    private Color color;
    private String name;
    private int price;

    public Fruit(Color color, String name, int price) throws IllegalArgumentException {
        this.color = color;
        this.name = name;
        if (price < 0) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return color.toString() + " " + name;
    }
}
