public class Strings {
    public static void main(String[] args) {
        System.out.println(calculator(1, 2, 54, -90));
    }

    public static int calculator(int ... a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
