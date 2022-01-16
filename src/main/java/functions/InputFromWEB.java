package functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class InputFromWEB extends Input {
    public static String[] getFromURL(String webLink) throws IOException {
        URL link = new URL(webLink);
        BufferedReader in = new BufferedReader(new InputStreamReader(link.openStream()));
        String inputURL;
        String[] fileData = new String[0];

        while ((inputURL = in.readLine()) != null) {
            inputURL = inputURL.replaceAll("[^\\d+(^\\.\\ \\d+)*]", "");
            inputURL = inputURL.replaceAll("  ", " ");
            fileData = inputURL.split(" ");
            System.out.println(inputURL+"test");
            System.out.println(Arrays.toString(fileData));

        }

        in.close();
        return  fileData;
    }
    public static void inputFromURL(String webLink) throws IOException {
        Input input = new Input();
        String[] fileData = getFromURL(webLink);
        for (String number : fileData) {
            input.addToData(Double.parseDouble(number));
        }

    }
}
