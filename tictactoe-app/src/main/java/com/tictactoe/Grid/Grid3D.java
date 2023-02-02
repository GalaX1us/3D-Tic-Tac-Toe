package com.tictactoe.Grid;
/**
 * classe pour la grille de jeu en 3D
 */
public class Grid3D {
    /**
     * taille de la grille
     */
    private int gridSize;

    /**
     * tableau de cellules
     */
    private Cell[][][] grid;

    /**
     * booleen pour savoir si la partie est finie
     */
    private Boolean over;

    /**
     * nombre de cellules occupées
     */
    private int occupiedCells;

    /**
     * Constructeur de la classe Grid3D
     * @param gridSize taille de la grille
     */
    public Grid3D(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new Cell[gridSize][gridSize][gridSize];
        this.initGrid();
        this.over = false;
        this.occupiedCells = 0;
    }

    /**
     * Methode pour initialiser la grille
     */
    private void initGrid(){
        for (int layer = 0; layer < gridSize; layer++) {
            for (int ligne = 0; ligne < gridSize; ligne++) {
                for (int elem = 0; elem < gridSize; elem++) {
                    this.grid[layer][ligne][elem] = new Cell(this.gridSize, (ligne*gridSize)+(elem+1));
                }
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
     * getter de la taille de la grille
     * @return la taille de la grille
     */
    public int getGridSize() {
        return this.gridSize;
    }
    
    /**
     *  Methode pour savoir si la cellule est libre
     * @param layer la couche de la cellule
     * @param index l'index de la cellule
     */
    public Boolean isCellFree(int layer, int index){
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        if (this.grid[layer][line][column].isPlayed()) return false;

        return true;
    }

    /**
     * Methode pour afficher la grille
     */
    public void displayGrid(){
        int cellLen = String.valueOf(this.gridSize*this.gridSize).length()+2;

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
                for (int l = 0; l < gridSize; l++) {
                    for (int i = 0; i < cellLen*gridSize+gridSize-1; i++) {
                        System.out.print("-"); 
                    }
                    if (l<gridSize-1) {
                        System.out.print("      ");
                    }
                    
                }
                System.out.println();
            }
        }

        for (int layer = 0; layer < gridSize; layer++){
            String index = "("+String.valueOf((char)(layer+ 1 + 64))+")";
            for (int i = 3; i < cellLen*this.gridSize+(this.gridSize-1); i++){   
                if (i%2 == 0) index = index+" ";
                else index = " "+index;
            }
            System.out.print(index);
            if (layer<gridSize-1) {
                System.out.print("      ");
            }
        }
        System.out.println();
    }

    /**
     * Methode pour selectionner une cellule
     * @param layer la couche de la cellule
     * @param index l'index de la cellule
     */
    public void selectCase(int layer, int index)
    {
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        this.grid[layer][line][column].setIsSelected(true);
    }

    /**
     * Methode pour deselectionner une cellule
     * @param layer la couche de la cellule
     * @param index l'index de la cellule
     */
    public void unselectCase(int layer, int index)
    {
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        this.grid[layer][line][column].setIsSelected(false);
    }

    /**
     * Methode pour jouer un coup
     * @param layer la couche de la cellule
     * @param index l'index de la cellule
     * @param symbol le symbole du joueur
     */
    public void setSymbol(int layer, int line, int column, char symbol)
    {
        this.grid[layer][line][column].setSymbol(symbol);
        this.grid[layer][line][column].setIsPlayed(true);
        this.occupiedCells += 1;
    }

    /**
     * Methode pour savoir si la grille est pleine
     * @return un booleen qui indique si la grille est pleine
     */
    public Boolean isFull(){
        return this.occupiedCells == this.gridSize*this.gridSize*this.gridSize;
    }

    /**
     * Renvoie la cellule aux coords spécifiées
     * @param layer indice de la couche
     * @param line indice de la ligne
     * @param column indice de la colonne
     * @return la cellule correspondante
     */
    public Cell getCell(int layer, int line, int column){
        return this.grid[layer][line][column];
    }

    /**
     * Methode pour savoir si un coup est gagnant
     * @param layer la couche de la cellule
     * @param line la ligne de la cellule
     * @param column la colonne de la cellule
     * @param symbol le symbole du joueur
     * @return un booleen qui indique si le joueur a gagné
     */
    public Boolean winningMove(int layer, int line, int column, char symbol) {
        Boolean value = CHECK_HORIZONTALLY(layer, line, column, symbol) ||
                    CHECK_VERTICALLY(layer, line, column, symbol) ||
                    CHECK_DIAGONALLY_LR(layer, line, column, symbol) ||
                    CHECK_DIAGONALLY_RL(layer, line, column, symbol) ||
                    CHECK_ACROSS_SAME_POSITION(layer, line, column, symbol) ||
                    CHECK_ACROSS_HORIZONTALLY_LR(layer, line, column, symbol) ||
                    CHECK_ACROSS_HORIZONTALLY_RL(layer, line, column, symbol) ||
                    CHECK_ACROSS_VERTICALLY_UD(layer, line, column, symbol) ||
                    CHECK_ACROSS_VERTICALLY_DU(layer, line, column, symbol) ||
                    CHECK_ACROSS_DIAGONALLY_LR_UD(layer, line, column, symbol) ||
                    CHECK_ACROSS_DIAGONALLY_LR_DU(layer, line, column, symbol) ||
                    CHECK_ACROSS_DIAGONALLY_RL_UD(layer, line, column, symbol) ||
                    CHECK_ACROSS_DIAGONALLY_RL_DU(layer, line, column, symbol);
        return value;
    }
    
    /**
     * Methode pour verifier si le coup est gagnant horizontalement
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant horizontalement
     */
    private Boolean CHECK_HORIZONTALLY (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[layer][line][j].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[layer][line][j].setWinning();
            }
            return true;
        }
        return false;
    }
    
    /**
     * Methode pour verifier si le coup est gagnant verticalement
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant verticalement
     */
    private Boolean CHECK_VERTICALLY (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[layer][j][column].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[layer][j][column].setWinning();
            }
            return true;
        }
        return false;
    }
   
    /**
     * Methode pour verifier si le coup est gagnant diagonalement de gauche à droite
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant diagonalement
     */
    private Boolean CHECK_DIAGONALLY_LR (int layer, int line, int column, char symbol) {
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[layer][j][j].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[layer][j][j].setWinning();
            }
            return true;
        }
        return false;
    }
    
    /**
     * Methode pour verifier si le coup est gagnant diagonalement de droite à gauche
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant diagonalement
     */
    private Boolean CHECK_DIAGONALLY_RL (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[layer][j][this.gridSize-1-j].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[layer][j][this.gridSize-1-j].setWinning();
            }
            return true;
        }
        return false;
    }
    
    /**
     * Methode pour verifier si le coup est gagnant sur une couche
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant sur une couche
     */
    private Boolean CHECK_ACROSS_SAME_POSITION (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[j][line][column].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[j][line][column].setWinning();
            }
            return true;
        }
        return false;
    }
    
    /**
     * Methode pour verifier si le coup est gagnant sur une ligne de gauche à droite
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant sur une ligne
     */
    private Boolean CHECK_ACROSS_HORIZONTALLY_LR (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[j][line][j].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[j][line][j].setWinning();
            }
            return true;
        }
        return false;
    }
    
    /**
     * Methode pour verifier si le coup est gagnant sur une ligne de droite à gauche
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant sur une ligne
     */
    private Boolean CHECK_ACROSS_HORIZONTALLY_RL (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[j][line][this.gridSize-1-j].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[j][line][this.gridSize-1-j].setWinning();
            }
            return true;
        }
        return false;
    }
    
    /**
     * Methode pour verifier si le coup est gagnant sur une colonne de haut en bas
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant sur une colonne
     */
    private Boolean CHECK_ACROSS_VERTICALLY_UD (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[j][j][column].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[j][j][column].setWinning();
            }
            return true;
        }
        return false;
    }
    /**
     * Methode pour verifier si le coup est gagnant sur une colonne de bas en haut
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant sur une colonne
     */
    private Boolean CHECK_ACROSS_VERTICALLY_DU (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[j][this.gridSize-1-j][column].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[j][this.gridSize-1-j][column].setWinning();
            }
            return true;
        }
        return false;
    }
    
    /**
     * Methode pour verifier si le coup est gagnant sur une diagonale de haut en bas de gauche à droite
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant sur une diagonale
     */
    private Boolean CHECK_ACROSS_DIAGONALLY_LR_UD (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[j][j][j].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[j][j][j].setWinning();
            }
            return true;
        }
        return false;
    }
    
    /**
     * Methode pour verifier si le coup est gagnant sur une diagonale de gauche à droite de bas en haut
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant sur une diagonale
     */
    private Boolean CHECK_ACROSS_DIAGONALLY_LR_DU (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[j][this.gridSize-1-j][j].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[j][this.gridSize-1-j][j].setWinning();
            }
            return true;
        }
        return false;
    }
    /**
     * Methode pour verifier si le coup est gagnant sur une diagonale de haut en bas de droite à gauche
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant sur une diagonale
     */
    private Boolean CHECK_ACROSS_DIAGONALLY_RL_UD (int layer, int line, int column, char symbol) {
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[j][j][this.gridSize-1-j].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[j][j][this.gridSize-1-j].setWinning();
            }
            return true;
        }
        return false;
    }
    
    /**
     * Methode pour verifier si le coup est gagnant sur une diagonale de droite à gauche de bas en haut
     * @param layer la couche de la cellule jouée
     * @param line la ligne de la cellule jouée
     * @param column la colonne de la cellule jouée
     * @param symbol le symbole du joueur ayant joué
     * @return un booleen qui indique si le coup est gagnant sur une diagonale
     */
    private Boolean CHECK_ACROSS_DIAGONALLY_RL_DU (int layer, int line, int column, char symbol) {
        
     int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[j][this.gridSize-1-j][this.gridSize-1-j].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[j][this.gridSize-1-j][this.gridSize-1-j].setWinning();
            }
            return true;
        }
        return false;
    }
}
