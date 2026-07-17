
package tut.zc.Interface;

import java.util.Map;

public interface TextSpectaclesInterface <M> {
    public byte lengthMessage(M m);
    public int numberOfWhite(M m);
    public int numberOfCommas(M m);
    public int numberOfFullStops(M m);
    public int numberOfWord(M m);
    public Map<String,Integer> occurence(M m);
    
}
