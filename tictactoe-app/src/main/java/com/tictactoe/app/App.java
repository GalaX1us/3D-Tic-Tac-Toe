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
        Game2D game = new Game2D(3);
        game.displayGrid();
        game.testRegression();

    }
}
