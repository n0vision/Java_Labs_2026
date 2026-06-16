package timus.task_1005;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Character, Integer> VALUES = new HashMap<>();

    static {
        VALUES.put('I', 1);
        VALUES.put('V', 5);
        VALUES.put('X', 10);
        VALUES.put('L', 50);
        VALUES.put('C', 100);
        VALUES.put('D', 500);
        VALUES.put('M', 1000);
    }

    public static int romanToInt(String roman) {
        int result = 0;
        for (int index = 0; index < roman.length(); index++) {
            int current = VALUES.get(roman.charAt(index));
            if (index + 1 < roman.length()) {
                int next = VALUES.get(roman.charAt(index + 1));
                if (current < next) {
                    result -= current;
                    continue;
                }
            }
            result += current;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            System.out.println(romanToInt(scanner.nextLine().trim()));
        }
    }
}
