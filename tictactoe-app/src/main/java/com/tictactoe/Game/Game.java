package com.tictactoe.Game;

import java.util.Scanner;

import com.tictactoe.Player.Player;

public abstract class Game {
    public Player player1;
    public Player player2;

    public Player currentPlayer;

    protected Scanner scanner;

    public abstract void play();
}