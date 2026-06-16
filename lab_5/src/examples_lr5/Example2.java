package examples_lr5;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Example2 {

    public static int[] commonElements(int[] first, int[] second) {
        Set<Integer> secondSet = Arrays.stream(second)
                .boxed()
                .collect(Collectors.toSet());

        return Arrays.stream(first)
                .filter(secondSet::contains)
                .distinct()
                .toArray();
    }

    public static void main(String[] args) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {3, 4, 5, 6, 7};
        int[] common = commonElements(first, second);

        System.out.println("Пример 2. Общие элементы двух массивов");
        System.out.println("Первый массив: " + Arrays.toString(first));
        System.out.println("Второй массив: " + Arrays.toString(second));
        System.out.println("Результат filter(): " + Arrays.toString(common));
    }
}
