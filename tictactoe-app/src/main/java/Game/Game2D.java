package Game;

import Player.Human;
import Player.Player;
import Game.Cell;

import java.util.InputMismatchException;
import java.util.Scanner;  // Import the Scanner class



public class Game2D extends Game{

    private int gridSize;
    public Cell[][]grid;
    public boolean isOver;



    public Game2D(int size) {
        this.player1 = new Human();
        this.player2 = new Human();
        this.isOver = false;
        this.currentPlayer = 1;


        this.gridSize = size;
        this.grid = new Cell[size][size];

        this.initGrid();
    }

    public void play_interface()
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean hasPlayed = false;
        do
        {
            displayGrid();
            System.out.println("C'est au joueur "+this.currentPlayer+" de jouer");
            System.out.println("Entrer le numéro de la case ou vous voulez jouer");
            

            boolean correctInput = true;
            int index = myObj.nextInt();
            System.out.println();

            
            selectCase(index);
            this.displayGrid();
            System.out.println("Vous avez choisi la case "+index);
            System.out.println("taper 1 pour confirmer, 2 pour annuler");
            int confirm = myObj.nextInt();
            System.out.println();

            if (confirm == 1) {
                this.play(index);
                hasPlayed = true;
                unselectCase(index);
            }
            else{
                unselectCase(index);
            }
        }while (!hasPlayed);
        




    }

    private void selectCase (int index)
    {
        int line = (index-1)/this.gridSize;
        int column = (index-1)%this.gridSize;
        this.grid[line][column].setIsSelected(true);
    }
    private void unselectCase (int index)
    {
        int line = (index-1)/this.gridSize;
        int column = (index-1)%this.gridSize;
        this.grid[line][column].setIsSelected(false);
    }

    public void play(int cellNumber){ // joue et change de joueur
        
        int line = (cellNumber-1)/this.gridSize;
        int column = (cellNumber-1)%this.gridSize;

        if (this.currentPlayer == 1) {
            this.grid[line][column].setSymbol('X');
            this.grid[line][column].setIsPlayed(true);
            if (this.winningMove(line, column, 'X')) {
                System.out.println("Player 1 wins");
                this.isOver = true;
            }
            this.currentPlayer = 2;
        }else{
            this.grid[line][column].setSymbol('O');
            this.grid[line][column].setIsPlayed(true);
            this.currentPlayer = 1;
            if (this.winningMove(line, column, 'O')) {
                System.out.println("Player 2 wins");
                this.isOver = true; 
            }
        }
    
    }

    private boolean winningMove(int line, int column, char symbol)
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
                if (!this.grid[i][j].getIsPlayed())
                {
                    full = false;
                }
            }
        }
        if (full) {
            System.out.println("Egalité");
            this.isOver = true;
            return false; 
        }

        return false;

    }

    

    

    private void initGrid(){
        for (int line = 0; line < this.gridSize; line++) {
            for (int column = 0; column < this.gridSize; column++) {
                this.grid[line][column] = new Cell(this.gridSize , line*this.gridSize+column+1); //verifier que ça marche bien ici 
            }
        }
    }

    public void displayGrid(){
        for (int line = 0; line < this.gridSize; line++) {
            for (int column = 0; column < this.gridSize; column++) {
                this.grid[line][column].displayCell();  
                if (column<this.gridSize) {
                    System.out.print("|"); 
                }
            }
            System.out.println();
            if (line<this.gridSize-1) {

                int nbMax = String.valueOf(this.gridSize*this.gridSize).length()+3; 
                for (int i = 0; i < nbMax*this.gridSize; i++) {
                    System.out.print("-"); 
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

// pour taille 3x3 
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

    public void testRegression2()// test regression pour tester les combinaisons gagnantes verticales 
    {

        displayGrid();
        this.play(1);
        this.play(2);
        this.play(4);
        this.play(5);
        this.play(7);

        displayGrid();
    }

    public void testRegression3()// test regression pour tester les combinaisons gagnantes diagonales 
    {

        displayGrid();
        this.play(1);
        this.play(2);
        this.play(5);
        this.play(4);
        this.play(9);

        displayGrid();
    }
    public void testRegression4()// test regression pour tester les combinaisons gagnantes diagonale2  
    {

        displayGrid();
        this.play(3);
        this.play(2);
        this.play(5);
        this.play(4);
        this.play(7);

        displayGrid();
    }

    //  taille gridSize
    public void testRegression5()
    {
        for (int i = 1; i <= gridSize; i++) {
            this.play(i);
            if (i < gridSize)
            {
                this.play(i+gridSize);
            }
            

        }
        displayGrid();
    }

   
}


    

