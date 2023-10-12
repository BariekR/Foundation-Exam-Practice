package animalshelter;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    private int budget;
    private List<Animal> animals;
    private List<String> adopterNames;

    public AnimalShelter() {
        this.budget = 50;
        animals = new ArrayList<>();
        adopterNames = new ArrayList<>();
    }

    public int rescue(Animal animal) {
        animals.add(animal);
        return animals.size();
    }

    public void addAdopter(String name) {
        adopterNames.add(name);
    }

    public int earnDonation(int amount) {
        budget += amount;
        return budget;
    }

    public void findNewOwner() {
        if (adopterNames.isEmpty() || animals.isEmpty()) {
            return;
        }

        if (adoptableAnimals() == 0) {
            return;
        }

        int randomNameIndex = (int) (Math.random() * adopterNames.size());
        int randomAnimalIndex = (int) (Math.random() * animals.size());

        while (true) {
            if (!animals.get(randomAnimalIndex).isAdoptable()) {
                randomAnimalIndex = (int) (Math.random() * animals.size());
            } else {
                break;
            }
        }

        animals.get(randomAnimalIndex).setOwnerName(adopterNames.get(randomNameIndex));
        animals.remove(randomAnimalIndex);
        adopterNames.remove(randomNameIndex);
    }

    private int adoptableAnimals() {
        int adoptableAnimalsCount = 0;
        for (Animal animal : animals) {
            if (animal.isAdoptable()) {
                adoptableAnimalsCount++;
            }
        }
        return adoptableAnimalsCount;
    }

    public int heal() {
        for (Animal animal : animals) {
            if (!animal.isAdoptable()) {
                if (budget >= animal.getHealCost()) {
                    animal.heal();
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String output = String.format("Budget: %d€,\n", budget);
        output = output.concat(String.format("There are %d animal(s) and %d potential adopter(s)\n", animals.size(), adopterNames.size()));
        for (Animal animal : animals) {
            output = output.concat(animal.toString()).concat("\n");
        }

        return output;
    }
}
