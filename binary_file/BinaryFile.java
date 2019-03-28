package file_class.binary_file;

import java.io.*;

public class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
        try{
            byte[] data = new byte[bf.available()];
            System.out.println("bf.available()----" + bf.available());
            System.out.println("bFile.length()----" + bFile.length());
            bf.read(data);
            return data;
        }finally {
            bf.close();
        }
    }
    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
}
