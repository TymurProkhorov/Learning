package arrayListLearning;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {

    public static void printAllElementsFromArrayList() {
        //Вывести все эл-ты списка
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 26; i++) {
            list.add(i);
        }
        //Первый способ
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //Второй способ
        for (Integer element: list){
            System.out.println(element);
        }
        //Третий способ
        list.stream().forEach(a -> System.out.println(a));
    }

    public static void getOddNumbers(List<Integer> arrayList) {
        List<Integer> newList = new ArrayList<>();
        for (int j = 0; j < arrayList.size(); j++) {
            if (arrayList.get(j) % 2 == 0) {
                newList.add(j);
            }
        }
    }

}
