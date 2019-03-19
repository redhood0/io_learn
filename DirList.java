package file_class;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File("./src/file_class/");
        String[] list;
        list = path.list(new DirFilter("\\w*.java"));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);//区分大小写？？？
        for(String dirItem : list){
            System.out.println(dirItem);
        }
    }
}

class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name){
        return pattern.matcher(name).matches();
    }
}

