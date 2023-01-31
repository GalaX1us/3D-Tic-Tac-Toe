package com.tictactoe.app;

import java.util.Scanner;

import com.tictactoe.Game.GameManager;

/**
 * Hello world!
 *
 */
public class TicTacToe 
{
    static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
        GameManager manage = new GameManager(sc);
        manage.start();
    }
}
