package annotationsLearning;


public class Main {

    @MyAnnotation // аннотации могут применяться к статическим методам
    public static void main(@MyAnnotation String[] args) { // к параметру в статическом методе

        Test test = new Test();
        test.method(); // Результат работы аннотации Deprecated. Если в библиотеке, которую мы пишем, появляется новый метод, а этот
        // устарел, то можно дать другим разработчикам понять, что пора от этого метода избавляться и не юзать.

        Test.printSomething();
    }
}
@MyAnnotation  // к классу
class Person {
   @MyAnnotation private int age; // к полю

    @MyAnnotation // к конструктору
    public Person() {
    }

    @MyAnnotation // к методу
    public int personsAge(@MyAnnotation int a) { // к параметру метода
        @MyAnnotation int r = 12; // к локальной переменной
         return a + age;
    }
}