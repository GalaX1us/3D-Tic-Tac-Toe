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
    public Player player1; 
    /**
     * deuxieme joueur
     */
    public Player player2;
    /**
     * joueur actuel
     */
    public Player currentPlayer;

    /**
     * scanner pour la saisie
     */
    protected Scanner scanner;
    
    /**
     * Methode pour jouer
     */
    public abstract void play();
}
