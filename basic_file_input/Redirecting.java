package file_class.basic_file_input;

import file_class.buffered_learn.BufferedInputFile;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("test2.txt"));
        PrintStream out = new PrintStream(new FileOutputStream("test2.out", true));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println("sASAsaSAs");
            System.out.println(s);
            System.out.println("111111");
            System.err.println("error:xxxxxx");
        }
        out.close();
//        FileWriter fileWriter = new FileWriter("test2.out",true);
//        fileWriter.write("-----end------");
//        fileWriter.close();
        PrintStream out2 = new PrintStream(new FileOutputStream("test2.out", true));
        System.setOut(out2);
        System.out.println("-------------------------------------------end----------------------------------------------------------------");
        out2.close();
        System.setOut(console);
        System.out.println("sASAsaSAs");

    }
}
