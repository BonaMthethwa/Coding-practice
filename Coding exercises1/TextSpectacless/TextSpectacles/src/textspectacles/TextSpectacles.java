
package textspectacles;

import java.util.Map;
import javax.swing.JOptionPane;
import manage.ManageTextSpectacles;
import tut.ac.za.message.Message;

public class TextSpectacles {

    public static void main(String[] args) {
       String MessageText="Foward, Love, programming unconditionally. Programming is love life";//Declare an initialize String
       Message message=new Message(MessageText);// Instantiate message object
       ManageTextSpectacles manage=new ManageTextSpectacles();// Instantiate manage object
       String occuranceConcate="";//Declare an initialize occurance String
       //Compound assignment for Map
       Map<String,Integer> ocuurMap=manage.occurence(message.getMessage());
        for (Map.Entry<String, Integer> entry : ocuurMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            occuranceConcate+="• "+key+" = "+value+"\n";
        }
        //Display
        JOptionPane.showMessageDialog(null, "• Length of the message in terms of bytes: "+manage.lengthMessage(message.getMessage())+"\n" +
                                            "• The number of white spaces: "+manage.numberOfWhite(message.getMessage())+"\n" +
                                            "• The number of commas: "+manage.numberOfCommas(message.getMessage())+"\n" +
                                            "• The number of fullstops: "+manage.numberOfFullStops(message.getMessage())+"\n" +
                                            "• The number of words: "+manage.numberOfWord(message.getMessage())+"\n\n\n"+
                                            "• The number of times each word occurs in the message.\n"+ occuranceConcate);
    }
    
}
