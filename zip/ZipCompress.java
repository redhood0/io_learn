package file_class.zip;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * zip压缩包的创建，构造方法提供编码级，可以为汉字服务。
 */
public class ZipCompress {
    private static final String[] files = {"a.txt", "b.txt", "c.txt", "d.jpg"};

    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());//计算和校验文件
        ZipOutputStream zos = new ZipOutputStream(csum, Charset.forName("UTF-8"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zos);

        zos.setComment("A test of java Zipping");
        //No没有corresponding 对应的getComment(), though（但是）
        for(String file : files){
            System.out.print("writing file " + file + " |");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            BufferedInputStream in2 = new BufferedInputStream(new FileInputStream(file));
            zos.putNextEntry(new ZipEntry(file));//dont know this
            int c;
            while((c = in2.read()) != -1){
                bufferedOutputStream.write(c);
            }
            in.close();
            bufferedOutputStream.flush();
        }
        System.out.println();
        bufferedOutputStream.close();
        //Checksum valid only after the file has been closed!
        System.out.println("Checksum: " + csum.getChecksum().getValue());
        //---------------------------------------------------------------------------------
        //Now extract the files:
        System.out.println("Reading file");





    }
}
