package fruitstore;

import java.util.List;

public class App {
    public static void main(String[] args) {
        FruitStore fruitStore = new FruitStore();

        Color red = new Color("Red", new int[]{255, 0, 0});
        Color redBlue = new Color("Red", new int[]{255, 0, 125});
        Color green = new Color("Green", new int[]{10, 255, 30});
        Color blue = new Color("Blue", new int[]{0, 0, 230});

        Fruit redApple = new Fruit(red, "Apple", 50);
        Fruit redOrange = new Fruit(red, "Orange", 100);
        Fruit greenApple = new Fruit(green, "Apple", 30);
        Fruit blueberry = new Fruit(redBlue, "Blueberry", 5);

        fruitStore.addFruit(redApple);
        fruitStore.addFruit(redOrange);
        fruitStore.addFruit(greenApple);
        fruitStore.addFruit(blueberry);

        System.out.println("Red apples: ");
        printFruits(fruitStore.getFruits("Red"));

        System.out.println("Exact red: ");
        printFruits(fruitStore.getFruits(red));

        System.out.println("Buy all blue: (should be 0)");
        System.out.println(fruitStore.buyFruits(fruitStore.getFruits("Blue")));

        System.out.println("Buy all green: (should be 30)");
        System.out.println(fruitStore.buyFruits(fruitStore.getFruits("Green")));

        System.out.println("Print all remaining fruits:");
        printFruits(fruitStore.getFruits());
    }

    public static void printFruits(List<Fruit> fruitsToPrint) {
        for (Fruit f : fruitsToPrint) {
            System.out.println(f);
        }
    }
}
