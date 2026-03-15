package task4;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Никита", 22, "Мужской");

        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
        System.out.println("Пол: " + person.getGender());
    }
}

