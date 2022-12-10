package queueLearning;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        Queue<Person> queue = new ArrayBlockingQueue<>(4);
     /* Можно исп. LinkedList, он тоже реализует инт. Queue,
        но мы используем ArrayBlockingQueue, он позволяет задать границу очереди (прям как массив).
        Очередь работает по принципу FIFO. Первый элемент, добавленный в очередь, первым и будет обрабатываться
        (показываться, удаляться итд).

        Основные методы добавления: add(), offer(). Разница между ними в том, что add() при ошибке кидает исключение
        IllegalStateException, а offer - спец.значение. Т.е., если добавить 5-й элемент в эту очередь, то offer просто
        выведет false.
        Основные методы удаления: remove(), poll(). Разница та же. Удаляя несуществующий эл-т, remove() выкинет
        IllegalStateException(?????проверить этот момент, так как выдает false?????), poll() - null.
        ОСновные методы получения: element(), peek(). Разница та же. element() - IllegalStateException.

        Queue допускает дубликаты, null не катит.
        */
        System.out.println(queue.offer(person2));
        System.out.println(queue.offer(person1));
        System.out.println(queue.offer(person3));
        System.out.println(queue.offer(person4));
        System.out.println(queue.offer(person1));
        System.out.println();

        queue.poll(); // выкинул первый эл-т, так как он вошел первым.

        System.out.println(queue.element()); // показал первый эл-т.
        System.out.println(queue.peek()); // то же самое.
    }
}

class Person {
    private final int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person {" + "id = " + id + '}';
    }
}
