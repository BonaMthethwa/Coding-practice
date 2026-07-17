
package servergui;
import java.net.*;
import java.io.*;
import za.tut.bl.MyThread;

public class ServerGUI {

    
    public static void main(String[] args) throws IOException {
        ServerSocket s=null;
        Socket socket=null;
        
        s=new ServerSocket(8080);
        
        while(true){
            socket=s.accept();
            new MyThread(socket);
        }
    }
    
}
