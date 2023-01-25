package Game;

import Player.Human;
import Player.Player;
import Game.Cell;

public class Game3D extends Game {
    public Player player1;
    public Player player2;

    public Player currentPlayer;

    private int gridSize;
    public Cell[][][] grid;

    public Game3D(int size) {
        this.player1 = new Human();
        this.player2 = new Human();
        this.currentPlayer = this.player1;

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

    public void play(){

    }

    public int[] coordsInput(){
        //layer, cell
        int[] coords = new int[1];
        String rawCoords;
        rawCoords = currentPlayer.askCoords();

        return coords;
    }

    private boolean winningMove(int layer, int line, int column, char symbol)
    {
        
    }

    private int CHECK_HORIZONTALLY () {
        
        int w = 0;
        int l = 0;
        int c = 0;
            
        for(int k = 0; k<4; k++) {
            for(int i = 0; i<4; i++) {    
                for(int j = 0; j<4 ; j++) {   
                    if(this.grid[k][i][j]. == this.actualPlayer)
                        w++;
                    if(this.table[k][i][j] == this.againstPlayer) {
                        l++;
                    }   
                }
                c = c + optimization(w, l, "HORIZONTALLY");
                w = 0;
                l = 0;
            }
        }
        return c;
    }
    
    /*
     * Cheque las posibles jugadas verticales
     */
    private int CHECK_VERTICALLY () {
        
        int w = 0;
        int l = 0;
        int c = 0;
            
        for(int k = 0; k<4; k++) {
            for(int j = 0; j<4; j++) {    
                for(int i = 0; i<4 ; i++) {   
                    if(this.table[k][i][j] == this.actualPlayer)
                        w++;
                    if(this.table[k][i][j] == this.againstPlayer) {
                        l++;
                    }   
                }
                c = c + optimization(w, l, "VERTICALLY");
                w = 0;
                l = 0;
            }
        }
        return c;
    }
    
    /*
     * Cheque las posibles jugadas que sean diagonal sencilla de izquierda a
     * derecha
     */
    private int CHECK_DIAGONALLY_LR () {
        
        int w = 0;
        int l = 0;
        int c = 0;
            
        for(int k = 0; k<4; k++) {
            for(int i = 0; i<4; i++) {
                if(this.table[k][i][i] == this.actualPlayer)
                    w++;
                if(this.table[k][i][i] == this.againstPlayer) {
                    l++;
                }   
            }
            c = c + optimization(w, l, "DIAGONALLY_LR");
            w = 0;
            l = 0;
        }
        return c;
    }
    
    /*
     * Chequea las posibles jugadas que sean diagonal sencilla de derecha a
     * izquierda
     */
    private int CHECK_DIAGONALLY_RL () {
        
        int w = 0;
        int l = 0;
        int c = 0;
            
        for(int k = 0; k<4; k++) {
            for(int i = 0; i<4; i++) {
                if(this.table[k][i][3-i] == this.actualPlayer)
                    w++;
                if(this.table[k][i][3-i] == this.againstPlayer) {
                    l++;
                }   
            }
            c = c + optimization(w, l, "CHECK_DIAGONALLY_RL");
            w = 0;
            l = 0;
        }
        return c;
    }
    
    /*
     * Cheque las jugadas posibles que sean por la misma posicion entre los 
     * cuatro tableros
     */
    private int CHECK_ACROSS_SAME_POSITION () {
        
        int w = 0;
        int l = 0;
        int c = 0;
        
        for(int i = 0; i<4; i++) {
            for(int j = 0; j<4; j++) {
                for(int k = 0; k<4; k++) {
                    if(this.table[k][i][j] == this.actualPlayer)
                        w++;
                    if(this.table[k][i][j] == this.againstPlayer) {
                        l++;
                    }      
                }            
                c = c + optimization(w, l, "ACROSS_SAME_POSITION");
                w = 0;
                l = 0; 
            }   
        }
        return c; 
    }
    
    /*
     * Chequea las posibles jugadas que sean horizontal de izquierda a derecha
     * entre los cuatro tableros
     */
    private int CHECK_ACROSS_HORIZONTALLY_LR () {
        
        int w = 0;
        int l = 0;
        int c = 0;
        
        for(int i = 0; i<4; i++) {
            for(int k = 0; k<4; k++) {
                if(this.table[k][i][k] == this.actualPlayer)
                    w++;
                if(this.table[k][i][k] == this.againstPlayer) {
                    l++;
                }   
            }
            c = c + optimization(w, l, "CHECK_ACROSS_HORIZONTALLY_LR");
            w = 0;
            l = 0;      
        }
        return c;
    }
    
    /*
     * Chequea las posibles jugadas que sean horizontal de derecha a izquierda
     * entre los cuatro tableros
     */
    private int CHECK_ACROSS_HORIZONTALLY_RL () {
        
        int w = 0;
        int l = 0;
        int c = 0;
        
        for(int i = 0; i<4; i++) {
            for(int k = 0; k<4; k++) {
                if(this.table[k][i][3-k] == this.actualPlayer)
                    w++;
                if(this.table[k][i][3-k] == this.againstPlayer) {
                    l++;
                }   
            }
            c = c + optimization(w, l, "ACROSS_HORIZONTALLY_RL");
            w = 0;
            l = 0;      
        }
        return c;  
    }
    
    /*
     * Chequea las posibles jugadas que sean vertical de arriba hacia abajo
     * entre los cuatro tableros
     */
    private int CHECK_ACROSS_VERTICALLY_UD () {
        
        int w = 0;
        int l = 0;
        int c = 0;
        
        for(int j = 0; j<4; j++) {
            for(int k = 0; k<4; k++) {
                if(this.table[k][k][j] == this.actualPlayer)
                    w++;
                if(this.table[k][k][j] == this.againstPlayer) {
                    l++;
                }   
            }
            c = c + optimization(w, l, "ACROSS_VERTICALLY_UD");
            w = 0;
            l = 0;      
        }
        return c; 
    }
    
    /*     
     * Chequea las posibles jugadas que sean vertical de abajo hacia arriba
     * entre los cuatro tableros
     */
    private int CHECK_ACROSS_VERTICALLY_DU () {
        
        int w = 0;
        int l = 0;
        int c = 0;
        
        for(int j = 0; j<4; j++) {
            for(int k = 0; k<4; k++) {
                if(this.table[k][3-k][j] == this.actualPlayer)
                    w++;
                if(this.table[k][3-k][j] == this.againstPlayer) {
                    l++;
                }   
            }
            c = c + optimization(w, l, "ACROSS_VERTICALLY_DU");
            w = 0;
            l = 0;      
        }
        return c;   
    }
    
    /*
     * Chequea las posibles jugadas que sean diagonal de izquierda a derecha y 
     * de arriba hacia abajo entre los cuatro tableros
     */
    private int CHECK_ACROSS_DIAGONALLY_LR_UD () {
        
        int w = 0;
        int l = 0;
        int c = 0;
        
        for(int k = 0; k<4; k++) {
            if(this.table[k][k][k] == this.actualPlayer)
                w++;
            if(this.table[k][k][k] == this.againstPlayer) {
                l++;
            }   
        }
        c = c + optimization(w, l, "ACROSS_DIAGONALLY_LR_UD");
        return c;
    }
    
    /*
     * Chequea las posibles jugadas que sean diagonal de derecha a izquierda y 
     * de abajo hacia arriba entre los cuatro tableros
     */
    private int CHECK_ACROSS_DIAGONALLY_LR_DU () {
        
        int w = 0;
        int l = 0;
        int c = 0;
        
        for(int k = 0; k<4; k++) {
            if(this.table[k][3-k][k] == this.actualPlayer)
                w++;
            if(this.table[k][3-k][k] == this.againstPlayer) {
                l++;
            }   
        }
        c = c + optimization(w, l, "ACROSS_DIAGONALLY_LR_DU");
        return c;
    }
    
    /*
     * Chequea las posibles jugadas que sean diagonal de derecha a izquierda y 
     * de arriba hacia abajo entre los cuatro tableros
     */
    private int CHECK_ACROSS_DIAGONALLY_RL_UD () {
        
        int w = 0;
        int l = 0;
        int c = 0;
        
        for(int k = 0; k<4; k++) {
            if(this.table[k][k][3-k] == this.actualPlayer)
                w++;
            if(this.table[k][k][3-k] == this.againstPlayer) {
                l++;
            }   
        }
        c = c + optimization(w, l, "ACROSS_DIAGONALLY_RL_UD");
        return c;
    }
    
    /*
     * Chequea las posibles jugadas que sean diagonal de izquierda a derecha y 
     * de abajo hacia arriba entre los cuatro tableros
     */
    private int CHECK_ACROSS_DIAGONALLY_RL_DU () {
        
        int w = 0;
        int l = 0;
        int c = 0;
        
        for(int k = 0; k<4; k++) {
            if(this.table[k][3-k][3-k] == this.actualPlayer)
                w++;
            if(this.table[k][3-k][3-k] == this.againstPlayer) {
                l++;
            }   
        }
        c = c + optimization(w, l, "ACROSS_DIAGONALLY_RL_DU");
        return c;
    }
}
