package lambdaLearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaLearningAdvanced {
    int[] array1 = new int[10];
    List<Integer> list1 = new ArrayList<>();

    public void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    public void fillArray(int[] array) {
        for (int i = 0; i < 10; i++) {
            array[i] = i + 1;
        }
    }

    public void multiplyBy2() {
        // умножим каждое число в массиве и списке на 2:  (старый способ)
        for (int i = 0; i < 10; i++) {
            array1[i] *= 2;
            list1.set(i, list1.get(i) * 2);
        }
        System.out.println(Arrays.toString(array1));
        System.out.println(list1);
    }

    public void multiplyBy2WithLambda() {
        //  а теперь умножим каждое число в массиве и списке на 2:  (новый способ, с пом. лямбды)
        /*
        Для массива сначала вызывается метод Arrays.stream, который принимает на вход массив
        и на выходе получается поток(не тот поток, что в многопоточке, а совсем другой!!),
        просто лямбда не может оперировать напрямую на массиве и сразу на листе, поэтому эти наборы
        эл-тов нужно сначала превратить в другую сущность - в потоки. Дальше на этом потоке вызывается метод
        map(). Это спец. метод, который пришел из функциональных ЯП(например, Haskell), который позволяет
        легко изменять наборы данных. Метод берет каждый эл-т из набора данных и сопоставляет ему
        новый элемент. И вот это сопоставление описываем с пом. лямбда-выражений.
        Для листа же просто вызывается поток. Выглядит так:
        Arrays.stream(array1).map();
        list1.stream().map();
        Далее в параметр map нужно вписать логику, согласно которой мы и будем сопоставлять эл-ты.
        map - отображение. Это понятие пришло из теории множеств. Это когда у нас есть оригинальное множество
        и какое-то преобразованное множество. Мы берем каждый эл-т из оригинального множества и по какому-то правилу
        сопоставляем этому эл-ту элемент из нового множества. такая операция называется отображением.
        Мы хотим отобразить каждый эл-т массива и листа в какой-то новый эл-т в новом массиве и в новом листе.
        Это отображение создается с пом. лямбда-выражения.
        Будет какая-то переменная a, она будет обозначать каждый эл-т исходного массива и листа. И ее
        мы сопоставляем этому же элементу, умноженному на 2. Конечный вариант:
         */
        array1 = Arrays.stream(array1).map(a -> a * 2).toArray();
        list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList());
        System.out.println(Arrays.toString(array1));
        System.out.println(list1);
        /*
        map берет на вход какой-то набор эл-тов (в нашем случае это stream(array1))  и начинает
        по нему итерироваться. Таким образом, пер-я a будет изменяться на a * 2 и сразу возвращаться в новое множество.
        map возвращает поток! а у нас переменные array1 и list1 - не потоки, поэтому в конце нужно просто привести
        эти потоки к соответствующим типам. К массиву - toArray(); к листу - collect(Collectors.toList());
         */
    }

    public void changeAllElementsTo3() {
        System.out.println("changeAllElementsTo3:");
        array1 = Arrays.stream(array1).map(a -> 3).toArray();
        System.out.println(Arrays.toString(array1));
    }

    public void filterMethodPractice() {
        // Создадим и заполним новый массив и лист
        int[] array2 = new int[10];
        List<Integer> list2 = new ArrayList<>();
        fillArray(array2);
        fillList(list2);
        System.out.println("filter method practice:");
        /*
        Метод filter фильтрует эл-ты массива или листа. Не модифицирует! Например, чтобы отфильтровать массив и лист,
        чтоб остались только четные числа, воспользуемся таким лямбда-выражением:
         */
        array2 = Arrays.stream(array2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(Arrays.toString(array2));
        System.out.println(list2);
    }

    public void forEachMethodPractice() {
        // Это просто более короткая форма цикла foreach. Аналог.
        System.out.println("forEachMethodPractice:");
        Arrays.stream(array1).forEach(a -> System.out.print(a + " "));
        System.out.println();
        list1.stream().forEach(a -> System.out.print(a + " "));
    }

    public void reducePractice() {
        System.out.println("reducePractice");
        /*
        reduce - уменьшение
        Берет набор данных и сжимает его в какой-то один элемент
        Работает с двумя пар-ми: аккумулятор acc и второй пер-й в, которая будет обозначать каждый эл-т набора данных.
        Приняв эти два параметра, начинает итерироваться по каждому эл-ту, после каждой итерации аккумулятору присваивает
        рез-т итерации, и возвр его в виде потока. По дефолту аккумулятор имеет значение первого элемента массива.
        Ему можно присвоить значение: reduce(0, (acc, b) -> acc + b). 0 и будет означать начальное значение асс-а.
        Если не указать значение итератору, то первая итерация пойдет со второго эл-та.
        Пример, как сложить все эл-ты массива, перемножить эл-ты листа:
         */
        int[] array3 = new int[10];
        List<Integer> list3 = new ArrayList<>();
        fillList(list3);
        fillArray(array3);
        int sum = Arrays.stream(array3).reduce((acc, b) -> acc + b).getAsInt();
        int product = list3.stream().reduce((acc, b) -> acc * b).get();
        System.out.println(sum);
        System.out.println(product);
    }

    public static boolean checkIfPresent(Object[] a, Object o) {
        /*
        Метод asList представляет любой массив в виде списка, позволяя применять к нему методы коллекций.
        contains проверяет, содержит ли наш массив параметр contains-a.
         */
        return Arrays.asList(a).contains(o);
        /*
        Второй вариант - метод anyMatch(). Возвращает true при любом совпадении.
        return Arrays.stream(a).anyMatch(q -> q == o);
        То есть, если какой-либо элемент (q) при проходе будет равняться о, то вернется true
         */
    }
}
