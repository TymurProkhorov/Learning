package IOLearning;

import java.io.*;

public class BufferedReaderAndBufferedWriter {
    public static void main(String[] args) {
        /*
        Буфферизация - процесс загрузки части файла, во время потоковой передачи, например,музыки\видео, до их
        воспроизведения. Позволяет смотреть\слушать файлы практически мгновенно. Т.е., загружается часть файла,
        воспроизводится, а остальная часть продолжает загружаться.
        Использование буфферизации позволяет увеличить производительность, так как обычный файл-ридер обращается к файлу,
        считывает символ, использует его(выводит например на экран), потом снова обращаетсся и считывает - О(n).
        А BufferedReader считывает все символы, помещает в буфер и использует из буфера - О(1) или О(n).
        BufferedWriter - аналогично.
        BufferedWriter, BufferedReader - обертки. Они оборачивают обычные FileWriter, FileReader,
         добавляя функционал буфферизации.
         */
        try(BufferedReader reader = new BufferedReader(
                new FileReader("Test2.txt")); // Если его нет - создать в классе FileWriterAndFileReader
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("Test3.txt"))) {
//            int character;
//            while((character = reader.read()) != -1) {
//                writer.write(character);
//            } это первый способ переноса данных из файла Test2 в Test3
            String line;
            while((line = reader.readLine()) != null) { // Пока есть, что читать, ...
                writer.write(line);
                writer.write("\n"); // Без этого все запишется в одну строку
            }
            System.out.println("Done");
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
