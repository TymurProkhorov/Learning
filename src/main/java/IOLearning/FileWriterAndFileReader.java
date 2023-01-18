package IOLearning;

import java.io.*;

public class FileWriterAndFileReader {
    public static void main(String[] args) throws IOException {
         writeToFile();
        // writeToFileSecondOption();
        // writeToFileWithTWR();
        // readFromFile();
    }

    public static void writeToFile() throws IOException {
        String a = "Здравствуй, Дедушка Мороз!\n"
                + "Отдохни немного —\n"
                + "Ты большой мешок принес\n"
                + "И устал с дороги.\n"
                + "\n" + "Мы тебя повеселим,\n"
                + "Спать, конечно, не дадим,\n"
                + "И станцуем для тебя.\n"
                + "С Новым Годом всех! Ура!\n";
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\Users\\Asus\\Desktop\\Test.txt"); // Абсолютный путь, по которому будет поиск, куда записывать
            for (int i = 0; i < a.length(); i++) {
                writer.write(a.charAt(i));
            }
            System.out.println();
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public static void writeToFileSecondOption() throws IOException {
        String a = "Здравствуй, Дедушка Мороз!\n"
                + "Отдохни немного —\n"
                + "Ты большой мешок принес\n"
                + "И устал с дороги.\n"
                + "\n"
                + "Мы тебя повеселим,\n"
                + "Спать, конечно, не дадим,\n"
                + "И станцуем для тебя.\n"
                + "С Новым Годом всех! Ура!\n";
        String b = "Hello";
        FileWriter writer = null;
        try {
            writer = new FileWriter("Test2", true); // Можно просто вписать имя файла, это будет
            // относительный путь, и файл сам создастся в корне проекта.
            writer.write(a); // можно и так, без лупа, записываем сразу весь стринг, но под капотом все равно
            // будет записываться посимвольно. Так неэффективно.
            //writer.write(b); эта строка для проверки работы второго параметра конструктора FileWriter-а.
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public static void writeToFileWithTWR() throws IOException {
        String a = "Здравствуй, Дедушка Мороз!\n"
                + "Отдохни немного —\n"
                + "Ты большой мешок принес\n"
                + "И устал с дороги.\n"
                + "\n" + "Мы тебя повеселим,\n"
                + "Спать, конечно, не дадим,\n"
                + "И станцуем для тебя.\n"
                + "С Новым Годом всех! Ура!\n";
        try (FileWriter writer = new FileWriter("Test2.txt")) {
            /*
            TWR позволяет сократить код, автоматически закрывая ресурсы, прописанные в finally, отчего он становится
            не нужен. Через точку с запятой можно добавлять несколько ресурсов. TWR может быть без catch и finally, как
            в этом методе. Под капотом все равно создается обычный вариант, как в предыдущих методах, поэтому catch
            блок здесь можно не писать, а throws обязательно. Либо catch, либо throws должно быть.
            Каждый ресурс, прописанный в параметре try, должен имплементить AutoCloseable!
             */
            writer.write(a);
        }
    }
    public static void readFromFile() throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader("Test2"); // можно также указать абсолютный путь
            int character;
            while ((character = reader.read()) != -1) {
                /* read() считывает из файла и возвращает int. Если считывать больше нечего - возвр. -1,
                поэтому, while есть что считывать...*/
                System.out.print((char) character); // Нет смысла считывать инт, потому кастуем до чар.
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
}
