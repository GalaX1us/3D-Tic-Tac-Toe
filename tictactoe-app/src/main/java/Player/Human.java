package Player;

import java.util.Scanner;

public class Human extends Player {
    
    public String askCoords(Boolean is3D){

        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        if (is3D){
            System.out.println("Enter your move (a1,a2,b3 ...):\n>");
        }else{
            System.out.println("Enter your move (1,2,3 ...):\n>");
        }
        
        String coords = myObj.nextLine();  // Read user input

        myObj.close();
        return coords;
    }
}
