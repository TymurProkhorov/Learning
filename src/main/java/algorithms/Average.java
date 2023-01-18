package algorithms;

public class Average {
    public static void main(String[] args) {
        int[] array = {10, 25, 67, 0, 12, 91};
        System.out.println(findAverage(array));
    }

    public static double findAverage(int[] array) {
        double sum = 0;
        for(int element: array) {
            sum += element;
        }
        return sum / array.length;
    }
}
