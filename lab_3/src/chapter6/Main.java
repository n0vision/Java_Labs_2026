package chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final int DEFAULT_N = 400_000_000;

    public static void main(String[] args) {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_N;

        System.out.println("N (элементов / повторов операции) = " + n);
        System.out.println("Коллекции: ArrayList, LinkedList, HashMap");
        System.out.println();
        System.out.println("Для HashMap: «начало/конец/середина» — порядок вставки/удаления по ключам (см. подписи).");
        System.out.println();

        System.out.println("--- Добавление в начало ---");
        System.out.println("ArrayList:  add(0, i)     -> " + measureAddBeginning(new ArrayList<>(), n) + " мс");
        System.out.println("LinkedList: add(0, i)     -> " + measureAddBeginning(new LinkedList<>(), n) + " мс");
        System.out.println("HashMap:    put(k) k=n-1..0 -> " + measureMapPutBeginning(new HashMap<>(), n) + " мс");
        System.out.println();

        System.out.println("--- Добавление в конец ---");
        System.out.println("ArrayList:  add(i)        -> " + measureAddEnd(new ArrayList<>(), n) + " мс");
        System.out.println("LinkedList: add(i)        -> " + measureAddEnd(new LinkedList<>(), n) + " мс");
        System.out.println("HashMap:    put(k) k=0..n-1 -> " + measureMapPutEnd(new HashMap<>(), n) + " мс");
        System.out.println();

        System.out.println("--- Добавление в середину ---");
        System.out.println("ArrayList:  add(size/2, i) -> " + measureAddMiddle(new ArrayList<>(), n) + " мс");
        System.out.println("LinkedList: add(size/2, i) -> " + measureAddMiddle(new LinkedList<>(), n) + " мс");
        System.out.println("HashMap:    put от центра к краям -> " + measureMapPutMiddle(new HashMap<>(), n) + " мс");
        System.out.println();

        System.out.println("--- Удаление с начала ---");
        System.out.println("ArrayList:  remove(0)     -> " + measureRemoveBeginning(new ArrayList<>(), n) + " мс");
        System.out.println("LinkedList: remove(0)     -> " + measureRemoveBeginning(new LinkedList<>(), n) + " мс");
        System.out.println("HashMap:    remove(k) k=0..n-1 -> " + measureMapRemoveBeginning(new HashMap<>(), n) + " мс");
        System.out.println();

        System.out.println("--- Удаление с конца ---");
        System.out.println("ArrayList:  remove(size-1) -> " + measureRemoveEnd(new ArrayList<>(), n) + " мс");
        System.out.println("LinkedList: remove(size-1) -> " + measureRemoveEnd(new LinkedList<>(), n) + " мс");
        System.out.println("HashMap:    remove(k) k=n-1..0 -> " + measureMapRemoveEnd(new HashMap<>(), n) + " мс");
        System.out.println();

        System.out.println("--- Удаление из середины ---");
        System.out.println("ArrayList:  remove(size/2) -> " + measureRemoveMiddle(new ArrayList<>(), n) + " мс");
        System.out.println("LinkedList: remove(size/2) -> " + measureRemoveMiddle(new LinkedList<>(), n) + " мс");
        System.out.println("HashMap:    remove среднего ключа -> " + measureMapRemoveMiddle(new HashMap<>(), n) + " мс");
        System.out.println();

        System.out.println("--- Получение по индексу / по ключу ---");
        System.out.println("ArrayList:  get(i)        -> " + measureGetByIndex(new ArrayList<>(), n) + " мс");
        System.out.println("LinkedList: get(i)        -> " + measureGetByIndex(new LinkedList<>(), n) + " мс");
        System.out.println("HashMap:    get(k) k=0..n-1 -> " + measureMapGetByKey(new HashMap<>(), n) + " мс");
    }

    private static long measureAddBeginning(List<Integer> list, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(0, i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureAddEnd(List<Integer> list, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureAddMiddle(List<Integer> list, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(list.size() / 2, i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureRemoveBeginning(List<Integer> list, int n) {
        fillSequential(list, n);
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.remove(0);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureRemoveEnd(List<Integer> list, int n) {
        fillSequential(list, n);
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.remove(list.size() - 1);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureRemoveMiddle(List<Integer> list, int n) {
        fillSequential(list, n);
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.remove(list.size() / 2);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureGetByIndex(List<Integer> list, int n) {
        fillSequential(list, n);
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.get(i);
        }
        return System.currentTimeMillis() - start;
    }

    private static void fillSequential(List<Integer> list, int n) {
        list.clear();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }

    private static long measureMapPutBeginning(Map<Integer, Integer> map, int n) {
        long start = System.currentTimeMillis();
        for (int k = n - 1; k >= 0; k--) {
            map.put(k, k);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureMapPutEnd(Map<Integer, Integer> map, int n) {
        long start = System.currentTimeMillis();
        for (int k = 0; k < n; k++) {
            map.put(k, k);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureMapPutMiddle(Map<Integer, Integer> map, int n) {
        long start = System.currentTimeMillis();
        int mid = n / 2;
        map.put(mid, mid);
        int count = 1;
        for (int d = 1; count < n; d++) {
            if (mid + d < n) {
                map.put(mid + d, mid + d);
                count++;
                if (count >= n) {
                    break;
                }
            }
            if (mid - d >= 0) {
                map.put(mid - d, mid - d);
                count++;
            }
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureMapRemoveBeginning(Map<Integer, Integer> map, int n) {
        for (int k = 0; k < n; k++) {
            map.put(k, k);
        }
        long start = System.currentTimeMillis();
        for (int k = 0; k < n; k++) {
            map.remove(k);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureMapRemoveEnd(Map<Integer, Integer> map, int n) {
        for (int k = 0; k < n; k++) {
            map.put(k, k);
        }
        long start = System.currentTimeMillis();
        for (int k = n - 1; k >= 0; k--) {
            map.remove(k);
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureMapRemoveMiddle(Map<Integer, Integer> map, int n) {
        for (int k = 0; k < n; k++) {
            map.put(k, k);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);
            int mid = keys.size() / 2;
            map.remove(keys.get(mid));
        }
        return System.currentTimeMillis() - start;
    }

    private static long measureMapGetByKey(Map<Integer, Integer> map, int n) {
        for (int k = 0; k < n; k++) {
            map.put(k, k);
        }
        long start = System.currentTimeMillis();
        for (int k = 0; k < n; k++) {
            map.get(k);
        }
        return System.currentTimeMillis() - start;
    }
}
