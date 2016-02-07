package initialization;


import java.io.File;
import java.io.PrintWriter;

public class GameWriter {

    public GameWriter() {
        try {
            PrintWriter writer = new PrintWriter(new File("initialization/saveFile.txt"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
