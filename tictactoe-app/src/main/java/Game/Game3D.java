package Game;

import Player.Human;
import Player.Player;

import java.util.Scanner;

import Game.Cell;

public class Game3D extends Game {
    public Player player1;
    public Player player2;

    public Player currentPlayer;

    private Grid3D grid;

    public Game3D(int size, Scanner scanner) {
        this.scanner = scanner;
        this.player1 = new Human("James", 'X', scanner);
        this.player2 = new Human("George", 'O', scanner);
        this.currentPlayer = this.player1;

        this.grid = new Grid3D(size);
    }
    
    public void play(){
        this.grid.displayGrid();
    }

    public int[] coordsInput(){
        //layer, cell
        int[] coords = new int[2];
        String rawCoords;
        Boolean valid = false;
        do{
            rawCoords = currentPlayer.askCoords();
            

        }while(!valid);

        return coords;
    }



    
}
