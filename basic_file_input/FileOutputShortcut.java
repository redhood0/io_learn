package file_class.basic_file_input;

import file_class.buffered_learn.BufferedInputFile;

import java.io.*;

public class FileOutputShortcut {
    static String file = "BasicFileOutput2.out";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(BufferedInputFile.read(
                "./src/file_class/basic_file_input/FileOutputShortcut.java")));

        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(
                new FileInputStream("./src/file_class/basic_file_input/FileOutputShortcut.java")));

        PrintWriter printWriter = new PrintWriter(file);
        int lineCount = 0;
        String s;
        while((s = bufferedReader2.readLine()) != null){
            printWriter.println(lineCount++ + ":" + s);
        }
        printWriter.flush();
        printWriter.close();
        System.out.println(BufferedInputFile.read(file));

    }

}
