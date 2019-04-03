package file_class.zip;

import java.io.*;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompress {
    private static final String[] files = {"a.txt", "b.txt", "c.txt", "d.jpg"};

    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());//计算和校验文件
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream bos = new BufferedOutputStream(zos);

        zos.setComment("A test of java Zipping");
        //No没有corresponding 对应的getComment(), though（但是）
        for(String file : files){
            System.out.print("writing file " + file);
            BufferedReader in = new BufferedReader(new FileReader(file));
            zos.putNextEntry(new ZipEntry(file));//dont know this
            int c;
            while((c = in.read()) != -1){
                bos.write(c);
            }
            in.close();
            bos.flush();
        }
        bos.close();
        //Checksum valid only after the file has been closed!
        System.out.println("Checksum: " + csum.getChecksum().getValue());
        //Now extract the files:
        System.out.println("Reading file");



    }
}
