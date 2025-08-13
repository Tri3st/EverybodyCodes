package suguru;

/*  
 * +-+-+-+-+
 * |1| | | |
 * +-+-+-+-+
 * |4|3| | |
 * +-+-+-+-+
 * | | | |5|
 * +-+-+-+-+
 * |2|4|1| |
 * +-+-+-+-+
*/

public class Suguru {
    private int[][] grid;
    private int size;

    public Suguru(int size) {
        this.size = size;
        this.grid = new int[size][size];
    }

    public void setCell(int row, int col, int value, int blockNr) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            grid[row][col] = value;
        }
    }

    public int getCell(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return grid[row][col];
        }
        return -1; // Invalid cell
    }

    public void printGrid() {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    
}
