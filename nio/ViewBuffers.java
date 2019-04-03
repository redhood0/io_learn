package file_class.nio;

import java.nio.*;

/**
 * 视图缓冲器
 */
public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        //System.out.println(bb);
        bb.rewind();//why rewind here
        //System.out.println(bb);
        System.out.print("Byte Buffer :");
        while(bb.hasRemaining()){
            System.out.print(bb.position() + " -> " + bb.get() + ", ");
        }
        System.out.println();

        CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
        System.out.print("[CharBuffer]--"+cb.position()+ "-" + cb.limit() + " :");
        while(cb.hasRemaining()){
            System.out.print(cb.position() + " -> " + cb.get() + ", ");
        }
        System.out.println();

        FloatBuffer fb = ((ByteBuffer) bb.rewind()).asFloatBuffer();
        System.out.print("[FloatBuffer]: ");
        while(fb.hasRemaining()){
            System.out.print(fb.position() + " -> " + fb.get() + ", ");
        }
        System.out.println();

        //int is 4 times byte
        IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
        System.out.print("[IntBuffer] :");
        while(ib.hasRemaining()){
            System.out.print(ib.position() + " -> " + ib.get() + ", ");
        }
        System.out.println();

        //long is 8 times byte
        LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
        System.out.print("[LongBuffer]: ");
        while(lb.hasRemaining()){
            System.out.print(lb.position() + " -> " + lb.get() + ", ");
        }
        System.out.println();

        //short is 2 times byte
        ShortBuffer sb = ((ByteBuffer) bb.rewind()).asShortBuffer();
        System.out.print("[ShortBuffer]: ");
        while(sb.hasRemaining()){
            System.out.print(sb.position() + " -> " + sb.get() + ", ");
        }
        System.out.println();

        //double is 8 timesbuffer
        DoubleBuffer db = ((ByteBuffer) bb.rewind()).asDoubleBuffer();
        System.out.print("[DoubleBuffer]: ");
        while(db.hasRemaining()){
            System.out.print(db.position() + " -> " + db.get() + ", ");
        }
        System.out.println();






    }
}
