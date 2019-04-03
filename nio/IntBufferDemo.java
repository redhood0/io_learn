package file_class.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        //Store an array of int:
        ib.put(new int[]{ 11, 42, 47, 31, 142, 811, 1016});
        //Absolute location read and write
        System.out.println("ib.get(3)----" + ib.get(3));
        ib.put(3,1811);
        ib.put(4,1823);
        //Setting a new  limit before rewinding the buffer
        System.out.println(ib);
        ib.flip();
        System.out.println(ib);
        while (ib.hasRemaining()){
            int i = ib.get();
            System.out.print(i + ", ");
        }
    }
}
