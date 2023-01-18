package IOLearning;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ClassFileLearning {
    public static void main(String[] args) throws IOException {
        File file = new File("Omen.txt");
        File folder = new File("D:\\Java");
        File file2 = new File("D:\\Java\\Test100500.txt"); // добавим в папку Java пока несуществующий файл.
        //Ексепшнов здесь не будет. Метод exists() проверит, существует ли файл\папка
        File folder2 = new File("D:\\Java\\B"); // добавим также несуществующую папку

        System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath(): " + folder.getAbsolutePath());
        System.out.println("--------------------------------");

        System.out.println("file.isAbsolute(): " + file.isAbsolute());
        System.out.println("folder.isAbsolute(): " + folder.isAbsolute());
        System.out.println("--------------------------------");

        System.out.println("file.isDirectory(): " + file.isDirectory());
        System.out.println("folder.isDirectory(): " + folder.isDirectory());
        System.out.println("--------------------------------");

        System.out.println("file.exists(): " + file.exists());
        System.out.println("folder.exists(): " + folder.exists());
        System.out.println("file2.exists(): " + file2.exists());
        System.out.println("folder2.exists(): " + folder2.exists());
        System.out.println("--------------------------------");

        System.out.println("file2.createNewFile(): " + file2.createNewFile()); // теперь file2 существует!
        System.out.println("folder2.mkdir(): " + folder2.mkdir()); // как и папка folder2
        System.out.println("file.createNewFile()" + file.createNewFile()); // если создать уже существующий файл, то будет false, создание не удалось
        System.out.println("--------------------------------");

        System.out.println("file2.length(): " + file2.length());
        System.out.println("folder2.length(): " + folder2.length());
        /*
        Чтоб найти длину всех файлов в папке, надо на каждом файле находить размеры и складывать их,
         а пока размер папки - 0
         */
        System.out.println("--------------------------------");

        System.out.println("file2.delete(): " + file2.delete());
        System.out.println("folder2.delete(): " + folder2.delete());
        System.out.println("folder.delete(): " + folder.delete()); // нельзя удалить не пустую папку, сначала надо
        // удалить из нее все содержимое
        System.out.println("--------------------------------");

        File[] files = folder.listFiles(); // глянем содержимое папки
        System.out.println(Arrays.toString(files));
        System.out.println("--------------------------------");

        System.out.println("file.isHidden(): " + file.isHidden());
        System.out.println("file.canRead(): " + file.canRead());
        System.out.println("file.canWrite(): " + file.canWrite());
        System.out.println("file.canExecute(): " + file.canExecute());
        System.out.println("--------------------------------");
    }
}
