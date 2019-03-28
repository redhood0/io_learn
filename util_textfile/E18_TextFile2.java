package file_class.util_textfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class E18_TextFile2 extends ArrayList<String> {
    // Read a file as a single string:
    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File(fileName).getAbsoluteFile()));
        try {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s);
            }
        } finally {
            bufferedReader.close();
        }
        return sb.toString();
    }

    //Write a file as a single string
    public static void write(String fileName, String txt) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File(fileName).getAbsoluteFile());
        try {
            printWriter.write(txt);
        } finally {
            printWriter.close();
        }
    }

    //Read a file ,split by any regular expression
    public E18_TextFile2(String fileName, String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0) == ""){
            remove(0);
        }
    }
    public E18_TextFile2(String fileName) throws IOException {
        this(fileName,"\n");
    }
    public void write(String fileName) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File(fileName).getAbsoluteFile());
        try {
            for (String s : this) {
                printWriter.println(s);
            }
        }finally {
            printWriter.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String file = E18_TextFile2.read("./src/file_class/util_textfile/E18_TextFile2.java");
        E18_TextFile2.write("test.txt",file);
        E18_TextFile2 textFile2 = new E18_TextFile2("test.txt");
        textFile2.write("text2.txt");
        TreeSet<String> treeSet = new TreeSet<>(new E18_TextFile2("text2.txt","\\W+"));
        System.out.println(treeSet.headSet("a"));
    }



}
