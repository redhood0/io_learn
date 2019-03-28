package file_class.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void copyFile(String File1,String File2) throws IOException {
        FileChannel in = new FileInputStream(File1).getChannel(),
                out = new FileOutputStream(File2).getChannel();
        in.transferTo(0,in.size(),out);
        //or :
        //out.transferFrom( in,0,in.size);
    }

    public static void main(String[] args) throws IOException {
        copyFile("text2.txt","text5.txt");
    }

}
