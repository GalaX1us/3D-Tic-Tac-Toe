package Game;

public class Cell {
    private int index;
    private char symbol;

    private Boolean isPlayed;
    private Boolean isSelected;

    public Cell() {
        this.index = 0;
        this.symbol = 'X';
        this.isPlayed = false;
        this.isSelected = false;
    }

    public Cell(int index) {
        this.index = index;
        this.symbol = 'X';
        this.isPlayed = false;
        this.isSelected = false;
    }

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
        else{
            str = " "+str+" ";
        }
        System.out.print(str);
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public Boolean getIsPlayed() {
        return isPlayed;
    }
    public void setIsPlayed(Boolean isPlayed) {
        this.isPlayed = isPlayed;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public Boolean getIsSelected() {
        return isSelected;
    }
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }
   
}
