package quest1;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.io.IOException;
import utils.ENI;
import utils.ReadFromFile;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Quest1 {
    private final String EXAMPLEPART11 = """
                                        A=4 B=4 C=6 X=3 Y=4 Z=5 M=11
                                        A=8 B=4 C=7 X=8 Y=4 Z=6 M=12
                                        A=2 B=8 C=6 X=2 Y=4 Z=5 M=13
                                        A=5 B=9 C=6 X=8 Y=6 Z=8 M=14
                                        A=5 B=9 C=7 X=6 Y=6 Z=8 M=15
                                        A=8 B=8 C=8 X=6 Y=9 Z=6 M=16""";
    private final String EXAMPLEPART21 = """
                                        A=4 B=4 C=6 X=3 Y=14 Z=15 M=11
                                        A=8 B=4 C=7 X=8 Y=14 Z=16 M=12
                                        A=2 B=8 C=6 X=2 Y=14 Z=15 M=13
                                        A=5 B=9 C=6 X=8 Y=16 Z=18 M=14
                                        A=5 B=9 C=7 X=6 Y=16 Z=18 M=15
                                        A=8 B=8 C=8 X=6 Y=19 Z=16 M=16""";
    private final String EXAMPLEPART22 = """
                                        A=3657 B=3583 C=9716 X=903056852 Y=9283895500 Z=85920867478 M=188
                                        A=6061 B=4425 C=5082 X=731145782 Y=1550090416 Z=87586428967 M=107
                                        A=7818 B=5395 C=9975 X=122388873 Y=4093041057 Z=58606045432 M=102
                                        A=7681 B=9603 C=5681 X=716116871 Y=6421884967 Z=66298999264 M=196
                                        A=7334 B=9016 C=8524 X=297284338 Y=1565962337 Z=86750102612 M=145""";
    private ArrayList<String> lines;
    private String fileName;

    private int part; // part 1, 2 or 3
    private int mode; // mode indicates to use the example notes or a notes file
        
    public Quest1(int part, int mode) {
        this.lines = new ArrayList<>();
        this.part = part;
        this.mode = mode;
        this.fileName = "quest1/notesPart" + part + ".txt";
    }

    /**
     * @param mode {int} The mode
     */
    public void doPart() {
        this.doReadLines();
      
        this.calcENIs();
        
    }

    private void calcENIs(){
        for (String line : this.lines) {
            String text = "A=(?<a>\\d+)\\sB=(?<b>\\d+)\\sC=(?<c>\\d+)\\sX=(?<x>\\d+)\\sY=(?<y>\\d+)\\sZ=(?<z>\\d+)\\sM=(?<m>\\d+)";
            Pattern pattern = Pattern.compile(text);
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()){
                // System.out.println("group a :" + matcher.group("a"));
                ENI eni = new ENI(
                    Integer.parseInt(matcher.group("a")),
                    Integer.parseInt(matcher.group("b")),
                    Integer.parseInt(matcher.group("c")),
                    Integer.parseInt(matcher.group("x")),
                    Integer.parseInt(matcher.group("y")),
                    Integer.parseInt(matcher.group("z")),
                    Integer.parseInt(matcher.group("m"))
                );
                System.out.println(eni.toString() + " -> " + eni);
            }
        }
    }

    /**
     * Reads the lines from the file or string based on the mode and part.
     * mode 0 uses the notes file for the part selected, 
     * mode 1 uses the first example notes,
     * mode 2 uses the second example notes (if any. otherwise uses the first example notes).

     * 
     */
    private void doReadLines() {
        if (mode == 1) {
            System.out.println(String.format("Part %d using example notes:", this.part));
            if(this.part == 1) {
                this.lines.addAll(ReadFromFile.readArrayListFromString(this.EXAMPLEPART11));
            } else if (part ==2) {
                this.lines.addAll(ReadFromFile.readArrayListFromString(this.EXAMPLEPART21));
            }
        } else if (mode == 2) {
            if(part ==1) {
                this.lines.addAll(ReadFromFile.readArrayListFromString(this.EXAMPLEPART11));
            } else if (part ==2) {
                this.lines.addAll(ReadFromFile.readArrayListFromString(this.EXAMPLEPART22));
            }
            
        } else if (mode == 0) {
            // read from notes file
            System.out.println(String.format("Part %d using notes file notesPart%s:", this.part, this.part));
            try {
                this.lines.addAll(ReadFromFile.readArrayListFromFile(this.fileName));
            } catch (Exception e) {
                // TODO: handle exception
            }
        } else {
            System.out.println("Invalid mode for Part " + part);
        }
          System.out.println("Lines read: ");
              for (String line : this.lines) {
            System.out.println(line);
        }
    }

}
