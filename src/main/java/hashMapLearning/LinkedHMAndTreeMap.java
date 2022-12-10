package hashMapLearning;

import java.util.Map;

public class LinkedHMAndTreeMap {

    public static void test(Map<String, Integer> map) {
        map.put("Mike", 32);
        map.put("Tim", 1);
        map.put("Alex", 0);
        map.put("Anna", 555);
        map.put("Kate", 999999);
        map.put("Jennifer",100);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
