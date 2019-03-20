package file_class.file_load2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CyclicBarrier;

public class Jiaowu implements Runnable{
    private static int count = 0;
    private final int id = count++;
    private static CyclicBarrier barrier = new CyclicBarrier(10000);


    @Override
    public void run() {
        System.out.println("id--" + id);
        HttpURLConnection conn = null;
        try {
            barrier.await();
            URL realUrl = new URL("http://jwxx.niit.edu.cn/");
            conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setUseCaches(false);
            conn.setReadTimeout(8000);
            conn.setConnectTimeout(8000);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0");
            int code = conn.getResponseCode();
            if (code == 200) {
                System.out.println(11);
                InputStream is = conn.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = in.readLine()) != null){
                    buffer.append(line + "\n");
                }
                String result = buffer.toString();
                System.out.println(result);

                //subscriber是观察者，在本代码中可以理解成发送数据给activity
                // subscriber.onNext(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            //subscriber.onError(e);
        }
    }
}
