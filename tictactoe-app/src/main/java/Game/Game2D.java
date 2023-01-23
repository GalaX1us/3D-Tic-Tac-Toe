package Game;

import Player.Human;
import Player.Player;
import Game.Cell;


public class Game2D extends Game{

    private int gridSize;
    public Cell[][]grid;


    public Game2D(int size) {
        this.player1 = new Human();
        this.player2 = new Human();
        this.currentPlayer = 1;

        this.gridSize = size;
        this.grid = new Cell[size][size];

        this.initGrid();
    }

    public void play(int cellNumber){ // joue et change de joueur
        
        int line = (cellNumber-1)/this.gridSize;
        int column = (cellNumber-1)%this.gridSize;

        if (this.currentPlayer == 1) {
            this.grid[line][column].setSymbol('X');
            this.grid[line][column].setIsPlayed(true);
            this.currentPlayer = 2;
        }else{
            this.grid[line][column].setSymbol('O');
            this.grid[line][column].setIsPlayed(true);
            this.currentPlayer = 1;
        }
    
    }

    public boolean winGrid(){

        //verifier les lignes
        for (int line = 0; line < this.gridSize; line++) {
            char symbol = this.grid[line][0].getSymbol();
            boolean win = true;
            for (int column = 1; column < this.gridSize; column++) {
                if (this.grid[line][column].getSymbol() != symbol) {
                    win = false;
                }
            }
            if (win) {
                return true;
            }
        }

        //verifier les colonnes
        for (int column = 0; column < this.gridSize; column++) {
            char symbol = this.grid[0][column].getSymbol();
            boolean win = true;
            for (int line = 1; line < this.gridSize; line++) {
                if (this.grid[line][column].getSymbol() != symbol) {
                    win = false;
                }
            }
            if (win) {
                return true;
            }
        }

        //verifier les diagonales
        char symbol = this.grid[0][0].getSymbol();
        boolean win = true;
        for (int i = 1; i < this.gridSize; i++) {
            if (this.grid[i][i].getSymbol() != symbol) {
                win = false;
            }
        }
        if (win) {
            return true;
        }

        symbol = this.grid[0][this.gridSize-1].getSymbol();
        win = true;
        for (int i = 1; i < this.gridSize; i++) {
            if (this.grid[i][this.gridSize-1-i].getSymbol() != symbol) {
                win = false;
            }
        }
        if (win) {
            return true;
        }

        return false;
    }

    private void initGrid(){
        for (int line = 0; line < this.gridSize; line++) {
            for (int column = 0; column < this.gridSize; column++) {
                this.grid[line][column] = new Cell(line*this.gridSize+column+1); //verifier que ça marche bien ici 
            }
        }
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
                for (int i = 0; i < this.gridSize+(3*(this.gridSize-1)); i++) {
                    System.out.print("-"); 
                }
                System.out.println();
            }
        }
    }

   
}


    

