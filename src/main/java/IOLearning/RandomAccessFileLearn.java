package IOLearning;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileLearn {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("Omen.txt", "rw")) { // mode: read\write
            int a = file.read(); // читаем побайтово
            System.out.println((char) a);

            String b = file.readLine(); // читаем всю строку(первый символ уже был прочитан, поэтому строка от второго символа)
            System.out.println(b);

            file.seek(10); // перемещает поинтер(курсор)
            int c = file.read();
            System.out.println((char) c);

            file.seek(file.length()-1);// идем в конец файла...
            file.writeBytes("\n\t\tOmen"); // и красиво добавим запись
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
