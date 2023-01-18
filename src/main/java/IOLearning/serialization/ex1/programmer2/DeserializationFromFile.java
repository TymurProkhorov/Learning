package IOLearning.serialization.ex1.programmer2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeserializationFromFile {
    public static void main(String[] args) {
/*
Другой программист, допустим, тоже положил себе этот файл в корень проекта. Он создает ObjectInputStream,
т.к. он будет читать этот файл и указывает относительный путь к этому файлу в конструкторе FileInputStream-a.
Считываем сериализованный файл с пом. readObject(Obj o), кастуем его к ArrayList, т.к. ридобджект принимает обджект.
Это десериализация.
 */
        List<String> otherListOfEmployees = new ArrayList<>();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Employees1.bin"))) {
            otherListOfEmployees = (ArrayList) inputStream.readObject();
            System.out.println(otherListOfEmployees);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
