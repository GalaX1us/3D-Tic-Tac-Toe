package com.tictactoe.Game;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class Game3DTest {

    static private Scanner sc = new Scanner(System.in);

    @Test
    public void testInsertionGrille()
    {

        Game3D g = new Game3D(3, sc);

        g.makeMove(0,0);
        g.makeMove(0,5);

        assertTrue(Character.compare(g.getGrid().getCell(0,0,0).getSymbol(), g.getCurrentPlayer().getSymbol())==0);
    }

    @Test
    public void testMakeMove()
    {

        Game3D g = new Game3D(3, sc);

        g.makeMove(0, 0);
        g.makeMove(1, 1);

        assertTrue(g.makeMove(2, 2));
    }
}
