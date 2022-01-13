import java.io.*;

public class InputFromFile {

    public static void readFromFile() {
        try {
            File file = new File("/home/marktailorson/testing/Lab4.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String aname = AuthorName.Name(line);
                Confidence.confidenceCounter(line,aname);
                Authors.authorsCount(line);
                line = reader.readLine();
            }

            Merging.result();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }




