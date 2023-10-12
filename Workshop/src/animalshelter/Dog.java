package animalshelter;

public class Dog extends Animal {
    public Dog() {
        setInitHealCost();
    }

    public Dog(String name, String ownerName) {
        super(name, ownerName);
        setInitHealCost();
    }

    private void setInitHealCost() {
        healCost = (int) (Math.random() * 8) + 1;
    }
}
