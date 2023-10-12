package animalshelter;

public class Cat extends Animal {
    public Cat() {
        setInitHealCost();
    }

    public Cat(String name, String ownerName) {
        super(name, ownerName);
        setInitHealCost();
    }

    private void setInitHealCost() {
        healCost = (int) (Math.random() * 7);
    }
}
