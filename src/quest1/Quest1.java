package quest1;

import utils.ENI;
import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class Quest1 {

    private final String EXAMPLENOTESPART11 = """
                                            A=4 B=4 C=6 X=3 Y=4 Z=5 M=11
                                            A=8 B=4 C=7 X=8 Y=4 Z=6 M=12
                                            A=2 B=8 C=6 X=2 Y=4 Z=5 M=13
                                            A=5 B=9 C=6 X=8 Y=6 Z=8 M=14
                                            A=5 B=9 C=7 X=6 Y=6 Z=8 M=15
                                            A=8 B=8 C=8 X=6 Y=9 Z=6 M=16""";
    private final String EXAMPLENOTESPART21 = """
                                            A=4 B=4 C=6 X=3 Y=14 Z=15 M=11
                                            A=8 B=4 C=7 X=8 Y=14 Z=16 M=12
                                            A=2 B=8 C=6 X=2 Y=14 Z=15 M=13
                                            A=5 B=9 C=6 X=8 Y=16 Z=18 M=14
                                            A=5 B=9 C=7 X=6 Y=16 Z=18 M=15
                                            A=8 B=8 C=8 X=6 Y=19 Z=16 M=16""";

    private final String EXAMPLENOTESPART22 = """
            A=3657 B=3583 C=9716 X=903056852 Y=9283895500 Z=85920867478 M=188
            A=6061 B=4425 C=5082 X=731145782 Y=1550090416 Z=87586428967 M=107
            A=7818 B=5395 C=9975 X=122388873 Y=4093041057 Z=58606045432 M=102
            A=7681 B=9603 C=5681 X=716116871 Y=6421884967 Z=66298999264 M=196
            A=7334 B=9016 C=8524 X=297284338 Y=1565962337 Z=86750102612 M=145""";
    private ArrayList<String> notesArr = new ArrayList<>();
    private long[] total = {0, 0, 0};
    private long[] highest = {0, 0, 0};
    private final String PATH = "/Volumes/WD2TB/JAVA/EverybodyCodes/src/";

    /**
     * Depending on the mode we use the example notes (mode 0) or the notes from the file (mode 1)
     * Part is which part to run. 1: part 1, 2: part2, 3: part3
     * @param mode {int} mode 0 or 1
     * @param part {int} part 1, 2 or 3
     */
    public Quest1(int part, int mode) {
        System.out.println("Quest 1 part " + part);
        if (mode == 1) {
            System.out.println("Reading notes from file notespart1.txt");
            try {
                String filename = "quest1/notespart" + part + ".txt";
                this.notesArr = FileReader.readFileArrayList(PATH + filename);
                System.out.println(this.notesArr.toString());
            } catch (IOException e){
                System.err.println("Error reading file: " + e.getMessage());
            }
        }
        if (part == 1) {
            if (mode == 0){
                System.out.println("Reading data from sample notes..");
                this.notesArr = FileReader.getArraysFromString(this.EXAMPLENOTESPART11);
            }
            this.calcEniPart1();
        } else if (part == 2){
            if (mode == 0) {
                System.out.println("Reading data from sample notes..");
                this.notesArr = FileReader.getArraysFromString(this.EXAMPLENOTESPART21);
            }
            this.calcEniPart2();
        } else if (part == 3){
            // TODO implement this
            this.calcEniPart3();
        }
    }

    private void calcEniPart1() {
        for (String note: notesArr) {
            ENI n = new ENI(note, 0);
            System.out.println(n + " -> " + n.getTotal());
            if (n.getTotal() > this.highest[0]) this.highest[0] = n.getTotal();
            this.total[0] += n.getTotal();
        }
    }

    private void calcEniPart2(){
        for (String note: this.notesArr){
            ENI n= new ENI(note, 5);
            System.out.println(n + " -> " + n.getTotal());
            if (n.getTotal() > this.highest[0]) this.highest[0] = n.getTotal();
            this.total[0] += n.getTotal();
        }
    }

    private void calcEniPart3(){}

    public long getTotal(int part){
        return this.total[part - 1];
    }

    public long getHighest(int part) {
        return this.highest[part - 1];
    }

}
