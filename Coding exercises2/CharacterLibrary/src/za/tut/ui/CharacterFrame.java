
package za.tut.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.SoftBevelBorder;
import za.ac.ui.FrameClass;

public class CharacterFrame extends JFrame {
    //panels
    private JPanel headingPnl;
    private JPanel messagePnl;
    private JPanel headingAndMessageCombined;
    private JPanel bytePnl;
    private JPanel punctPnl;
    private JPanel byteAndPunctCombined;
    private JPanel btnsPnl;
    private JPanel mainPnl;
    
    //labels
    private JLabel headingLbl;
    private JLabel messageLbl;
    private JLabel byteLbl;
    private JLabel punctLbl;
    
    //textArea
    private JTextArea messageTA;
    private JTextArea punctTA;
    
    //textField
    private JTextField byteTF;
    
    //buttons
    private JButton calcB;
    private JButton clearB;
    private JButton exitB;
    
    public CharacterFrame(){
        setTitle("Characters");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400,500);
        
        //creating panels
        headingPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        messagePnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        headingAndMessageCombined=new JPanel(new BorderLayout());
        byteAndPunctCombined=new JPanel(new BorderLayout());
        bytePnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        punctPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnsPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        mainPnl=new JPanel(new BorderLayout());
        
        //creating labels
        headingLbl=new JLabel("Counting Characters");
        headingLbl.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        headingLbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD +Font.ITALIC,10));
        headingLbl.setForeground(Color.red);
        
        messageLbl=new JLabel("Message:  ");
        byteLbl=new JLabel("Bytes in the message:  ");
        punctLbl=new JLabel("Number of punctuation marks including spaces:  ");
  
        //textAreas
        messageTA=new JTextArea(10,20);
        messageTA.setFocusable(true);
        punctTA=new JTextArea(10,20);
        punctTA.setEditable(false);
        
        //tf
        byteTF=new JTextField(10);
        byteTF.setEditable(false);
        
        //buttons
        calcB=new JButton("Calculate");
        calcB.addActionListener(new CalcB());
        clearB=new JButton("Clear");
        clearB.addActionListener(new ClearB());
        exitB=new JButton("Exit");
        exitB.addActionListener(new ExitB());
        
        //addingComponents
        headingPnl.add(headingLbl);
        
        messagePnl.add(messageLbl);
        messagePnl.add(messageTA);
        
        headingAndMessageCombined.add(headingPnl, BorderLayout.NORTH);
        headingAndMessageCombined.add(messagePnl, BorderLayout.CENTER);
        
        bytePnl.add(byteLbl);
        bytePnl.add(byteTF);
        
        punctPnl.add(punctLbl);
        punctPnl.add(punctTA);
        
        byteAndPunctCombined.add(bytePnl, BorderLayout.NORTH);
        byteAndPunctCombined.add(punctPnl, BorderLayout.CENTER);
        
        btnsPnl.add(calcB);
        btnsPnl.add(clearB);
        btnsPnl.add(exitB);
        
        mainPnl.add(headingAndMessageCombined, BorderLayout.NORTH);
        mainPnl.add(byteAndPunctCombined, BorderLayout.CENTER);
        mainPnl.add(btnsPnl, BorderLayout.SOUTH);
        
        add(mainPnl);
        
        
        setVisible(true);
        
        
    }
    private class CalcB implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String message, bts, punctMarks;
            FrameClass frame;
            JFileChooser fc;
            BufferedWriter bw;
            int val;
            File file;
            
            
            message= messageTA.getText();
            bts=byteTF.getText();
            punctMarks=punctTA.getText();
            byte[] bytes=message.getBytes();
            
            int lengthInBytes=bytes.length;
            byteTF.setText(String.valueOf(lengthInBytes));
            
            String[] words= message.split(" ");
            int countWords=words.length;
            
            
            int commaCount=0;
            int spaceCount=0;
            
            for(char c :message.toCharArray()){
                
                if(c == ','){
                    commaCount++;
                    
                }
                else if(Character.isWhitespace(c));{
                spaceCount++;
                
            }
                punctTA.setText("Words: "+String.valueOf(countWords)+"\n Commas: "+String.valueOf(commaCount+"\n Spaces: "+String.valueOf(spaceCount)));
            }
            frame=new FrameClass(message,bts,punctMarks); 
            
            fc= new JFileChooser();
            val=fc.showSaveDialog(CharacterFrame.this);
            if(val== JFileChooser.APPROVE_OPTION){
                try{
                    file=fc.getSelectedFile();
                    
                    //open streams
                    bw=new BufferedWriter(new FileWriter(file,true));
                    
                    //write
                    bw.write(frame.toString());
                    bw.newLine();
                    bw.close();
                    JOptionPane.showMessageDialog(CharacterFrame.this, "Successful");
                    
                } catch (IOException ex) {
                    Logger.getLogger(CharacterFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(CharacterFrame.this, "Unsuccessful"+ val);
                
            }
            }
                
        }
        
        
        
    
   private class ClearB implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String data, record="";
            JFileChooser fc;
            File file;
            int val;
            BufferedReader br;
            
            
            messageTA.setText("");
            byteTF.setText("");
            punctTA.setText("");
        
        fc=new JFileChooser();
        val=fc.showOpenDialog(CharacterFrame.this);
        
        if(val== JFileChooser.APPROVE_OPTION){
            try{
                file=fc.getSelectedFile();
                
                br=new BufferedReader(new FileReader(file));
                
                while((data=br.readLine()) != null){
                    record=record+data+"\n";
                    
                }
                br.close();
                punctTA.setText(record);
            }   catch (FileNotFoundException ex) {
                    Logger.getLogger(CharacterFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CharacterFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }
   } 
   private class ExitB implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
       
   }
    
}
