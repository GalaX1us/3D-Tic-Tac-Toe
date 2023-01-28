package Player;

import java.util.Scanner;

public class Human extends Player {

    public Human(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }

    public String askCoords(){

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("C'est a"+this.name+" de jouer");
        System.out.println("Entrer le numéro de la case ou vous voulez jouer");
        
        String index = myObj.nextLine();
    
        myObj.close();

        return index; 
    }

    public int askValidation(String coup){

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Vous avez choisi la case "+coup);
        System.out.println("taper 1 pour confirmer, 2 pour annuler");
        
        int val = myObj.nextInt();
    
        myObj.close();

        return val; 
    }
}
