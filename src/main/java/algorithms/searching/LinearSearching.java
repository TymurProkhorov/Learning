package algorithms.searching;

public class LinearSearching {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 90, 110, 125};
        System.out.println(findElement(array, 33));
    }

    public static int findElement(int[] array, int elementToSearch) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == elementToSearch) {
                return i;
            }
        }
        return -1;
    }
}
