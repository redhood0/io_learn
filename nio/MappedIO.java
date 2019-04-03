package file_class.nio;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedIO {
    private static int numOfInts = 4000;
    private static int numOFUnbuffInts = 2000000;

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runRunTest() throws IOException {
            System.out.print(name + ": ");
            long start = System.nanoTime();
            test();
            double duration = System.nanoTime() - start;
            System.out.format("%.2f", duration / 1.0e9);
            System.out.print("---" + duration + "\n");

        }

        protected abstract void test() throws IOException;
    }

    private static Tester[] tests = {
//            new Tester("Stream Write") {
//                @Override
//                protected void test() throws IOException {
//                    DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("temp.tmp")));
//                    for (int i = 0; i < numOfInts; i++) {
//                        dos.writeInt(i);
//                    }
//                    dos.close();
//                }
//            },
            new Tester("Mapped Write") {
                @Override
                protected void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, fc.size(), fc.size()+40001).asIntBuffer();
                    for (int i = 0; i < numOfInts; i++) {
                        ib.put(i*i);
                    }
                    fc.close();
                }
            },
//            new Tester("Stream Read") {
//                @Override
//                protected void test() throws IOException {
//                    DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("temp.tmp")));
//                    for (int i = 0; i < numOfInts; i++) {
//                        dis.readInt();
//                    }
//                    dis.close();
//                }
//            },
//            new Tester("Mapper Read") {
//                @Override
//                protected void test() throws IOException {
//                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
//                    MappedByteBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size());
//                    for (int i = 0; i < numOfInts; i++) {
//                        ib.get();
//                    }
//                    fc.close();
//                }
//            },
            new Tester("Stream Read and Write") {
                @Override
                protected void test() throws IOException {
//                    DataInputStream dts = new DataInputStream(new FileInputStream("temp.tmp"));
//                    DataOutputStream dto = new DataOutputStream(new FileOutputStream("temp.tmp",true));
//                    for(int i = 0; i < numOFUnbuffInts; i++){
//                        dto.writeInt(dts.readInt());
//                    }
//                    dts.close();
//                    dto.close();
//
//                    RandomAccessFile raf = new RandomAccessFile("temp.tmp", "rw");
//                    raf.writeInt(1);
//                    System.out.println("raf.length()--" + raf.length());
//                    for (int i = 0; i < numOFUnbuffInts; i++) {
//                        raf.seek(raf.length() - 4);
//                       // System.out.println("raf.length() - 4 " + (raf.length() - 4));
//                        raf.writeInt(raf.readInt());
//                    }
//                    raf.close();
                }
            },
//            new Tester("Mapper Read and Write") {
//                @Override
//                protected void test() throws IOException {
//
//                    FileChannel fc = new RandomAccessFile("temp.tmp","rw").getChannel();
//                    System.out.println("temp.tmp.size" + fc.size());
//                    CharBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE,0,fc.size()).asCharBuffer();
//                    for(int i = 0; i < fc.size()/4; i++){
//                        char a = ib.get();
//                        ib.put('a');
//                        System.out.println(i);
//                    }
//                    fc.close();
//                }
//            }

    };

    public static void main(String[] args) throws IOException {
        for(Tester tester : tests){
            tester.runRunTest();
        }

    }


}
