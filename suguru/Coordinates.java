package suguru;

/**
 * Coordinates class to represent the position of a cell in the Suguru grid.
 * It holds the row and column indices, and block number
 * which can be used to identify the block the cell belongs to.
 * This class can be useful for tracking the position of cells in the grid.
 * It can also be extended to include methods for checking adjacency or other spatial relationships.
 */
public class Coordinates {
    private int row;
    private int col;
    private int blockNr; // Assuming blockNr is used to identify the block the cell belongs to

    /**
     * Constructor to initialize the coordinates of a cell.
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param blockNr the block number the cell belongs to
     */
    public Coordinates(int row, int col, int blockNr) {
        this.row = row;
        this.col = col;
        this.blockNr = blockNr; // Initialize block number if needed
    }

    public int getBlockNr() {
        return blockNr;
    }

    public void setBlockNr(int blockNr) {
        this.blockNr = blockNr;
    }   

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}