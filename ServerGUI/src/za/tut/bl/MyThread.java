
package za.tut.bl;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class MyThread extends Thread {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public MyThread(Socket socket) throws IOException {
        this.socket = socket;
        out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        start();
    }
    
    @Override
    public void run(){
      String data;
      AccountManager ac ;
      AccManager a;
      Account acc ;
      String outcome="";
      Double balance;
      
        try {
            data=in.readLine();
            a=new AccManager();
            ac=new AccountManager();
            while(!data.equalsIgnoreCase("Stop")){
                String[] token=data.split("#");
                String option=token[0];
                Integer accNo=Integer.parseInt(token[1]);
                balance=Double.parseDouble(token[2]);
                acc=new Account(accNo,balance);
                if(option.equalsIgnoreCase("FILE")){
                    File file;
                    JFileChooser fc;
                    int val;
                    BufferedWriter bw;
                    
                    fc=new JFileChooser();
                    val=fc.showSaveDialog(null);
                    
                    if(val==JFileChooser.APPROVE_OPTION){
                        file=fc.getSelectedFile();
                        bw=new BufferedWriter(new FileWriter(file,true));
                        
                        bw.write(accNo);
                        
                        bw.newLine();
                        
                        bw.write(String.valueOf(balance));
                    }
                }
                
                else{
                    if(option.equalsIgnoreCase("deposit")){
                        acc=new Account(accNo, balance);
                        outcome=ac.deposit(acc);
                    }else if(option.equalsIgnoreCase("withdraw")){
                        acc=new Account(accNo,balance);
                        outcome=ac.withdraw(acc);
                    }else if(option.equalsIgnoreCase("getBalance")){
                        acc=new Account(accNo,balance);
                        outcome=ac.getBalance(acc);
                    } 
                   
                    a.add(acc);
                    a.update(acc);
                }
                 data=in.readLine();
                    out.println(outcome);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
