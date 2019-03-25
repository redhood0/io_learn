package file_class.buffered_learn;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class IO_exe7 {
    public static List<String> ReadFileToList(String fileName, List<String> list) throws IOException {
        //解决中文txt乱码问题
        //BufferedReader bufferedReader = new BufferedReader(new FileReader(new FileInputStream(fileName),"UTF-8"));

        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));

        String s;
        while((s = bufferedReader2.readLine()) != null){

            list.add(s);
        }
        bufferedReader2.close();
        return list;
    }

    /**
     * list倒序遍历，使用listIterator的previous方法
     * @param list
     */
    public static void reverseList(List<String> list){
        list.iterator();
        ListIterator<String> listIterator = list.listIterator(list.size());
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous().toLowerCase());
        }
    }

    public static void main(String[] args) throws IOException {
        reverseList(ReadFileToList("C:\\Users\\redhood\\shortcut\\player\\myass.txt",new LinkedList<String>()));

    }


}
