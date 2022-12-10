package comparatorLearning;

public class ComparablePerson implements Comparable<ComparablePerson> {
    private int id;
    private String name;

    public ComparablePerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ComparablePerson {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(ComparablePerson o) {
        /* метод дает понять, что объекты класса ComparablePerson сортируемы.
        То есть так мы задаем естественный порядок сортировки для кастомных объектов. Конвенция та же, что и в compare().
         Тут 1 параметр, так как мы сравниваем объект с нашим текущим объектом класса ComparablePerson - this.id или
         this.name
         Сортанем по нэйму. Чем больше длина строки - тем больше объект.
         */
        if(this.name.length() > o.getName().length()) return 1;
        else if(this.name.length() < o.getName().length()) return -1;
        else return 0;
    }
}
