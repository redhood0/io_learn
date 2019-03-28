package file_class.file_load2;

import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

public class GetAbsoluteFile {

    public static void main(String[] args) throws IOException {
        File f1 = new File("testAbsoluteFile.txt");
        System.out.println("f1:" + f1);
        System.out.println("f1.getPath------:" + f1.getPath());
        System.out.println("f1.getAbsolutePath:---" + f1.getAbsolutePath());
        System.out.println("f1.getAbsoluteFile:---" + f1.getAbsoluteFile());
        System.out.println("f1.getCanonicalFile:---" + f1.getCanonicalFile());
        int i = 0;
        double d = 0.0;
        long l = 1;
        System.out.println(d + l);
        //----------------------
        System.out.println(2 * (5 / 2 + 5 / 2));//12题第一问。
        //-----------------------
        char a = 'a';
        System.out.println(++a);//14题
        System.out.println((int)++a);//14题

    }

    public void ranges(){

    }

}
