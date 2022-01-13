import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class InputFromFile {

    public static void inputFromFile(File file) throws FileNotFoundException, IOException {
        String[] fileData = textFormatting(file);

        SimpleMovingAverage.numbers = new ArrayList<>();
        for (String number : fileData) {
            SimpleMovingAverage.daysInput(Double.parseDouble(number));
        }

    }
    public static String[] textFormatting(File file) throws IOException {
        String path = file.getPath();
        String line = textInput(path, StandardCharsets.UTF_8);
        line = line.replaceAll("[^\\d+(^\\.\\ \\d+)*]", "");
        line = line.replaceAll("  ", " ");
        String[] fileData = line.split(" ");

        return fileData;
    }
    public static String textInput(String path, Charset encoding) throws IOException{
        String line = Files.lines(Paths.get(path),encoding).collect(Collectors.joining(System.lineSeparator()));
        return line;
    }
}

