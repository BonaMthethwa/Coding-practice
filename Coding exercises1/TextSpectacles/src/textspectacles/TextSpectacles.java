
package textspectacles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextSpectacles {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String, Integer> map=new HashMap<>();
        
        //to prompt the user to enter message
        System.out.println("Enter the message :");
        String message=sc.nextLine();
        
        //calculating length of message in byte
        byte[] bytes=message.getBytes();
        int lengthBytes=bytes.length;
        System.out.println("The length of messag in length is : "+lengthBytes);
        
        //number of whiteSpaces, commas and fullstops
        int commas=0;
        int fullStop=0;
        int whiteSpaces=0;
        
        for(char c: message.toCharArray()){
            if(c == ','){
                commas++;}
            else if(c=='.'){
                fullStop++;
            } 
            else if(Character.isWhitespace(c)){
                whiteSpaces++;
            }
            
        }
        System.out.println("Number of commas is "+ commas);
        System.out.println("Number of full stops is "+ fullStop);
        System.out.println("Number of white spaces is "+ whiteSpaces);
        
        //number of words
        String[] words=message.split(" ");
        int numWords=words.length;
        
        System.out.println("The number of words is "+ numWords);
        
        //for word frequencies
        int wordCount=0;
        for(String word: words){
            wordCount++;
           
            //remove punctuations
            word=word.replaceAll("[^a-zA-Z]","").toLowerCase();
            
            map.put(word, map.getOrDefault(word, 0) + 1);
            
        }
        System.out.println("The of times each word occurs in the message "+ wordCount);
    }
    
}
