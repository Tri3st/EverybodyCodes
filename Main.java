class Main {
    public static void main(String[] args) {
        System.out.println("SUGURU PUZZLE");

        Suguru s1 = new Suguru(4);
        s1.setCell(0, 0, 1, 1);
        s1.setCell(1, 0, 4, 1);
        s1.setCell(1, 1, 3, 1);
        s1.setCell(3, 0, 2, 4);
        s1.setCell(3, 1, 4, 3);
        s1.setCell(3, 2, 1, 3);
        s1.setCell(2, 3, 5, 3);

        System.out.println("Grid:");
        s1.printGrid();

    }
}