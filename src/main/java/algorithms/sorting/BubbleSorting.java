package algorithms.sorting;

import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] array = {1, 2, 15, 66, 100, 3, 0, 2, 2};
        System.out.println(Arrays.toString(bubbleSorting(array)));
    }

    public static int[] bubbleSorting(int[] array) {
        /*
        Внутренним фором проходимся по всем парам эл-тов и, если надо, меняем их значения с пом. временной пер-ой.
        {1, 2, 15, 66, 3, 0, 2, 2}. Пройдясь по такому массиву внутреним фором 1 раз, 66 встанет в конец,
         потом добавляется 1 к i(внешнего фора) и начинаем по новой проходиться по внутреннему 2-й
        раз - и 15 встанет в конец итд.
         */
       for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
