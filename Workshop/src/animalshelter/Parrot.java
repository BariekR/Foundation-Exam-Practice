package animalshelter;

public class Parrot extends Animal {
    public Parrot() {
        setInitHealCost();
    }

    public Parrot(String name, String ownerName) {
        super(name, ownerName);
        setInitHealCost();
    }

    private void setInitHealCost() {
        healCost = (int) ((Math.random() * 7) + 4);
    }
}
