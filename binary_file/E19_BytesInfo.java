package file_class.binary_file;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class E19_BytesInfo {
    public static void main(String[] args) throws IOException {
        Map<Byte,Integer> binarysStat = new HashMap<>();
        for(Byte b : BinaryFile.read("./src/file_class/buffered_learn/E14_BufferPerformance.java")){
            Integer count = binarysStat.get(b);
            binarysStat.put(b , count == null ? 1 : count++);
        }
        List<Byte> keys = new ArrayList<>(binarysStat.keySet());
        for(Byte key : keys){
            System.out.println(key + "----" + binarysStat.get(key));
        }
        System.out.println(((byte)202 & 0x0f));
        System.out.println(Integer.toHexString('a'));
        System.out.println();

        String hexString = "CAFEBABE";
        char c = 'C';
        char a = 'A';
        byte c1 = (byte) ((byte) ((byte)c << 4) | (byte)a);
        System.out.println(c1);
        System.in.read();

       /* 0000     0000     255
        1100(15) 1010(15) 202
         12      10
         0123456789abcdedf
         c        a
         */


    }
}
