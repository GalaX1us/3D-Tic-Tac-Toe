package com.tictactoe.Grid;

/**
 * classe pour la grille de jeu en 2D
 */
public class Grid2D {

    /**
     * taille de la grille
     */
    private int gridSize;
    /**
     * tableau de cellules
     */
    private Cell[][] grid;
    /**
     * booleen pour savoir si la partie est finie
     */
    private boolean over;
    /**
     * nombre de cellules occupées
     */
    private int occupiedCells;

    /**
     * Constructeur de la classe Grid2D
     * @param gridSize taille de la grille
     */
    public Grid2D(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new Cell[gridSize][gridSize];
        this.initGrid();
        this.over = false;
        this.occupiedCells = 0;
    }

    /**
     * Methode pour initialiser la grille
     */
    private void initGrid(){
        for (int line = 0; line < this.gridSize; line++) {
            for (int column = 0; column < this.gridSize; column++) {
                this.grid[line][column] = new Cell(this.gridSize , line*this.gridSize+column+1);
            }   
        }
    }

    /** 
     * Methode qui revoie le booleen over
    */
    public Boolean isOver(){
        return this.over;
    }

    /**
     * setter pour le booleen over
     */
    public void setOver(){
        this.over = true;
    }

    /**
     * 
     * @param index
     * @return si la cellule est libre
     */
    public Boolean isCellFree(int index){
        int line = (index-1)/this.gridSize;
        int column = (index-1)%this.gridSize;
        if (this.grid[line][column].isPlayed()) return false;

        return true;
    }

    /**
     * Méthode pour afficher la grille
     */
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

    /**
     * Méthode pour verifier si la grille est pleine
     * @return si la grille est pleine (boolean)
     */
    public boolean isFull()
    {
        return this.occupiedCells == this.gridSize*this.gridSize;
    }

    /**
     * Méthode pour vérifier si un coup est gagnant
     * @param line ligne du coup
     * @param column colonne du coup
     * @param symbol symbole du coup
     * @return si le coup est gagnant (boolean)
     */
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

    /**
     * Méthode pour mettre en evidence une classe 
     * @param index emplacement de la case
     */
    public void selectCase (int index)
    {
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        this.grid[line][column].setIsSelected(true);
    }

    /**
     * Méthode pour enlever l'évidence d'une classe
     * @param index emplacement de la case
     */
    public void unselectCase (int index)
    {
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        this.grid[line][column].setIsSelected(false);
    }


    /**
     * @return the gridSize
     */
    public int getGridSize() {
        return gridSize;
    }

    /**
     * @param gridSize the gridSize to set
     */
    public void setSymbol(int index, char symbol)
    {
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        this.grid[line][column].setSymbol(symbol);
        this.grid[line][column].setIsPlayed(true);
        this.occupiedCells += 1;
    }
    
}
