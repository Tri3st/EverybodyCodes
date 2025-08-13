package algoritmia;
import utils.ReadFromFile;

public class Part1 {
    private final String example = """
            WORDS:THE,OWE,MES,ROD,HER,QAQ

            AWAKEN THE POWE ADORNED WITH THE FLAMES BRIGHT IRE
            THE FLAME SHIELDED THE HEART OF THE KINGS
            POWE PO WER P OWE R
            THERE IS THE END
            QAQAQ""";
    private String[] words;
    private String[] sentences;
    private int nrOfRunicWords;

    public Part1() {
        System.out.println("Part 1: ");
        this.nrOfRunicWords = 0;
    
        this.extractWords(1);
    }


    /**
     * Extracts words from the example string based on the specified mode.
     * 
     * @param mode 1 for using example, 2 for extracting from notes.txt
     */
    private void extractWords(int mode) {
        if (mode == 1) {
            String[] lines = example.split("\n");

            this.words = lines[0].split(":")[1].split(",");
            System.out.println("Words extracted: " + String.join(", ", words));
            String[] tmp_sentences = new String[lines.length - 2];
            for (int i = 2; i < lines.length; i++) {
                tmp_sentences[i - 2] = lines[i].trim();
            } 
            this.sentences = tmp_sentences;
            System.out.println("Sentences extracted: " + String.join(" ", sentences));

        } else {
            // Logic for extracting from notes.txt would go here
        }

        System.out.println("Words extracted: " + words.length);
        System.out.println("Sentences extracted: " + sentences.length);
        
        // Further processing can be added here
    }
    
}
