package file_class.lockfile;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;


public class LockingMappedFile {
    static final int LENGTH =20;
    static FileChannel fc;

    public static void main(String[] args) throws IOException {
        fc = new RandomAccessFile("test.dat", "rw").getChannel();
        MappedByteBuffer mbf = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            mbf.put((byte) 'x');
        }

        new LockAndModify(mbf, 0, LENGTH / 3);
        new LockAndModify(mbf, LENGTH / 2, LENGTH / 2 + LENGTH / 4);

    }

    private static class LockAndModify extends Thread {
        private ByteBuffer bb;
        private int start, end;

        public LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            bb = mbb.slice();//slice切片
            start();
        }

        @Override
        public void run() {
            //Exclusive互斥 lock锁 with no overlap重叠
            try {
                FileLock fl = fc.lock(start, end, false);
                System.out.println("locked:" + start + " to " + end);
                while (bb.position() < bb.limit() - 1) {
                    bb.put((byte) 'c');
                }
                fl.release();
                System.out.println("release: " + start + " to " + end);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
