package file_class.file_load2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory {
    public static File[] local(File dir, String regex){
        File[] files = dir.listFiles((File file,String name) ->{
            //System.out.println(name + "----" + file.getName() + "===" + new File(name).getName());
            return new File(name).getName().matches(regex);
        });
        return files;
    }

    public static File[] local(String dir, String regex){
        File[] files = new File(dir).listFiles((File file,String name) ->{
            //System.out.println(name + "----" + file.getName() + "===" + new File(name).getName());
            return new File(name).getName().matches(regex);
        });
        return files;
    }
    //内部类
    public static class TreeInfo implements Iterable<File>{
        List<File> dirs = new ArrayList<>(16);
        List<File> files = new ArrayList<>(16);

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo t){
            dirs.addAll(t.dirs);
            files.addAll(t.files);
        }
        @Override
        public String toString(){
            return PPrint.pformat(dirs) + "----\n" + PPrint.pformat(files);
        }
    }
    //recurse 递归 recurse 递归 recurse 递归
    public static TreeInfo recurseDirs(File startFile, String regex){

        TreeInfo t = new TreeInfo();
        for(File file : startFile.listFiles()){
            if(startFile.isDirectory()){
                t.dirs.add(file);
                t.addAll(recurseDirs(file,regex));
            }else{
                if (file.getName().matches(regex)) {
                    //System.out.println(item + "  is file");
                    t.files.add(file);
                }
            }
        }
        return t;
    }

    public static TreeInfo walk(File start, String regex){
        return recurseDirs(start, regex);
    }
    public static TreeInfo walk(File start){
        return recurseDirs(start, ".*");
    }



    public static void main(String[] args) throws IOException {
//        File[] files = Directory.local(new File("./src/file_class"),".*[.]java");
//        for(File file : files){
//            System.out.println(file.getCanonicalPath());
//        }
        TreeInfo treeInfo = new TreeInfo();
        Iterator i = treeInfo.iterator();
        i.hasNext();
        i.next();

    }
}
