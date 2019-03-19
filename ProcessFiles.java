package file_class;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {
    //Strategy 战略，策略
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;//后缀的意思

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            strategy.process(file.getCanonicalFile());//canonical form规范形式---绝对路径
        }
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for(String arg : args){
                    File filearg = new File(arg);
                    if(filearg.isDirectory()){
                        processDirectoryTree(filearg);
                    }else{
                        //Allow user to leave off extension
                        if(!arg.endsWith("."+ext)){
                            arg += "." + ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(file -> System.out.println(file),"java").start(args);

//        try {
//            System.out.println("-----默认相对路径：取得路径不同------");
//            File file1 = new File("..\\src\\test1.txt");
//            System.out.println(file1.getPath());
//            System.out.println(file1.getAbsolutePath());
//            System.out.println(file1.getCanonicalPath());
//            System.out.println("-----默认相对路径：取得路径不同------");
//            File file = new File(".\\test1.txt");
//            System.out.println(file.getPath());
//            System.out.println(file.getAbsolutePath());
//            System.out.println(file.getCanonicalPath());
//
//            System.out.println("-----默认绝对路径:取得路径相同------");
//            File file2 = new File("D:\\workspace\\test\\test1.txt");
//            System.out.println(file2.getPath());
//            System.out.println(file2.getAbsolutePath());
//            System.out.println(file2.getCanonicalPath());
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}
