package Game;

import java.util.Scanner;

public class GameManager{

    private Game game;
    private Scanner sc;

    

    public GameManager(Scanner sc) {
        this.sc = sc;
    }
    private int askGameMode(){
        int gamemode = -1;
        Boolean flag = false;
        do {
            if (flag){
                System.out.println("Erreur : Vous devez rentrer soit 2 soit 3 !");
            }else{
                System.out.println("Choisissez le mode de jeu, 2 pour 2D, 3 pour 3D :");
                flag=true;
            }
            System.out.print(">");
            gamemode = sc.nextInt();
              
        } while (gamemode!=2 && gamemode!=3);

        return gamemode;
    }
    public void start(){
        int gamemode = this.askGameMode();
        if (gamemode==2){
            game = new Game2D(4, sc);
        }else{
            game = new Game3D(3, sc);
        }
        game.play();
    }
}
