import java.util.ArrayList;


class Quest1 {
    private final String EXAMPLEPART1 = """
                                    A=4 B=4 C=6 X=3 Y=4 Z=5 M=11
                                    A=8 B=4 C=7 X=8 Y=4 Z=6 M=12
                                    A=2 B=8 C=6 X=2 Y=4 Z=5 M=13
                                    A=5 B=9 C=6 X=8 Y=6 Z=8 M=14
                                    A=5 B=9 C=7 X=6 Y=6 Z=8 M=15
                                    A=8 B=8 C=8 X=6 Y=9 Z=6 M=16""";
    private final String EXAMPLEPART2 = """

    """;

    private ArrayList<String> lines;
        
    public Quest1(String fileName) {
        this.lines = new ArrayList<>();
        try {
            this.lines = ReadFromFile.readArrayListFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executes the first part of the quest based on the mode.
     * mode 0: use example notes
     * mode 1: use notes.txt
     * @param mode {int} The mode
     */
    public void doPart1(int mode) {
        if (mode == 0) {
            System.out.println("Part 1 using example notes:");
            this.lines = ReadFromFile.readArrayListfromString(this.EXAMPLEPART1);
        } else if (mode == 1) {
            System.out.println("Part 1 using notes.txt:");
            this.lines = ReadFromFile.readArrayListFromFile("notesQuest1.txt");
        } else {
            System.out.println("Invalid mode for Part 1");
        }
        for (String line : this.lines) {
            String[] parts = line.split(" ");
            int a = Integer.parseInt(parts[0].split("=")[1]);
            int b = Integer.parseInt(parts[1].split("=")[1]);
            int c = Integer.parseInt(parts[2].split("=")[1]);
            int x = Integer.parseInt(parts[3].split("=")[1]);
            int y = Integer.parseInt(parts[4].split("=")[1]);
            int z = Integer.parseInt(parts[5].split("=")[1]);
            int m = Integer.parseInt(parts[6].split("=")[1]);

            ENI eni = new ENI(a, b, c, x, y, z, m);
            System.out.println(eni);
        }
    }

}
