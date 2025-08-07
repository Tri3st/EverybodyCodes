package suguru;
import java.util.ArrayList;

public class Cell {
    private int value;
    private ArrayList<Integer> candidates = new ArrayList<>();
    private boolean isFixed;
    private Border[] borders = {Border.NONE, Border.NONE, Border.NONE, Border.NONE};
    private Coordinates coordinates; // Assuming Coordinates is a class that holds the row and column indices of the cell

    /**
     * Constructor for a cell with a specific value.
     * Initializes the cell with the given value and sets it as fixed if the value is not zero.
     * @param value the initial value of the cell
     *              (0 indicates an empty cell, non-zero indicates a fixed cell)
     */
    public Cell(int value) {
        this.value = value;
        this.isFixed = (value != 0); // If value is not zero, the cell is considered fixed
    }

    /**
     * Default constructor for an empty cell.
     * Initializes the cell with a value of 0 and sets it as not fixed.
     * This constructor is useful for creating cells that will be filled later.
     */
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
