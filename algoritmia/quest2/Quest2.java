package algoritmia.quest2;

import utils.ReadFromFile;
import java.io.IOException;

public class Quest2 {
    String data;
    Part part;

    public Quest2(int part, int type){
        String path = "algoritmia/quest2/";
        String filename = "";
        if (type == 0) {
            // We take the test notes
            filename += "testNotesPart";
        } else {
            // We take the real notes
            filename += "notesPart";
        }
        if (part > 0 && part < 4) {
            filename += "" + part + ".txt";
        }
        String fullPath = path + filename;

        try {
            this.data = ReadFromFile.readStringFromFile(fullPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        switch(part){
            case 1:
                this.part = new Part(1, this.data);
                break;
            case 2:
                this.part = new Part(2, this.data);
                break;
            case 3:
                this.part = new Part(3, this.data);
                break;
        }


    }
}
