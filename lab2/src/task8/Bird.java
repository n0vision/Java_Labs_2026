package task8;

public class Bird extends Animal {

    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    public void makeSound() {
        System.out.println(name + " говорит: Чирик!");
    }

    public void fly() {
        if (canFly) {
            System.out.println(name + " умеет летать");
        } else {
            System.out.println(name + " не умеет летать");
        }
    }
}
