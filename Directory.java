package file_class;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class Directory {
    public static File[] local(File dir,final String regex){
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //don't know matcher(new File(name).getName)
                return Pattern.compile(regex).matcher(new File(name).getName()).matches();
            }
        });
        return files;
    }
    //overload
    public static File[] local(String path,final String regex){
        return local(new File(path),regex);
    }
    // A
}
