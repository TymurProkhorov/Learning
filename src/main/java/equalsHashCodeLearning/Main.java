package equalsHashCodeLearning;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(1, "Mike");
        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        map.put(person1, "12");
        map.put(person2, "34");
        set.add(person1);
        set.add(person2);
        System.out.println(map);
        System.out.println(set);
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return Objects.equals(name, person.name);
    }

    /*
    Зачем нужен hashCode? Он преобразует массив неопределенной длины в число определенной длины. Другими словами,
    объект любой длины (например класса Integer со значением 1, или же кастомный объект с сотней полей) конвертится в число
    определенной длины, так сравнивать намного быстрее. Это механизм хеширования. Но могут быть коллизии, ведь
    диапазон int-ов не бесконечен. Поэтому нужен equals.
    А equals нужен, чтобы дать гарантированно точное сравнение, но это будет происходить намного медленнее, чем сравнение по
    хеш-коду. Т.е., при сравнении двух объектов, сначала вызывается хеш-код и они сравниваются по нему, если коллизия, то
    вызывается медленный equals и есть точный результат.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    /*
    Контракт hashCode() equals():
    1) У проверяемых объектов вызывается hashCode() и если хешкоды разные - то объекты точно разные.
    2) Если хешкоды равны - то не ясно, это объекты равны или возникла коллизия? Поэтому вызывается equals и проверяется.
     */
}