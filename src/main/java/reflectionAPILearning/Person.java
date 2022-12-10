package reflectionAPILearning;

@Author
public class Person {
    public int id;
    String name;
    private int date;

    public Person() {
        this.id = -1;
        this.name = "No name";
        this.date = 2222;
    }

    public Person(int id, String name, int date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
