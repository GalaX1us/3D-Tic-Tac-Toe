package com.tictactoe.Player;

import java.util.Scanner;

/**
 * Classe abstraite pour le joueur
 */
public abstract class Player {
    /**
     * nom du joueur
     */
    protected String name;
    /**
     * symbole du joueur
     */
    protected char symbol;
    /**
     * scanner pour la saisie
     */
    protected Scanner scanner;

    /**
     * Methode pour demander des coordonnées
     * @param message 
     * @return
     */
    public abstract String askCoords(String message);

    /**
     * Methode pour demander une validation de la case au joueur 
     * @param coup
     * @return boolean qi indique si la case est validé par le joueur
     */
    public abstract String askValidation(String coup);

    /**
     * getter pour le symbole du joueur
     * @return le symbole du joueur (char)
     */
    public char getSymbol(){
        return this.symbol;
    }

    /**
     * getter pour le nom du joueur
     * @return le nom du joueur (String)
     */
    public String getName(){
        return this.name;
    }
}
