package ducksndragons.quest3;

import ducksndragons.quest2.Complex;
import utils.ReadFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crates {
    private ArrayList<Integer> crates;
    private int maxWeight;

    public Crates(int quest, int type, int part) throws IOException {
        this.crates = new ArrayList<>();
        this.maxWeight = 0;
        switch (part) {
            case 1:
                this.readFile(quest, type, 1);
                this.part1();
                break;
            case 2:
                this.readFile(quest, type, 2);
                this.part2();
                break;
            case 3:
                this.readFile(quest, type, 3);
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
    private void readFile(int quest, int type, int part) throws IOException {
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
        String path = "ducksndragons/quest%d/%s".formatted(quest, fileName);
        String input;
        try {
            input = ReadFromFile.readStringFromFile(path);
        } catch (IOException e) {
            throw new IOException("Error reading file: " + path, e);
        }
        System.out.printf("Input : %s%n", input);
        String[] digits = input.split(",");
        for (String d: digits){
            this.crates.add(Integer.parseInt(d));
        }
    }

    private int getHeaviest(ArrayList<Integer> list){
        int highest = 0;
        for(int c: list){
            if (c > highest) highest = c;
        }
        return highest;
    }

    private void part1(){
        ArrayList<Integer> crates = new ArrayList<>(this.crates);
        int heaviest = 0;
        while(!crates.isEmpty()){
            int heavy = this.getHeaviest(crates);
            crates.remove(heavy);
            heaviest += heavy;
        }
        System.out.printf("Total weight = %d", heaviest);

    }

    private void part2(){}

    private void part3(){}
}
