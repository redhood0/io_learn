package file_class.zip;

/**
 * gzip 单文件压缩
 */

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

//compress压缩，变小

public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        //BufferedReader in3  =   new  BufferedReader(new  InputStreamReader(new  FileInputStream( "123.txt" ), "UTF-8"));
        BufferedReader in = new BufferedReader(new FileReader("123.txt"));

        BufferedOutputStream bos = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("123.gz")));

        System.out.println("write file");
        String c;
        while((c = in.readLine()) != null){
            //System.out.println((char)c);
            bos.write(c.getBytes("UTF-8"));
        }
        in.close();
        bos.close();

        System.out.println("read file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("123.gz")),"UTF-8"));
        String s;
        while((s = in2.readLine()) != null){
            System.out.print(s);
        }
        in2.close();
    }
}
