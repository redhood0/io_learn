package file_class.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZE = 1024;//1kB

    public static void main(String[] args) throws IOException {
        //write a file:
        FileChannel fileChannel = new FileOutputStream("data1.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("Some text".getBytes()));
        fileChannel.close();
        //Add to the end of the file(method: getChannel)
        fileChannel = new RandomAccessFile("data1.txt", "rw").getChannel();
        System.out.println("fileChannel.size()  ---" + fileChannel.size());
        fileChannel.position(fileChannel.size());//position位置
        fileChannel.write(ByteBuffer.wrap("some more".getBytes()));
        fileChannel.close();
        //read the file
        fileChannel = new FileInputStream("data1.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);//allocate 分配
        ByteBuffer buffDirect = ByteBuffer.allocateDirect(BSIZE);
        buff.putInt(10);
        fileChannel.read(buff);
        System.out.println(buff.limit() + "L-----" + buff.position() + "P---" +buff.capacity() + "C---" + buff.mark());

        buff.flip();//flip 翻转缓冲区
        System.out.println(buff.limit() + "L-----" + buff.position() + "P---" +buff.capacity() + "C---" + buff.mark());
        //remaining 剩余的
        int count = 0;
        while (buff.hasRemaining()) {
            System.out.println(buff.hasRemaining() + "---" + count++);
            System.out.println((char) buff.get());
        }
    }

}
