package fruitstore;

import java.util.ArrayList;
import java.util.List;

public class FruitStore {
    private List<Fruit> fruits;

    public FruitStore() {
        fruits = new ArrayList<>();
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    public List<Fruit> getFruits(String colorName) {
        List<Fruit> output = new ArrayList<>();

        for (Fruit fruit : fruits) {
            if (fruit.getColor().getName().equals(colorName)) {
                output.add(fruit);
            }
        }
        return output;
    }

    public List<Fruit> getFruits(Color color) {
        List<Fruit> output = new ArrayList<>();

        for (Fruit fruit : fruits) {
            if (fruit.getColor().compareTo(color) == 0) {
                output.add(fruit);
            }
        }
        return output;
    }

    public int buyFruits(List<Fruit> fruits) {
        int price = 0;

        for (Fruit fruit : fruits) {
            if (this.fruits.contains(fruit)) {
                this.fruits.remove(fruit);
                price += fruit.getPrice();
            }
        }
        return price;
    }
}
