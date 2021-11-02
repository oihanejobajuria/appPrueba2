package A3;

import java.util.Scanner;

public class Player {
    String playerName;
    int playerPoint;

    public Player(String playerName, int playerPoint) {
        this.playerName = playerName;
        this.playerPoint = playerPoint;
    }

    public Player() {
    }

    public void createPlayer(){
        Scanner name = new Scanner(System.in);
        Scanner point = new Scanner(System.in);

        System.out.println("Introdueix el nom del nou jugador: ");
        this.playerName = name.nextLine();
        System.out.println("Introdueix els punts del nou jugador: ");
        this.playerPoint = point.nextInt();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerPoint() {
        return playerPoint;
    }

    public void setPlayerPoint(int playerPoint) {
        this.playerPoint = playerPoint;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", point=" + playerPoint +
                '}';
    }
}
