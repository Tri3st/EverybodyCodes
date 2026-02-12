package algoritmia.quest3;

public class Part implements iPart {
    private String[][] earthBlocksGrid;
    private int dimX;
    private int dimY;
    private int maxNrEarthBlocks;

    public Part(int part, String data) {
        System.out.printf("-----====> Part %d <======-------%n%n", part);
        this.stringToGrid(data);
        this.printGrid();
    }

    private void stringToGrid(String data){
        String[] lines = data.split("\n");
        this.dimX = lines[0].length();
        this.dimY = lines.length;
        this.earthBlocksGrid = new String[this.dimY][this.dimX];
        for (int y = 0; y < this.dimY; y++){
            String line = lines[y];
            for (int x = 0; x < this.dimX; x++){
                this.earthBlocksGrid[y][x] = "" + line.charAt(x);
            }
        }
    }

    private void printGrid(){
        for (int y = 0; y < this.dimY; y++){
            for (int x = 0; x < this.dimX; x++){
                System.out.printf("%s", this.earthBlocksGrid[y][x]);
            }
            System.out.println();
        }
    }

    @Override
    public void maxNrEarthBlocks() {

    }

    @Override
    public void countPart1() {

    }

    @Override
    public void countPart2() {

    }

    @Override
    public void countPart3() {

    }
}