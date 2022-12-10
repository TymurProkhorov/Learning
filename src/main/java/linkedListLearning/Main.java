package linkedListLearning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        System.out.println("----------\ntimeMeasuringAddingToTheEnd:");
        timeMeasuringAddingToTheEnd(linkedList);
        timeMeasuringAddingToTheEnd(arrayList); // Выиграл!
        System.out.println("----------\ntimeMeasuringGetting:");
        timeMeasuringGetting(linkedList);
        timeMeasuringGetting(arrayList); // Выиграл!
        System.out.println("----------\ntimeMeasuringAddingToBeginning:");
        timeMeasuringAddingToBeginning(linkedList); // Выиграл!
        timeMeasuringAddingToBeginning(arrayList);
        System.out.println("-----------\ntimeMeasuringRemoving:");
        timeMeasuringRemoving(linkedList); // Выиграл!
        timeMeasuringRemoving(arrayList);
        System.out.println("----------------------------------\nMySimpleLinkedList:");
        MySimpleLinkedList myLinkedList = new MySimpleLinkedList();
        myLinkedList.add(12);
        myLinkedList.add(13);
        myLinkedList.add(3200);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(2));
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());
    }

    private static void timeMeasuringAddingToTheEnd(List<Integer> list) {
        // Сравним время выполнения операций на linkedList и arrayList.
        long start = System.currentTimeMillis(); // Метод возвращает текущее время в милисекундах(засекаем стартовое время).

        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis(); // И измерим время после проведения операций.
        System.out.println(end - start); // Выводим время выполнения операций - этот метод будет считать время, за которое выполнится код между start и end
    }

    private static void timeMeasuringGetting(List<Integer> list) {
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void timeMeasuringAddingToBeginning(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            list.add(0, i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void timeMeasuringRemoving(List<Integer> list) {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            list.remove(i);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}