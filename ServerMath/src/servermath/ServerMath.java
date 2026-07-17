
package servermath;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.tut.bl.RequestThread;

public class ServerMath {

    
    public static void main(String[] args) {
        ServerSocket s=null;
        Socket socket=null;
        
        try {
            s=new ServerSocket(9191);
            System.out.println("Server started..."+ s);
            
            while(true){
                socket=s.accept();
                System.out.println("Communication established.."+socket);
                new RequestThread(socket);
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
    }
    
}
