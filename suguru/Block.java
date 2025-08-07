package suguru;

public class Block {
    private Cell[] cells;
    private int size;

    public Block(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(); // Initialize each cell as empty
            }
        }
    }

    public Cell getCell(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return cells[row][col];
        }
        return null; // Invalid cell access
    }

    public void setCell(int row, int col, Cell cell) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            cells[row][col] = cell;
        }
    }

    public int getSize() {
        return size;
    }
}
