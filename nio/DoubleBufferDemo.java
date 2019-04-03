package file_class.nio;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class DoubleBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        db.put(new double[]{0,0,0,0,0,0,0,1});
        System.out.println("db.get(3)----" + db.get(3));
        db.put(3,1811);
        db.put(4,1823);
        //db.rewind();
        db.flip();
        while(db.hasRemaining()){
            System.out.print(db.position() + " -> " + db.get() + ", ");
        }
    }
}
