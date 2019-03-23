package file_class.buffered_learn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    //Throw exceptions to console
    //测试中文是否乱码
    public static String read(String filenam) throws IOException {
        //reading iput by line
        BufferedReader in = new BufferedReader(new FileReader(filenam));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine()) != null){
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("./src/file_class/buffered_learn/BufferedInputFile.java"));
    }
}
