package com.tictactoe.Grid;

public class Grid2D {

    private int gridSize;
    private Cell[][] grid;
    private boolean over;

    private int occupiedCells;

    public Grid2D(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new Cell[gridSize][gridSize];
        this.initGrid();
        this.over = false;
        this.occupiedCells = 0;
    }

    private void initGrid(){
        for (int line = 0; line < this.gridSize; line++) {
            for (int column = 0; column < this.gridSize; column++) {
                this.grid[line][column] = new Cell(this.gridSize , line*this.gridSize+column+1);
        }
    }
    }

    public Boolean isOver(){
        return this.over;
    }

    public void setOver(){
        this.over = true;
    }

    public Boolean isCellFree(int index){
        int line = (index-1)/this.gridSize;
        int column = (index-1)%this.gridSize;
        if (this.grid[line][column].isPlayed()) return false;

        return true;
    }

    public void displayGrid(){
        for (int line = 0; line < this.gridSize; line++) {
            for (int column = 0; column < this.gridSize; column++) {
                this.grid[line][column].displayCell();  
                if (column<this.gridSize-1) {
                    System.out.print("|"); 
                }
            }
            System.out.println();
            if (line<this.gridSize-1) {

                int nbMax = String.valueOf(this.gridSize*this.gridSize).length()+2; 
                for (int i = 0; i < nbMax*this.gridSize+(this.gridSize-1); i++) {
                    System.out.print("-"); 
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

    public boolean isFull()
    {
        return this.occupiedCells == this.gridSize*this.gridSize;
    }

    public boolean winningMove(int line, int column, char symbol)
    {
        boolean l = true;
        for (int i=0; i<gridSize ; i++ )
        {
            if (this.grid[line][i].getSymbol() != symbol)
            {
                l = false ; 
            }

        }
        if (l) {
            for (int i=0; i<gridSize ; i++ )
            {
                this.grid[line][i].setWinning();
            }
            return true;
            
        }

        //pour les colonnes 
        boolean c = true;
        for (int i=0; i<gridSize ; i++ )
        {
            if (this.grid[i][column].getSymbol() != symbol)
            {
                c = false ; 
            }

        } 
        if (c) {
            for (int i=0; i<gridSize ; i++ )
            {
                this.grid[i][column].setWinning();
            }
            return true;
        }

        //pour les diagonales

        boolean diagonal1 = true;
        for (int i=0; i<gridSize ; i++ )
        {
            if (this.grid[i][i].getSymbol() != symbol)
            {
                diagonal1 = false ; 
            }

        }

        if (diagonal1) {
            for (int i=0; i<gridSize ; i++ )
            {
                this.grid[i][i].setWinning();
            }
            return true;
        }

        // pour la deuxième diagonale
        boolean diagonal2 = true;
        for (int i=0; i<gridSize ; i++ )
        {
            if (this.grid[i][gridSize-i-1].getSymbol() != symbol)
            {
                diagonal2 = false ; 
            }

        }
        if (diagonal2) {
            for (int i=0; i<gridSize ; i++ )
            {
                this.grid[i][gridSize-i-1].setWinning();
            }
            return true;
        }

        //pour gerer l'égalité 
        boolean full = true;
        for (int i=0; i<gridSize && full ; i++ )
        {
            for (int j=0; j<gridSize && full; j++ )
            {
                if (!this.grid[i][j].isPlayed())
                {
                    full = false;
                }
            }
        }
        if (full) {
            System.out.println("Egalité");
            this.over = true;
            return false; 
        }

        return false;

    }

    public void selectCase (int index)
    {
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        this.grid[line][column].setIsSelected(true);
    }

    public void unselectCase (int index)
    {
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        this.grid[line][column].setIsSelected(false);
    }


    // setter and getter

    public int getGridSize() {
        return gridSize;
    }

    public void setSymbol(int index, char symbol)
    {
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        this.grid[line][column].setSymbol(symbol);
        this.grid[line][column].setIsPlayed(true);
        this.occupiedCells += 1;
    }










    
}
