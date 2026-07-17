
package setexample;

import java.util.HashSet;
import java.util.Set;


public class SetExample {

    
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        
        do{
            set.add(1);
            set.add(2);
            set.add(3);
            set.add(4);
            set.add(4);
        }while (set.isEmpty());
        
        //to display
        System.out.println("there are "+ set.size()+" in the set");
         System.out.println(set);
         
         //try to add a duplicate 
         boolean outcome=set.add(5);
          System.out.println("\n Is the duplicate added ? "+outcome);
           System.out.println(set);
           
           //to add anothe 2 unique numbers
           set.add(9);
           set.add(10);
            System.out.println("there are "+ set.size()+" in the set");
             System.out.println(set);
    }
    
}
