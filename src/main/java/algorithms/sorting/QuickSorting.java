package algorithms.sorting;

import java.util.Arrays;

public class QuickSorting {
    public static void main(String[] args) {
        int[] array = {1, 2, 15, 66, 3, 0, 2, 2};
        int from = 0;
        int to = array.length - 1; // low, high - границы подмассива, в пределах которых будет происходить сортировка.
        quickSorting(array, from, to); // при запуске сортировки это весь массив, т.е. от array[0] до array.length-1
        System.out.println(Arrays.toString(array));
    }

    public static void quickSorting(int[] array, int from, int to) {
        if (array.length == 0) {
            return;
        }
        if (from >= to) {
            return; // завершить выполнение, если уже нечего делить
        }

        // выбрать опорный элемент:
        int middle = from + (to - from) / 2;
        int supportElement = array[middle]; // supportElement - опорный элемент

        // разделить на массивы, которые больше и меньше опорного эл-та:
        int i = from;
        int j = to;
        while (i <= j) {
            while(array[i] < supportElement) {
                i++;
            }
            while(array[j] > supportElement) {
                j--;
            }
            if(i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if(from < j) {
            quickSorting(array, from, j);
        }
        if(to > i) {
            quickSorting(array, i, to);
        }
    }
}
