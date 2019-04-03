package file_class.lockfile;

import file_class.util_textfile.TextFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws Exception {
//        FileOutputStream fos = new FileOutputStream("file.txt");
//        FileChannel fc = fos.getChannel();
        FileInputStream fis = new FileInputStream("file.txt");
        FileChannel fc1 = fis.getChannel();
        FileLock fileLock = fc1.tryLock(0,20,true);
        if(fileLock != null){
            System.out.println("lock file!");
            TimeUnit.SECONDS.sleep(1);
            fileLock.release();
            System.out.println("release lock");
        }
        fc1.close();
    }
}
