package Game;

public class Cell {
    private int index;
    private char symbol;

    private Boolean isPlayed;
    private Boolean isSelected;
    private Boolean winningMove;

    private int size; 

    public Cell(int size) {
        this.index = 0;
        this.symbol = 'X';
        this.isPlayed = false;
        this.isSelected = false;
        this.winningMove = false;
        this.size = size;
        
    }

    public Cell(int size, int index) {
        this.index = index;
        this.symbol = 'X';
        this.isPlayed = false;
        this.isSelected = false;
        this.winningMove = false;
        this.size = size;


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
        
        String strMax = String.valueOf(this.size*this.size);
        int strMaxSize = strMax.length()+2;

        if (strSize == strMaxSize)
        {
            return str;
        }
        
        for (int i = strSize; i < strMaxSize; i++)
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

    public Boolean getIsPlayed() {
        return isPlayed;
    }
    public void setIsPlayed(Boolean isPlayed) {
        this.isPlayed = isPlayed;
    }

    public void setWinning(){
        this.winningMove=true;
    }

    public char getSymbol() {
        if (this.getIsPlayed())
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
   
}
