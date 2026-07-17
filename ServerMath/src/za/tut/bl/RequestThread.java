
package za.tut.bl;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public RequestThread(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    }
    
    @Override
    public void run(){
    String data, outcome = null;
    char op;
    int num1, num2;
    
    try{
    System.out.println("Servicing request from IP address "+ socket+"\n");
    
    while(true){
            //get data
            data=in.readLine();
            
            if(!data.equalsIgnoreCase("STOP")){
                System.out.println("Receiced data from client: "+data);
                String[] tokens=data.split("#");
                
                num1=Integer.parseInt(tokens[0]);
                num2=Integer.parseInt(tokens[1]);
                op=tokens[2].charAt(0);
                
                //process data
                if(op=='+'){
                    outcome=Integer.toString(num1+num2);
                }else if(op=='-'){
                    outcome=Integer.toString(num1-num2);
                }else if(op=='*'){
                    outcome=Integer.toString(num1*num2);
                }else
                   break;
                data=in.readLine();
               
            }
             System.out.println("Sending response to client :"+outcome);
                out.println(outcome);
        }
    
    } catch (IOException ex) {
           ex.printStackTrace();
    }finally{
        try {
            System.out.println("Now Closing... ");
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    }
    
}
