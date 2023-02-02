package com.tictactoe.Grid;
/**
 * classe pour la cellule de la grille "
 */
public class Cell {
    /**
     * index de la cellule
     */
    private int index;
    /**
     * symbole de la cellule
     */
    private char symbol;
    /**
     * booleen pour savoir si la cellule est jouée
     */
    private Boolean isPlayed;
    /**
     * booleen pour savoir si la cellule est selectionnée
     */
    private Boolean isSelected;
    /**
     * booleen pour savoir si la cellule est une combinaison gagnante
     */
    private Boolean winningMove;
    /**
     * taille max de la chaine de caractère rentrée dans la cellule
     */
    private int maxStrSize; 

    /**
     * Constructeur de la classe Cell
     * @param size taille de la grille
     */
    public Cell(int size) {
        this.index = 0;
        this.symbol = '-';
        this.isPlayed = false;
        this.isSelected = false;
        this.winningMove = false;
        this.maxStrSize = String.valueOf(size*size).length()+2;
        
    }

    /**
     * Constructeur de la classe Cell
     * @param size taille de la grille
     * @param index index de la cellule
     */
    public Cell(int size, int index) {
        this(size);
        this.index = index;
    }

    /**
     * 
     * @return si la cellule est gagnante
     */
    public Boolean getWinningMove() {
        return winningMove;
    }

    /**
     * Methode pour afficher la cellule
     */
    public void displayCell(){
        String str = "";
        if(isPlayed){
            str = ""+symbol;
        }else{
            str = String.valueOf(index);
        }
        if (isSelected) {
            str = ">"+str+"<";
        }
        else if (winningMove) {
            str = "["+str+"]";
        }
        else{
            str = " "+str+" ";
        }
        str = formatStr(str);
        System.out.print(str);
    }

    /**
     * Methode pour formater la chaine de caractère
     * @param str chaine de caractère à formater
     * @return chaine de caractère formatée
     */
    public String formatStr(String str){
        String s = str;
        int strSize = str.length();

        if (strSize >= maxStrSize){
            return str;
        }
        
        for (int i = strSize; i < maxStrSize; i++){   
            if (i%2 == 0){
                s = s+" ";
            }
            else{
                s = " "+s;
            }
        }
        return s;

    }

    /**
     * Methode pour savoir si la cellule est jouée
     * @return booleen pour savoir si la cellule est jouée
     */
    public Boolean isPlayed() {
        return isPlayed;
    }
    
    /**
     * setter de l'attribut isPlayed
     * @param isPlayed
     */
    public void setIsPlayed(Boolean isPlayed) {
        this.isPlayed = isPlayed;
    }

    /**
     * setter de l'attribut winningMove
     */
    public void setWinning(){
        this.winningMove=true;
    }

    /**
     * getter de l'attribut symbol
     * @return
     */
    public char getSymbol() {
        return symbol; 
    }
    /**
     * setter de l'attribut symbol
     * @param symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    /**
     * getter de l'attribut isSelected
     * @return
     */
    public Boolean getIsSelected() {
        return isSelected;
    }
    /**
     * setter de l'attribut isSelected
     * @param isSelected
     */
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }   
}
