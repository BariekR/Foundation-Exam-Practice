package animalshelter;
public class Animal {
    private String ownerName, name;
    private boolean isHealthy;
    protected int healCost;

    public Animal() {
        this.name = this.getClass().getSimpleName();
    }

    public Animal(String name, String ownerName) {
        this.name = name;
        this.ownerName = ownerName;
    }

    public void heal() {
        isHealthy = true;
    }

    public boolean isAdoptable() {
        return isHealthy;
    }

    public int getHealCost() {
        return healCost;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        if (!isHealthy) {
            return String.format("%s is not healthy (%d€), and not adoptable", name, healCost);
        } else {
            return String.format("%s is healthy, and adoptable", name);
        }
    }
}
