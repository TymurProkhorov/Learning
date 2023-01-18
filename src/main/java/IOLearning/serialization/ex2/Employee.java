package IOLearning.serialization.ex2;

import java.io.Serializable;

public class Employee implements Serializable {
    int age;
     transient String name;
    String dept;

    public Employee(int age, String name, String dept) {
        this.age = age;
        this.name = name;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
