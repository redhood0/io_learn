package file_class.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

//大型映射文件
public class LargeMappedFiles {
    static int length = 0x8000000; //128 MB

    public static void main(String[] args) throws IOException {
        MappedByteBuffer out = new RandomAccessFile("test3.txt","wr").getChannel()
                .map(FileChannel.MapMode.READ_WRITE,0,length);
        for(int i = 0;i < length; i++){
            out.put((byte)'s');
        }
        System.out.println("finish writing");
        for(int i = length/2; i < length; i++){
            System.out.println((char)out.get(i));
        }
    }


}
