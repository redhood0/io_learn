package file_class;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class Directory {
    public static File[] local(File dir, final String regex) {
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
    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    // A two-tuple for returing a pair of objects;
    public static class TreeInfo implements Iterable<File> {


        public List<File> files = new ArrayList<>(10);
        public List<File> dirs = new ArrayList<>(10);

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs:" + PPrint.pformat(dirs) +
                    "\n\nfiles:" + PPrint.pformat(files);
        }
    }

    //recurse递归---recurse--recurse--recurse
    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        if (startDir.listFiles().length == 0) {

        }
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                //System.out.println(item + "  is directory");
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    //System.out.println(item + "  is file");
                    result.files.add(item);
                }
            }
        }
        return result;
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    public static void main(String[] args) {
        TreeInfo s = walk("./src/test_package");
        System.out.println(s);
    }

}
