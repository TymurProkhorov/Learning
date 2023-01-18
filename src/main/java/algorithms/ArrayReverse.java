package algorithms;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 8, 9, 0};
        System.out.println(Arrays.toString(arrayReverse(array)));
    }

    public static int[] arrayReverse(int[] array) {
/*
Находим середину массива и проходим от начала до нее, в теле цикла меняя i-тое значение(т.е. от первого итд) со значением
array.length - i - 1. Значения меняем с пом. временной переменной.
 */
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
