package com.tictactoe.app;

import Game.Game;
import Game.Game3D;
import Game.Game2D;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Game game = new Game3D(4);
        game.play();
    }
}
