package algoritmia.quest2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part implements iPart {
    private ArrayList<String> words;
    private ArrayList<String> inscriptions;
    private int nrOfRunicWords;
    private String[][] scaleGrid;

    public Part(int part, String str) {
        System.out.printf("-----====> Part %d <======-------%n%n", part);
        this.words = new ArrayList<>();
        this.inscriptions = new ArrayList<>();
        this.nrOfRunicWords = 0;
        if (part == 1 || part == 2 || part == 3){
            String[] datas = str.split("\n\n");
            Matcher header =  Pattern.compile("^WORDS:(.*)$").matcher(datas[0]);
            if (header.find()){
                String payload = header.group(1);
                Matcher token = Pattern.compile("[A-Z]+").matcher(payload);
                while (token.find()){
                    this.words.add(token.group());
                }
            }
            this.inscriptions = new ArrayList<>(List.of(datas[1].split("\n")));
        }
        if (part == 3) {
            this.convertListsToArray();
        }
        this.count_runic_words(part);
    }

    @Override
    public void count_runic_words(int part) {
        switch (part) {
            case 1:
                this.countPart1();
            case 2:
                this.countPart2();
            case 3:
                this.countPart3();
        }
    }

    @Override
    public void countPart1() {
        for (String inscription: this.inscriptions){
            System.out.println(inscription);
            int inscLength = inscription.length();
            int runicWords = 0;
            for (int i = 0; i < inscLength; i++){
                for (String word : this.words){

                    // If the word would run past the end, skip this start position
                    if (i + word.length() > inscLength) continue;

                    boolean matched = true;
                    for (int j = 0; j < word.length(); j++){
                        if (inscription.charAt(i + j) != word.charAt(j)) {
                            matched = false;
                            break;
                        }
                    }
                    if (matched){
                        System.out.println("Found " + word);
                        this.nrOfRunicWords++;
                        runicWords++;
                    }
                }
            }
            System.out.printf("Found %d runnic words%n%n", runicWords);
        }
        System.out.printf("Which makes it a total of %d runic words.", this.nrOfRunicWords);
    }

    @Override
    public void countPart2() {
        this.addReverseWords();
        int totalRunicLetters = 0;
        for (String inscription: this.inscriptions){
            // We make a map of the inscription
            int inscLength = inscription.length();
            HashMap<Integer, Boolean> inscrMap = new HashMap<>(inscLength);
            for (int i = 0; i < inscLength; i++){
                inscrMap.put(i, false);
            }
            System.out.println(inscription);
            int runicWords = 0;
            for (int i = 0; i < inscLength; i++){
                for (String word : this.words){

                    // If the word would run past the end, skip this start position
                    if (i + word.length() > inscLength) continue;

                    boolean matched = true;
                    for (int j = 0; j < word.length(); j++){
                        if (inscription.charAt(i + j) != word.charAt(j)) {
                            matched = false;
                            break;
                        }
                    }
                    if (matched){
                        System.out.println("Found " + word);
                        for (int k = 0; k < word.length(); k++){
                            inscrMap.put(i + k, true);
                        }
                        this.nrOfRunicWords++;
                        runicWords++;
                    }
                }
            }
            System.out.printf("Found %d runnic words%n%n", runicWords);
            int runicLetters = 0;
            for (boolean b: inscrMap.values()) if (b) runicLetters++;
            totalRunicLetters += runicLetters;
            System.out.printf("Found %d runic letters.%n%n%n", runicLetters);
        }
        System.out.printf("The total number of runic letters is %d%n", totalRunicLetters);
    }

    /**
     * Reverse the given word
     * @param word A string that represents a word
     * @return The versed word
     */
    private String reverseWord(String word){
        String reversed = "";
        int wordL = word.length();
        if (wordL == 1) return word;
        for (int i = wordL - 1; i >= 0; i--) {
            reversed += "" + word.charAt(i);
        }
        return reversed;
    }

    /**
     * For part2: Add the reversed words to the list of words.
     */
    private void addReverseWords(){
        ArrayList<String> toAdd = new ArrayList<>();
        for (String word: this.words){
            String reversedWord = this.reverseWord(word);
            if(!this.words.contains(reversedWord) && !toAdd.contains(reversedWord)){
                toAdd.add(reversedWord);
            }
        }
        this.words.addAll(toAdd);
    }

    private void convertListsToArray(){
        int dimX = this.inscriptions.getFirst().length();
        int dimY = this.inscriptions.size();
        this.scaleGrid = new String[dimY][dimX];
        for (int y = 0; y < dimY; y++){
            String line = this.inscriptions.get(y);
            for (int x = 0; x < dimX; x++){
                this.scaleGrid[y][x] = String.valueOf(line.charAt(x));
            }
        }
    }

    private void printScaleGrid(){
        int dimX = this.inscriptions.getFirst().length();
        int dimY = this.inscriptions.size();
        for (int y = 0; y < dimY; y++){
            for (int x = 0; x < dimX; x++){
                System.out.printf("%s", this.scaleGrid[y][x]);
            }
            System.out.println();
        }
    }

    @Override
    public void countPart3() {
        this.printScaleGrid();
    }
}
