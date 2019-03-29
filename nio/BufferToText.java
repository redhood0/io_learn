package file_class.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
/*
如何用管道nio输出字符，并且设定字符编码
 */
public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();//建立文件“data2.txt”连接通道
        fc.write(ByteBuffer.wrap("Some Text中文".getBytes()));//"文件中输入"
        fc.close();//关闭通道
        //接下来利用通道读取文件
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer bf = ByteBuffer.allocate(BSIZE);
        fc.read(bf);
        bf.flip();
        //输出小车中的煤矿
        System.out.println(bf.asCharBuffer());
         //Decoding using this system's default Charset
        bf.rewind();//rewind 倒带，倒回
        String encoding2 = System.getProperty("file.encoidng");
        String encoding = "UTF-8";
        System.out.println("Decoded using " + encoding + ":" + Charset.forName(encoding).decode(bf));//decode 解码
        //Or,we could encode with something that will print 在字符
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text中1文11asdadsasda".getBytes("UTF-16BE")));
        fc.close();
        //new try read again
        fc = new FileInputStream("data2.txt").getChannel();
        bf.clear();
        fc.read(bf);
        bf.flip();
        System.out.println(bf.asCharBuffer());
        //Use a CharBuffer to write through
        fc = new FileOutputStream("data2.txt").getChannel();
        bf = ByteBuffer.allocate(24);
        bf.asCharBuffer().put("some 中文");
        fc.write(bf);
        fc.close();
        //read and display
        fc = new FileInputStream("data2.txt").getChannel();
        bf.clear();
        fc.read(bf);
        bf.flip();
        System.out.println(bf.asCharBuffer());
    }
}
