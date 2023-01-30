package Game;

import java.util.Scanner;

import Player.Player;

public abstract class Game {
    public Player player1;
    public Player player2;

    public Player currentPlayer;

    public Scanner scanner;

    public abstract void play();
}
