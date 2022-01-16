package functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class InputFromFile extends Input{
    public static void inputFromFile(File file, Input input) throws FileNotFoundException, IOException {
        //Input input = new Input();

        String[] fileData = textFormatting(file);


        for (String number : fileData) {
            input.addToData(Double.parseDouble(number));
        }
        System.out.println(input.getData());


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
