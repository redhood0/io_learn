package file_class.nio;

import java.nio.ByteBuffer;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        //Allocation automatically zeroes the ByteBUffer:
        int i = 0;
//        while(bb.hasRemaining())
//        System.out.println(bb.get());
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                System.out.print("nonezero");
            }
        }
        System.out.println("i= " + i);
        System.out.println(bb);//仅仅用来展示rewind的作用
        bb.rewind();
        System.out.println(bb);//仅仅用来展示rewind的作用
        //Store and read a short
        bb.asShortBuffer().put((short) 471142);
        System.out.println("(short)471142---" + (short) 471142);
        System.out.println("bb.getShort()--" + bb.getShort());
        bb.rewind();
        //Store and read a int
        bb.asIntBuffer().put(99471142);
        System.out.println("bb.getInt()--" + bb.getInt());
        bb.rewind();
        //Store and read a int
        bb.asLongBuffer().put(99471142);
        System.out.println("bb.getLong--" + bb.getLong());
        bb.rewind();
        //store and read a float
        bb.asFloatBuffer().put(99471142);
        System.out.println("bb.getFloat--" + bb.getFloat());
        bb.rewind();
        //store and read a double
        bb.asDoubleBuffer().put(99471142);
        System.out.println("bb.getFloat--" + bb.getDouble());
        bb.rewind();
    }
}
