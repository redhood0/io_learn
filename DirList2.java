package file_class;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
    public static FilenameFilter filter(final String regex){
        return  new FilenameFilter() {
            private Pattern p = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return p.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File path = new File("./out/production/io_system/file_class/");
        String[] list;
        list = path.list(filter(".*[.]class"));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }
    }
}
