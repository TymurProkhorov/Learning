package IOLearning;

import java.io.*;

public class DataInputStreamAndDataOutputStream {
    public static void main(String[] args) {
        try(DataOutputStream dataOutputStream = new DataOutputStream(
                new FileOutputStream("newFile.bin"));
            DataInputStream dataInputStream = new DataInputStream(
                    new FileInputStream("newFile.bin")
            )) {
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeInt(100);
            dataOutputStream.writeByte(50);
            dataOutputStream.writeChar('q');
            dataOutputStream.writeLong(1_000_000_000L);

            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readLong());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
