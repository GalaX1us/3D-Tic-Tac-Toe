package Player;

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

    public String askCoords(){

        System.out.println("C'est a "+this.name+" de jouer");
        System.out.println("Entrer le numéro de la case ou vous voulez jouer :");
        
        String index = this.scanner.nextLine();
    
        return index; 
    }

    public String askValidation(String coup){

        System.out.println("Vous avez choisi la case "+coup);
        System.out.println("taper 1 pour confirmer, 2 pour annuler");
        
        String val = scanner.nextLine();
    
        return val; 
    }
}
