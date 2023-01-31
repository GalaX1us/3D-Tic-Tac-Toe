package com.tictactoe.Grid;

public class Grid3D {

    private int gridSize;
    private Cell[][][] grid;

    private Boolean over;

    private int occupiedCells;

    public Grid3D(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new Cell[gridSize][gridSize][gridSize];
        this.initGrid();
        this.over = false;
        this.occupiedCells = 0;
    }

    private void initGrid(){
        for (int layer = 0; layer < gridSize; layer++) {
            for (int ligne = 0; ligne < gridSize; ligne++) {
                for (int elem = 0; elem < gridSize; elem++) {
                    this.grid[layer][ligne][elem] = new Cell(this.gridSize, (ligne*3)+(elem+1));
                }
            }
        }
    }

    public Boolean isOver(){
        return this.over;
    }

    public void setOver(){
        this.over = true;
    }

    public int getGridSize() {
        return this.gridSize;
    }

    public Boolean isCellFree(int layer, int index){
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        if (this.grid[layer][line][column].isPlayed()) return false;

        return true;
    }

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
                    for (int i = 0; i < cellLen*3+gridSize-1; i++) {
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

    public void selectCase(int layer, int index)
    {
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        this.grid[layer][line][column].setIsSelected(true);
    }

    public void unselectCase(int layer, int index)
    {
        int line = (index)/this.gridSize;
        int column = (index)%this.gridSize;
        this.grid[layer][line][column].setIsSelected(false);
    }

    public void setSymbol(int layer, int line, int column, char symbol)
    {
        this.grid[layer][line][column].setSymbol(symbol);
        this.grid[layer][line][column].setIsPlayed(true);
        this.occupiedCells += 1;
    }
    
    public Boolean isFull(){
        return this.occupiedCells == this.gridSize*this.gridSize*this.gridSize;
    }

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
    
    private Boolean CHECK_DIAGONALLY_RL (int layer, int line, int column, char symbol) {
        
        int w = 0;
                        
        for(int j = 0; j<this.gridSize ; j++) {   
            if(this.grid[layer][this.gridSize-1-j][this.gridSize-1-j].getSymbol() == symbol)
                w++; 
        }
        if (w==this.gridSize){
            for(int j = 0; j<this.gridSize ; j++) {   
                this.grid[layer][this.gridSize-1-j][this.gridSize-1-j].setWinning();
            }
            return true;
        }
        return false;
    }
    
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
