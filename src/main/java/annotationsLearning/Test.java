package annotationsLearning;

public class Test {

    @Deprecated
    public void method() {

    }

    @MethodInfo(date = 2023)
    public static void printSomething() {
        System.out.println("Hello");
    }
}
