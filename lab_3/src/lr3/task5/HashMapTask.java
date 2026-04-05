package lr3.task5;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class HashMapTask {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "a");
        map.put(1, "bb");
        map.put(2, "ccc");
        map.put(3, "dddd");
        map.put(4, "eeeee");
        map.put(5, "ffffff");
        map.put(6, "ggggggg");
        map.put(7, "hhhhhhhh");
        map.put(8, "iiiiiiiii");
        map.put(9, "jjjjjjjjjj");

        System.out.println("Строки при ключе > 5:");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getKey() > 5) {
                System.out.println("  ключ " + e.getKey() + ": " + e.getValue());
            }
        }

        System.out.print("При ключе = 0 (подстроки через запятую): ");
        if (map.containsKey(0)) {
            String v = map.get(0);
            StringJoiner joiner = new StringJoiner(", ");
            for (String part : v.split(",")) {
                joiner.add(part.trim());
            }
            System.out.println(joiner);
        } else {
            System.out.println("(записи с ключом 0 нет)");
        }

        long product = 1L;
        boolean any = false;
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getValue().length() > 5) {
                product *= e.getKey();
                any = true;
            }
        }
        System.out.println("Произведение ключей, где длина строки > 5: "
                + (any ? product : "(нет таких записей)"));
    }
}
