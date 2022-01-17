package functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DocReader {

    public static ArrayList<Author> readFromFile(File file) {
        InfoAnalyzer analyzer = new InfoAnalyzer();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                analyzer.gatherNamesAndMail(line);
                analyzer.rememberLastEncounteredAuthor(line);
                analyzer.gatherAuthorsConfidence(line);
                analyzer.gatherProbability(line);
                line = reader.readLine();
            }
            }catch (IOException e) {
            e.printStackTrace();
            }
            analyzer.calculateAverageProbability(analyzer.getProbability(), analyzer.getAuthorsInfo());
            return analyzer.getAuthorsInfo();
        }
        }


