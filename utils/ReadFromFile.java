package utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    /**
     * Reads from a text file on disk and return the whole String
     * @param filenName The filename (whole path)
     * @return The whole String
     * @throws IOException
     */
    public static String readStringFromFile(String fileName) throws IOException {
        String res = "";
        try {
            res = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Reads a text file from disk and returns an ArrayList<String>
     * @param fileName String The filename (whole path)
     * @return ArrayList<String> with every line being a list entry
     * @throws IOException
     */
    public static ArrayList<String> readArrayListFromFile(String fileName) throws IOException {
        ArrayList<String> res = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            res.addAll(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Reads a string and converts it to an ArrayList<String>.
     * Each line in the string becomes an element in the ArrayList.
     * @param data The string to be converted.
     * Each line in the string should be separated by a newline character.
     * @return The ArrayList<String>
     */
    public static ArrayList<String> readArrayListFromString(String data) {
        ArrayList<String> res = new ArrayList<>();
        String[] lines = data.split("\n");
        for (String line : lines) {
            res.add(line);
        }
        return res;
    }
}