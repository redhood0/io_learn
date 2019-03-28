package file_class.process_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while((s = results.readLine()) != null){
                System.out.println(s);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while((s = errors.readLine()) != null){
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            //Compensate for windos 2000,which throws an exception for the default command line
            if(!command.startsWith("CMD /C")){
                command("CMD /C" + command);
            }else {
                throw new RuntimeException(e);
            }
            if(err){
                throw new RuntimeException("ERROes executing" + command);
            }
        }
    }

    public static void main(String[] args) {
        OSExecute.command("cd ");
       // OSExecute.command("javap javawork/io_system/src/file_class/process_control/OSExecute");
    }
}
