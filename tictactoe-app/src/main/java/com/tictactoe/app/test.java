package com.tictactoe.app;

import java.util.Scanner;

import com.tictactoe.Game.Game3D;
import com.tictactoe.Grid.Cell;

public class test {
    static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
        Cell g = new Cell(3, 2);

        System.out.println(g.getSymbol());

        g.setSymbol('X');
        g.setIsPlayed(true);   

    }
}
