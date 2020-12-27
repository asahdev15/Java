package battleships;

public class BattleShipGame {

    private Player player1;
    private Player player2;

    public BattleShipGame(Player player1, Player player2){
        this.player1=player1;
        this.player2=player2;
    }

    public void start(){
        while(true){
            if((player1.isMissilesFinished() && player2.isMissilesFinished()) || (player1.isAllShipsDestroyed() || player2.isAllShipsDestroyed())){
                break;
            }
            player1.fire();
            player2.fire();
        }
        if(!player1.isAllShipsDestroyed() && !player2.isAllShipsDestroyed()){
            GameUtility.printGameDraw();
        }else if(player1.isAllShipsDestroyed()){
            GameUtility.printWinnerDetails(player2.getPlayerName());
        }else if(player2.isAllShipsDestroyed()){
            GameUtility.printWinnerDetails(player1.getPlayerName());
        }
    }
}
