package linkedHMAndTreeMapLearning;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>(); // Внутри не гарантитуется никакого порядка.

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // Гарантируется порядок пар согласно добавлению.

        Map<Integer, String> treeMap = new TreeMap<>(); // Упорядочивается по ключу (для интеджеров - от меньшего к
        //большему, для строк - лексикографически).

        test(treeMap);

    }

    public static void test(Map<Integer, String> map) {
        map.put(32, "Mike");
        map.put(1, "Tim");
        map.put(0, "Alex");
        map.put(555, "Anna");
        map.put(999999, "Kate");
        map.put(100, "Jennifer");
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}