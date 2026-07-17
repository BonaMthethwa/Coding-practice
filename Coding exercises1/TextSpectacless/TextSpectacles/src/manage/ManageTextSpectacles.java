package manage;

import java.util.HashMap;
import java.util.Map;
import tut.zc.Interface.TextSpectaclesInterface;

public class ManageTextSpectacles implements TextSpectaclesInterface {

    @Override
    public byte lengthMessage(Object message) {
        String mess = (String) message;
        return (byte) mess.length();
    }

    @Override
    public int numberOfWhite(Object message) {
        String mess = (String) message;
        int numWhite = 0;
        for (int i = 0; i < mess.length(); i++) {
            if (Character.isWhitespace(mess.charAt(i))) {
                numWhite++;
            }
        }
        return numWhite;
    }

    @Override
    public int numberOfCommas(Object message) {
        String mess = (String) message;
        int numbCommas = 0;
        for (int i = 0; i < mess.length(); i++) {
            if (mess.charAt(i) == ',') {
                numbCommas++;
            }
        }
        return numbCommas;
    }

    @Override
    public int numberOfFullStops(Object message) {
        String mess = (String) message;
        int numbFull = 0;
        for (int i = 0; i < mess.length(); i++) {
            if (mess.charAt(i) == '.') {
                numbFull++;
            }
        }
        return numbFull;
    }

    @Override
    public int numberOfWord(Object message) {
        String mess = (String) message;
        return numberOfWhite(mess) + 1;
    }

    @Override
    public Map<String, Integer> occurence(Object message) {
        String mess = (String) message;
        String tempMessage;
        int numOccurence=0;
        Map<String, Integer> mapOccurences=new HashMap<>();
        String[] splitedMessage = mess.split(" ");
        for (int i = 0; i < splitedMessage.length; i++) {
            tempMessage = splitedMessage[i];
            //if (doesNotRepeat(removeUnwated(tempMessage), mapOccurences)) {
                for (int j = 0; j < splitedMessage.length; j++) {
                    if (removeUnwated(splitedMessage[j]).equalsIgnoreCase(removeUnwated(tempMessage))) {
                        numOccurence++;
                      }
                }
                mapOccurences.put(removeUnwated(tempMessage), numOccurence);
                
                numOccurence = 0;
            //}
        }
        return mapOccurences;
    }
//My, helper, method. to remove unwanted character in each word
    private String removeUnwated(String word)
    {
        String wordModified="";
        for (int i = 0; i < word.length(); i++) {
            if(Character.isLetter(word.charAt(i)))
            {
                wordModified+=word.charAt(i);
            }
        }
        return wordModified;
    }
    //My, helper, method. to check if the word does not repeat
    public boolean doesNotRepeat(String word,Map<String,Integer> map)
    {   
        boolean validate=false;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            
            String key = entry.getKey();
            System.out.println(key);
            if(!word.equalsIgnoreCase(key))
            {
               validate=true; 
            }
            
        }
        return validate;
    }
}
