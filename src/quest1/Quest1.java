package quest1;

import utils.ENI;
import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class Quest1 {

    private ArrayList<String> notesArr = new ArrayList<>();
    private String sampleNotes;
    private int total = 0;
    private final String PATH = "/Volumes/WD2TB/JAVA/EverybodyCodes/src/";

    public Quest1() {
        System.out.println("Quest 1");

        this.sampleNotes = """
                A=4 B=4 C=6 X=3 Y=4 Z=5 M=11
                A=8 B=4 C=7 X=8 Y=4 Z=6 M=12
                A=2 B=8 C=6 X=2 Y=4 Z=5 M=13
                A=5 B=9 C=6 X=8 Y=6 Z=8 M=14
                A=5 B=9 C=7 X=6 Y=6 Z=8 M=15
                A=8 B=8 C=8 X=6 Y=9 Z=6 M=16""";

        try {
            this.notesArr = FileReader.readFileArrayList(PATH + "quest1/notes.txt");
        } catch (IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }

    }

    public int getEniFromSample() {
        ArrayList<String> sampleData = FileReader.getArraysFromString(this.sampleNotes);
        for (String d: sampleData) {
            ENI eni = new ENI(d);
            System.out.println(eni);
            this.total += eni.getTotal();
        }
        return this.total;
    }

    public int getEniFromFile(){
        for (String d: this.notesArr){
            ENI eni = new ENI(d);
            this.total += eni.getTotal();
        }
        return this.total;
    }

    public int getTotal(){
        return this.total;
    }

}
