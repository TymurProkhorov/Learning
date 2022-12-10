package lambdaLearning;

import java.util.Arrays;

interface Executable {
    int execute(int x, String y);
}

class Runner {
    public void run(Executable e) {
        /*
        Этот метод в качестве аргумента ждет какую-то реализацию интерфейса Executable.
        То есть в качестве аргумента, мы должны передать в метод run
         какой-то класс, который реализует Executable
         */
        int a = e.execute(10, "90");
        System.out.println(a);
    }
}

//class ExecutableImplementation implements Executable {
//
//    @Override
//    public void execute() {
//        System.out.println("Hello");
//    }
//}

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();
         /* теперь при создании объекта класса Runner и если мы захотим запустить на нем метод run,
         мы должны в качестве аргумента передать реализацию инт. Executable. Это можно сделать 3-я способами.
         1) Создать класс ExecutableImplementation, реализовать в нем метод интерфейса Executable и в методе run
         можно в качестве аргумента передать новый объект класса ExecutableImplementation.
         Этот способ топорный, поэтому я его закомментил.
         */

        //runner.run(new ExecutableImplementation());

        // 2) Второй способ - создать анон. класс.
        runner.run(new Executable() {
            @Override
            public int execute(int x, String y) {
                System.out.println("Hello");
                return x + Integer.parseInt(y);
            }
        });

        // 3) Создать лямбда-выражение.
        runner.run((x, y) -> {
            System.out.println("Hello");
            System.out.println("goodbye");
            return x + Integer.parseInt(y);
        });

        // LambdaLearningAdvanced:
        System.out.println();
        System.out.println("LambdaLearningAdvanced:");

        LambdaLearningAdvanced lambdaLearningAdvanced1 = new LambdaLearningAdvanced();
        lambdaLearningAdvanced1.fillArray(lambdaLearningAdvanced1.array1); // заполняем массив
        lambdaLearningAdvanced1.fillList(lambdaLearningAdvanced1.list1); // заполняем лист
        System.out.println(lambdaLearningAdvanced1.list1);//отображаем лист
        System.out.println(Arrays.toString(lambdaLearningAdvanced1.array1)); // отображаем массив

        //lambdaLearningAdvanced1.multiplyBy2(); // множим и отображаем каждый эл-т массива и листа старым способом
        lambdaLearningAdvanced1.multiplyBy2WithLambda(); // множим и отображаем каждый эл-т массива и листа новым способом
        lambdaLearningAdvanced1.changeAllElementsTo3(); // тренировка - заменим каждый эл-т массива на "3"

        lambdaLearningAdvanced1.filterMethodPractice(); // тренировка метода filter на новом массиве и листе

        LambdaLearningAdvanced lambdaLearningAdvanced2 = new LambdaLearningAdvanced();
        lambdaLearningAdvanced2.fillArray(lambdaLearningAdvanced2.array1); // заполним массив и лист на новом объекте,
        // чтоб обновились значения.
        lambdaLearningAdvanced2.fillList(lambdaLearningAdvanced2.list1);
        lambdaLearningAdvanced2.forEachMethodPractice();

        System.out.println();
        lambdaLearningAdvanced2.reducePractice();

        System.out.println(LambdaLearningAdvanced.checkIfPresent(new Integer[]{1, 2, 34, 4, 5, 6}, 340));

    }
}
