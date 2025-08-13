package algoritmia;

import java.io.IOException;

import utils.ReadFromFile;

public class WordPart {
    private final String EXAMPLE1 = """
                                    WORDS:THE,OWE,MES,ROD,HER

                                    AWAKEN THE POWER ADORNED WITH THE FLAMES BRIGHT IRE""";
    private final String EXAMPLE2 = """
                                    WORDS:THE,OWE,MES,ROD,HER,QAQ

                                    AWAKEN THE POWE ADORNED WITH THE FLAMES BRIGHT IRE
                                    THE FLAME SHIELDED THE HEART OF THE KINGS
                                    POWE PO WER P OWE R
                                    THERE IS THE END
                                    QAQAQ""";

    private String[] words;
    private String[] sentences;
    private int nrOfRunicWords;
    private int part;
    
    public WordPart(int part) {
        System.out.println("Word Part " + part + ": ");
        this.nrOfRunicWords = 0;
    
        this.extractWords(1);
        this.countRunicWords();
    }

    /**
     * Extracts words from the example string based on the specified mode.
     * 
     * @param mode 1 for using example, 2 for extracting from notes.txt
     */
    private void extractWords(int mode) {
        if (mode == 1) {
            if (this.part == 1) {
                this.getStrings(this.EXAMPLE1);
            } else if (this.part == 2) {
                this.getStrings(this.EXAMPLE2);
            } else {
                System.out.println("Invalid part number. Please use 1 or 2.");
                return;
            }
        } else if (mode == 2) {
            // Logic for extracting from notes.txt would go here
            try {
                String dataLines = ReadFromFile.readStringFromFile("algoritmia/notesPart1.txt");
                System.out.println("LOADING DATA FROM FILE ");
                System.out.println(dataLines.toString());
                this.getStrings(dataLines);
            } catch (IOException e) {
                System.err.println("Error reading from file: " + e.getMessage());
                return;
            }
            
        }

        System.out.println("Words extracted: " + words.length);
        System.out.println("Sentences extracted: " + sentences.length);
        
        // Further processing can be added here
    }

    private void getStrings(String dataString){
        String[] lines = dataString.split("\n");

            this.words = lines[0].split(":")[1].split(",");
            System.out.println("Words extracted: " + String.join(", ", words));
            this.sentences = lines[2].split(", ");
            System.out.println("Sentences extracted: " + String.join("\n", sentences));
    }

    private void countRunicWords() {
        int total = 0;
        for(String rWord: this.words) {
            int count = 0;
            for (String sentence : this.sentences) {
                count += countRunicWordsInSentence(rWord, sentence);
            }
            System.out.println("Runic word '" + rWord + "' found " + count + " times in all sentences.");
            total += count;
        }
        this.nrOfRunicWords = total;
        System.out.println("Total runic words found: " + this.nrOfRunicWords);
    }

    private int countRunicWordsInSentence(String runicWord, String sentence) {
        int count = 0;
        int wordLength = runicWord.length();
        int sentenceLength = sentence.length();
        for (int i = 0; i <= sentenceLength - wordLength; i++) {
            if (sentence.substring(i, i + wordLength).equals(runicWord)) {
                count++;
            }
        }
        return count;
    }

}
