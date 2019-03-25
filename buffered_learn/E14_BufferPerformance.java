package file_class.buffered_learn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class E14_BufferPerformance {
    static String file = "E14_BufferPerformance.out";

    public static List<String> read() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "./src/file_class/buffered_learn/E14_BufferPerformance.java"));
        String s;
        List<String> list = new ArrayList<>();
        while((s = bufferedReader.readLine()) != null){
            list.add(s);
        }
        bufferedReader.close();
        return list;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = read();
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 0;
        long t1 = System.nanoTime();
        for(String s : list){
            printWriter.write(lineCount + ":" + s);
        }
        long t2 = System.nanoTime();
        System.out.println("buffered use time :" + (t2 - t1) + "millis");
        printWriter.close();
        PrintWriter printWriter1 = new PrintWriter(new FileWriter(file));
        int linecount2 = 0;
        long t3 = System.nanoTime();
        for(String s : list){
            printWriter1.write(linecount2 + ":" + s);
        }
        long t4 = System.nanoTime();
        System.out.println("no Buffered use time :" + (t4 - t3) + "millis");
        printWriter1.close();

    }

}
