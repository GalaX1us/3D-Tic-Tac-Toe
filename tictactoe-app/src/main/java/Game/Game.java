package Game;

import Player.Player;

public abstract class Game {
    public Player player1;
    public Player player2;

    public int currentPlayer;

    public abstract void displayGrid();
}
