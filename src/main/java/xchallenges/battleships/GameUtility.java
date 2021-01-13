package battleships;

import java.util.HashMap;
import java.util.Map;

public class GameUtility {

    public static Map<Character, Integer> shipTypeLife = new HashMap<Character, Integer>();

    static{
        shipTypeLife.put('Q', 2);
        shipTypeLife.put('P', 1);
    }

    public static void printFireDetails(String playerName, String missileTargetLocation, String status){
        System.out.println(playerName + " fires a missile with target " + missileTargetLocation + " which got " + status);
    }

    public static void printNoMissilesLeft(String playerName){
        System.out.println(playerName + " has no more missiles left to launch");
    }

    public static void printWinnerDetails(String playerName){
        System.out.println(playerName + " won the battle");
    }

    public static void printGameDraw(){
        System.out.println("Battle ends in a draw");
    }


}
