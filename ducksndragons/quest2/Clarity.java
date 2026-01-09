package ducksndragons.quest2;

import utils.ReadFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clarity {

    private Complex a;
    private Complex result;
    private ArrayList<Engraving> engravings;

    /**
     * Constructor for the clarity Class
     * @param type Type (0: test, 1: real)
     * @param part Which part to run (1, 2 or 3)
     * @throws IOException Throws an exception
     */
    public Clarity(int type, int part) throws IOException {
        this.result = new Complex();
        this.engravings = new ArrayList<>();
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
        System.out.printf("Input : %s%n", input);

        // Pattern breakdown:
        // A=\[   : Matches the literal "A=["
        // (\d+)  : Group 1 - Matches one or more digits
        // ,      : Matches the literal comma
        // (\d+)  : Group 2 - Matches one or more digits
        // \]     : Matches the literal "]"
        Pattern pattern = Pattern.compile("A=\\[(-?\\d+),(-?\\d+)]");
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
        // Multiply the result by itself
        this.result = this.result.multiplyComplex(this.result);
//        System.out.printf("Multiplying result by itself gives : %s%n", this.result);

        // Divide the result by [10,10]
        this.result = this.result.divideComplex(new Complex(10, 10));
//        System.out.printf("Dividing the result by [10,10] gives : %s%n", this.result);

        // Add a to the result
        this.result = this.result.addComplex(this.a);
//        System.out.printf("Adding A to the result gives : %s%n", this.result);
    }

    public Complex cycle2(Complex oldRes, Complex p){
        Complex tempResult = oldRes.copyComplex();

        // Multiply the result by itself
        tempResult = tempResult.multiplyComplex(tempResult);
//        System.out.printf("Multiplying result by itself gives : %s%n", this.result);

        // Divide the result by [10,10]
        tempResult = tempResult.divideComplex(new Complex(10, 10));
//        System.out.printf("Dividing the result by [10,10] gives : %s%n", this.result);

        // Add p to the result
        tempResult = tempResult.addComplex(p);
//        System.out.printf("Adding A to the result gives : %s%n", this.result);

        return tempResult;
    }

    public Engraving findEngravingByComplex(int x, int y){
        for (Engraving en: this.engravings){
            Complex c = en.getP();
            if (c.getX() == x && c.getY() == y) return en;
        }
        return null;
    }

    public void part1(){
        System.out.println(this.a);

        for (int i = 0; i < 3; i++){
            this.cycle(i + 1);
        }

        System.out.printf("%nThe final result is %s%n", this.result);

    }

    public void part2(){
        System.out.println(this.a);
        Complex originalA = this.a.copyComplex();
        int DIMY = 1001;  // CAUTION! steps are per 10!!!
        int DIMX = 1001;  // CAUTION! steps are per 10!!!
        int MAXCYCLES = 100;
        for (int i = 0; i < DIMY; i += 10){
            for (int j = 0; j < DIMX; j += 10){
                this.result.resetComplex();
                long x1 = originalA.getX() + j;
                long y1 = originalA.getY() + i;
                System.out.printf("Calculating engravings for [%d,%d]%n", x1, y1 );
                this.a.setComplex(x1, y1);
                int maxCycles = 0;
                for (int h = 0; h < MAXCYCLES; h++){
                    this.result = this.cycle2(this.result, this.a);
                    if ((Math.abs(this.result.getX()) > 1_000_000 || Math.abs(this.result.getY()) > 1_000_000) && maxCycles == 0) {
                        maxCycles = h + 1;
                    }
                }
                int tempCycles;
                if (maxCycles == 0) {
                    tempCycles = 100;
                } else {
                    tempCycles = maxCycles;
                }
                Engraving e = new Engraving(new Complex(x1, y1), new Complex(this.result.getX(), this.result.getY()), tempCycles);
                this.engravings.add(e);
                System.out.println(e);
            }
        }

        // All 100 Cycles
        Engraving p1 = this.findEngravingByComplex(35630,-64880);
        Engraving p2 = this.findEngravingByComplex(35630,-64870);
        Engraving p3 = this.findEngravingByComplex(35640,-64860);
        Engraving p4 = this.findEngravingByComplex(36230,-64270);
        Engraving p5 = this.findEngravingByComplex(36250,-64270);

        System.out.printf("P=%s   R=%s    C=%s   %n", p1.getP(), p1.getResult(), p1.isEngrave() ? p1.getCycles(): "");
        System.out.printf("P=%s   R=%s    C=%s   %n", p2.getP(), p2.getResult(), p2.isEngrave() ? p2.getCycles(): "");
        System.out.printf("P=%s   R=%s    C=%s   %n", p3.getP(), p3.getResult(), p3.isEngrave() ? p3.getCycles(): "");
        System.out.printf("P=%s   R=%s    C=%s   %n", p4.getP(), p4.getResult(), p4.isEngrave() ? p4.getCycles(): "");
        System.out.printf("P=%s   R=%s    C=%s   %n", p5.getP(), p5.getResult(), p5.isEngrave() ? p5.getCycles(): "");


        // Limit exceeded
        Engraving p6 = this.findEngravingByComplex(35460,-64910);
        Engraving p7 = this.findEngravingByComplex(35470,-64910);
        Engraving p8 = this.findEngravingByComplex(35480,-64910);
        Engraving p9 = this.findEngravingByComplex(35680,-64850);
        Engraving p10 = this.findEngravingByComplex(35630,-64830);


        System.out.printf("P=%s   R=%s    C=%s   %n", p6.getP(), p6.getResult(), p6.isEngrave() ? p6.getCycles(): "");
        System.out.printf("P=%s   R=%s    C=%s   %n", p7.getP(), p7.getResult(), p7.isEngrave() ? p7.getCycles(): "");
        System.out.printf("P=%s   R=%s    C=%s   %n", p8.getP(), p8.getResult(), p8.isEngrave() ? p8.getCycles(): "");
        System.out.printf("P=%s   R=%s    C=%s   %n", p9.getP(), p9.getResult(), p9.isEngrave() ? p9.getCycles(): "");
        System.out.printf("P=%s   R=%s    C=%s   %n", p10.getP(), p10.getResult(), p10.isEngrave() ? p10.getCycles(): "");
    }

    public void part3(){}

}
