package Player;

import java.util.Scanner;

public abstract class Player {

    protected String name;
    protected char symbol;
    protected Scanner scanner;

    public abstract String askCoords();

    public abstract String askValidation(String coup);

    public char getSymbol(){
        return this.symbol;
    }

    public String getName(){
        return this.name;
    }
}
