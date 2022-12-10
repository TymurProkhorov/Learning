package comparatorLearning;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("elephant");
        animals.add("cat");
        animals.add("dog");
        animals.add("bird");
        Collections.sort(animals); // Статический метод sort() в классе Collections сортирует эл-ты в естественном порядке.
        System.out.println(animals);
        /*
        Но что если нас не устраивает естественный порядок? Например цель отсортировать строки листа animals
        по длине или числа в обратном порядке. Вот для этих случаев есть интерфейс Comparator.
        Сначала создаем класс, реализуем компаратор и его метод compare. В compare логика сортировки. Конвенция compare:
        o1 > o2 => return 1
        o1 < o2 => return -1
        o1 = o2 => return 0
        o1 и о2 это как бы примеры типов, которые мы сортируем в коллекции.
         */
        animals.sort(new StringLengthComparator());
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(500);
        numbers.add(0);
        numbers.add(100);
        Collections.sort(numbers);
        System.out.println(numbers);
        // Так как мы создаем целый класс для реализации всего лишь 1 метода, лучше исп. анон. класс,
        // а его конечно можно представить лямбдой:
        numbers.sort((o1, o2) -> {
            if (o1 > o2) return -1;
            else if (o1 < o2) return 1;
            else return 0;
        });
        System.out.println(numbers); // Числа в обратном порядке

        // Для кастомных объектов естественный порядок неизвестен, поэтому обычный sort() здесь не работает -
        // надо поставлять свой Comparator. Создадим класс Person и отсортируем людей по id.
        System.out.println("-----custom sorting with Comparator-----");
        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "Javelii"));
        people.add(new Person(2, "Pythonoslav"));
        people.add(new Person(4, "Pascalii"));
        people.add(new Person(3, "Vasjan"));
        people.sort((o1, o2) -> {
            if (o1.getId() > o2.getId()) return 1;
            else if (o1.getId() < o2.getId()) return -1;
            else return 0;
        });
        System.out.println(people);

        System.out.println("-----defining the natural order for custom objects-----");
        List<ComparablePerson> list = new ArrayList<>();
        Set<ComparablePerson> set = new TreeSet<>();
        addElements(list);
        addElements(set);

        System.out.println("list: " + list);
        System.out.println("set: " + set);  // TreeSet сортирует сам, к нему не нужно еще раз вызывать sort(),
        // ему главное иметь метод compareTo в классе, объекты которого он хочет сортировать.
        Collections.sort(list);

        System.out.println("list after sorting: " + list);
        System.out.println("set after sorting: " + set);

    }

    private static void addElements(Collection<ComparablePerson> collection) {
        collection.add(new ComparablePerson(1, "Elvira"));
        collection.add(new ComparablePerson(4, "Gazel"));
        collection.add(new ComparablePerson(3, "Kulbaba"));
        collection.add(new ComparablePerson(2, "Fatima"));
    }
}
