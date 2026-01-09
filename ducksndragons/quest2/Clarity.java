package ducksndragons.quest2;

import utils.ReadFromFile;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clarity {

    private Complex a;
    private Complex result;

    public Clarity(int type, int part) throws IOException {
        this.result = new Complex();
        this.a = new Complex();
        switch (part) {
            case 1:
                this.readFile(type, 1);
                this.part1();
                break;
            case 2:
                this.readFile(type, 2);
                this.part2();
                break;
            case 3:
                this.readFile(type, 3);
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
        String path = "ducksndragons/quest2/" + fileName;
        String input;
        try {
            input = ReadFromFile.readStringFromFile(path);
        } catch (IOException e) {
            throw new IOException("Error reading file: " + path, e);
        }

        // Pattern breakdown:
        // A=\[   : Matches the literal "A=["
        // (\d+)  : Group 1 - Matches one or more digits
        // ,      : Matches the literal comma
        // (\d+)  : Group 2 - Matches one or more digits
        // \]     : Matches the literal "]"
        Pattern pattern = Pattern.compile("A=\\[(\\d+),(\\d+)]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // matcher.group(0) is the entire match ("A=[12,34]")
            // matcher.group(1) is the first set of parentheses
            // matcher.group(2) is the second set of parentheses
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            this.a = new Complex(x, y);
        }

    }

    public void cycle(int counter){
        System.out.printf("Cycle %d%n%n", counter);
        // Multiply the result by itself
        this.result = this.result.multiplyComplex(this.result);
        System.out.printf("Multiplying result by itself gives : %s%n", this.result);

        // Divide the result by [10,10]
        this.result = this.result.divideComplex(new Complex(10, 10));
        System.out.printf("Dividing the result by [10,10] gives : %s%n", this.result);

        // Add a to the result
        this.result = this.result.addComplex(this.a);
        System.out.printf("Adding A to the result gives : %s%n", this.result);
    }

    public void part1(){
        System.out.println(this.a);

        for (int i = 0; i < 3; i++){
            this.cycle(i + 1);
        }

        System.out.printf("%nThe final result is %s%n", this.result);

    }

    public void part2(){}

    public void part3(){}

}
