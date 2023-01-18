package algorithms.searching;

public class BinarySearching {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 2, 2, 3, 15, 66, 155, 1000, 2000, 346435983};
        int[] array2 = {2, 2, 2, 2, 2, 2,2,3,3,3,3,3,3,3,3};
        System.out.println(binarySearch(array2, 2));
    }

    public static int binarySearch(int[] array, int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        //условие прекращения (пока есть эл-ты в массиве)
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] == elementToSearch) {
                return middleIndex;
            } else if (array[middleIndex] < elementToSearch) {
                firstIndex = middleIndex + 1;
            } else if (array[middleIndex] > elementToSearch) {
                lastIndex = middleIndex - 1;
            }
            /*
            Если мидл индекс равен эл-ту - то ок, верни этот индекс. Если мидл индекс меньше эл-та, то эл-т справа.
            Поэтому ферстиндексу присваиваем теперь мидлиндекс+1, чтоб полностью отсечь первую половину массива, ведь
            при повторном проходе вайла, он будет расценивать ферстиндекс как первый индекс, по которому нужно идти
            и проверять.
            Если же мидл индекс больше эл-та, то отсечем вторую половину массива, присвоив ластиндексу мидлиндекс-1.
            Проходы идут, пока не встрянем в элемент в первом ифе и возврашаем его индекс.
            Ничего не найдено - возвращаем -1.
             */
        }
        return -1;
    }
}
