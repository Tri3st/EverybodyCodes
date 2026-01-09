package ducksndragons.quest1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import utils.ReadFromFile;

public class EggShell {

    private ArrayList<String> names;
    private int namesCount;
    private ArrayList<String> instructions;

    /**
     * Constructor of the EggShell class
     *
     * @param type Type of input needed. 0: test notes,1 : notes
     * @param part Which part has to be run. 1, 2, 3, etc.
     */
    public EggShell(int type, int part) throws IOException {
        switch(part){
            case 1:
                this.readFile(type, 1);
                this.part1();
                break;
            case 2:
                readFile(type, 2);
                this.part2();
                break;
            case 3:
                readFile(type, 3);
                this.part3();
                break;
        }
    }

    /**
     * Reads the file for the right type of the right part
     * @param type Type of file (0: test, 1: real)
     * @param part Which part to use
     * @throws IOException
     */
    private void readFile(int type, int part) throws IOException {
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
        String path = "ducksndragons/quest1/" + fileName;
        String input;
        try {
            input = ReadFromFile.readStringFromFile(path);
        } catch (IOException e) {
            throw new IOException("Error reading file: " + path, e);
        }
        System.out.println(input);
        String[] lines = input.split("\n\n");
        String[] names = lines[0].split(",");
        String[] instructions = lines[1].split(",");
        this.names = new ArrayList<>(Arrays.asList(names));
        this.instructions = new ArrayList<>(Arrays.asList(instructions));
        this.namesCount = this.names.size();
    }

    /**
     * Simple walk through the list. If we cant go further to the R or L then just stay at the end.
     */
    public void part1(){
        int counter = 0;
        for (String instr : this.instructions) {
            char d = instr.charAt(0);
            int steps = Integer.parseInt(instr.substring(1));
            System.out.printf("direction : %c%n", d);
            System.out.printf("steps : %d%n" ,steps);
            if (d == 'R') {
                // R
                if (counter + steps > this.namesCount - 1) {
                    counter = this.namesCount - 1;
                } else {
                    counter += steps;
                }
            } else {
                // L
                if (counter - steps <= 0) {
                    counter = 0;
                } else {
                    counter -= steps;
                }
            }
            System.out.printf("resulting to %d steps to the %c -> %s%n", steps, d, this.names.get(counter));
        }
        System.out.printf("Your name is : %s%n", this.names.get(counter));
    }

    /**
     * Now it's a circle. So we count round to the left or right.
     * Modulus it is.
     */
    public void part2(){
        int counter = 0;
        for (String instr : this.instructions) {
            char d = instr.charAt(0);
            int steps = Integer.parseInt(instr.substring(1));
            System.out.printf("direction : %c%n", d);
            System.out.printf("steps : %d%n", steps);
            if (d == 'R') {
                // R
                counter = (counter + steps) % this.namesCount;
            } else {
                // L
                counter = ((counter - steps) + this.namesCount) % this.namesCount;
            }
            System.out.printf("resulting to %d steps to the %c -> %s%n", steps, d,  this.names.get(counter));
        }
        System.out.printf("Your name is : %s%n", this.names.get(counter));
    }

    /**
     * this time it is a circle and in stead of just staying on the place, we swap places.
     * Old becomes new and visa versa.
     */
    public void part3(){
        int oldCounter = 0;
        int newCounter = 0;
        for (String instr : this.instructions) {
            char d = instr.charAt(0);
            int steps = Integer.parseInt(instr.substring(1));
            System.out.printf("direction : %c%n", d);
            System.out.printf("steps : %d%n", steps);
            if (d == 'R') {
                // R
                newCounter = (oldCounter + steps) % this.namesCount;
                // Swap old and new places
                String temp = this.names.get(oldCounter);
                this.names.set(oldCounter, this.names.get(newCounter));
                this.names.set(newCounter, temp);
            } else {
                // L
                // Made the calculation of the steps better
                newCounter = (oldCounter - (steps % this.namesCount) + this.namesCount) % this.namesCount;
                // Swap old and new places
                String temp = this.names.get(oldCounter);
                this.names.set(oldCounter, this.names.get(newCounter));
                this.names.set(newCounter, temp);
            }
            System.out.printf("%s and %s have been swapped.%n", this.names.get(oldCounter), this.names.get(newCounter));
            System.out.printf("resulting to %d steps to the %c -> %s%n", steps, d, this.names.get(newCounter));
        }
        System.out.println("Your name is : " + this.names.get(oldCounter));
    }
}
