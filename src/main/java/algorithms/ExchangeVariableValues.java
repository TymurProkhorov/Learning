package algorithms;

public class ExchangeVariableValues {
    public static void main(String[] args) {
        // обмен значениями переменных. Способ 1, с исп. временной переменной.
        int a = 3;
        int b = 5;
        int temp;
        System.out.println("a before exchange: " + a);
        System.out.println("b before exchange: " + b);
        temp = a;
        a = b;
        b = temp;
        System.out.println("a after exchange: " + a);
        System.out.println("b after exchange: " + b);
        System.out.println("--------------------------");
        // обмен значениями переменных. Способ 2, без исп. временной переменной.
        int y = 10;
        int z = 20;
        System.out.println("y before exchange: " + y);
        System.out.println("z before exchange: " + z);
        y = y + z;
        z = y - z;
        y = y - z;
        System.out.println("y after exchange: " + y);
        System.out.println("z after exchange: " + z);
    }
}
