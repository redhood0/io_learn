package file_class;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {
    public static void main(String[] args) {
        File path = new File("./out/production/io_system/file_class/");
        String[] list;
        list = path.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return false;
            }
        });

        list = path.list((File dir, String name) -> {
            Pattern pattern = Pattern.compile(".*[.]class");
            return pattern.matcher(name).matches();});
        Arrays.sort(list);
        for(String filename : list){
            File file = new File("./out/production/io_system/file_class/",filename);
            System.out.println(filename + " size:" + file.length() + " byte");
        }
    }

}
