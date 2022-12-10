package reflectionAPILearning;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Person person = new Person();

        // 3 способа создания объекта класса Class:
        Class personClass1 = Person.class;
        Class personClass2 = person.getClass();
        Class personClass3 = Class.forName("reflectionAPILearning.Person"); // Выкидываем искл., если метод не найдет класс по указанному адресу.
        ClassesInJavaReflectAPI c = new ClassesInJavaReflectAPI();
//        c.getMethodsFromPersonClass();
//        System.out.println("----------------------");
//        c.getFieldsFromPersonClass();
//        System.out.println("----------------------");
//        c.getAnnotationsFromPersonClass();

        /*
        Считаем из консоли назв. двух классов и создадим объекты этих двух классов с пом. рефлексии, затем считаем из консоли
        название метода, вызовем этот метод на объекте первого класса и в качестве аргумента для этого вызова метода,
        мы передадим объект второго класса. Такое в Джаве без рефлексии сделать невозможно.
         */
        Scanner sc = new Scanner(System.in);
        // Название_класса1 Название_класса2 Название_метода
        Class classObject1 = Class.forName(sc.next()); // получим класс из консоли
        Class classObject2 = Class.forName(sc.next());
        String methodName = sc.next();

        Method m = classObject1.getMethod("methodName", classObject2); // так как мы хотели методу вторым аргументом поставить
        //объект второго класса, вторым аргументом метода getMethod ставим именно classObject2
        Object o1 = classObject1.newInstance(); // создан объект, который соответствует первому классу
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value"); // создан объект, соотв. второму классу,с пар-ом

        m.invoke(o1, o2); // Вызывается на объекте о1 и вызывается он с аргументом о2
        System.out.println(o1);

    }
}
