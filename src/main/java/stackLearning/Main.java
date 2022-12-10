package stackLearning;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Структура данных для LIFO, допускает дубликаты, работает с null.
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2); // затолкать элемент)
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek()); // показать эл-т, не удаляет.  Показывает последний эл-т, ведь он зашел последним.
        System.out.println(stack.pop()); // показать эл-т и удалить его.
        System.out.println(stack.pop()); // повторный вызов отобразит и удалит след. эл-т

        System.out.println("------------------");
        //отобразим все эл-ты с пом. метода pop() и метода empty()
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}