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
