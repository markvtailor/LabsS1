import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class InputFromWEB {
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
        String[] fileData = getFromURL(webLink);
        SimpleMovingAverage.numbers = new ArrayList<>();
        for (String number : fileData) {
            SimpleMovingAverage.daysInput(Double.parseDouble(number));
        }

    }
}
