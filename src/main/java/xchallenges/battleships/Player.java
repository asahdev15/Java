package xchallenges.battleships;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class Player {

    private String playerName;
    private Map<String, Integer> ships = new HashMap<String, Integer>();
    private Queue<String> missiles = new ArrayDeque<>();
    private Player target;

    public Player(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public void addShip(char shipType, int shipWidth, int shipHeight, String location) throws ShipPositionOverlapException{
        char yShip = location.charAt(0);
        int xShip = Integer.valueOf(location.substring(1));
        for(int y = 0 ; y < shipHeight ; y++){
            for(int x = 0 ; x < shipWidth ; x++){
                String shipPartsLocation = String.valueOf(((char)((int)yShip+y))) + (xShip+x);
                if(ships.containsKey(shipPartsLocation)){
                    throw new ShipPositionOverlapException();
                }
                ships.put(shipPartsLocation, GameUtility.shipTypeLife.get(shipType));
            }
        }
    }

    public void addMissiles(String location) {
        missiles.add(location);
    }

    private boolean isHit(String location) {
        if (ships.containsKey(location)) {
            Integer remaininglife = ships.get(location) - 1;
            if (remaininglife > 0) {
                ships.put(location, remaininglife);
            } else {
                ships.remove(location);
            }
            return true;
        }
        return false;
    }

    public boolean isAllShipsDestroyed() {
        return ships.isEmpty();
    }

    public boolean isMissilesFinished(){
        return missiles.isEmpty();
    }

    public void fire(){
        boolean continueFiring = true;
        while(continueFiring){
            if(target.isAllShipsDestroyed()){
                continueFiring = false;
            }else if(isMissilesFinished()){
                GameUtility.printNoMissilesLeft(playerName);
                continueFiring=false;
            }else{
                String missileTargetLocation = missiles.peek();
                boolean isHit = target.isHit(missiles.poll());
                if(isHit){
                    GameUtility.printFireDetails(playerName, missileTargetLocation, "hit");
                    continueFiring=true;
                }else{
                    GameUtility.printFireDetails(playerName, missileTargetLocation, "miss");
                    continueFiring=false;
                }
            }
        }
    }

}