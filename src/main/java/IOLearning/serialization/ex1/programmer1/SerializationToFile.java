package IOLearning.serialization.ex1.programmer1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationToFile {
    public static void main(String[] args) {
        /*
        Программист1 создает объект работников и хочет передать его другому с пом.сериализации. Создаем в TWR новый
        бинарный файл Employees1.bin и записываем с пом. метода writeObject(obj). Идем в пакет программер2...

        ArrayList и String имплементят Serializable, для всех кастомных объектов(и всех его полей)
        его надо имплементить вручную!!!
         */
        /*
        Если первый программист создал класс, который надо сериализовать, у второго программиста должен быть
        такой же класс. Но что если первый программист изменил класс, сериализовал его объект, а у второго программера
        получается "устаревший класс"? Будет InvalidClassException при десериализации. В этом ексепшне генерируется переменная
        serialVersionUID, чувствительная к изменению классов, то есть измени чуть-чуть класс и она изменится.
        Хорошая практика - самостоятельно создавать эту пер-ную final static long versionUID = 1; обычным полем класса,
        и если кто-то меняет что-то в классе, то и присваивать ей другое значение.
         */
        List<String> employees = new ArrayList<>();
        employees.add("Alex");
        employees.add("Helen");
        employees.add("Ann");
        employees.add("Mark");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Employees1.bin"))){
            outputStream.writeObject(employees);
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
