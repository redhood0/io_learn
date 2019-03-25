package file_class.basic_file_input;

import file_class.buffered_learn.BufferedInputFile;

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(
                BufferedInputFile.read("./src/file_class/basic_file_input/BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 0;
        String s;
        while((s = bufferedReader.readLine()) != null){
            out.println(lineCount++ + ":" + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }

}
