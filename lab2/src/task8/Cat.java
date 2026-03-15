package task8;

public class Cat extends Animal {

    private String foodType;

    public Cat(String name, int age, String foodType) {
        super(name, age);
        this.foodType = foodType;
    }

    public void makeSound() {
        System.out.println(name + " говорит: Мяу!");
    }

    public void showFood() {
        System.out.println("Тип корма: " + foodType);
    }
}
