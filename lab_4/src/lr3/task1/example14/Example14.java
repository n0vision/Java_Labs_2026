package lr3.task1.example14;

public class Example14 {
    public static void m(int x) throws ArithmeticException {
        int h = 10 / x;
        System.out.println(h);
    }

    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            m(l);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль");
        }
    }
}
