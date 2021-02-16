package xchallenges.battleships;


import java.util.Scanner;

public class GameApp {

    public static void main(String[] args) {
        try {
            GameApp gameApp = new GameApp();
            gameApp.startGame();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private Player player1;
    private Player player2;

    Scanner scanner;
    int width = 0;
    char height = 'A';
    int numberOfBattleShips = 0;
    BattleShipGame battleShipGame;

    public void startGame() throws ConstraintFailedException, ShipPositionOverlapException {
        scanner = new Scanner(System.in);
        prepareInputs();
        battleShipGame.start();
    }

    private void prepareInputs() throws ConstraintFailedException, ShipPositionOverlapException {
        prepareBattleShipGame();
        widthHeight();
        prepareShips();
        prepareMissiles();
    }

    private void widthHeight() throws ConstraintFailedException {
        String input = scanner.nextLine();
        String[] battleArea = input.split(" ");
        width = Integer.valueOf(battleArea[0]);
        height = battleArea[1].charAt(0);
        if (width < 1 || width > 9) {
            throw new ConstraintFailedException("Constraint failed : 1 <= Width of Battle area (M’) <= 9");
        }
        if ((int) height < (int) 'A' || (int) height > (int) 'Z') {
            throw new ConstraintFailedException("Constraint failed : A <= Height of Battle area (N’) <= Z");
        }
    }

    private void prepareShips() throws ConstraintFailedException, ShipPositionOverlapException {
        numberOfBattleShips = Integer.valueOf(scanner.nextLine());
        while (numberOfBattleShips > 0) {
            String details = scanner.nextLine();
            String[] shipsDetails = details.split(" ");
            char shipType = shipsDetails[0].charAt(0);
            if (!GameUtility.shipTypeLife.containsKey(shipType)) {
                throw new ConstraintFailedException("Constraint failed : Type of ship = {‘P’, ‘Q’}");
            }
            Integer shipWidth = Integer.valueOf(shipsDetails[1]);
            if (shipWidth > width) {
                throw new ConstraintFailedException("Constraint failed : 1 <= Width of battleship <= " + width);
            }
            Integer shipHeight = Integer.valueOf(shipsDetails[2]);
            if (shipHeight > ((int) height - (int) 'A')) {
                throw new ConstraintFailedException("Constraint failed : A <= Height of battleship <= " + height);
            }
            String player1_ship = shipsDetails[3];
            String player2_ship = shipsDetails[4];
            player1.addShip(shipType, shipWidth, shipHeight, player1_ship);
            player2.addShip(shipType, shipWidth, shipHeight, player2_ship);
            numberOfBattleShips--;
        }
    }

    private void prepareMissiles() throws ConstraintFailedException {
        String player1_Missles = scanner.nextLine();
        for (String missiles : player1_Missles.split(" ")) {
            player1.addMissiles(missiles);
        }

        String player2_Missles = scanner.nextLine();
        for (String missiles : player2_Missles.split(" ")) {
            player2.addMissiles(missiles);
        }
    }

    private void prepareBattleShipGame() {
        player1 = new Player("Player-1");
        player2 = new Player("Player-2");
        player1.setTarget(player2);
        player2.setTarget(player1);
        battleShipGame = new BattleShipGame(player1, player2);
    }

}
