package file_class.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {
    //symmetric对称，匀称  scramble 编码 unscramble 译码
    private static void symmetricScramble(CharBuffer buffer){
        while(buffer.hasRemaining()){
            buffer.mark();//what is mark?
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();//mark use here (positin = mark)

            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {

        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());

    }
}
