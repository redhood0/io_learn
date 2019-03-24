package file_class.buffered_learn;

import java.io.*;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(
                "./src/file_class/buffered_learn/BufferedInputFile.java")));
        int x = 0;
        while((x = in.available()) != 0){
            System.out.println("x-----" + x);
            System.out.println((char)in.readByte());
        }
    }

}
