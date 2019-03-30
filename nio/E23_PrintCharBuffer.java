package file_class.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.BitSet;

public class E23_PrintCharBuffer {
    static BitSet isPrintable = new BitSet(127);
    static String encodind = "UTF-8";
    static{
        for(int i = 32; i <= 127; i++){
            isPrintable.set(i);
            System.out.println((char)i);
        }
    }
    public static void setPrintableLimit(CharBuffer cb){
        cb.rewind();
        while(isPrintable.get(cb.get())){
        }
        cb.limit(cb.position() - 1);
        cb.rewind();
    }

    public static void main(String[] args) {
        System.out.println("(char) 0x01-----" + (char) 0x01);
        System.out.println("Default Encoding is :" + encodind);
        CharBuffer buffer = ByteBuffer.allocate(16).asCharBuffer();
        buffer.put("ABCD中" + (char) 0x01 + "FG");
        buffer.rewind();
        System.out.println(buffer);
        setPrintableLimit(buffer);
        System.out.println(buffer); // Print printable

    }


}
