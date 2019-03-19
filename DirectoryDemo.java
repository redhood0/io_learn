package file_class;

import java.io.File;

public class DirectoryDemo {
    public static void main(String[] args) {
        //All directories:
       PPrint.pprint(Directory.walk(".").dirs);
       //All files begining with 'T'
        PPrint.pprint(Directory.walk(".","T.*").files);
        for(File file : Directory.walk(".","T.*\\.java")){
            System.out.println(file);
        }
        System.out.println("-----------------------------------------------");
        //class files contatining "S" or "s";
        for(File file : Directory.walk(".",".*[sS].*\\.class")){
            System.out.println(file);
        }
    }
}
