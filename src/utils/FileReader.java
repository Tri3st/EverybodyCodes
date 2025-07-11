package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class FileReader {
    /**
     * readFilArray reads from a text file and returns an ArrayList of Strings (split by \n
     *
     * @param fileName Full path of the textfile
     * @return The ArrayList of Strings
     * @throws IOException
     */
    public static ArrayList<String> readFileArrayList(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String pathstr = path.toString();
        String[] patharr = pathstr.split("\n");
        ArrayList<String> arr = new ArrayList<>();
        Collections.addAll(arr, patharr);
        return arr;
    }

    /**
     * readFileString reads from a text file and returns a String
     *
     * @param fileName Full path of the textfile
     * @return The String
     * @throws IOException
     */
    public static String readFileString(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readString(path);
    }

    public static ArrayList<String> getArraysFromString(String data) {
        String[] datalines = data.split("\n");
        return new ArrayList<String>(Arrays.asList(datalines));
    }
}
