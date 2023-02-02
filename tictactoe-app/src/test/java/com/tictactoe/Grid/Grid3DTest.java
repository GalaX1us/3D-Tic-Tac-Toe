package com.tictactoe.Grid;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

import com.tictactoe.Game.Game3D;

public class Grid3DTest {

    static private Scanner sc = new Scanner(System.in);
    
    @Test 
    public void testCasesGagnante() // pour verifier si ça détecte bien quand on gagne 
    {
        // Test 1 
        Game3D g = new Game3D(3, sc);
        g.makeMove(0,0);
        g.makeMove(0,3);
        g.makeMove(0,1);
        g.makeMove(0,4);
        g.makeMove(0,2);

        assertTrue(g.getGrid().getCell(0, 0, 0).getWinningMove() && 
        g.getGrid().getCell(0, 0, 1).getWinningMove() &&
        g.getGrid().getCell(0, 0, 2).getWinningMove());
    }

    // pour taille 3x3
    @Test 
    public void testCombGagnanteHorizontale() // pour verifier si ça détecte bien quand on gagne 
    {
        // Test 1 
        Game3D g = new Game3D(3, sc);
        g.makeMove(0,0);
        g.makeMove(0,3);
        g.makeMove(0,1);
        g.makeMove(0,4);
        g.makeMove(0,2);

        assertTrue(g.getGrid().winningMove(0,0, 2, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteVerticale()// test  pour tester les combinaisons gagnantes verticales 
    {

        Game3D g = new Game3D(3, sc);

        g.makeMove(0,0);
        g.makeMove(0,1);
        g.makeMove(0,3);
        g.makeMove(0,4);
        g.makeMove(0,6);

        assertTrue(g.getGrid().winningMove(0,2, 0, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonale()// test  pour tester les combinaisons gagnantes diagonales 
    {

        Game3D g = new Game3D(3, sc);

        g.makeMove(0,0);
        g.makeMove(0,1);
        g.makeMove(0,4);
        g.makeMove(0,3);
        g.makeMove(0,8);

        assertTrue(g.getGrid().winningMove(0,2, 2, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonale2()  
    {
        Game3D g = new Game3D(3, sc);

        g.makeMove(0,2);
        g.makeMove(0,1);
        g.makeMove(0,4);
        g.makeMove(0,3);
        g.makeMove(0,6);

        assertTrue(g.getGrid().winningMove(0, 2, 0, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteProfondeur()  
    {
        Game3D g = new Game3D(3, sc);

        g.makeMove(0,0);
        g.makeMove(0,1);
        g.makeMove(1,0);
        g.makeMove(0,3);
        g.makeMove(2,0);

        assertTrue(g.getGrid().winningMove(2, 0, 0, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonaleHorizontaleGD()  
    {
        Game3D g = new Game3D(3, sc);

        g.makeMove(0,0);
        g.makeMove(0,1);
        g.makeMove(1,1);
        g.makeMove(0,3);
        g.makeMove(2,2);

        assertTrue(g.getGrid().winningMove(2, 0, 2, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonaleHorizontaleDG()  
    {
        Game3D g = new Game3D(3, sc);

        g.makeMove(0,2);
        g.makeMove(0,1);
        g.makeMove(1,1);
        g.makeMove(0,3);
        g.makeMove(2,0);

        assertTrue(g.getGrid().winningMove(2, 0, 0, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonaleVerticaleHB()  
    {
        Game3D g = new Game3D(3, sc);

        g.makeMove(0,0);
        g.makeMove(0,1);
        g.makeMove(1,3);
        g.makeMove(0,3);
        g.makeMove(2,6);

        assertTrue(g.getGrid().winningMove(2, 2, 0, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonaleVerticaleBH()  
    {
        Game3D g = new Game3D(3, sc);

        g.makeMove(0,6);
        g.makeMove(0,1);
        g.makeMove(1,3);
        g.makeMove(0,3);
        g.makeMove(2,0);

        assertTrue(g.getGrid().winningMove(2, 0, 0, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonaleGD_HB()  
    {
        Game3D g = new Game3D(3, sc);

        g.makeMove(0,0);
        g.makeMove(0,1);
        g.makeMove(1,4);
        g.makeMove(0,3);
        g.makeMove(2,8);

        assertTrue(g.getGrid().winningMove(2, 2, 2, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonaleDG_HB()  
    {
        Game3D g = new Game3D(3, sc);

        g.makeMove(0,2);
        g.makeMove(0,1);
        g.makeMove(1,4);
        g.makeMove(0,3);
        g.makeMove(2, 6);

        assertTrue(g.getGrid().winningMove(2, 2, 0, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonaleGD_BH()  
    {
        Game3D g = new Game3D(3, sc);

        g.makeMove(0,6);
        g.makeMove(0,1);
        g.makeMove(1,4);
        g.makeMove(0,3);
        g.makeMove(2,2);

        assertTrue(g.getGrid().winningMove(2, 0, 2, g.getCurrentPlayer().getSymbol()));
    }

    @Test
    public void testCombGagnanteDiagonaleDG_BH()  
    {
        Game3D g = new Game3D(3, sc);

        g.makeMove(0,8);
        g.makeMove(0,1);
        g.makeMove(1,4);
        g.makeMove(0,3);
        g.makeMove(2,0);

        assertTrue(g.getGrid().winningMove(2, 0, 0, g.getCurrentPlayer().getSymbol()));
    }
    
    //  taille getGrid()Size
    @Test
    public void testGrillePleine()
    {

        Game3D g = new Game3D(3, sc);

        for(int i = 0; i < g.getGrid().getGridSize(); i++){
            for (int j = 0; j < g.getGrid().getGridSize()*g.getGrid().getGridSize(); j++) {
                g.makeMove(i,j);
            }
        }

        assertTrue(g.getGrid().isFull());
    }
}
