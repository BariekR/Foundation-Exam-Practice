package animalshelter;

public class App {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Parrot parrot = new Parrot();

        AnimalShelter shelter = new AnimalShelter();
        shelter.addAdopter("Thomas");
        shelter.addAdopter("Theresa");
        shelter.addAdopter("Timothy");
        shelter.rescue(cat);
        shelter.rescue(dog);
        shelter.rescue(parrot);

        System.out.println(shelter.toString());
    }
}
