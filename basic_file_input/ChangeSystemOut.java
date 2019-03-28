package file_class.basic_file_input;

import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("hellow ,world");
    }
}
