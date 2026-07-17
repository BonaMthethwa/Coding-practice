
package za.ac.tut;
import boxer.Boxer;

public class BoxingFight {
    private Boxer boxer1;
    private Boxer boxer2;

    public BoxingFight(String name1, String name2) {
       boxer1= new Boxer(name1);
        boxer2 = new Boxer(name2);
    }

    public Boxer getBoxer1() {
        return boxer1;
    }

    public Boxer getBoxer2() {
        return boxer2;
    }
    
    public String possibleWinner(int numFights1, int numWins1, int numKO1, int numFights2, int numWins2, int numKO2){
       String results=" ";
       double  box1=boxer1.winningPossibility(numFights1, numWins1, numKO1);
       double box2= boxer2.winningPossibility(numFights2, numWins2, numKO2);
        
       if(box1>box2){
          results="The winner is "+ boxer1.getBoxerName();
       } 
       else {
           results="The winner is " +boxer2.getBoxerName();
       }
        return results;
        
    }
    
    
}
