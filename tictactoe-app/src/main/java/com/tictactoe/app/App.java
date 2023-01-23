package com.tictactoe.app;

import Game.Game;
import Game.Game3D;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Game g = new Game3D(3);
        g.displayGrid();
    }
}
