package file_class.buffered_learn;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    //1测11试汉字
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("./src/file_class/buffered_learn/MemoryInput.java"));
        int c;
        while((c = in.read()) != -1){
            System.out.println((char)c);
        }
    }
}
