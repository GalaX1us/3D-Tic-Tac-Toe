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

    private void play(int cellNumber){ // joue et change de joueur
        
        int line = (cellNumber-1)/this.gridSize;
        int column = (cellNumber-1)%this.gridSize;

        if (this.currentPlayer == 1) {
            this.grid[line][column].setSymbol('X');
            this.grid[line][column].setIsPlayed(true);
            if (this.winningMove(line, column, 'X')) {
                System.out.println("Player 1 wins");
            }
            this.currentPlayer = 2;
        }else{
            this.grid[line][column].setSymbol('O');
            this.grid[line][column].setIsPlayed(true);
            this.currentPlayer = 1;
            if (this.winningMove(line, column, 'O')) {
                System.out.println("Player 2 wins");
            }
        }
    
    }

    private boolean winningMove(int line, int column, char symbol)
    {
        if (this.grid[line][0].getSymbol() == symbol && this.grid[line][1].getSymbol() == symbol && this.grid[line][2].getSymbol() == symbol ) {
            System.out.println("ligne !");
            return true;
            
        }
        if (this.grid[0][column].getSymbol() == symbol && this.grid[1][column].getSymbol() == symbol && this.grid[2][column].getSymbol() == symbol) {
            System.out.println("column ! ");
            return true;
        }
        if (this.grid[0][0].getSymbol() == symbol && this.grid[1][1].getSymbol() == symbol && this.grid[2][2].getSymbol() == symbol) {
            return true;
        }
        if (this.grid[0][2].getSymbol() == symbol && this.grid[1][1].getSymbol() == symbol && this.grid[2][0].getSymbol() == symbol) {
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
        System.out.println();
        System.out.println();
    }


    public void testRegression() // pour verifier si ça détecte bien quand on gagne 
    {
        // Test 1 
        this.displayGrid();
        this.play(1);
        this.play(4);
        this.play(2);
        this.play(5);
        this.play(3);

        displayGrid();
    }

   
}


    

