package linkedListLearning;

import java.util.Arrays;

public class MySimpleLinkedList {
    private Node head;
    private int size; // текущий размер списка. Иниц. не нужно, так как примитив изначально равен 0

    public void add(int value) {
        // Если это первое добавление в список
        if (head == null) {
            this.head = new Node(value);
        } else { // если не первое(т.е в head уже что-то есть)
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
            /*
            Как работает этот код? Переменная temp нужна, чтоб итерироваться. head всегда указывает на первый эл-т, поэтому
            им нельзя итерироваться. Предположим, у нас есть список из 3 эл-тов: [1] -> [2] -> [3]
            Ссылка head указывает на [1]. Берем переменную temp и ссылаем ее на тот же эл-т(на head). И в цикле начинаем
            продвигаться дальше по списку, то есть сначала проверяем, равняется ли наш temp.getNext(т.е. след. элемент [2])
            null-ом? В данном случае нет, он равен 2. Поэтому мы берем temp и присваиваем ей новое значение след.эл-та.
            Теперь temp находится на [2], а head все также на [1]. Идем дальше. temp.getNext() равно null-у? Нет, значит теперь
            temp = [3]. Дальше - temp.getNext() равно null-у? ДА! Потому что дальше нет узлов. Поэтому из цикла мы выходим,
            а temp указывает на последний эл-т в списке.
            И теперь следующему эл-ту после temp передаем новый объект класса Node со значением value.
            Таким образом, мы изменили список и он стал таким: [1] -> [2] -> [3] -> [4]
             */
        }
        size++; // после добавления одного эл-та надо увеличить и размер списка на 1.
    }

    public int get(int index) {
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) { // итерируемся по списку...
            if (currentIndex == index) { // если текущий индекс,который инкрементируется в елс-е, совпадет со входным,
                //то возвращаем значение ноды.
                return temp.getValue();
            } else { // если нет, то продолжаем итерироваться, заодно не забываем инкрементить currentIndex
                temp = temp.getNext();
                currentIndex++;
            }
        }
        // Если так и не совпали индексы, то нужно выбросить исключение, что такого индекса нет в списке
        throw new IllegalArgumentException();
    }

    public void remove(int index) {
        if(index == 0) { // удаление первого эл-та - отдельный случай. Поэтому вынесем его в отдельный if
            head = head.getNext();
            size--;
            return;
        }
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) {
            if (currentIndex == index - 1) {
                temp.setNext(temp.getNext().getNext());
                // Удаляем эл-т заменой ссылки. return нужен, чтоб не продолжать крутиться в этом цикле. И конечно,
                // при выходе,декрементим size.
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public int size() {
        return size;
    }

    public String toString() {
        // Переопределим toString, чтобы эл-ты удобно выводились на экран. Для этого надо пройтись по всем эл-там и вывести их
        int[] result = new int[size]; // Создадим временный массив с размером списка
        int index = 0; // и пер-ю индекс, равную 0
        Node temp = head; // Снова создадим пер-ю temp, которая будет указывать на head
        while (temp != null) { // Пройдемся по всему списку так, чтобы захватить и последний эл-т, для этого юзаем просто temp (не temp.getNext()).
            result[index++] = temp.getValue(); // Каждый раз добавляем в массив новое значение узла.
            temp = temp.getNext(); // И продвигаемся дальше...
        }
        return Arrays.toString(result); // И вернем массив в виде строки.
    }

    private static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
