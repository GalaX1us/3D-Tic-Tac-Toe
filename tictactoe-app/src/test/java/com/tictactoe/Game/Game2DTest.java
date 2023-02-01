package com.tictactoe.Game;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Game2DTest {

    private Game2D game;

    // pour taille 3x3 
    public void testRegression() // pour verifier si ça détecte bien quand on gagne 
    {
        // Test 1 
        game.grid.displayGrid();
        game.makeMove(1);
        game.makeMove(4);
        game.makeMove(2);
        game.makeMove(5);
        game.makeMove(3);

        game.grid.displayGrid();
    }

    public void testRegression2()// test regression pour tester les combinaisons gagnantes verticales 
    {

        game.grid.displayGrid();
        game.makeMove(1);
        game.makeMove(2);
        game.makeMove(4);
        game.makeMove(5);
        game.makeMove(7);

        game.grid.displayGrid();
    }

    public void testRegression3()// test regression pour tester les combinaisons gagnantes diagonales 
    {

        game.grid.displayGrid();
        game.makeMove(1);
        game.makeMove(2);
        game.makeMove(5);
        game.makeMove(4);
        game.makeMove(9);

        game.grid.displayGrid();
    }
    public void testRegression4()// test regression pour tester les combinaisons gagnantes diagonale2  
    {

        game.grid.displayGrid();
        game.makeMove(3);
        game.makeMove(2);
        game.makeMove(5);
        game.makeMove(4);
        game.makeMove(7);

        game.grid.displayGrid();
    }

    //  taille gridSize
    public void testRegression5()
    {
        for (int i = 1; i <= game.grid.getGridSize(); i++) {
            game.makeMove(i);
            if (i < game.grid.getGridSize())
            {
                game.makeMove(i+game.grid.getGridSize());
            }
            

        }
        game.grid.displayGrid();
    }





   
}
