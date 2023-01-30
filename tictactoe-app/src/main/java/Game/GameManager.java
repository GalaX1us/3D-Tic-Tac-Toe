package Game;

import java.util.Scanner;

public class GameManager{

    private Game game;

    private int askGameMode(Scanner scanner){
        int gamemode;
        Boolean flag = false;
        do {
            if (flag){
                System.out.println("Erreur : Vous devez rentrer soit 2 soit 3 !");
            }else{
                System.out.println("Choisissez le mode de jeu, 2 pour 2D, 3 pour 3D :");
                flag=true;
            }
            System.out.print(">");
        
            gamemode = scanner.nextInt();
            
        } while (gamemode!=2 && gamemode!=3);

        return gamemode;
    }
    public void start(){
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        int gamemode = this.askGameMode(scanner);
        if (gamemode==2){
            game = new Game2D(3, scanner);
        }else{
            game = new Game3D(3, scanner);
        }
        game.play();
        scanner.close();
    }
}
