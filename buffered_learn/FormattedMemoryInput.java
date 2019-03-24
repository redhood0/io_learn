package file_class.buffered_learn;
//测试中文
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;

public class FormattedMemoryInput {
    public static void main(String[] args) throws Exception{
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.
                    read("./src/file_class/buffered_learn/BufferedInputFile.java").getBytes()));
            while (true) {
                System.out.println((char) in.readByte());
            }
        }catch (EOFException e){
            System.out.println("end of stream");
        }
        //测试中文
    }
}
