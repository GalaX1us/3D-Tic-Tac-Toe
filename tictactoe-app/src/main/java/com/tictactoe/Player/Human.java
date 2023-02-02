package com.tictactoe.Player;

import java.util.Scanner;

/**
 * Classe pour le joueur humain
 */
public class Human extends Player {
    /**
     * constructeur de la classe Human 
     * @param name nom du joueur
     * @param symbol symbole du joueur
     * @param scanner scanner pour la saisie
     */
    public Human(String name, char symbol, Scanner scanner) {
        this.name = name;
        this.symbol = symbol;
        this.scanner = scanner;
    }

    /**
     * getter pour le symbole du joueur
     */
    public char getSymbol() {
        return this.symbol;
    }
    /**
     * getter pour le nom du joueur
     */
    public String getName() {
        return this.name;
    }
    /**
     * Methode pour demander des coordonnées
     */
    public String askCoords(String message){

        System.out.println("C'est a "+this.name+" de jouer");
        System.out.println(message);
        System.out.print(">");
        
        String index = this.scanner.nextLine();
    
        return index; 
    }

    /**
     * Methode pour demander une validation de la case au joueur 
     */
    public String askValidation(String coup){

        System.out.println("Vous avez choisi la case "+coup);
        System.out.println("taper 1 pour confirmer, 2 pour annuler");
        System.out.print(">");

        String val = scanner.nextLine();
    
        return val; 
    }
}
