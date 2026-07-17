
package queueexample;

import java.util.LinkedList;
import java.util.Queue;


public class QueueExample {

    
    public static void main(String[] args) {
       Queue<Integer> qNum=new LinkedList<>();
       //to add
       do{
          qNum.add(1);
          qNum.add(2);
          qNum.add(3);
          qNum.add(4);
          qNum.add(5);
       }while(qNum.isEmpty());
       
       //To display all elements
       System.out.println("The size is "+ qNum.size());
       
       for(Integer num: qNum){
       System.out.println("The number in the Queue "+ num);
       }
       //to get the first elements in the Que using the element method
       System.out.println("The first element in the queue is "+ qNum.element());
       System.out.println("size is"+ qNum.size());
       
        for(Integer n:qNum){
           System.out.println(n+" is in the Queue");
       }
       ////getting the first element withou removing it
       System.out.println("The element at the top is "+qNum.peek());
       
       //using poll
       System.out.println("The element at top is "+  qNum.poll());
       
       //to add othe numbers to the queue
       qNum.add(9);
       qNum.offer(9);
       
       System.out.println("The numbers 10 and 9 have been added to the queue");
       System.out.println("The first elements now is "+qNum.peek());
       System.out.println("The size of the queue no is "+qNum.size());
       
        for(Integer n:qNum){
           System.out.println(n+" is in the Queue");
       }
       //To display the numbers
       for(Integer n:qNum){
           System.out.println(n+" is in the Queue");
       }
       
       
    }
}

           
           
       
   
    

