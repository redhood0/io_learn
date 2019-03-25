package file_class.store_and_recover;

import java.io.*;

public class StroingAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
        out.writeDouble(3.1415925);
        out.writeUTF("That was pi!中文");
        out.writeDouble(1.21212);
        out.writeUTF("square root of 2");
        out.writeChar('a');
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readChar());
    }
}
