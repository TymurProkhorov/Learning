package hashMapLearning;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Орешек для Мсбелки");
        map.put(2, "Морковка для Страпельки");
        map.put(3, "Бамбук для Пуча");
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println(map.keySet() + " | " + map.values());

        System.out.println("-----LinkedHashMap and TreeMap-----");
        Map<String, Integer> hashMap = new HashMap<>(); // Внутри не гарантитуется никакого порядка.
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(); // Гарантируется порядок пар согласно добавлению.
        Map<String, Integer> treeMap = new TreeMap<>(); // Упорядочивается по ключу (для интеджеров - от меньшего к
        //большему, для строк - лексикографически).
        LinkedHMAndTreeMap.test(treeMap);

    }
}
