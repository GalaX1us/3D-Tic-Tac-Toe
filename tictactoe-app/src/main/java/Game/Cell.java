package Game;

public class Cell {
    private int index;
    private char symbol;

    private Boolean isPlayed;
    private Boolean isSelected;
    private Boolean winningMove;

    private int maxStrSize; 

    public Cell(int size) {
        this.index = 0;
        this.symbol = '-';
        this.isPlayed = false;
        this.isSelected = false;
        this.winningMove = false;
        this.maxStrSize = String.valueOf(size*size).length()+2;
        
    }

    public Cell(int size, int index) {
        this(size);
        this.index = index;
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
        if (winningMove) {
            str = "["+str+"]";
        }
        else{
            str = " "+str+" ";
        }
        str = formatStr(str);
        System.out.print(str);
    }

    private String formatStr(String str)
    
    {
        String s = str;
        int strSize = str.length();

        if (strSize == maxStrSize)
        {
            return str;
        }
        
        for (int i = strSize; i < maxStrSize; i++)
        {   
            if (i%2 == 0)
            {
                s = s+" ";
            }
            else
            {
                s = " "+s;
            }
        }
        return s;

    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public Boolean isPlayed() {
        return isPlayed;
    }
    public void setIsPlayed(Boolean isPlayed) {
        this.isPlayed = isPlayed;
    }

    public void setWinning(){
        this.winningMove=true;
    }

    public char getSymbol() {
        if (this.isPlayed())
        {
            return symbol;
        }
        else 
        {
            return (char) index; 
        }
        
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

    public int getLength(){
        return this.maxStrSize;
    }
   
}
