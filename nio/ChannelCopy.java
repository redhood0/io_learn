package file_class.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        //args传入两个参数
        FileChannel in = new FileInputStream("test2.txt").getChannel(),
                out = new FileOutputStream("test3.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while(in.read(buffer) != -1){
            System.out.println(buffer.limit() + "1L-----" + buffer.position() + "P---" +buffer.capacity() + "C---" + buffer.mark());

            buffer.flip();  //prepare for writing
            System.out.println(buffer.limit() + "2L-----" + buffer.position() + "P---" +buffer.capacity() + "C---" + buffer.mark());

            out.write(buffer);
            System.out.println(buffer.limit() + "3L-----" + buffer.position() + "P---" +buffer.capacity() + "C---" + buffer.mark());

            buffer.clear();  //prepare for reading
            System.out.println(buffer.limit() + "4L-----" + buffer.position() + "P---" +buffer.capacity() + "C---" + buffer.mark());

        }
    }
}

