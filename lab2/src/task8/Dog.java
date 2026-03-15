package task8;

public class Dog extends Animal {

    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void makeSound() {
        System.out.println(name + " говорит: Гав!");
    }

    public void showBreed() {
        System.out.println("Порода: " + breed);
    }
}
