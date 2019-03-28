package file_class.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy2 {
    private static int BSIZE = 1024;
    public static void copyFile(String fileName1,String fileName2) throws IOException {
        FileChannel in = new FileInputStream(fileName1).getChannel(),
                out = new FileOutputStream(fileName2).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);

        while(in.read(byteBuffer) != -1){
            byteBuffer.flip();
            out.write(byteBuffer);
            byteBuffer.clear();
        }
    }

    public static void main(String[] args) throws IOException {
        ChannelCopy2.copyFile("test2.txt","test4.txt");
    }
}
