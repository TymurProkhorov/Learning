package arrayListLearning;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {

    public static void printAllElementsFromArrayList() {
        //Вывести все эл-ты списка
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 26; i++) {
            list.add(i);
        }
        //Первый способ
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //Второй способ
        for (Integer element: list){
            System.out.println(element);
        }
        //Третий способ
        list.stream().forEach(a -> System.out.println(a));
    }

    public static void getOddNumbers(List<Integer> arrayList) {
        List<Integer> newList = new ArrayList<>();
        for (int j = 0; j < arrayList.size(); j++) {
            if (arrayList.get(j) % 2 == 0) {
                newList.add(j);
            }
        }
    }

    public static void methods() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(20);
        list.add(100);
        list.add(500);

        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(0);


        System.out.println(list.size());
        System.out.println(list.isEmpty());
//        list.clear();
        System.out.println(list.get(1));
        list.add(1, 1000);
        list.addAll(list2);
        list.remove(0);
        //list.removeAll(list2); // удалить из листа все эл-ты листа2
        //list.retainAll(list2); // оставить в листе те эл-ты, которые есть в лист2
        List<Integer> list3 = List.copyOf(list); // Создает unmodifiable list3 такой же, как list.
        List<Integer> list4 = List.of(1,3,4,56); // Создает unmodifiable list4.
        List<Integer> w = list.subList(0,1); /* Возвращает List. Создает представление искомого листа(подлист). Представление значит,
        что это не отдельная сущность, а какая-то абстракция. Если добавить в этот саблист элемент, он добавится.
        Но также добавится и в основной лист этот же элемент на индекс после саблиста. То есть, если есть лист с 10-ю
        элементами, и саблист, охватывающий, например, индексы 1-5(не включительно) этого листа, то, добавив элемент "а"
        в саблист, этот элемент вставится на индекс 5 и искомого листа тоже.
        Если же потом сносить структурные модификации(изменения) в искомый лист, например, просто добавить в него 11-й
        элемент, выскочит ConcurrentModificationException, потому что все структурные изменения искомого листа
        теперь нужно производить через представление - саблист.
        */
        boolean a = list.contains(1);
        System.out.println(a);
        System.out.println(list.containsAll(list2)); // содержит ли лист1 все эл-ты листа2?
        Integer[] array = list.toArray(new Integer[0]); // пишем 0 и не думаем о размере массива.
        Integer[] array2 = list.toArray(new Integer[100]); // массив заполнится эл-тами, а потом пойдут наллы
        Integer[] array3 = list.toArray(new Integer[1]); // джава дозаполнит сама массив и выведутся все эл-ты все равно
    }
}
