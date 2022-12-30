package setLearning;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>(); // добавляет эл-ты беспорядочно.
        Set<String> linkedHashSet = new LinkedHashSet<>(); // добавляет в том порядке, в кот. я добавлял.
        Set<String> treeSet = new TreeSet<>(); // добавляет, сортируя в естественном порядке.
        treeSet.add("Adam");
        treeSet.add("Clara");
        treeSet.add("Derek");
        treeSet.add("Johnny");
        treeSet.add("Fuzzywuzzy");
        treeSet.add("Bobby");
        treeSet.add("Derek");
        treeSet.add("Derek");
        for (String s: treeSet) {
            System.out.println(s); // Дубликаты тупо игнорятся. Также Set работает с null!
        }
        System.out.println("-----");
        System.out.println(hashSet.contains("Adam")); // Работает оч быстро благодаря хешированию.
        System.out.println(hashSet.contains("Puch"));

        System.out.println("Теория множеств:");
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set1.add(6);
        set1.add(7);

        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);
        set2.add(9);
        set2.add(10);

        // Intersection - пересечение. Когда остаются эл-ты только те, которые есть и в первом и во втором множествах.
        Set<Integer> intersection = new HashSet<>(set1); // intersection будет иметь все эл-ты set1
        intersection.retainAll(set2);
        System.out.println("Пересечение: " + intersection);

        // Union - объединение множеств. повторяющиеся эл-ты игнорятся
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Объединение: " + union);

        // Difference - разность. Из сет1 вычтем сет2, тогда останутся только оставшиеся эл-ты сета1 (уникальные).
        // см. картинку в тетрадке,стр.150-151.
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Вычитание: " + difference);
    }
}