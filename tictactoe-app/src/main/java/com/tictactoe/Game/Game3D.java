package com.tictactoe.Game;

import java.util.Scanner;

import com.tictactoe.Grid.Grid3D;
import com.tictactoe.Player.Human;

/**
 * Classe pour le jeu en 3D
 */
public class Game3D extends Game {
    /*
     * grille de jeu
     */
    private Grid3D grid;

    /**
     * Constructeur de la classe Game3D
     * 
     * @param size    taille de la grille
     * @param scanner scanner pour la saisie
     */
    public Game3D(int size, Scanner scanner) {
        this.scanner = scanner;
        this.player1 = new Human("Joueur 1", 'X', scanner);
        this.player2 = new Human("Joueur 2", 'O', scanner);
        this.currentPlayer = this.player1;
        this.grid = new Grid3D(size);
    }

    /**
     * Methode pour récupérer la grille de jeu
     * 
     * @return grille de jeu
     */
    public Grid3D getGrid() {
        return grid;
    }

    /**
     * Methode pour jouer et demander des coordonnées
     */
    @Override
    public void play() {
        this.scanner.nextLine();
        while (!this.grid.isOver()) {

            int[] coords; 
            boolean valid = false;
            do 
            {
                this.grid.displayGrid();
                coords = this.coordsInput();
                this.grid.selectCase(coords[0], coords[1]);
                this.grid.displayGrid();
                valid = this.validationInput(coords[0], coords[1]);
                this.grid.unselectCase(coords[0], coords[1]);
            } while (!valid);
            Boolean win = this.makeMove(coords[0], coords[1]);

            if (win) {
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
                System.out.println();
            }
        }
    }

    /**
     * Methode pour jouer un coup
     * 
     * @param layer     couche
     * @param cellNumber numéro de la case dans la couche
     * @return le coup est il gagnant
     */
    public Boolean makeMove(int layer, int cellNumber){ // joue et change de joueur
        
        int line = (cellNumber)/this.grid.getGridSize();
        int column = (cellNumber)%this.grid.getGridSize();

        this.grid.setSymbol(layer, line, column, currentPlayer.getSymbol());

        return this.grid.winningMove(layer, line, column, currentPlayer.getSymbol());
        }
    
    /**
     * Methode pour demander des coordonnées
     * 
     * @return tableau de coordonnées
     */
    public int[] coordsInput(){
        int[] coords = {-1,-1}; 
        int layer = -1, coord = -1;
        String rawCoords;
        Boolean valid = false;
        do{
            rawCoords = currentPlayer.askCoords("Entrez la position de la case que vous voulez jouer (ex : A6)");
            if (rawCoords.compareTo("")==0) continue;
            if (rawCoords.length()<2){
                System.out.println("\nErreur : Coordonnées invalides, format : (couche+case) ex:A6\n");
                continue;
            }
            try{
                layer = Character.toLowerCase(rawCoords.charAt(0)) - 'a' + 1;
                coord = Integer.parseInt(rawCoords.substring(1));

                if(layer < 1 || layer > this.grid.getGridSize()){
                    System.out.println("\nErreur : Veuillez choisir une couche entre A et "+String.valueOf((char)(this.grid.getGridSize() + 64))+"\n");  
                }else if(coord < 1 || coord > this.grid.getGridSize()*this.grid.getGridSize()) {
                    System.out.println("\nErreur : Veuillez choisir une case entre 1 et "+this.grid.getGridSize()*this.grid.getGridSize()+"\n");
                }else if(!this.grid.isCellFree(layer-1, coord-1)){
                    System.out.println("\nErreur : Veuillez jouer sur une case libre\n");    
                }else{
                    valid = true;
                }

            }catch(Exception e){
                System.out.println("\nErreur : Veuillez entrer un nombre valide\n");
            }
        }while(!valid);

        coords[0] = layer-1;
        coords[1] = coord-1;

        return coords;
    }

    /**
     * Methode pour demander une validation
     * 
     * @param layer couche
     * @param coord numéro de la case dans la couche
     * @return vrai si la case est valide
     */
    public boolean validationInput(int layer, int coord)
    {
        int validation = 0;
        String rawValidation;
        Boolean valid = false;

        do{
            rawValidation = currentPlayer.askValidation(String.valueOf((char)(layer + 1 + 64))+Integer.toString(coord+1));
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



    
}
