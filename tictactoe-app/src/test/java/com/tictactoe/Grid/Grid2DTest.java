package com.tictactoe.Grid;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

import com.tictactoe.Game.Game2D;

public class Grid2DTest {

    static private Scanner sc = new Scanner(System.in);
    
    // pour taille 3x3
    @Test 
    public void testCasesGagnante() // pour verifier si ça détecte bien quand on gagne 
    {
        // Test 1 
        Game2D g = new Game2D(3, sc);
        g.makeMove(0);
        g.makeMove(3);
        g.makeMove(1);
        g.makeMove(4);
        g.makeMove(2);

        assertTrue(g.getGrid().getCell(0, 0).getWinningMove() && 
        g.getGrid().getCell(0, 1).getWinningMove() &&
        g.getGrid().getCell(0, 2).getWinningMove());
    }

    // pour taille 3x3
    @Test 
    public void testCombGagnanteHorizontale() // pour verifier si ça détecte bien quand on gagne 
    {
        // Test 1 
        Game2D g = new Game2D(3, sc);
        g.makeMove(0);
        g.makeMove(3);
        g.makeMove(1);
        g.makeMove(4);
        g.makeMove(2);

        assertTrue(g.getGrid().winningMove(0, 2, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteVerticale()// test  pour tester les combinaisons gagnantes verticales 
    {

        Game2D g = new Game2D(3, sc);

        g.makeMove(0);
        g.makeMove(1);
        g.makeMove(3);
        g.makeMove(4);
        g.makeMove(6);

        assertTrue(g.getGrid().winningMove(2, 0, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonale()// test  pour tester les combinaisons gagnantes diagonales 
    {

        Game2D g = new Game2D(3, sc);

        g.makeMove(0);
        g.makeMove(1);
        g.makeMove(4);
        g.makeMove(3);
        g.makeMove(8);

        assertTrue(g.getGrid().winningMove(2, 2, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonale2()// test  pour tester les combinaisons gagnantes diagonale2  
    {
        Game2D g = new Game2D(3, sc);

        g.makeMove(2);
        g.makeMove(1);
        g.makeMove(4);
        g.makeMove(3);
        g.makeMove(6);

        assertTrue(g.getGrid().winningMove(2, 0, g.getCurrentPlayer().getSymbol()));
    }

    
    @Test
    public void testGrillePleine()
    {

        Game2D g = new Game2D(3, sc);

        for (int i = 0; i < g.getGrid().getGridSize()*g.getGrid().getGridSize(); i++) {
            g.makeMove(i);
        }

        assertTrue(g.getGrid().isFull());
    }
}
