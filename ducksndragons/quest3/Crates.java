package ducksndragons.quest3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import utils.ReadFromFile;

public class Crates {
    private ArrayList<Integer> crates;
    private int total;
    private final String QUEST = "3";

    public Crates(int type, int part) throws IOException {
        this.total = 0;
        crates = new ArrayList<>();
        this.readFile(type, part);
        switch(part) {
            case 1:
                this.part1();
                break;
            case 2:
                this.part2();
                break;
            case 3:
                this.part3();
                break;
        }
    }

    /**
     * Reads the file for the right type of the right part
     * @param type Type of file (0: test, 1: real)
     * @param part Which part to use
     * @throws IOException Throws an IOException when something goes wrong while reading file
     */
    private void readFile(int type, int part) throws IOException {
        System.out.printf("Doing part %d with type %d%n", part, type);
        String fileName;
        if (type == 0) {
            // Read testNotes
            fileName = "testNotesPart" + part + ".txt";
        } else if (type == 1) {
            // Read notes
            fileName = "notesPart" + part + ".txt";
        } else {
            // Throw a ValueException
            throw new IllegalArgumentException("Invalid type parameter. Expected 0 or 1, got: " + type);
        }
        String path = "ducksndragons/quest" + this.QUEST + "/" + fileName;
        String input;
        try {
            input = ReadFromFile.readStringFromFile(path);
        } catch (IOException e) {
            throw new IOException("Error reading file: " + path, e);
        }
        System.out.printf("Input : %s%n", input);

        String line[] = input.split(",");
        for (String st: line){
            this.crates.add(Integer.parseInt(st));
        }
    }

    public void part1(){
        Set<Integer> crats = new HashSet<>();
        for(int d: this.crates) crats.add(d);
        int total = 0;
        for (int x: crats) total += x;
        this.total = total;
        System.out.println(crats);
        System.out.printf("Total : %d%n", this.total);
    };

    public void part2(){
        int maxLength = 20;
        for 
    };

    public void part3(){};

    public String toString(){
        return this.crates.toString();
    }
}