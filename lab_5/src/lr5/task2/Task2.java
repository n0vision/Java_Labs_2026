package lr5.task2;

import lr5.StreamFunctions;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {3, 4, 5, 6, 7};
        int[] common = StreamFunctions.commonElements(first, second);

        System.out.println("Первый массив: " + Arrays.toString(first));
        System.out.println("Второй массив: " + Arrays.toString(second));
        System.out.println("Общие элементы: " + Arrays.toString(common));
    }
}
