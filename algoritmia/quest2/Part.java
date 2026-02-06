package algoritmia.quest2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part implements iPart {
    private ArrayList<String> words;
    private String inscription;
    private ArrayList<String> inscriptions;
    private ArrayList<String> runicWords;
    private int nrOfRunicWords;

    public Part(int part, String str) {
        System.out.printf("-----====> Part %d <======-------%n%n", part);
        this.words = new ArrayList<>();
        this.inscriptions = new ArrayList<>();
        this.inscription = "";
        this.runicWords = new ArrayList<>();
        this.nrOfRunicWords = 0;
        if (part == 1){
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
    }

    @Override
    public void countPart3() {
    }
}
