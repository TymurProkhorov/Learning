package IOLearning.serialization.ex2;

import java.io.*;

public class SerializationCustomObject {
    public static void main(String[] args) {
        Employee Tim = new Employee(29, "Tim", "IT");
        serialization(Tim);
        deserialization(Tim);
    }

    private static void serialization(Employee employee) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Employees.bin"))) {
            outputStream.writeObject(employee);
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deserialization(Employee employee) {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Employees.bin"))) {
            employee = (Employee) inputStream.readObject();
            System.out.println(employee);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
