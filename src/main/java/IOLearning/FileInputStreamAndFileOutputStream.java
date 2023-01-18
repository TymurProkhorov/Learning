package IOLearning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamAndFileOutputStream {
    public static void main(String[] args) {
        try(FileInputStream inputStream =
                    new FileInputStream("D:\\скачка\\alpaca.jfif"); // Адрес картинки на раб.столе. FIS читает
            FileOutputStream outputStream = new FileOutputStream("newPicture.jpeg")) // FOS записывает в новую картинку с указанным именем
        {
         int i;
         while((i = inputStream.read()) != -1) {
             outputStream.write(i);
         }
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}
