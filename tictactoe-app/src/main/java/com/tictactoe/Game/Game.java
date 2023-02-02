package com.tictactoe.Game;

import java.util.Scanner;

import com.tictactoe.Player.Player;

/**
 * Classe abstraite pour le jeu dont hérite Game2D et Game3D
 */
public abstract class Game {

    /**
     * premier joueur
     */
    protected Player player1; 
    /**
     * deuxieme joueur
     */
    protected Player player2;
    /**
     * joueur actuel
     */
    protected Player currentPlayer;

    /**
     * scanner pour la saisie
     */
    protected Scanner scanner;
    
    /**
     * Methode pour jouer
     */
    public abstract void play();

    /**
     * Methode pour récupérer le joueur actuel
     * 
     * @return le joueur actuel
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
