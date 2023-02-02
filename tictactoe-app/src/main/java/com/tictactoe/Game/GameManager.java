package com.tictactoe.Game;

import java.util.Scanner;
/**
 * Classe pour le game manager qui sert à lancer le jeu avec les bonnes options
 */
public class GameManager{

    /**
     * Game qui sera lancé
     */
    private Game game;
    /**
     * Scanner pour la saisie
     */
    private Scanner sc;

    /**
     * Constructeur de la classe GameManager
     * @param sc Scanner pour la saisie
     */
    public GameManager(Scanner sc) {
        this.sc = sc;
    }
    /**
     * Methode pour demander le mode de jeu
     * @return le mode de jeu (2 ou 3)
     */
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
            if (sc.hasNextInt()) {
                gamemode = sc.nextInt();
            }else{
                sc.nextLine();
            }
             
        } while (gamemode!=2 && gamemode!=3);

        return gamemode;
    }
    /**
     * Methode pour demander la taille de la grille
     * @return la taille de la grille
     */
    private int askSize(){
        int size = -1;
        Boolean flag = false;
        do {
            if (flag){
                System.out.println("Erreur : Vous devez rentrer une taille entre 3 et 26 !");
            }else{
                System.out.println("Choisissez une taille pour la grille de jeu (entre 3 et 26)");
                flag=true;
            }
            System.out.print(">");
            size = sc.nextInt();
              
        } while (size<3 || size>26);

        return size;
    }
    /**
     * Methode pour lancer le jeu
     */
    public void start(){
        int gamemode = this.askGameMode();
        int size = this.askSize();
        if (gamemode==2){
            game = new Game2D(size, sc);
        }else{
            game = new Game3D(size, sc);
        }
        game.play();
    }
}
