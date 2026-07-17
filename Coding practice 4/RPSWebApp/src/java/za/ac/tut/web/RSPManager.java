
package za.ac.tut.web;


public class RSPManager implements RSPInteface{

    @Override
    public char generateSign() {
        char[] signs={'R','P','S'};
        int index=(int)Math.floor(Math.random()*3);
        return signs[index];
    }

    @Override
    public String determineOutcome(char playerSign, char computerSign) {
        String outcome="";
        
        if(playerSign =='R' && computerSign=='P'){
            outcome="Rock wraps paper, Player wins";
        }
        else if(playerSign =='R' && computerSign=='S'){
            outcome="Rock crashes scissor, Player wins";
        }
         else if(playerSign =='P' && computerSign=='R'){
            outcome="paper wraps rock, Player wins";
        }
        else if(playerSign =='P' && computerSign=='S'){
            outcome="Scissor cuts paper, computer wins";
        }
        else if(playerSign =='S' && computerSign=='R'){
            outcome="Rock crashes scissor, coumputer wins";
        }
        else if(playerSign =='S' && computerSign=='P'){
            outcome="Scissor cuts paper, Computer wins";
        }else{
            outcome="Tie";
        }
        
        return outcome;
    }
    
}
