package Game;

import Player.Human;
import Player.Player;
import Game.Cell;

public class Game3D extends Game {
    public Player player1;
    public Player player2;

    public int currentPlayer;

    private int gridSize;
    public Cell[][][] grid;

    public Game3D(int size) {
        this.player1 = new Human();
        this.player2 = new Human();
        this.currentPlayer = 1;

        this.gridSize = size;
        this.grid = new Cell[this.gridSize][this.gridSize][this.gridSize];

        this.initGrid();

    }

    private void initGrid(){
        for (int layer = 0; layer < gridSize; layer++) {
            for (int ligne = 0; ligne < gridSize; ligne++) {
                for (int elem = 0; elem < gridSize; elem++) {
                    this.grid[layer][ligne][elem] = new Cell((ligne*3)+(elem+1));
                }
            }
        }
    }


    public void displayGrid(){
        for (int ligne = 0; ligne < gridSize; ligne++) {
            for (int layer = 0; layer < gridSize; layer++) {
                for (int elem = 0; elem < gridSize; elem++) {

                    this.grid[layer][ligne][elem].displayCell();  


                    if (elem<gridSize-1) {
                        System.out.print("|"); 
                    }
                }
                System.out.print("      ");               
            }
            System.out.println();
            if (ligne<gridSize-1) {
                for (int l = 0; l < grid.length; l++) {
                    for (int i = 0; i < gridSize+(3*(gridSize-1)); i++) {
                        System.out.print("-"); 
                    }
                    if (l<gridSize-1) {
                        System.out.print("      ");
                    }
                    
                }
            }
            System.out.println();
        }
    }
    
    public void setCell(int layer, int line, int column, char value){
        this.grid[layer][line][column].setSymbol(value);
    }

    public Cell[][][] getGrid() {
        return grid;
    }
}
