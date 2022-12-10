package arrayListLearning;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        ArrayListPractice.getOddNumbers(list);
        ArrayListPractice.printAllElementsFromArrayList();

    }
}