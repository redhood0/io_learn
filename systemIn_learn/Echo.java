package file_class.systemIn_learn;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//echo 回声，反射
public class Echo {
    public static void main(String[] args) throws IOException {
        //system.in 标准输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while((s = br.readLine()) != null && s.length() != 0){
            System.out.println(s.toUpperCase());
        }
    }
}
