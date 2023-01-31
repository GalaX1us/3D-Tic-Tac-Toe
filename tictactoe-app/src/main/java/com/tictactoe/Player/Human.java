package com.tictactoe.Player;

import java.util.Scanner;

public class Human extends Player {

    public Human(String name, char symbol, Scanner scanner) {
        this.name = name;
        this.symbol = symbol;
        this.scanner = scanner;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }

    public String askCoords(String message){

        System.out.println("C'est a "+this.name+" de jouer");
        System.out.println(message);
        System.out.print(">");
        
        String index = this.scanner.nextLine();
    
        return index; 
    }

    public String askValidation(String coup){

        System.out.println("Vous avez choisi la case "+coup);
        System.out.println("taper 1 pour confirmer, 2 pour annuler");
        System.out.print(">");

        String val = scanner.nextLine();
    
        return val; 
    }
}
