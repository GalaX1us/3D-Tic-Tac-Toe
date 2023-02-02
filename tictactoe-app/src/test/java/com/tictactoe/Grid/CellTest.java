package com.tictactoe.Grid;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CellTest {
    
    @Test
    public void testSymbol()
    {

        Cell g = new Cell(3, 0);

        assertTrue(Character.compare(g.getSymbol(), '-')==0);

        g.setSymbol('X');

        assertTrue(Character.compare(g.getSymbol(), 'X')==0);
    }

    @Test
    public void testFormatage()
    {
        Cell g = new Cell(3, 0);

        String str1 = "1";
        String str2 = "10";

        String str1Formated = g.formatStr(str1);
        String str2Formated = g.formatStr(str2);

        assertTrue(str1Formated.equals(" 1 "));
        assertTrue(str2Formated.equals("10 "));
    }
}
