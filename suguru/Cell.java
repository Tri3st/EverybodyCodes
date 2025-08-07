package suguru;

public class Cell {
    private int value;
    private int[] candidates;
    private boolean isFixed;
    private Border borders = {0, 0, 0, 0}; // Assuming Border is an enum or class with constants for borders

    public Cell(int value) {
        
    }


    public Cell() {
        this(0); // Default value for an empty cell
        this.isFixed = false; // Cells are not fixed by default
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean isFixed) {
        this.isFixed = isFixed;
    }
}
