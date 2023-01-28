package Game;

import Player.Human;
import Player.Player;
import Game.Cell;

import java.util.InputMismatchException;
import java.util.Scanner;  // Import the Scanner class



public class Game2D extends Game{

    public Human player1;
    public Human player2;
    public Grid2D grid;
    public Player currentPlayer;

    //verifier ce que l'on met en public ou private

    public int coordsInput(){
        int coords = 0; 
        String rawCoords;
        Boolean valid = false;
        do{
            rawCoords = currentPlayer.askCoords();
            try{
                
                coords = Integer.parseInt(rawCoords);
                if (coords < 1 || coords > this.grid.getGridSize()*this.grid.getGridSize()) {
                    System.out.println("Veuillez entrer un nombre entre 1 et "+this.grid.getGridSize()*this.grid.getGridSize());
                }else{
                    valid = true;
                }

            }catch(InputMismatchException e){
                System.out.println("Veuillez entrer un nombre");
            }

        }while(!valid);

        return coords;
    }




    public Game2D(int size) {
        this.player1 = new Human("James", 'X');
        this.player2 = new Human("George", 'O');
        this.currentPlayer = this.player1;
        this.grid = new Grid2D(size);
    }

    public void play_interface()
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean hasPlayed = false;
        do
        {
            this.grid.displayGrid();
            System.out.println("C'est au joueur "+this.currentPlayer+" de jouer");
            System.out.println("Entrer le numéro de la case ou vous voulez jouer");
            

            boolean correctInput = true;
            int index = myObj.nextInt();
            System.out.println();

            
            this.grid.selectCase(index);
            this.grid.displayGrid();
            System.out.println("Vous avez choisi la case "+index);
            System.out.println("taper 1 pour confirmer, 2 pour annuler");
            int confirm = myObj.nextInt();
            System.out.println();

            if (confirm == 1) {
                this.play(index);
                hasPlayed = true;
                this.grid.unselectCase(index);
            }
            else{
                this.grid.unselectCase(index);
            }
        }while (!hasPlayed);
    }

    public void play(int cellNumber){ // joue et change de joueur
        
       
    
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        
    }


   

    

    

   

    

// pour taille 3x3 
    public void testRegression() // pour verifier si ça détecte bien quand on gagne 
    {
        // Test 1 
        this.grid.displayGrid();
        this.play(1);
        this.play(4);
        this.play(2);
        this.play(5);
        this.play(3);

        this.grid.displayGrid();
    }

    public void testRegression2()// test regression pour tester les combinaisons gagnantes verticales 
    {

        this.grid.displayGrid();
        this.play(1);
        this.play(2);
        this.play(4);
        this.play(5);
        this.play(7);

        this.grid.displayGrid();
    }

    public void testRegression3()// test regression pour tester les combinaisons gagnantes diagonales 
    {

        this.grid.displayGrid();
        this.play(1);
        this.play(2);
        this.play(5);
        this.play(4);
        this.play(9);

        this.grid.displayGrid();
    }
    public void testRegression4()// test regression pour tester les combinaisons gagnantes diagonale2  
    {

        this.grid.displayGrid();
        this.play(3);
        this.play(2);
        this.play(5);
        this.play(4);
        this.play(7);

        this.grid.displayGrid();
    }

    //  taille gridSize
    public void testRegression5()
    {
        for (int i = 1; i <= this.grid.getGridSize(); i++) {
            this.play(i);
            if (i < this.grid.getGridSize())
            {
                this.play(i+this.grid.getGridSize());
            }
            

        }
        this.grid.displayGrid();
    }





   
}


    

