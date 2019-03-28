package file_class.util_textfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    //read a file as a single string
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));//TODO：dont understand
            String s;
            try {
                while ((s = bf.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                bf.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    //write a single file in one method call
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());//TODO:
            try {
                out.write(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //constructer
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void writer(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile()); //TODO:why use getAbsoluteFile
            try {
                for (String item : this) {
                    out.write(item);
                    out.write("\n");
                  //  out.println(item); same as pre
                }
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //simple test:
    public static void main(String[] args) {
        String file = read("./src/file_class/util_textfile/TextFile.java");
        write("file_test.txt",file);
        TextFile textFile = new TextFile("./src/file_class/util_textfile/TextFile.java");
        textFile.writer("test2.txt");
        //Break into unique sorted list of word:
        TreeSet<String> words = new TreeSet<String>(new TextFile("test2.txt","\\W+"));
        System.out.println(words);
        System.out.println(words.size());
        System.out.println(words.headSet("b"));//取比参数小的集合
        System.out.println(words.size());
    }


}
