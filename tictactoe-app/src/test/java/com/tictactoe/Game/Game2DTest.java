package com.tictactoe.Game;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class Game2DTest {

    static private Scanner sc = new Scanner(System.in);

    @Test
    public void testInsertionGrille()
    {

        Game2D g = new Game2D(3, sc);

        g.makeMove(0);
        g.makeMove(5);

        assertTrue(Character.compare(g.getGrid().getCell(0,0).getSymbol(), g.getCurrentPlayer().getSymbol())==0);
    }

    @Test
    public void testMakeMove()
    {

        Game2D g = new Game2D(3, sc);

        g.makeMove(0);
        g.makeMove(1);

        assertTrue(g.makeMove(2));
    }
}
