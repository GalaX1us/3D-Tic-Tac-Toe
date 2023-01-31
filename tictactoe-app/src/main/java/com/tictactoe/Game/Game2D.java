package com.tictactoe.Game;

import java.util.Scanner;  // Import the Scanner class

import com.tictactoe.Grid.Grid2D;
import com.tictactoe.Player.Human;
import com.tictactoe.Player.Player;



public class Game2D extends Game{

    public Human player1;
    public Human player2;
    public Grid2D grid;
    public Player currentPlayer;

    public Game2D(int size, Scanner scanner) {
        this.scanner = scanner;
        this.player1 = new Human("James", 'X', scanner);
        this.player2 = new Human("George", 'O', scanner);
        this.currentPlayer = this.player1;
        this.grid = new Grid2D(size);
    }

    //verifier ce que l'on met en public ou private

    public int coordsInput(){
        int coords = 0; 
        String rawCoords;
        Boolean valid = false;
        do{
            rawCoords = currentPlayer.askCoords("Entrez le numéro de la case que vous voulez jouer");
            if (rawCoords.compareTo("")==0) continue;
            try{
                coords = Integer.parseInt(rawCoords);
                if (coords < 1 || coords > this.grid.getGridSize()*this.grid.getGridSize()) {
                    System.out.println("\nErreur : Veuillez entrer un nombre entre 1 et "+this.grid.getGridSize()*this.grid.getGridSize()+"\n");
                }else if(!this.grid.isCellFree(coords)){
                    System.out.println("\nErreur : Veuillez jouer sur une case libre\n");    
                }else{
                    valid = true;
                }

            }catch(Exception e){
                System.out.println("\nErreur : Veuillez entrer un nombre valide\n");
            }

        }while(!valid);

        return coords-1;
    }

    public boolean validationInput(int coup)
    {
        int validation = 0;
        String rawValidation;
        Boolean valid = false;

        do{
            rawValidation = currentPlayer.askValidation(Integer.toString(coup+1));
            try{
                validation = Integer.parseInt(rawValidation);
                if (validation < 1 || validation > 2) {
                    System.out.println("\nErreur : Veuillez entrer un nombre entre 1 et 2\n");
                }
                else{
                    valid = true;
                }
            }
            catch(Exception e){
                System.out.println("\nErreur : Veuillez entrer un nombre valide\n");
            }
        }while(!valid);

        return (validation == 1); 
            
    }

    public void makeMove(int cellNumber){ // joue et change de joueur
        
        int line = (cellNumber)/this.grid.getGridSize();
        int column = (cellNumber)%this.grid.getGridSize();

        this.grid.setSymbol( cellNumber, currentPlayer.getSymbol());

            if (this.grid.winningMove(line, column, currentPlayer.getSymbol())) {
                this.grid.displayGrid();
                System.out.println("Victoire de "+currentPlayer.getName());
                this.grid.setOver();
            }
            else if (this.grid.isFull()) {
                this.grid.displayGrid();
                System.out.println("Match nul");
                this.grid.setOver();
            }
            else{
                if (this.currentPlayer == this.player1) {
                    this.currentPlayer = this.player2;
                }
                else{
                    this.currentPlayer = this.player1;
                }
            }

        }

    @Override
    public void play() {
        this.scanner.nextLine();
        while (!this.grid.isOver()) {

            int coords; 
            boolean valid = false;
            do 
            {
                this.grid.displayGrid();
                coords = this.coordsInput();
                this.grid.selectCase(coords);
                this.grid.displayGrid();
                valid = this.validationInput(coords);
                this.grid.unselectCase(coords);
            } while (!valid);
            this.makeMove(coords);
        }
    }


   

    

    

   



// pour taille 3x3 
    public void testRegression() // pour verifier si ça détecte bien quand on gagne 
    {
        // Test 1 
        this.grid.displayGrid();
        this.makeMove(1);
        this.makeMove(4);
        this.makeMove(2);
        this.makeMove(5);
        this.makeMove(3);

        this.grid.displayGrid();
    }

    public void testRegression2()// test regression pour tester les combinaisons gagnantes verticales 
    {

        this.grid.displayGrid();
        this.makeMove(1);
        this.makeMove(2);
        this.makeMove(4);
        this.makeMove(5);
        this.makeMove(7);

        this.grid.displayGrid();
    }

    public void testRegression3()// test regression pour tester les combinaisons gagnantes diagonales 
    {

        this.grid.displayGrid();
        this.makeMove(1);
        this.makeMove(2);
        this.makeMove(5);
        this.makeMove(4);
        this.makeMove(9);

        this.grid.displayGrid();
    }
    public void testRegression4()// test regression pour tester les combinaisons gagnantes diagonale2  
    {

        this.grid.displayGrid();
        this.makeMove(3);
        this.makeMove(2);
        this.makeMove(5);
        this.makeMove(4);
        this.makeMove(7);

        this.grid.displayGrid();
    }

    //  taille gridSize
    public void testRegression5()
    {
        for (int i = 1; i <= this.grid.getGridSize(); i++) {
            this.makeMove(i);
            if (i < this.grid.getGridSize())
            {
                this.makeMove(i+this.grid.getGridSize());
            }
            

        }
        this.grid.displayGrid();
    }





   
}


    

